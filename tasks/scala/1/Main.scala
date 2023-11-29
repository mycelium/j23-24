package recfun
import common._

object Main
{
  def main(args: Array[String]): Unit =
  {
    println("Pascal's Triangle")
    for (row <- 0 to 10)
    {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  //Exercise 1
  def pascal(c: Int, r: Int): Int =
  {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  //Exercise 2 Parentheses Balancing  
  def balance(chars: List[Char]): Boolean =
  {
    def balance_1(chars: List[Char], openCount: Int): Boolean =
      if (chars.isEmpty) openCount == 0
      else if (chars.head == '(') balance_1(chars.tail, openCount + 1)
      else if (chars.head == ')') openCount > 0 && balance_1(chars.tail, openCount - 1)
      else balance_1(chars.tail, openCount)

    balance_1(chars, 0)
  }

  //Exercise 3 Counting Change
  def countChange(money: Int, coins: List[Int]): Int =
  {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}