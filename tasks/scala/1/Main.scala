package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Exercise 1. Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println("---------------------------------")
    println("Exercise 2. Parentheses Balancing")
    val test1 = "(((()(()))()())())"
    val test2 = "(One, (Two), Tree, Four)"
    val test3 = "()))("

    println(s"Parentheses Balancing '$test1': ${balance(test1.toList)}")
    println(s"Parentheses Balancing '$test2': ${balance(test2.toList)}")
    println(s"Parentheses Balancing '$test3': ${balance(test3.toList)}")

    println("---------------------------------")
    println("Exercise 3. Counting Change")
    println(countChange(0, List(1, 2, 3))) // should be 1 // No change needed
    println(countChange(5, List(1, 2, 5))) // should be 4 // [1, 1, 1, 1, 1], [1, 1, 1, 2], [1, 2, 2], [5]
    println(countChange(10, List(2, 5, 10))) // should be 3 // [2, 2, 2, 2, 2], [2, 2, 5, 1], [10]
    println(countChange(4, List(1, 2, 3))) // should be 4 // [1, 1, 1, 1], [1, 1, 2], [1, 3], [2, 2]
  }

  /**
   * Exercise 1
   */
  //Exercise 1
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {

    // Helper function to check balanced parentheses
    def balanceHelper(chars: List[Char], openCount: Int): Boolean = chars match {
      case Nil => openCount == 0
      case '(' :: tail => balanceHelper(tail, openCount + 1)
      case ')' :: tail => openCount > 0 && balanceHelper(tail, openCount - 1)
      case _ :: tail => balanceHelper(tail, openCount)
    }

    // Start the balancing check with an initial open count of 0
    balanceHelper(chars, 0)
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = (money, coins) match {
    case (0, _) => 1 // Base case: one way to exchange is to change nothing
    case (_, Nil) => 0 // There are no ways to exchange for a non-zero amount with an empty list of coins
    case (m, c :: rest) if m < 0 => 0 // There are no ways to exchange for a negative amount
    case (m, c :: rest) => countChange(m - c, coins) + countChange(m, rest)
  }
}
