package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathPredicate.containing;
import static xpather.XpathPredicate.index;

public class XpathPredicateTest {
    @Test
    public void toXpathWillPutContentsInSquareBrackets() {
        assertThat(XpathExpression.predicate("1").toXpath(), is("[1]"));
    }

    @Test
    public void containingWillReturnEqualsPredicateXpath() {
        XpathFragment someFragment = xpathFragment("something");
        assertThat(containing("aValue").decorate(someFragment).toXpath(), is("[contains(something,'aValue')]"));
    }

    @Test
    public void indexOfWillAppendIndexPredicateToXpath(){
        XpathFragment someFragment = xpathFragment("something");
        assertThat(index(2).decorate(someFragment).toXpath(), is("something[2]"));

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
