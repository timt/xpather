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

class EqualToXpathDecorator implements XpathDecorator<XpathPredicate> {
    private final String value;

    public EqualToXpathDecorator(String value) {
        this.value = value;
    }

    @Override
    public XpathPredicate decorate(XpathFragment xpathFragment) {
        assertIsInstanceOfElementOrAttribute(xpathFragment);
        String xpath = stripLeadingSlash(xpathFragment);

        return XpathExpression.predicate(xpath + "='" + value + "'");
    }

    private void assertIsInstanceOfElementOrAttribute(XpathFragment xpathFragment) {
        if(xpathFragment instanceof XpathElement || xpathFragment instanceof XpathAttribute){
            return;
        }
        throw new IllegalXpathExpressionException("is() can only be applied to and Element or Attribute, not to : "+xpathFragment.toXpath());
    }

    private String stripLeadingSlash(XpathFragment xpathFragment) {
        return xpathFragment.toXpath().replace("/", "");
    }


}
