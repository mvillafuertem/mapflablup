package io.github.mvillafuertem.mapflablup

import org.scalatest.{FlatSpec, Matchers}

class JsonFlattenTest extends FlatSpec with Matchers  {

  it should "flatten a json string" in {

    // Given
    val jsonString = """{"registered":"2015-03-28T06:35:33 -01:00","location":{"latitude":78.370719,"longitude":-137.117139},"guid":"f3b5960b-f3e1-4556-9a5d-f552afe204e7","_id":"5c5f1f313fcc6e3084fbe65e","personalinfo":{"phone":"+1 (858) 421-2925","address":"952 Cropsey Avenue, Tyro, Guam, 1787","company":{"name":"SPACEWAX"},"name":"Elliott Kaufman","gender":"male","email":"elliottkaufman@spacewax.com"},"balance":"$2,809.92","age":28,"favoriteFruit":"strawberry","isActive":true,"greeting":"Hello, Elliott Kaufman! You have 5 unread messages.","picture":"http://placehold.it/32x32","about":"Labore tempor cupidatat nulla veniam ea veniam aliqua ea. Ad id id dolor enim quis amet irure ad occaecat. Quis enim enim esse mollit. Et officia officia ea consectetur deserunt eiusmod nisi ex culpa consectetur","eyeColor":"blue","index":0}"""

    // When
    val jsonFlatten = new JsonFlatten toString jsonString

    // Then
    val expected = """{"personalinfo.company.name":"SPACEWAX","registered":"2015-03-28T06:35:33 -01:00","guid":"f3b5960b-f3e1-4556-9a5d-f552afe204e7","location.latitude":78.370719,"_id":"5c5f1f313fcc6e3084fbe65e","balance":"$2,809.92","personalinfo.phone":"+1 (858) 421-2925","age":28,"personalinfo.name":"Elliott Kaufman","location.longitude":-137.117139,"favoriteFruit":"strawberry","personalinfo.gender":"male","isActive":true,"greeting":"Hello, Elliott Kaufman! You have 5 unread messages.","picture":"http://placehold.it/32x32","personalinfo.address":"952 Cropsey Avenue, Tyro, Guam, 1787","about":"Labore tempor cupidatat nulla veniam ea veniam aliqua ea. Ad id id dolor enim quis amet irure ad occaecat. Quis enim enim esse mollit. Et officia officia ea consectetur deserunt eiusmod nisi ex culpa consectetur","eyeColor":"blue","index":0,"personalinfo.email":"elliottkaufman@spacewax.com"}"""
    assert(jsonFlatten equals expected)
  }

}
