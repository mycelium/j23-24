
//import common._

object Main {
  def main(args: Array[String]):Unit =  {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row){
        print(pascal(col, row) + " ")
      }
      println()
    }

    println("Testing balance with asserts")
    // Some asserts to check correct of function
    assert(balance("(()()()()((())))".toList)) // true
    assert(!balance("(()()()()((()))".toList)) // false
    assert(!balance("(".toList)) // false
    assert(!balance("())".toList)) // false
    assert(!balance("()()()()()()()()())()()".toList)) // false
    println("Balance function correct")

    
    println("Testing coins with asserts")
    // Some asserts to check correct of function
    assert(countChange(1, List(5)) == 0)
    assert(countChange(0, List(1, 2, 3)) == 1)
    assert(countChange(3, List(1, 2, 3)) == 3) 
    assert(countChange(8, List(1, 2, 3)) == 10)
    println("Coins function correct")

  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    assert(c >= 0 && r >= 0 && c <= r)
    if (c == 0 || (c == r)) 1
    else
      pascal(c-1, r-1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
   def correct_sequence(count: Int, chars: List[Char]):Boolean = chars match {
    case _ if count < 0 => false
    case '(' :: xs => correct_sequence(count+1,xs)
    case ')' :: xs => correct_sequence(count-1,xs)
    case Nil => count == 0
    case _ => false
   }
   return correct_sequence(0,chars)
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
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}

