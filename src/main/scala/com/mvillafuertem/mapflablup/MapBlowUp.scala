package com.mvillafuertem.mapflablup

import scala.collection.mutable

final class MapBlowUp {

  def blowUp(map: mutable.Map[String, Any]): mutable.Map[String, Any] = {
    val node = new mutable.LinkedHashMap[String, Any]
    map.foreach(tuple => treeFromPath(splitPath(tuple._1), tuple._2, node))
    node
  }

  private def splitPath(path: String): Array[String] = {
    path.split("[.]")
  }

  private def treeFromPath(path: Array[String], value: Any, map: mutable.Map[String, Any]): mutable.Map[String, Any] = {
    if (path.length equals 1) {
      map.put(path.head, value)
      map
    } else {
      treeFromPath(path.drop(1), value, `with`(path.head, map))
    }
  }


  def `with`(propertyName: String, map: mutable.Map[String, Any]): mutable.Map[String, Any] = {
    val option = map.get(propertyName)

    option match {
      case Some(value) => value.asInstanceOf[mutable.Map[String, Any]]
      case None => val result = new mutable.LinkedHashMap[String, Any]
        map.put(propertyName, result)
        result
    }

  }

}
