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
  }
