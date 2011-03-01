package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathPredicate.*;

public class XpathPredicateTest {
    @Test
    public void toXpathWillPutContentsInSquareBrackets() {
        assertThat(xPathPredicate("1").toXpath(), is("[1]"));
    }

    @Test
    public void hasValueWillReturnEqualsPredicateXpath() {
        XpathFragment someFragment = xpathFragment("something");
        assertThat(equalTo("aValue").enrich(someFragment).toXpath(), is("[something='aValue']"));
    }

    @Test
    public void containingWillReturnEqualsPredicateXpath() {
        XpathFragment someFragment = xpathFragment("something");
        assertThat(containing("aValue").enrich(someFragment).toXpath(), is("[contains(something,'aValue')]"));
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
