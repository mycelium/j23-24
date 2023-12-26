package recfun
import common._

object Main {
  def main(args: Array[String]): Unit = {
    println("Треугольник Паскаля")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  val balancedExpression = "(if (a>0) 1 else (0))"
  val unbalancedExpression = "(()()))"

  val balancedResult = balance(balancedExpression.toList)
  val unbalancedResult = balance(unbalancedExpression.toList)

  println(s"Результат сбалансированного выражения: $balancedResult")
  println(s"Результат несбалансированоого выражения: $unbalancedResult")


  val coins1 = List(1, 2, 3,4,5)
  val ways1 = countChange(5, coins1)
  println(s"Количество способов разменять 5 монетами номиналом $coins1: $ways1")

  val coins2 = List(2, 3)
  val ways2 = countChange(5, coins2)
  println(s"Количество способов разменять 5 монетами номиналом $coins2: $ways2")


  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }


  /**
   * Exercise 2 Parentheses Balancing
   */

  def balance(chars: List[Char]): Boolean = {
      chars.foldLeft(0)((count, char) =>
        if (count < 0) count
        else if (char == '(') count + 1
        else if (char == ')') count - 1
        else count
      ) == 0
  }


  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */

  def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money < 0 || coins.isEmpty) 0
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}