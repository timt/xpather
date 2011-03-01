package xpather;

public class XpathComposite implements XpathFragment {
    private XpathFragment[] xpathFragments;

    public XpathComposite(XpathFragment... xpathFragments) {
        this.xpathFragments = xpathFragments;
    }

    @Override
    public String toXpath() {
        String xpath = "";
        for (XpathFragment xpathFragment : xpathFragments) {
            xpath += xpathFragment.toXpath();
        }
        return xpath;
    }
}
