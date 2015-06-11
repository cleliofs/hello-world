package main.scala.http

import java.util.concurrent.TimeoutException

import dispatch._
import Defaults._
import scala.collection.immutable.Seq
import scala.concurrent.duration._

import scala.concurrent.{Promise, Await}
import scala.util.{Failure, Success}
import scala.xml.{XML, Elem, NodeSeq, PrettyPrinter}

/**
 * Http dispatch example
 *
 * Created by clelio on 11/06/15.
 */
object HttpDispatch extends App {

  val defaultXml = """<Response>
                     |  <IP>162.144.32.24</IP>
                     |  <CountryCode>US</CountryCode>
                     |  <CountryName>United States</CountryName>
                     |  <RegionCode>UT</RegionCode>
                     |  <RegionName>Utah</RegionName>
                     |  <City>Provo</City>
                     |  <ZipCode>84606</ZipCode>
                     |  <TimeZone>America/Denver</TimeZone>
                     |  <Latitude>40.234</Latitude>
                     |  <Longitude>-111.659</Longitude>
                     |  <MetroCode>770</MetroCode>
                     |</Response>"""

  val request = url("http://freegeoip.net/xml/www.dailymail.co.uk")
  val resultXml = Http(request OK as.xml.Elem)
  val printer = new PrettyPrinter(90, 2)
  val timeoutFuture = Future {
    try {
      Await.result(resultXml, 3 seconds)
    } catch {
      case e: TimeoutException => XML.loadString(defaultXml)
    }
  }

//
//  val locations = timeoutFuture() map { xml =>
//    ((xml \\ "City").text, (xml \\ "CountryName").text, (xml \\ "CountryCode").text))
//  }
//

  case class Location(city: String, country: String, countryCode: String)

  def extractLocations(xml: scala.xml.Elem) = for {
    city <- xml \\ "City"
    countryName <- xml \\ "CountryName"
    countryCode <- xml \\ "CountryCode"
  } yield Location(city.text, countryName.text, countryCode.text)

  val locations = extractLocations(timeoutFuture())

  Future {
    println(locations);


    Http.shutdown();
  }


}
