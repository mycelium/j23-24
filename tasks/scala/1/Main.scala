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
    print("\n\n")

    print("Parentheses Balancing:\n")
    print("String 1: ))(fjfj))dkd(jkdc)kor(k(((kedk)\n")
    val str1 = "))(fjfj))dkd(jkdc)kor(k(((kedk)"
    val charList1: List[Char] = str1.toList
    print(balance(charList1))
    print("\n\n")

    print("String 2: ()()jhsjd(jkdjfkj)kdk((keokeo))\n")
    val str2 = "()()jhsjd(jkdjfkj)kdk((keokeo))"
    val charList2: List[Char] = str2.toList
    print(balance(charList2))
    print("\n\n")

    print("String 3: )(\n")
    val str3 = ")("
    val charList3: List[Char] = str3.toList
    print(balance(charList3))
    print("\n\n")


    print("Counting Change:\n")
    var coins_list1: List[Int] = List(2,4,1,5,7,8)
    print(countChange(34, coins_list1))
    print("\n")

    var coins_list2: List[Int] = List(1, 2, 4)
    print(countChange(4, coins_list2))
    print("\n")

    var coins_list3: List[Int] = List(1, 2, 5, 4)
    print(countChange(20, coins_list3))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2 Parentheses Balancing
   */
  def balance(chars: List[Char]): Boolean = {
    def parenthes_counter(chars: List[Char], count: Int): Boolean = {
      if (chars.isEmpty) count == 0
      else if (chars.head == '(') parenthes_counter(chars.tail, count + 1)
      else if (chars.head == ')') count > 0 && parenthes_counter(chars.tail, count - 1)
      else parenthes_counter(chars.tail, count)
    }
    parenthes_counter(chars, 0)
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) 0
      else if (money == 0) 1
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
