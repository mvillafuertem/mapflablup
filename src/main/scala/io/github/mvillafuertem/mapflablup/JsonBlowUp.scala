package io.github.mvillafuertem.mapflablup


final class JsonBlowUp {

  def toString(jsonString: String): String = {
    JsonParser parse blowUp(jsonString)
  }

  def toMap(jsonString: String): Map[String, Any] = {
    blowUp(jsonString)
  }

  private def blowUp(jsonString: String): Map[String, Any] = {
    val parsedJson = JsonParser parse jsonString
    MapBlowUp.apply(parsedJson).blowUp
  }

}
