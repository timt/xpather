package xpather;

import java.util.ArrayList;
import java.util.List;

public class XpathElement implements XpathFragment {
    private final String name;
    private List<XpathFragment> subXpathElements = new ArrayList<XpathFragment>();

    public XpathElement(String name) {
        this.name = name;
    }

    public static XpathElement xpathElement(String name) {
        return new XpathElement(name);
    }

    @Override
    public String toXpath() {
        return "/" + name + subXpathElementsToXpath();
    }

    public XpathElement with(XpathFragment subXpathElement) {
        this.subXpathElements.add(subXpathElement);
        return this;
    }

    public static XpathFragment any(XpathElement xpathElement) {
        return xpathElement(xpathElement.toXpath());
    }

    String subXpathElementsToXpath() {
        String xpath = "";
        for (XpathFragment xpathFragment : subXpathElements) {
            xpath += xpathFragment.toXpath();
        }
        return xpath;
    }

    @Override
    public String toString() {
        return toXpath();
    }

    public static XpathElement xPath() {
        return new XpathElement(null) {
            @Override
            public String toXpath() {
                return subXpathElementsToXpath();
            }
        };
    }

}
