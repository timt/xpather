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

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static xpather.XpathPredicate.equalTo;
import static xpather.XpathPredicate.index;

public class XpathExpression<T extends XpathExpression> implements XpathFragment {
    private List<XpathFragment> xpathFragments=new ArrayList<XpathFragment>();

    public static XpathExpression xpathExpression(XpathFragment... xpathFragments) {
        return new XpathExpression(xpathFragments);

    }

    protected XpathExpression(XpathFragment... xpathFragments) {
        this.xpathFragments.addAll(asList(xpathFragments));
    }

    public static XpathExpression xPath() {
        return new XpathExpression();
    }

    public static XpathElement element(String name) {
        return new XpathElement(name);
    }

    static XpathAttribute attribute(String name) {
        return new XpathAttribute(name);
    }

    static XpathPredicate predicate(String predicate) {
        return new XpathPredicate(predicate);
    }

    @Override
    public String toXpath() {
        String xpath = "";
        for (XpathFragment xpathFragment : xpathFragments) {
            xpath += xpathFragment.toXpath();
        }
        return xpath;
    }

    @Override
    public String toString() {
        return toXpath();
    }

    public T with(XpathFragment xpathFragment) {
        this.xpathFragments.add(xpathFragment);
        return (T)this;
    }

    public XpathPredicate is(String value) {
        return equalTo(value).decorate(this);
    }

    public XpathExpression atIndex(int index) {
        return index(index).decorate(this);
    }
}
