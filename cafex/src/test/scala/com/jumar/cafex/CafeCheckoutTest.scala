package com.jumar.cafex



import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class CafeCheckoutTest extends org.scalatest.FunSuite {


  test("Calculate with no items"){
    val order  = List()

    assert( CafeCheckout.calculate(order) == 0.0)
  }

  test("Calculate with available items"){
    val order  = List("Cola", "Cheese Sandwich")

    assert(CafeCheckout.calculate(order) == 2.50f)
  }

  test("Calculate with not available items"){
    val order  = List("Junk","Cola", "Stuff")

    assert(CafeCheckout.calculate(order) == 0.5f )
  }

  test("Step 1:with given items"){
    val order  = List("Cola", "Coffee", "Cheese Sandwich")

    assert(CafeCheckout.calculate(order) == 3.5f )
  }


  test("Calculate only drinks"){
    val order  = List("Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee")

    assert(CafeCheckout.calculate(order) == 10.5f)
  }

  test("Calculate only drinks with Service ch"){
    val order  = List("Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee","Cola","Coffee")

    assert(CafeCheckout.calculateWithServiceCharge(order) == 10.5f)
  }


  test("Calculate Cold food With Service 10%"){
    val order  = List("Cola","Cheese Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich")
    assert(CafeCheckout.calculate(order) == 15.0f)
    assert(CafeCheckout.calculateWithServiceCharge(order) == 16.5f)
  }

  test("Calculate With Service for hot food 20%"){
    val order  = List("Cola","Cheese Sandwich", "Steak Sandwich","Cola","Cheese Sandwich","Cola","Cheese Sandwich", "Steak Sandwich","Cola", "Steak Sandwich","Cheese Sandwich","Cola", "Steak Sandwich","Cheese Sandwich","Cola","Cheese Sandwich")
    assert(CafeCheckout.calculate(order) == 33.0f)
    assert(CafeCheckout.calculateWithServiceCharge(order) == 39.6f)
  }

  test("Calculate With Service > 20"){
    val order  = List("Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich",
      "Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich"
    )

    assert(CafeCheckout.calculateWithServiceCharge(order) == 272.0f)
  }


}
