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
import static xpather.XpathExpression.attribute;

public class XpathAttributeTest {

    @Test
    public void toXpathWillReturnAttribute(){
        assertThat(attribute("someAttribute").toXpath(), is("@someAttribute"));
    }
    @Test
    public void equalToWillReturnAttributeEqualsPredicateXpath() {
        assertThat(attribute("someAttribute").is("aValue").toXpath(), is("[@someAttribute='aValue']"));
    }

    @Test
    public void containingWillReturnAttributeContainingPredicateXpath(){
        assertThat(attribute("anAttribute").containing("someValue").toXpath(), is("[contains(@anAttribute,'someValue')]"));
    }

}
