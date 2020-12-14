package movieticket.models

import play.api.libs.json.{Json, OFormat}

case class Buyinfo( username:String,
                    movieId:Int,
                    seatid:Int)



object Buyinfo{
  implicit val ticketformat: OFormat[Buyinfo]=Json.format[Buyinfo]
}
