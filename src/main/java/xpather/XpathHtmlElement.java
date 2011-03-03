package xpather;

import static xpather.XpathExpression.element;

public class XpathHtmlElement {
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

    static XpathElement ul(){
        return element("ul");
    }

    static XpathElement li(){
        return element("li");
    }

    static XpathElement anchor(){
        return element("a");
    }

}
