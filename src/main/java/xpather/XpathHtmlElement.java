package xpather;

import static xpather.XpathExpression.element;

public class XpathHtmlElement {
    public static XpathElement html() {
        return element("html");
    }

    public static XpathElement head() {
        return element("head");
    }

    public static XpathElement body() {
        return element("body");
    }

    public static XpathElement title() {
        return element("title");
    }

    public static XpathElement div() {
        return element("div");
    }

    public static XpathElement span() {
        return element("span");
    }

    public static XpathElement p() {
        return element("p");
    }

    public static XpathElement h(int level) {
        return element("h"+level);
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

    static XpathElement table(){
        return element("table");
    }

    static XpathElement th(){
        return element("th");
    }

    static XpathElement tr(){
        return element("tr");
    }

    static XpathElement td(){
        return element("td");
    }

    static XpathElement img(){
        return element("img");
    }

    static XpathElement form(){
        return element("form");
    }

    static XpathElement input(){
        return element("input");
    }

    static XpathElement textarea(){
        return element("textarea");
    }

    static XpathElement select(){
        return element("select");
    }
    static XpathElement option(){
        return element("option");
    }

}
