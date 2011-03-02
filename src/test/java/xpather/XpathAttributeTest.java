package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathExpression.attribute;

public class XpathAttributeTest {

    @Test
    public void toXpathWillReturnAttribute(){
        assertThat(attribute("someAttribute").toXpath(), is("@someAttribute"));
    }
    @Test
    public void ofValueWillReturnAttributeEqualsPredicateXpath() {
        assertThat(attribute("someAttribute").ofValue("aValue").toXpath(), is("[@someAttribute='aValue']"));
    }

    @Test
    public void containingWillReturnAttributeContainingPredicateXpath(){
        assertThat(attribute("anAttribute").containing("someValue").toXpath(), is("[contains(@anAttribute,'someValue')]"));
    }

}
