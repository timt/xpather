package xpather;

import static xpather.XpathPredicate.hasValue;

public class XpathAttribute implements XpathFragment {
    public final String name;

    public XpathAttribute(String name) {
        this.name = name;
    }


    static XpathAttribute xpathAttribute(String name) {
        return new XpathAttribute(name);
    }

    static XpathFragment id(String value) {
        return xpathAttribute("id").ofValue(value);
    }

    @Override
    public String toXpath() {
        return "@" + name;
    }

    public XpathFragment ofValue(String value) {
        return hasValue(this, value);
    }

    public XpathFragment containing(String value) {
        return XpathPredicate.containing(this, value);
    }


}
