package xpather;

import static xpather.XpathPredicate.equalTo;

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
        return attribute("id").ofValue(value);
    }

    public XpathFragment ofValue(String value) {
        return equalTo(value).decorate(this);
    }

    public XpathFragment containing(String value) {
        return XpathPredicate.containing(value).decorate(this);
    }


}
