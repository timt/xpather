package xpather;

public class XpathElement extends XpathExpression<XpathElement> {

    public XpathElement(final String name) {
        super(new XpathFragment() {
            @Override
            public String toXpath() {
                return "/" + name;
            }
        });
    }

    public static XpathFragment any(XpathElement xpathElement) {
        return xpathElement(xpathElement.toXpath());
    }

}
