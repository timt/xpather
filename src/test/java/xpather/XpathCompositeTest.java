package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathAttribute.xpathAttribute;
import static xpather.XpathElement.xpathElement;
import static xpather.XpathPredicate.xpathPredicate;

public class XpathCompositeTest {

    @Test
    public void constructionWillCreateFragmentThatIsComposedOfPrameters(){
        XpathElement element = xpathElement("Book");
        XpathAttribute attribute = xpathAttribute("lang");
        XpathPredicate predicate = xpathPredicate("2");

        assertThat(new XpathComposite(element, attribute, predicate).toXpath(),is("/Book@lang[2]"));
    }
}
