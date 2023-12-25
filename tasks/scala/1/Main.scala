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

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c==0||c==r) 1
    else
      return pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
    def check(chars: List[Char], open: Int): Boolean = {
      if (open < 0) false
      else chars match {
        case '(' :: tail => check(tail, open + 1)
        case ')' :: tail => check(tail, open - 1)
        case Nil => open == 0
        case _ :: tail => check(tail, open)
      }
    }
    check(chars, 0)
  }

//  val test1 = List(
//    "(dfgfdg (dfg ) fdg (dfg))",     // t
//    "dfgfgdfg ( gfdg d(())fgg()  (dfg) qwewe). (weqweqwe)", // t
//    "hxfthft )",                            // f
//    "())(",                           // f
//    "()dfg(dfg)dfg()",                         // t
//    "(dfg((())dfgfdg))",                       // t
//    "((fdgdfg(((",                          // f
//    ""                                // t
//  )
//
//  test1.foreach(test => println(balance(test1.toList)))

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    coins match {
      case _ if money == 0 => 1
      case Nil => 0
      case h :: t =>
        if (money < 0) 0
        else countChange(money - h, coins) + countChange(money, t)
    }
  }

//  val test2 = List(
//    (4, List(1, 2)),      // 3
//    (0, List(1, 2, 3)),   // 1
//    (5, List(1, 2, 3)),   // 5
//    (10, List(5)),        // 1
//    (-1, List(1, 2, 3)),  // 0
//    (4, List()),           // 0
//    (11, List(1, 5, 10))   // 4
//  )
//
//  test2.foreach { case (money, coins) => println(countChange(money, coins))}
}
