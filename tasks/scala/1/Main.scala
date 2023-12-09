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

    println("Exercise 2. Parentheses Balancing")
    val testString1 = "if (snow == true) { println(\"Winter is coming\") }"
    val testString2 = "You need to take your enemy’s side (if you’re going to see things the way they do)."
    val testString3 = ":)"

    println(s"Balance for '$testString1': ${balance(testString1.toList)}")
    println(s"Balance for '$testString2': ${balance(testString2.toList)}")
    println(s"Balance for '$testString3': ${balance(testString3.toList)}")

    println("Exercise 3. Counting Change")
    val testMoney1 = 5
    val testCoins1 = List(2, 3)
    println(s"The number of ways to make change for $testMoney1: ${countChange(testMoney1, testCoins1)}")

    val testMoney2 = 4
    val testCoins2 = List(1, 2)
    println(s"The number of ways to make change for $testMoney2: ${countChange(testMoney2, testCoins2)}")
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def calculatePascal(col: Int, row: Int): Int = {
      if (col == 0 || col == row) 1 // Recursion base: the extreme elements are equal to 1
      else calculatePascal(col - 1, row - 1) + calculatePascal(col, row - 1)
    }

    calculatePascal(c, r)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
    def isBalanced(chars: List[Char], stack: List[Char]): Boolean = {
      if (chars.isEmpty) stack.isEmpty
      else if (chars.head == '(') isBalanced(chars.tail, '(' :: stack)
      else if (chars.head == ')') {
        if (stack.isEmpty) false // If there is a closing parenthesis without a corresponding opening one, then the expression is not balanced
        else isBalanced(chars.tail, stack.tail) // We check the remaining characters and open brackets in the stack
      } else isBalanced(chars.tail, stack) // Ignore the other characters and continue checking
    }

    isBalanced(chars, List())
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1 // Recursion base: one way to exchange is to change nothing
    else if (money < 0 || coins.isEmpty) 0 // There are no ways to exchange for a negative amount or an empty list of coins
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
