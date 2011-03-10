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

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathExpression.*;

public class XpathExpressionTest {

    @Test
    public void constructionWillCreateFragmentThatIsComposedOfPrameters() {
        XpathElement element = element("Book");
        XpathAttribute attribute = attribute("lang");
        XpathPredicate predicate = predicate("2");

        assertThat(xpathExpression(element, attribute, predicate).toXpath(), is("/Book@lang[2]"));
    }

    @Test
    public void withWillAddFragmentToXpathExpression(){
        XpathExpression xpathExpression = xpathExpression();
        String xPath = xpathExpression.with(element("Book")).toXpath();
        assertThat(xPath,is("/Book"));
    }

    @Test
    public void atIndexWillAppendIndexPredicate() {
        XpathExpression xpathExpression = xpathExpression(anXpathFragment("something")).atIndex(3);
        assertThat(xpathExpression.toXpath(), is("something[3]"));
    }

    private XpathFragment anXpathFragment(final String fragment) {
        return new XpathFragment() {
            @Override
            public String toXpath() {
                return fragment;
            }
        };
    }


}
