Xpather
=======

Xpather is a simple DSL for generating xpath expressions, including specific support for creating xpath expression for xHtml

Cookbook
--------

* Selecting the root node i.e. /Library
* Select a node from the current node the document not matter where they are, i.e. /Library//Book
* Select all the elements with a given value, i.e., //book[price='35.00']
* Select a node with attribute, i.e. //Book/@language
* Select a node with attribute with value, i.e. //Book[@language='english']
* Select xHtml element with id, i.e. //div[@id='myId']
* Select xHtml element with style class, i.e. //div[@class='myClass']
* Select an xHtml element with an attribute that contains a value, i.e. //div[contains(@class, 'myClass')]
* Select a repeating element at index, i.e. //div/ul/li[2]


Selecting the root node i.e. /Library
-------------------------------------

    import static xpather.XpathExpression.*;
    ...
    element("Library").toXpath();

Will return the xpath expression

    /Library

Select a node from the current node the document no matter where they are, i.e. /Library//Book
-------------------

    import static xpather.XpathExpression.*;
    ...
    element("Library").with(any(element("Book"))).toXpath();

Will return the xpath expression

    /Library//Book

Select all the elements with a given value, i.e., //book[price='35.00']
-------------------

    import static xpather.XpathExpression.*;
    ...
    any(element("book")).with(element("price").equalTo("35.00")).toXpath();

Will return the xpath expression

    /Library//Book


Select a node with attribute, i.e. //Book/@language
-------------

    import static xpather.XpathExpression.*;
    ...
    any(element("Book")).with(attribute("language")).toXpath();

Will return the xpath expression

    //Book/@language

Select a node with attribute with value, i.e. //Book[@language='english']
-----------------

    import static xpather.XpathExpression.*;
    ...
    any(element("Book")).with(attribute("language").containing("english")).toXpath();

Will return the xpath expression

    //Book[@language='english']

Select xHtml element with id, i.e. //div[@id='myId']
-----------------

    import static xpather.XpathExpression.*;
    ...
    any(div().with(id("myId"))).toXpath();

Will return the xpath expression
    //div[@id='myId']


Select xHtml element with style class, i.e. //div[@class='myClass']
---------------


    import static xpather.XpathExpression.*;
    ...
    any(div().with(css("myClass"))).toXpath();

Will return the xpath expression

    //div[@class='myClass']

Select an xHtml element with an attribute that contains a value, i.e. //div[contains(@class, 'myClass')]
-----------------


    import static xpather.XpathExpression.*;
    ...
    any(div().with(css(containing("myClass")))).toXpath();

Will return the xpath expression

    //div[contains(@class, 'myClass')]

Select a repeating element at index, i.e. //div/ul/li[2]
--------------------

    import static xpather.XpathExpression.*;
    ...
    any(div().with(ul().with(li().atIndex(2)))).toXpath();

Will return the xpath expression

    //div/ul/li[2]
