import org.scalatest.funsuite.AnyFunSuite
import ru.ifmo.backend_2021.WordStatIndex

import scala.util.matching.Regex

class WordStatIndexTest extends AnyFunSuite {
  /*
  test("Yorick") {
    assert(testInput(
      "To be, or not to be, that is the question:"
    )
    )
  }
  test("Monday's Child") {
    assert(testInput(
      s"""Monday's child is fair of face.
         |Tuesday's child is full of grace.
         |""".stripMargin
    )
    )
  }
  test("Шалтай-Болтай") {
    assert(testInput(
      s"""Шалтай-Болтай
         |Сидел на стене.
         |Шалтай-Болтай
         |Свалился во сне.""".stripMargin
    )
    )
  } */
  test("Repeated") {
    assert(testInput("I will not waste chalk.\n" * 1000))
  }
  /*
  test("random 10, 3, 5 en") {
    assert(testInput(randomText(10, 3, 5, en)))
  }
  test("random 3, 10, 10 symbols") {
    assert(testInput(randomText(3, 10, 10, symbols)))
  }
  test("random 3, 10, 10 en") {
    assert(testInput(randomText(3, 10, 10, en)))
  }
  test("random 10, 3, 5 ru") {
    assert(testInput(randomText(10, 3, 5, ru)))
  }
  test("random 100, 1000, 100 all") {
    assert(testInput(randomText(100, 1000, 100, ru ++ en ++ symbols)))
  }
*/
  lazy val wordRegex: Regex = "[\\p{L}\\-']+".r

  def testInput(input: String): Boolean =
    WordStatIndex.getStats(input) ==
      wordRegex
        .findAllIn(input)
        .filterNot(_.isBlank)
        .toList
        .map(_.toLowerCase)
        .zipWithIndex
        .groupBy(_._1)
        .map({ case (k, v) =>
          val positions = v.map(_._2 + 1)
          positions.min -> s"$k ${positions.size} ${positions.mkString(" ")}"
        }
        )
        .toList
        .sortBy(_._1)
        .map(_._2)
        .mkString("\n")

  def randomStringFromCharList(length: Int, chars: Seq[Char]): String = {
    val sb = new StringBuilder
    for (_ <- 1 to length) {
      val randomNum = util.Random.nextInt(chars.length)
      sb.append(chars(randomNum))
    }
    sb.toString
  }

  def randomString(length: Int, chars: Seq[Char]): String = {
    randomStringFromCharList(length, chars)
  }

  lazy val delimiters: Seq[Char] = ',' :: ';' :: '"' :: '{' :: '|' :: Nil
  lazy val ru: Seq[Char] = ('а' to 'я') ++ ('А' to 'Я')
  lazy val en: Seq[Char] = ('a' to 'z') ++ ('A' to 'Z')
  lazy val symbols: Seq[Char] = '-' :: '\'' :: Nil

  def randomLine(wordsPerLine: Int, wordsLength: Int, chars: Seq[Char]): String =
    (for (_ <- 1 to wordsPerLine) yield randomString(wordsLength, chars)).mkString(randomStringFromCharList(3, delimiters))

  def randomText(wordsLength: Int, lines: Int, wordsPerLine: Int, chars: Seq[Char]): String =
    (for (_ <- 1 to lines) yield randomLine(wordsPerLine, wordsLength, chars)).mkString("\n")
}