package io.github.mvillafuertem.mapflablup

import org.scalatest.{FlatSpec, Matchers}

class JsonBlowUpTest extends FlatSpec with Matchers {

  it should "blowUp a json string" in {

    // Given
    val jsonString = """{"registered":"2015-03-28T06:35:33 -01:00","eyeColor":"blue","guid":"f3b5960b-f3e1-4556-9a5d-f552afe204e7","favoriteFruit":"strawberry","isActive":true,"greeting":"Hello, Elliott Kaufman! You have 5 unread messages.","picture":"http://placehold.it/32x32","personalinfo.name":"Elliott Kaufman","personalinfo.gender":"male","personalinfo.address":"952 Cropsey Avenue, Tyro, Guam, 1787","personalinfo.company.name":"SPACEWAX","personalinfo.phone":"+1 (858) 421-2925","personalinfo.email":"elliottkaufman@spacewax.com","location.latitude":78.370719,"location.longitude":-137.117139,"_id":"5c5f1f313fcc6e3084fbe65e","age":28,"index":0,"balance":"$2,809.92","about":"Labore tempor cupidatat nulla veniam ea veniam aliqua ea. Ad id id dolor enim quis amet irure ad occaecat. Quis enim enim esse mollit. Et officia officia ea consectetur deserunt eiusmod nisi ex culpa consectetur"}"""

    // When
    val jsonBlowUp = new JsonBlowUp toString jsonString

    // Then
    println(jsonBlowUp)
    val expected = """{"registered":"2015-03-28T06:35:33 -01:00","location":{"latitude":78.370719,"longitude":-137.117139},"guid":"f3b5960b-f3e1-4556-9a5d-f552afe204e7","_id":"5c5f1f313fcc6e3084fbe65e","personalinfo":{"company":{"name":"SPACEWAX"},"phone":"+1 (858) 421-2925","name":"Elliott Kaufman","gender":"male","address":"952 Cropsey Avenue, Tyro, Guam, 1787","email":"elliottkaufman@spacewax.com"},"balance":"$2,809.92","age":28,"favoriteFruit":"strawberry","isActive":true,"greeting":"Hello, Elliott Kaufman! You have 5 unread messages.","picture":"http://placehold.it/32x32","about":"Labore tempor cupidatat nulla veniam ea veniam aliqua ea. Ad id id dolor enim quis amet irure ad occaecat. Quis enim enim esse mollit. Et officia officia ea consectetur deserunt eiusmod nisi ex culpa consectetur","eyeColor":"blue","index":0}"""
    assert(jsonBlowUp equals expected)
  }
}
