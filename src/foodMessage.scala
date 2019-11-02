import play.api.libs.json.{JsValue, Json}

object FoodMessage {

  def fromJSON(json: String): FoodMessage = {
    val jsonValue = Json.parse(json)
    val restaurantName = (jsonValue \ "restaurant").as[String]
    val restaurantAddress= (jsonValue \ "address").as[String]
    val latitude= (jsonValue \ "latitude").as[String]
    val longitude=(jsonValue \ "longitude").as[String]
    val load=(jsonValue \ "load size").as[String]
    val bank=(jsonValue \ "nearest food bank").as[String]
    new FoodMessage(restaurantName, restaurantAddress, latitude, longitude, load, bank)
  }

}

class FoodMessage(val rName: String, val address: String, val longitude: String, val latitude: String,
                  loadSize: String, val nearestBank: String) {

  def asJsValue(): JsValue ={
    val messageMap: Map[String, JsValue] = Map("restaurant" -> Json.toJson(rName), "address" -> Json.toJson(address),
    "longitude" -> Json.toJson(longitude), "latitude" -> Json.toJson(latitude), "load size" -> Json.toJson(loadSize),
    "nearest food bank" -> Json.toJson(nearestBank))
    Json.toJson(messageMap)
  }
}