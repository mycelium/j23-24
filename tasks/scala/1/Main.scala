package recfun
import common._

object Main {
  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    // Test Exercise 2: Parentheses Balancing
    val balancedExpression = "((()))"
    val unbalancedExpression = "(()))("
    val unbalancedExpression2 = "()()(((())))))"
    println(s"Balanced: ${balance(balancedExpression.toList)}") // Should print true
    println(s"Balanced: ${balance(unbalancedExpression.toList)}") // Should print false
    println(s"Balanced: ${balance(unbalancedExpression2.toList)}") // Should print false
    
    // Test Exercise 3: Counting Change
    val money = 5
    val coins = List(1, 2, 3)
    println(s"Number of ways to make change: ${countChange(money, coins)}")
    // Ways: 2+3 = 5, 1+1+1+1+1 = 5, 2+2+1 = 5, 2+1+1+1 = 5, 3+1+1 = 5
  }

  /**
   * Exercise 1: Pascal's Triangle
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2: Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
    def balancing(chars: List[Char], count: Int): Boolean = {
      if (chars.isEmpty) count == 0
      else if (chars.head == '(') balancing(chars.tail, count + 1)
      else if (chars.head == ')') count > 0 && balancing(chars.tail, count - 1)
      else balancing(chars.tail, count)
    }

    balancing(chars, 0)
  }

  /**
   * Exercise 3: Counting Change
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
