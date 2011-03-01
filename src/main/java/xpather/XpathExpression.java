package xpather;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class XpathExpression<T extends XpathExpression> implements XpathFragment {
    private List<XpathFragment> xpathFragments=new ArrayList<XpathFragment>();

    public static XpathExpression xpathComposite(XpathFragment... xpathFragments) {
        return new XpathExpression(xpathFragments);

    }

    public XpathExpression(XpathFragment... xpathFragments) {
        this.xpathFragments.addAll(asList(xpathFragments));
    }

    @Override
    public String toXpath() {
        String xpath = "";
        for (XpathFragment xpathFragment : xpathFragments) {
            xpath += xpathFragment.toXpath();
        }
        return xpath;
    }

    @Override
    public String toString() {
        return toXpath();
    }

    public T with(XpathFragment xpathFragment) {
        this.xpathFragments.add(xpathFragment);
        return (T)this;
    }

    public static XpathExpression xPath() {
        return new XpathExpression();
    }
}
