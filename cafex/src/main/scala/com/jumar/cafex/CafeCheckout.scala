package com.jumar.cafex

/**
  * Created by yogesh123 on 17-06-2017.
  */
object CafeCheckout {

  //Map that holds the item and its cost
  val itemDetail = Map[String, Float]("Cola"->0.50f, "Coffee"->1.00f, "Cheese Sandwich"-> 2.00f, "Steak Sandwich"-> 4.50f)
  // A list containing the items in the menu
  val order  = List("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")
  /**
    * get a list of String 'items' parse it and calculates
    * the cost of the order.
    *
   */
  def calculate( order :  List[String]): Float = {

    val itemMap = countItems(order)

    var total = 0.0f
    for ((prod, count) <- itemMap){
      val tmp = count * ((itemDetail.get(prod)) match {
        case Some(x:Float) => x
        case _ => Float.MinValue
      })

      total = total +tmp
    }

    println("total in calc : "+total)

    return total
  }

  /**
    * counts the ocurrance of the items in the list
    * and returns the count against every item
    *
    */
  def countItems(itemsString: List[String]):scala.collection.mutable.Map[String, Int] = {

    val filteredList = itemsString.filter(x=> order.contains(x))

    val itemCount = scala.collection.mutable.HashMap[String, Int]().withDefaultValue(0)

    filteredList.foreach(item => itemCount(item) += 1 )

    return itemCount
  }


}
