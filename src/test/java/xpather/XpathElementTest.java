package xpather;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathElement.any;
import static xpather.XpathExpression.xpathElement;

public class XpathElementTest {

    @Test
    public void toStringWillReturnValidXpathForElement() {
        assertThat(xpathElement("Book").toString(), is("/Book"));
    }

    @Test
    public void anyWillAddLeadingSlashToXpathElement() {
        assertThat(any(xpathElement("Book")).toXpath(), is("//Book"));
    }
}
