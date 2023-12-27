package recfun
import common._

object Main {
  def main(args: Array[String])={
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println("Parenthesis Balance")
    println(balance("((())())".toList))
    println(balance("((())()".toList))
    println("Count change")
    println(countChange(8,List(2,3)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0) 0
    else
      if (c == 0) 1
      else
        if (c > r) 0
        else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
    def drop(chars: List[Char]): List[Char] = {
      chars match {
        case Nil => Nil
        case ::(head, next) => head match {
          case ')' => next
          case '(' => head+:drop(next)
        }
      }
    }
    chars match{
      case Nil => true
      case ::(head, next) => head match{
        case ')' => false
        case '(' => {
          if (next == Nil) false
          else balance(drop(next))
        }
      }
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
      else if (money < 0) assert(false)
      else
        val c = coins.filter(_ <= money)
        c match {
          case Nil => 0
          case ::(head, tail) => countChange(money - head, c) + countChange(money, tail)
        }
    }
  }
