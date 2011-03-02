package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathExpression.*;

public class XpathExpressionTest {

    @Test
    public void constructionWillCreateFragmentThatIsComposedOfPrameters() {
        XpathElement element = element("Book");
        XpathAttribute attribute = attribute("lang");
        XpathPredicate predicate = predicate("2");

        assertThat(xpathComposite(element, attribute, predicate).toXpath(), is("/Book@lang[2]"));
    }

    @Test
    public void withWillAddFragmentToXpathExpression(){
        XpathExpression xpathExpression = xpathComposite();
        String xPath = xpathExpression.with(element("Book")).toXpath();
        assertThat(xPath,is("/Book"));
    }


}
