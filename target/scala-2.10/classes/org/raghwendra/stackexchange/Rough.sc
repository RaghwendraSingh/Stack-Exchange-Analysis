import org.raghwendra.stackexchange.PostsXMLUtil

val xmlString = """
                  |<row Id="3381" PostTypeId="5" CreationDate="2012-09-23T09:12:58.853" Score="0" Body="&lt;p&gt;&lt;a href=&quot;http://en.wikipedia.org/wiki/Science&quot; rel=&quot;nofollow&quot;&gt;Science&lt;/a&gt; (from Latin scientia, meaning &quot;knowledge&quot;) is a systematic enterprise that builds and organizes knowledge in the form of testable explanations and predictions about the universe.&lt;/p&gt;&#xA;&#xA;&lt;p&gt;In an older and closely related meaning, &quot;science&quot; refers to the body of reliable knowledge itself, of the type that can be logically and rationally explained. &lt;/p&gt;&#xA;&#xA;&lt;p&gt;&lt;em&gt;Note :&lt;/em&gt; This tag wiki has content adapted from Wikipedia, used under the CC-BY-SA 3.0 license.&lt;/p&gt;&#xA;" OwnerUserId="1580" LastEditorUserId="1580" LastEditDate="2012-09-24T07:20:28.387" LastActivityDate="2012-09-24T07:20:28.387" CommentCount="0" />
"""



val xml = PostsXMLUtil.toXML(xmlString)

PostsXMLUtil.getAttributeFromElem(xml, "href")