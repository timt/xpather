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
import static xpather.XpathPredicate.containing;
import static xpather.XpathPredicate.index;

public class XpathPredicateTest {
    @Test
    public void toXpathWillPutContentsInSquareBrackets() {
        assertThat(XpathExpression.predicate("1").toXpath(), is("[1]"));
    }

    @Test
    public void containingWillReturnEqualsPredicateXpath() {
        XpathFragment someFragment = xpathFragment("something");
        assertThat(containing("aValue").decorate(someFragment).toXpath(), is("[contains(something,'aValue')]"));
    }

    @Test
    public void indexOfWillAppendIndexPredicateToXpath(){
        XpathFragment someFragment = xpathFragment("something");
        assertThat(index(2).decorate(someFragment).toXpath(), is("something[2]"));

    }

    private XpathFragment xpathFragment(final String something) {
        return new XpathFragment() {
            @Override
            public String toXpath() {
                return something;
            }
        };
    }


}
