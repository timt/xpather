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
import static xpather.XpathComposite.xPath;
import static xpather.XpathElement.any;
import static xpather.XpathPredicate.containing;
import static xpather.XpathPredicate.indexOf;

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
        assertXpath(xPath().with(html()), locatesHtml(html));
    }

    @Test
    public void anyWillFindSubElementAnyWhere() throws XPathExpressionException, TransformerException, IOException {
        assertXpath(xPath().with(any(title())), locatesHtml("<title>timt/xpather - GitHub</title>"));
    }

    @Test
    public void willChainHtmlElements() throws TransformerException, IOException, XPathExpressionException {
        assertXpath(
                xPath()
                        .with(html())
                        .with(head())
                        .with(title()),
                locatesHtml("<title>timt/xpather - GitHub</title>"));
    }

    @Test
    public void idWillFindTagWithIdOfValue() throws TransformerException, IOException, XPathExpressionException {
        assertXpath(
                xPath().with(any(div().with(id("pl-description")))),
                locatesHtml("<div id=\"pl-description\" style=\"display:none\">\n" +
                        "    <p>\n" +
                        "        <em class=\"placeholder\">click here to add a description</em>\n" +
                        "    </p>\n" +
                        "</div>"));
    }

    @Test
    public void cssWillFindTagWithAttributeWithClassOfValue() throws TransformerException, IOException, XPathExpressionException {
        assertXpath(
                xPath().with(any(div().with(css("full-button")))),
                locatesHtml("<div class=\"full-button\">\n" +
                        "    <button class=\"classy\" type=\"submit\">\n" +
                        "        <span>Go</span>\n" +
                        "    </button>\n" +
                        "</div>"));
    }

    @Test
    public void containingWillFindTagWithAttributeWithClassOfValue() throws TransformerException, IOException, XPathExpressionException {
        assertXpath(
                xPath().with(any(div().with(css(containing("some-other-class"))))),
                locatesHtml("<div style=\"display:none\" class=\"metabox-loader, some-other-class\" id=\"repo_details_loader\">Sending Request</div>"));
    }


    @Test
    public void cssWillFindTagWithAttributeClassContainingValue() throws TransformerException, IOException, XPathExpressionException {
        XpathFragment xpathFragment = xPath().with(any(div().with(css(containing("some-other-class")))));
        assertXpath(xpathFragment, locatesHtml("<div style=\"display:none\" class=\"metabox-loader, some-other-class\" id=\"repo_details_loader\">Sending Request</div>"));
    }

    @Test
    public void indexOfWillAppendAIndexPredicateToElement() throws TransformerException, IOException, XPathExpressionException {
        XpathFragment xpathFragment = xPath().with(any(div().with(css("subnav-bar")).with(ul().with(li(indexOf(2))))));

        assertXpath(xpathFragment, locatesHtml(
                "<li>\n" +
                        "    <a class=\"dropdown defunct\" href=\"#\">Switch Tags (0)</a>\n" +
                        "</li>"));
    }

    private void assertXpath(XpathFragment xpathFragment, String expectedHtmlToLocate) {
        assertEquals(parseHtmlWithXpath(xpathFragment), expectedHtmlToLocate);
    }

    private String locatesHtml(String htmlToLocate) {
        return htmlToLocate;
    }


    private String parseHtmlWithXpath(XpathFragment xpathElement) {
        System.out.println("xpathElement.toXpath() = " + xpathElement.toXpath());
        try {
            NodeList result = (NodeList) newInstance().newXPath().compile(xpathElement.toXpath()).evaluate(htmlDocument, XPathConstants.NODESET);
            return prettyPrintNodeList(result.item(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
