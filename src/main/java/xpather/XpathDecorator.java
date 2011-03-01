package xpather;

public interface XpathDecorator<T extends XpathExpression> {
    T decorate(XpathFragment xpathFragment);
}
