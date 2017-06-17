package com.jumar.cafex

/**
  * Created by yogesh123 on 17-06-2017.
  */
object CafeCheckout {

  //Map that holds the item and its cost
  val itemDetail = Map[String, Float]("Cola"->0.50f, "Coffee"->1.00f, "Cheese Sandwich"-> 2.00f, "Steak Sandwich"-> 4.50f)
  // A list containing the items in the menu
  val order  = List("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")
  // A Map containing the details if it is served hot or cold
  val itemServingType = Map[String, String]("Cola"->"Cold", "Coffee"->"Hot", "Cheese Sandwich"->"Cold", "Steak Sandwich"->"Hot")
  // A Map containing the details if the item is a drink or food
  val itemFoodType = Map[String, String]("Cola"->"Drink", "Coffee"->"Drink", "Cheese Sandwich"->"Food", "Steak Sandwich"->"Food")

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

  /**
    * Calculate the cost of food with service charge applied
    *
    */
  def calculateWithServiceCharge( order :  List[String]): Float = {
    val itemMap = countItems(order)

    var totalCost = 0.0f
    var serviceCh = 0.0f
    var hotFoodService = false
    var foodService = false
    for ((prod, count) <- itemMap){
      val itemCost = count * ((itemDetail.get(prod)) match {
        case Some(x:Float) => x
        case _ => Float.MinValue
      })

      if ((((itemFoodType.get(prod)) match {
        case Some(x:String) => x
        case _ => ""
      }) == "Food") && (!foodService)){
        foodService = true
        if ((((itemServingType.get(prod)) match {
          case Some(x:String) => x
          case _ => ""
        }) == "Hot") ){
          hotFoodService = true
        }
      }
      totalCost += itemCost
    }
    //Apply Step2 rule 2. Hot food service 20%
    if (hotFoodService) {
      serviceCh = ((totalCost/100) *20)

    } else if(foodService ) {
      //Apply Step2 rule 1.  food service not hot 10%
      serviceCh = ((totalCost/100) *10)

    }
    serviceCh = Math.round(serviceCh * 100.0) / 100.0f
    //Apply Step2 rule 3. max service charge is 20 pounds
    if(serviceCh > 20.0 )
      serviceCh = 20.0f

    totalCost= totalCost+serviceCh

    return totalCost
  }

}
