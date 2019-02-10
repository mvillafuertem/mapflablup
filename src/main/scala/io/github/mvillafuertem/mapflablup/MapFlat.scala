package io.github.mvillafuertem.mapflablup

import scala.collection.JavaConverters._
import scala.collection.mutable

final class MapFlat {

  private val map: mutable.Map[String, Any] = new mutable.LinkedHashMap[String, Any]

  def flat(map: mutable.Map[String, Any]): mutable.Map[String, Any] = {
    flatten(map = map)
    this.map
  }

  private def flatten(basePath: String = "", map: mutable.Map[String, Any]): mutable.Map[String, Any] = {
    map.toSet.foreach((entry: (String, Any)) => flatJsonNode(appendPath(basePath, entry._1), entry._2))
    map
  }

  private def flatJsonNode(path: String, anyRef: Any): mutable.Map[String, Any] = {

    anyRef match {
      case map : mutable.Map[_, _] =>
        flatten(path, map.asInstanceOf[mutable.Map[String, Any]])

      case _ if anyRef.isInstanceOf[java.util.Map[_, _]] =>
        flatten(path, anyRef.asInstanceOf[java.util.Map[String, Any]].asScala)

      case _ =>
        map.put(path, anyRef)
        map
    }
  }

  private def appendPath(basePath: String, key: String): String = {
    if (basePath.nonEmpty) basePath + "." + key
    else key
  }
}
