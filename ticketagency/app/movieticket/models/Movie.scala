package models
import reactivemongo.bson.BSONObjectID
import play.api.libs.json.{Json,OFormat}
import reactivemongo.play.json._

case class Movie(
                  id: Option[BSONObjectID],
                  imdbId:Int,
                  imdbLink:String,
                  title:String,
                  imdbScore:Double,
                  genre:String,
                  poster:String
                )

object Movie{
  implicit val format: OFormat[Movie]=Json.format[Movie]
}

