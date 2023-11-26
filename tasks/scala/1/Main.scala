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

//    println("Exercise 2 Parentheses Balancing")
//    val listOfLists = List(
//      List('(', ')', '(', ')', '(', ')', '(', ')', '(', ')'),
//      List('(', '(', '(', '(', ')', ')', ')', ')', ')', '(', ')'),
//      List('(', '(', '('),
//      List('('),
//      List(')'),
//      List(')', ')', ')'),
//      List('(', ')', '('),
//      List(')', '(', ')'),
//      List('(', ')'),
//      List('(', ')', '(', ')', '(', ')'),
//      List('(', '(', '(', ')', ')', ')')
//    )
//    for (lst <- listOfLists) {
//      println(lst.toString(), balance(lst))
//    }
//    println()
//
//
//    println()
//    val coinsList = List(
//      List(1, 2, 4, 5),
//      List(2, 4, 6, 8),
//      List(1, 3, 4, 5),
//      List(3, 5, 6, 7),
//    )
//
//    val targetList = List(
//      9, 11, 4, 6
//    )
//
//    for (target <- targetList; coins <- coinsList) {
//      println(s" target=$target, coins=$coins countChange() =  ${countChange(target, coins)}")
//    }



  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    (c, r) match {
      case (1,1) => 1
      case (_, _)if c < 1 || c > r => 0
      case (c, r) =>  pascal(c-1, r-1)+pascal(c, r-1)
    }
  }

  /**
   * Exercise 2 Parentheses Balancing
   */

  def help_balance(count: Int, chars: List[Char]): Boolean = chars match {
    case _ if count < 0 => false
    case '(' :: tail => help_balance(count + 1, tail)
    case ')' :: tail => help_balance(count - 1, tail)
    case Nil => count == 0
  }
  def balance(chars: List[Char]): Boolean = {
    help_balance(0, chars)
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def combinations(list: List[Int]): List[List[Int]] = list match {

      case Nil => List(Nil)
      case head :: tail =>
        val tailCombinations = combinations(tail)
        tailCombinations ++ tailCombinations.map(head :: _)
    }


    def sumHelper(acc: Int, target: Int, lst: List[Int]): Boolean = {
      lst match {
        case Nil => acc == target
        case head :: tail => sumHelper( acc + head,target, tail)
      }
    }

    val pred: List[Int] => Boolean = lst => sumHelper(0, money, lst)
    combinations(coins).count(pred)
  }

}