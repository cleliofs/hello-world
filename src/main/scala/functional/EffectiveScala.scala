package main.scala.functional

/**
 * http://twitter.github.io/effectivescala/
 *
 * Created by csouza on 30/06/2015.
 */
object EffectiveScala extends App {

  val votes = Seq(("scala", 1), ("java", 4), ("scala", 10), ("scala", 1), ("python", 10))

  val orderedVotes: Seq[(String, Int)] = {
    val votesByLang = votes groupBy { case (lang, vote) => lang }

    val votesByLangAndCount = votesByLang map { case (lang, counts) =>
      val votesCountOnly = counts map { case (_, c) => c }
      (lang, votesCountOnly.sum)
    }

    votesByLangAndCount.toSeq.sortBy { case (lang, voteCount) => voteCount }.reverse
  }

  println(votes.mkString(", "))
  println(orderedVotes.mkString(", "))

//  val orderedVotes2: Seq[(String, Int)] = {
////    val groupByLang: PartialFunction[(String, Int), String] = { case (lang, vote) => lang }
//    val groupByLang = { case (lang, vote) => lang }
//    val votesByLang = votes.groupBy(groupByLang)
//
//    val countsByLang: PartialFunction[String, Seq[(String, Int)]] = { case (lang, counts) =>
//      val countsOnly = { case (_, c) => c }
//      val votesCountOnly = counts.map(countsOnly)
//      (lang, votesCountOnly.sum)
//    }
//
//    val votesByLangAndCount = votesByLang.map(countsByLang)
//
//    votesByLangAndCount.toSeq.sortBy { case (lang, voteCount) => voteCount }.reverse
//  }
}
