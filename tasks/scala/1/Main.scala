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
  }

  // ******************************************************************
  // Exercise 1: Pascal's Triangle
  // ******************************************************************

  /**
   * Calculates the value at a given position (column and row) in Pascal's Triangle.
   *
   * @param c: The column number (starting from 0)
   * @param r: The row number (starting from 0)
   * @return The value at the given position using Pascal's recursive formula
   */
  def pascal(c: Int, r: Int): Int = {
    if (c==0 || c==r){
    	// Base cases: Edges of the triangle are always 1
    	1
    }
    else{
    	// Recursively calculate the value using Pascal's formula:
      	// value(c, r) = value(c-1, r-1) + value(c, r-1)
    	pascal(c-1, r-1) + pascal(c, r-1)
    }
  }

  // ******************************************************************
  // Exercise 2: Parentheses Balancing
  // ******************************************************************

  /**
   * Checks if a given list of characters has balanced parentheses.
   *
   * @param chars: The list of characters to check
   * @return True if the parentheses are balanced, false otherwise
   */
  def balance(chars: List[Char]): Boolean = {
    def check(chars: List[Char], stack: List[Char]): Boolean = {
      if (chars.isEmpty) {
        // If there are no characters left, balance is achieved only if the stack is also empty
        stack.isEmpty
      } else if (chars.head == '(' || chars.head == '[' || chars.head == '{') {
        // Push opening parentheses onto the stack
        check(chars.tail, chars.head :: stack)
      }
      else if (stack.nonEmpty &&
        (chars.head == ')' && stack.head == '(' ||
          chars.head == ']' && stack.head == '[' ||
          chars.head == '}' && stack.head == '{')) {
        // Pop matching closing parentheses from the stack
        check(chars.tail, stack.tail)
      } else {
        // Unmatched closing parenthesis or unexpected character
        false
      }
    }

    // Start the checking process with an empty stack
    check(chars, List())
  }

  // ******************************************************************
  // Exercise 3: Counting Change
  // ******************************************************************

  /**
  * Recursively counts the number of ways to make change for a given amount using a list of coin denominations.
  *
  * @param money: The amount of money to make change for
  * @param coins: The list of available coin denominations
  * @return The number of ways to make change
  */
  def countChange(money: Int, coins: List[Int]): Int = {
     if (money == 0) {
       // Base case: There's one way to make change for 0 (no coins needed)
       return 1
     }
     if (money < 0 || coins.isEmpty) {
       // Base case: No way to make change with negative money or no coins
       return 0
     }
     val withoutFirstDenomination = countChange(money, coins.tail)
     val withFirstDenomination = countChange(money - coins.head, coins)

     withoutFirstDenomination + withFirstDenomination
   }
}
