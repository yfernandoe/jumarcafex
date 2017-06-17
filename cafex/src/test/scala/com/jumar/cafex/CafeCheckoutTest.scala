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

}
