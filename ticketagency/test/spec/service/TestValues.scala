package spec.service

import models.Ticket
import movieticket.models.Buyinfo
import play.modules.reactivemongo.ReactiveMongoApi

trait TestValues{
  val ticket =
    Ticket(1,1,1,1,1)
  val catalogList = List(ticket)

  val buyinfo = Buyinfo("user1",1,1)
  val infolist = List(buyinfo)

//  val ticketupdate =
//    Ticket(1,1,"http://www.imdb.com/title/tt114709","Toy Story (1995)",8.3, "animation|adventure|Comedy",
//      "https://images-na.ssl-images-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhM...",1,1,1)
//  val updatelist = List(ticketupdate)

}
