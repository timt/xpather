package xpather;

public class XpathElement extends XpathComposite<XpathElement> {

    public XpathElement(final String name) {
        super(new XpathFragment() {
            @Override
            public String toXpath() {
                return "/" + name;
            }
        });
    }

    public static XpathElement xpathElement(String name) {
        return new XpathElement(name);
    }

    public static XpathFragment any(XpathElement xpathElement) {
        return XpathElement.xpathElement(xpathElement.toXpath());
    }

}
