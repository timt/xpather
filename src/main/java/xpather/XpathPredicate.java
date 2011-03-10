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

public class XpathPredicate extends XpathExpression<XpathPredicate>{

    public XpathPredicate(final String predicate) {
        super(new XpathFragment() {
            @Override
            public String toXpath() {
                return "["+predicate+"]";
            }
        });
    }

    public static XpathDecorator<XpathPredicate> containing(final String value){
        return new XpathDecorator<XpathPredicate>() {
            @Override
            public XpathPredicate decorate(XpathFragment xpathFragment) {
                return predicate("contains(" + xpathFragment.toXpath() + ",'" + value + "')");
            }
        };
    }

    public static XpathDecorator<XpathPredicate> equalTo(final String value){
        return new EqualToXpathDecorator(value);
    }

    public static XpathDecorator<XpathExpression> index(final int index){
        return new XpathDecorator<XpathExpression>() {
            @Override
            public XpathExpression decorate(XpathFragment xpathFragment) {
                return xpathExpression(xpathFragment, predicate("" + index));
            }
        };
    }

}
