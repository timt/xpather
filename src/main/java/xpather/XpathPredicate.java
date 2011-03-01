package xpather;

public class XpathPredicate extends XpathExpression<XpathPredicate>{

    public XpathPredicate(final String predicate) {
        super(new XpathFragment() {
            @Override
            public String toXpath() {
                return "["+predicate+"]";
            }
        });
    }

    static XpathPredicate xpathPredicate(String predicate) {
        return new XpathPredicate(predicate);
    }

    public static XpathDecorator<XpathPredicate> containing(final String value){
        return new XpathDecorator<XpathPredicate>() {
            @Override
            public XpathPredicate decorate(XpathFragment xpathFragment) {
                return xpathPredicate("contains(" + xpathFragment.toXpath() + ",'" + value + "')");
            }
        };
    }

    public static XpathDecorator<XpathPredicate> equalTo(final String value){
        return new XpathDecorator<XpathPredicate>() {
            @Override
            public XpathPredicate decorate(XpathFragment xpathFragment) {
                return xpathPredicate(xpathFragment.toXpath() + "='" + value + "'");
            }
        };
    }

    public static XpathDecorator<XpathExpression> indexOf(final int index){
        return new XpathDecorator<XpathExpression>() {
            @Override
            public XpathExpression decorate(XpathFragment xpathFragment) {
                return new XpathExpression(xpathFragment, xpathPredicate("" + index));
            }
        };
    }
}
