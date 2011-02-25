package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathAttribute.xpathAttribute;

public class XpathAttributeTest {

    @Test
    public void toXpathWillReturnAttribute(){
        assertThat(xpathAttribute("someAttribute").toXpath(), is("@someAttribute"));
    }
    @Test
    public void ofValueWillReturnAttributeEqualsPredicateXpath() {
        assertThat(xpathAttribute("someAttribute").ofValue("aValue").toXpath(), is("[@someAttribute='aValue']"));
    }

    @Test
    public void containingWillReturnAttributeContainingPredicateXpath(){
        assertThat(xpathAttribute("anAttribute").containing("someValue").toXpath(), is("[contains(@anAttribute,'someValue')]"));
    }

}
