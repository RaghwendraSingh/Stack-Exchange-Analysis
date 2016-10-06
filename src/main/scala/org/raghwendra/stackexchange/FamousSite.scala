package org.raghwendra.stackexchange

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Raghwendra on 27/9/16.
  */
object FamousSite {
  def main(args: Array[String]) {
    if (args.length != 3) {
      System.err.println("usage: <appName> <inputPath> <outputPath>")
      System.exit(1)
    }

    val Seq(appName, inputPath, outputPath) = args.toSeq

    val conf = new SparkConf()
      .setAppName(appName)
      .setJars(SparkContext.jarOfClass(this.getClass).toSeq)

    val sc = new SparkContext(conf)

    val postsFile = sc.textFile(inputPath)

    val questionsByMonths = postsFile.filter(PostsXMLUtil.containsRow(_))
      .map(PostsXMLUtil.toXML(_))
      .filter(PostsXMLUtil.getAttributeFromElem(_, "PostTypeId").equals("1"))
      .map(PostsXMLUtil.getAttributeFromElem(_, "CreationDate").split("T")(0))
      .map(date => {
        val dateParts = date.split("-")
        (dateParts(0)+"-"+dateParts(1),1)
      })
      .combineByKey(v => v,
        (aggV: Int, newValue: Int) => aggV + newValue,
        (acc1: Int, acc2: Int) => acc1 + acc2)

    questionsByMonths.saveAsTextFile(outputPath+"/questionsByMonths")

  }
}
