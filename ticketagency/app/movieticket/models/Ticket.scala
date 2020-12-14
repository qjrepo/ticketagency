package models

import play.api.libs.json.{Json, OFormat}
import reactivemongo.bson.BSONObjectID
case class Ticket(
                   //_id: Option[BSONObjectID],
                   id:Int,
                   movie_id:Int,
                   seat_id:Int,
                   seatno:Int,
                   var filled:Int
                 )

object Ticket{
  implicit val format: OFormat[Ticket]=Json.using[Json.WithDefaultValues].format[Ticket]

}