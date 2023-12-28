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

    /////////////////////////// task 2/////////////////////////////
    println(balance("((s(aaaa)s))".toList)) // true
    println(balance("(((2+3)*560)+789)(7/8)".toList)) // true
    println(balance("(()))(aa".toList)) // false
    println(balance("aaaa)(()))(".toList)) // false


    /////////////////////////////// task 3/////////////////////////
    println("Способов оплаты:")
    println(countChange(10, List(1, 2, 5,10)))
    println(countChange(10, List(1, 2)))
    println(countChange(12, List(1, 2, 3, 4)))
    println(countChange(12, List(1, 2, 3, 4, 5, 6)))
    println(countChange(5, List(2, 3)))
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
    def balanceRec(chars: List[Char], stack: List[Char]): Boolean = {
      if (chars.isEmpty) {
        return  stack.isEmpty //  если стек пустой, вернет true, послед. корректна
      }
      val head = chars.head               // одно первое значение
      val tail = chars.tail

      head match {
        case '(' => balanceRec(tail, '(' :: stack) // Если открывающая скобка, добавляем её в стек
        case ')' =>
          stack match {
            case Nil => false // Если стек пустой, то закрывающая скобка не имеет пары
            case '(' :: rest => balanceRec(tail, rest) // сверху открывающая скобка, убираем её из стека
            case _ => false //
          }
        case _ => balanceRec(tail, stack) // Игнорируем другие символы

      }
    }

    balanceRec(chars, Nil) // Начинаем с пустого стека
  }

  /**
   * Exercise 3 Counting Change
   * Write a recursive function that counts how many different ways you can make
   * change for an amount, given a list of coin denominations. For example,
   * there is 1 way to give change for 5 if you have coins with denomiation
   * 2 and 3: 2+3.
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    // тк функция осуществляет полный перебор всех значений, при большом money, работает медлено
    def CountRec(money: Int, coins: List[Int]): List[List[Int]]= {
      if(money==0)
        return List(List(0)) // нулевая монета не имеет смысла
      else if(money<0)
        return List(List(-1)) // отрицательная тоже
      else {

        val ans: List[List[Int]] = coins.foldLeft(List.empty[List[Int]]) { (acc, elem) =>  // получим полный перебор всех вариантов
          val result: List[List[Int]] = CountRec(money - elem, coins)
          val modified_result: List[List[Int]] = result.map(elem :: _)             // добавляем монету в начало списка
          acc ++ modified_result //собираем общий результат в List[List[Int]]
        }
        return ans
      }

    }
    val ret: List[List[Int]]=CountRec(money, coins)
    val filteredRet: List[List[Int]] = ret.filter(inside_list => inside_list.lastOption.contains(0))
    // оставляем только те списки, которые завершаются 0 (сумма 10)
    val sorted: List[List[Int]] = filteredRet.map(_.sorted)
    //сортируем
    val distinctSorted: List[List[Int]] = sorted.toSet.toList //удаляем повторы с помощью множества
    return distinctSorted.size
  }
}
