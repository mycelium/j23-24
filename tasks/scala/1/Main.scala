package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    assert(balance("()".toList))
    assert(!balance("())".toList))
    assert(!balance(")(".toList))
    assert(balance("(()) ()".toList))

    assert(countChange(1, List(1)) == 1)
    assert(countChange(0, List(1, 2)) == 1)
    assert(countChange(2, List(1, 2)) == 2)
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    assert(c >= 0 && r >= 0 && c <= r)
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
    val prefixSums = chars.view
      .map { case '(' => 1; case ')' => -1; case _ => 0 }
      .scanLeft(0) { _ + _ }
      .toList

    prefixSums.forall(_ >= 0) && prefixSums.last == 0
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    assert(money >= 0)
    if (money == 0) 1
    else coins match {
      case Nil => 0
      case c :: cs =>
        (if (money < c) 0 else countChange(money - c, coins)) + countChange(money, cs)
    }
  }
}
