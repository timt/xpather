package xpather;

import static xpather.XpathExpression.attribute;
import static xpather.XpathExpression.element;
import static xpather.XpathPredicate.equalTo;

public class HtmlXpathElement {
    public static XpathElement html() {
        return element("html");
    }

    public static XpathElement head() {
        return element("head");
    }

    public static XpathElement title() {
        return element("title");
    }

    public static XpathElement div() {
        return element("div");
    }

    static XpathExpression css(String className) {
        return css(equalTo(className));
    }

    static XpathExpression css(XpathDecorator xpathDecorator) {
        return xpathDecorator.decorate(attribute("class"));
    }

    static XpathElement ul(){
        return element("ul");
    }

    static XpathElement li(){
        return element("li");
    }

    static XpathExpression li(XpathDecorator xpathDecorator){
        return xpathDecorator.decorate(li());
    }

    static XpathElement anchor(){
        return element("a");
    }

}
