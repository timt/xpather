package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class XpathCompositeTest {

    @Test
    public void constructionWillCreateFragmentThatIsComposedOfPrameters(){
        XpathElement element = new XpathElement("Book");
        XpathAttribute attribute = new XpathAttribute("lang");
        XpathPredicate predicate = new XpathPredicate("2");

        assertThat(new XpathComposite(element, attribute, predicate).toXpath(),is("/Book@lang[2]"));
    }
}
