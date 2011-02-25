package xpather;

public class XpathPredicate implements XpathFragment{
    private String predicate;

    public XpathPredicate(String predicate) {
        this.predicate = predicate;
    }

    static XpathPredicate xPathPredicate(String predicate) {
        return new XpathPredicate(predicate);
    }

    static XpathPredicate hasValue(XpathFragment xpathFragment, String value){
        return xPathPredicate(xpathFragment.toXpath() + "='" + value + "'");
    }

    public static XpathPredicate containing(XpathFragment xpathFragment, String value) {
        return xPathPredicate("contains("+xpathFragment.toXpath()+",'"+value+"')");
    }

    public static XpathEnricher containing(final String value){
        return new XpathEnricher() {
            @Override
            public XpathFragment enrich(XpathFragment xpathFragment) {
                return containing(xpathFragment, value);
            }
        };
    }

    public static XpathEnricher equalTo(final String value){
        return new XpathEnricher() {
            @Override
            public XpathFragment enrich(XpathFragment xpathFragment) {
                return hasValue(xpathFragment, value);
            }
        };
    }

    @Override
    public String toXpath() {
        return "["+predicate+"]";
    }
}
