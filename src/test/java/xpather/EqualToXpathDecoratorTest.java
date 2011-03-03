package xpather;

import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathExpression.attribute;
import static xpather.XpathExpression.element;
import static xpather.XpathPredicate.equalTo;

public class EqualToXpathDecoratorTest {
    @Test
    public void equalToWillReturnEqualsPredicateXpath() {
        XpathFragment someFragment = attribute("something");
        assertThat(equalTo("aValue").decorate(someFragment).toXpath(), is("[@something='aValue']"));
    }

    @Test
    public void equalToWillStripLeadingSlashWhenAppiedToElements(){
        XpathFragment someFragment = element("something");
        assertThat(equalTo("aValue").decorate(someFragment).toXpath(), is("[something='aValue']"));
    }

    @Test
    public void equalToWillThrowExceptionWhenXpathFragmentIsNotElementOrAttribute(){
        XpathFragment someFragment = xpathFragment("something");
        try{
            assertThat(equalTo("aValue").decorate(someFragment).toXpath(), is("[something='aValue']"));
            fail("Expected exception to be thrown when");
        }catch(IllegalXpathExpressionException e){
            assertThat(e.getMessage(), is("is() can only be applied to and Element or Attribute, not to : something"));
        }
    }

     private XpathFragment xpathFragment(final String something) {
        return new XpathFragment() {
            @Override
            public String toXpath() {
                return something;
            }
        };
    }

}
