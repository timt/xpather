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
import static xpather.XpathElement.any;
import static xpather.XpathExpression.element;

public class XpathElementTest {

    @Test
    public void toStringWillReturnValidXpathForElement() {
        assertThat(element("Book").toString(), is("/Book"));
    }

    @Test
    public void anyWillAddLeadingSlashToXpathElement() {
        assertThat(any(element("Book")).toXpath(), is("//Book"));
    }

    @Test
    public void equalToWillApplyEqualToPredicateToElement(){
        assertThat(element("bookstore").with(element("book").with(element("price").is("35.00"))).toXpath(), is("/bookstore/book[price='35.00']"));
    }
}
