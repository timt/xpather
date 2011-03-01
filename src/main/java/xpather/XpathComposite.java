package xpather;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class XpathComposite<T extends XpathComposite> implements XpathFragment {
    private List<XpathFragment> xpathFragments=new ArrayList<XpathFragment>();

    public static XpathComposite xpathComposite(XpathFragment... xpathFragments) {
        return new XpathComposite(xpathFragments);

    }

    public XpathComposite(XpathFragment... xpathFragments) {
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

    public static XpathComposite xPath() {
        return new XpathComposite();
    }
}
