package xpather;

import static xpather.XpathExpression.attribute;
import static xpather.XpathPredicate.equalTo;

public class XpathHtmlAttribute {
    static XpathExpression css(String className) {
        return css(equalTo(className));
    }

    static XpathExpression css(XpathDecorator xpathDecorator) {
        return xpathDecorator.decorate(attribute("class"));
    }
}
