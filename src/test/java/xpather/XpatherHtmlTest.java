package xpather;

import com.sun.org.apache.xml.internal.serialize.Method;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import com.sun.tools.internal.xjc.util.NullStream;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;

import static javax.xml.xpath.XPathFactory.newInstance;
import static org.junit.Assert.assertEquals;
import static xpather.HtmlXpathElement.*;
import static xpather.XpathAttribute.id;
import static xpather.XpathElement.any;
import static xpather.XpathElement.xPath;
import static xpather.XpathPredicate.containing;

public class XpatherHtmlTest {

    private static final String TEST_WEB_PAGE_HTML = "TestWebPage.html";
    private Document htmlDocument;
    private String html;

    @Before
    public void loadTestWebPage() throws IOException, URISyntaxException, ParserConfigurationException, SAXException {
        Tidy tidy = new Tidy();
        tidy.setShowWarnings(false);
        htmlDocument = tidy
                .parseDOM(getClass().getResourceAsStream(TEST_WEB_PAGE_HTML), new NullStream());
        html = prettyPrintNodeList(htmlDocument);
    }

    @Test
    public void htmlWillReturnHtmlDocument() throws XPathExpressionException, TransformerException, IOException {
        assertEquals(html, runXpath(xPath().with(html())));
    }

    @Test
    public void anyWillFindSubElementAnyWhere() throws XPathExpressionException, TransformerException, IOException {
        String actual = runXpath(xPath().with(any(title())));
        assertEquals("<title>timt/xpather - GitHub</title>", actual);
    }

    @Test
    public void willChainHtmlElements() throws TransformerException, IOException, XPathExpressionException {
        String actual = runXpath(
                xPath()
                        .with(html())
                        .with(head())
                        .with(title()));
        assertEquals("<title>timt/xpather - GitHub</title>", actual);
    }

    @Test
    public void idWillFindTagWithIdOfValue() throws TransformerException, IOException, XPathExpressionException {
        String actual = runXpath(xPath().with(any(div().with(id("pl-description")))));
        assertEquals(
                "<div id=\"pl-description\" style=\"display:none\">\n" +
                        "    <p>\n" +
                        "        <em class=\"placeholder\">click here to add a description</em>\n" +
                        "    </p>\n" +
                        "</div>",
                actual);
    }

    @Test
    public void cssWillFindTagWithAttributeWithClassOfValue() throws TransformerException, IOException, XPathExpressionException {
        String actual = runXpath(xPath().with(any(div().with(css("full-button")))));
        assertEquals(
                "<div class=\"full-button\">\n" +
                        "    <button class=\"classy\" type=\"submit\">\n" +
                        "        <span>Go</span>\n" +
                        "    </button>\n" +
                        "</div>",
                actual);
    }

    @Test
    public void containingWillFindTagWithAttributeWithClassOfValue() throws TransformerException, IOException, XPathExpressionException {
        String actual = runXpath(xPath().with(any(div().with(css(containing("some-other-class"))))));
        assertEquals("<div style=\"display:none\" class=\"metabox-loader, some-other-class\" id=\"repo_details_loader\">Sending Request</div>", actual);
    }


    @Test
    public void cssWillFindTagWithAttributeClassContainingValue() throws TransformerException, IOException, XPathExpressionException {
        String actual = runXpath(xPath().with(any(div().with(css(containing("some-other-class"))))));
        assertEquals("<div style=\"display:none\" class=\"metabox-loader, some-other-class\" id=\"repo_details_loader\">Sending Request</div>",
                actual);
    }


    private String runXpath(XpathElement xpathElement) throws XPathExpressionException, TransformerException, IOException {
        NodeList result = (NodeList) newInstance().newXPath().compile(xpathElement.toXpath()).evaluate(htmlDocument, XPathConstants.NODESET);
        return prettyPrintNodeList(result.item(0));
    }

    private String prettyPrintNodeList(Node node) throws IOException {
        if (node == null) {
            return "";
        }
        StringWriter writer = new StringWriter();
        XMLSerializer serializer = new XMLSerializer(writer, new OutputFormat(Method.XML, "UTF-8", true));
        serializer.serialize(node);
        return asHtml(writer);
    }

    private String asHtml(StringWriter stringWriter) {
        return stringWriter
                .toString()
                .replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n", "")
                .trim();
    }


}
