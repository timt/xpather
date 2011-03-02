Xpather
=======

Xpather is a simple DSL for generating xpath exprssions, including specific support for creating xpath expression for xHtml

Cookbook
--------

* [Selecting the root node i.e. /Library](#selectingRootNode)
* Select a node from the current node the document not matter where they are, i.e. /Library//Book
* Select a node with attribute, i.e. //Book/@language
* Select a node with attribute with value, i.e. //Book[@language='english']
* Select xHtml element with id, i.e. //div[@id='myId']
* Select xHtml element with style class, i.e. //div[@class='myClass']
* Select an xHtml element with an attribute that contains a value, i.e. //div[contains(@class, 'myClass')]
* Select a repeating element at index, i.e. //div/ul/li[2]


[selectingRootNode]: Selecting the root node i.e. /Library][selectingRootNode
-----------------------------------------------------------------------------
    import static xpather.XpathExpression.*;
    ...
    xPath().with(element("Library")).toXpath();

Will return the xpath expression
    /Library
