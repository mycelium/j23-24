package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
}

/* Where are the elements of the set stored?

The elements of the set are not stored explicitly. There are uses a functional
representation of sets, where each set is defined by its characteristic function.

type Set = Int => Boolean

Set is a type representing a set, and Int => Boolean is the type of the characteristic function.
This function takes an integer and returns a Boolean indicating whether the number belongs to the set.

For example, if we have a set containing elements 1, 2, and 3, its characteristic
function would look like this:

val mySet: Set = (x: Int) => x == 1 || x == 2 || x == 3

To check if an element belongs to the set, we call the function mySet(elem).
*/
