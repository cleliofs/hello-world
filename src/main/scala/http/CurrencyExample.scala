package http

import dispatch._

import scala.concurrent.ExecutionContext

import Defaults._

import scala.collection.immutable.TreeMap

/**
 * Currency Example
 *
 * Created by clelio on 11/06/15.
 */
object Currency extends App {
  val url = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml"

  def syncFetch = {

    val rates = {
      for {
        elem <- xml.XML.load(url) \ "Cube" \ "Cube" \ "Cube"
      } yield (elem \ "@currency").text -> BigDecimal((elem \ "@rate").text)
    }.toMap ++ Map("EUR" -> 1)

    TreeMap(rates.toSeq: _*)
  }



  def asyncFetch = {
    def extract(xml: scala.xml.Elem) = {
      for {
        elem <- xml \ "Cube" \ "Cube" \ "Cube"
      } yield (elem \ "@currency").text -> BigDecimal((elem \ "@rate").text)
    }.toMap ++ Map("EUR" -> 1)

    val request: Future[scala.xml.Elem] = Http(dispatch.url(url) OK as.xml.Elem)

    val rates = extract(request())

    TreeMap(rates.toSeq: _*)
  }

  val currencies = asyncFetch
  currencies.foreach(println)

  Http.shutdown()

}


