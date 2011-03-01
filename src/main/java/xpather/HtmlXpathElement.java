package xpather;

import static xpather.XpathAttribute.xpathAttribute;
import static xpather.XpathElement.xpathElement;
import static xpather.XpathPredicate.equalTo;

public class HtmlXpathElement {
    public static XpathElement html() {
        return xpathElement("html");
    }

    public static XpathElement head() {
        return xpathElement("head");
    }

    public static XpathElement title() {
        return xpathElement("title");
    }

    public static XpathElement div() {
        return xpathElement("div");
    }

    static XpathExpression css(String className) {
        return css(equalTo(className));
    }

    static XpathExpression css(XpathDecorator xpathDecorator) {
        return xpathDecorator.decorate(xpathAttribute("class"));
    }

    static XpathElement ul(){
        return xpathElement("ul");
    }

    static XpathElement li(){
        return xpathElement("li");
    }

    static XpathExpression li(XpathDecorator xpathDecorator){
        return xpathDecorator.decorate(li());
    }

    static XpathElement anchor(){
        return xpathElement("a");
    }

}
