package xpather;

class EqualToXpathDecorator implements XpathDecorator<XpathPredicate> {
    private final String value;

    public EqualToXpathDecorator(String value) {
        this.value = value;
    }

    @Override
    public XpathPredicate decorate(XpathFragment xpathFragment) {
        assertIsInstanceOfElementOrAttribute(xpathFragment);
        String xpath = stripLeadingSlash(xpathFragment);

        return XpathExpression.predicate(xpath + "='" + value + "'");
    }

    private void assertIsInstanceOfElementOrAttribute(XpathFragment xpathFragment) {
        if(xpathFragment instanceof XpathElement || xpathFragment instanceof XpathAttribute){
            return;
        }
        throw new IllegalXpathExpressionException("is() can only be applied to and Element or Attribute, not to : "+xpathFragment.toXpath());
    }

    private String stripLeadingSlash(XpathFragment xpathFragment) {
        return xpathFragment.toXpath().replace("/", "");
    }


}
