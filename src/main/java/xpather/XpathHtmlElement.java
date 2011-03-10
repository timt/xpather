/**
 * Copyright (C) 2011 timt http://github.com/timt/xpather
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
