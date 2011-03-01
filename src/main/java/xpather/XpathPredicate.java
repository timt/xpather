package xpather;

public class XpathPredicate implements XpathFragment{
    private String predicate;

    public XpathPredicate(String predicate) {
        this.predicate = predicate;
    }

    static XpathPredicate xpathPredicate(String predicate) {
        return new XpathPredicate(predicate);
    }

    public static XpathEnricher containing(final String value){
        return new XpathEnricher() {
            @Override
            public XpathFragment enrich(XpathFragment xpathFragment) {
                return xpathPredicate("contains(" + xpathFragment.toXpath() + ",'" + value + "')");
            }
        };
    }

    public static XpathEnricher equalTo(final String value){
        return new XpathEnricher() {
            @Override
            public XpathFragment enrich(XpathFragment xpathFragment) {
                return xpathPredicate(xpathFragment.toXpath() + "='" + value + "'");
            }
        };
    }

    public static XpathEnricher indexOf(final int index){
        return new XpathEnricher() {
            @Override
            public XpathFragment enrich(XpathFragment xpathFragment) {
                return new XpathComposite(xpathFragment, xpathPredicate("" + index));
            }
        };
    }

    @Override
    public String toXpath() {
        return "["+predicate+"]";
    }
}
