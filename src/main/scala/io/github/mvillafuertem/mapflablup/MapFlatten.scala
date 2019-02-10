package io.github.mvillafuertem.mapflablup

import scala.collection.JavaConverters._
import scala.collection.mutable

object MapFlatten {
  def apply(map: mutable.Map[String, Any]): MapFlatten = new MapFlatten(map)
}

final class MapFlatten(tree: mutable.Map[String, Any]) {

  private val out = mutable.Map[String, Any]()

  def flatten: mutable.Map[String, Any] = {
    flat("", tree)
    out
  }

  private def flat(basePath: String, tree: mutable.Map[String, Any]): Unit = {
    tree.toSet.foreach((entry: (String, Any)) => put(appendPath(basePath, entry._1), entry._2))
  }

  private def put(path: String, anyRef: Any): Unit = {

    anyRef match {
      case leaf : mutable.Map[_, _] =>
        flat(path, leaf.asInstanceOf[mutable.Map[String, Any]])

      case _ if anyRef.isInstanceOf[java.util.Map[_, _]] =>
        flat(path, anyRef.asInstanceOf[java.util.Map[String, Any]].asScala)

      case _ =>
        out.put(path, anyRef)
    }
  }

  private def appendPath(basePath: String, key: String): String = {
    if (basePath.nonEmpty) basePath + "." + key
    else key
  }
}
