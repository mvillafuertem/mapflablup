package io.github.mvillafuertem.mapflablup


final class JsonFlatten {

  def toString(jsonString: String): String = {
    JsonParser parse flatten(jsonString)
  }

  def toMap(jsonString: String): Map[String, Any] = {
    flatten(jsonString)
  }

  private def flatten(jsonString: String): Map[String, Any] = {
    val parsedJson = JsonParser parse jsonString
    MapFlatten.apply(parsedJson).flatten
  }
}
