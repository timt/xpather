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

    static XpathFragment css(String className) {
        return css(equalTo(className));
    }

    static XpathFragment css(XpathEnricher xpathEnricher) {
        return xpathEnricher.enrich(xpathAttribute("class"));
    }

    static XpathElement ul(){
        return xpathElement("ul");
    }

    static XpathElement li(){
        return xpathElement("li");
    }

    static XpathFragment li(XpathEnricher xpathEnricher){
        return xpathEnricher.enrich(li());
    }

}
