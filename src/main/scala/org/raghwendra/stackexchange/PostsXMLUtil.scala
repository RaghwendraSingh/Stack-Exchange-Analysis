package org.raghwendra.stackexchange

import scala.xml._

/**
  * Created by Raghwendra on 27/9/16.
  */
object PostsXMLUtil {
  def containsRow(line: String) = line.contains("row")

  def toXML(xmlString: String): scala.xml.Elem = XML.loadString(xmlString)

  def getAttributeFromElem(elem: scala.xml.Elem, attribute: String) = (elem \ s"@$attribute").toString

}
