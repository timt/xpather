package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathElement.any;
import static xpather.XpathExpression.element;

public class XpathElementTest {

    @Test
    public void toStringWillReturnValidXpathForElement() {
        assertThat(element("Book").toString(), is("/Book"));
    }

    @Test
    public void anyWillAddLeadingSlashToXpathElement() {
        assertThat(any(element("Book")).toXpath(), is("//Book"));
    }
}
