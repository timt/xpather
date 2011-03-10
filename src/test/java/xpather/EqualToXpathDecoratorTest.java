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

import static junit.framework.Assert.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static xpather.XpathExpression.attribute;
import static xpather.XpathExpression.element;
import static xpather.XpathPredicate.equalTo;

public class EqualToXpathDecoratorTest {
    @Test
    public void equalToWillReturnEqualsPredicateXpath() {
        XpathFragment someFragment = attribute("something");
        assertThat(equalTo("aValue").decorate(someFragment).toXpath(), is("[@something='aValue']"));
    }

    @Test
    public void equalToWillStripLeadingSlashWhenAppiedToElements(){
        XpathFragment someFragment = element("something");
        assertThat(equalTo("aValue").decorate(someFragment).toXpath(), is("[something='aValue']"));
    }

    @Test
    public void equalToWillThrowExceptionWhenXpathFragmentIsNotElementOrAttribute(){
        XpathFragment someFragment = xpathFragment("something");
        try{
            assertThat(equalTo("aValue").decorate(someFragment).toXpath(), is("[something='aValue']"));
            fail("Expected exception to be thrown when");
        }catch(IllegalXpathExpressionException e){
            assertThat(e.getMessage(), is("is() can only be applied to and Element or Attribute, not to : something"));
        }
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
