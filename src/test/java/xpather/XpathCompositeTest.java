package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathAttribute.xpathAttribute;
import static xpather.XpathComposite.xpathComposite;
import static xpather.XpathElement.xpathElement;
import static xpather.XpathPredicate.xpathPredicate;

public class XpathCompositeTest {

    @Test
    public void constructionWillCreateFragmentThatIsComposedOfPrameters() {
        XpathElement element = xpathElement("Book");
        XpathAttribute attribute = xpathAttribute("lang");
        XpathPredicate predicate = xpathPredicate("2");

        assertThat(xpathComposite(element, attribute, predicate).toXpath(), is("/Book@lang[2]"));
    }

    @Test
    public void withWillAddFragmentToXpathExpression(){
        XpathComposite xpathComposite = xpathComposite();
        String xPath = xpathComposite.with(xpathElement("Book")).toXpath();
        assertThat(xPath,is("/Book"));
    }


}
