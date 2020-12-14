package models

import reactivemongo.bson.BSONObjectID
import play.api.libs.json.{Json,OFormat}
import reactivemongo.play.json._

case class User(
               _id: Option[BSONObjectID],
               username:String,
               password:String,
               staff:String
               )

object User{
  implicit val format: OFormat[User]=Json.format[User]
}
