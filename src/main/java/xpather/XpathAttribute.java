package xpather;

public class XpathAttribute extends XpathExpression<XpathAttribute>{

    public XpathAttribute(final String name) {
        super(new XpathFragment() {
            @Override
            public String toXpath() {
                return "@" + name;
            }
        });
    }

    static XpathFragment id(String value) {
        return attribute("id").is(value);
    }

    public XpathFragment containing(String value) {
        return XpathPredicate.containing(value).decorate(this);
    }


}
