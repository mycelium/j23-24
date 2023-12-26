package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  val set1: Set = singletonSet(1)
  val set2: Set = singletonSet(2)
  val set3: Set = singletonSet(3)

  val unionSet: Set = union(set1, set2)
  println("Union")
  println("unionSet")
  printSet(unionSet)
  println(s"The unionSet contains 1:${contains(unionSet, 1)}")
  println(s"The unionSet contains 2:${contains(unionSet, 2)}")


  val intersectionSet: Set = intersect(unionSet,set1)
  val intersectionSet1: Set = intersect(unionSet,set3)
  println("Intersection")
  println("intersectionSet")
  printSet(intersectionSet)
  println("intersectionSet1")
  printSet(intersectionSet1)
  println(s"The intersectionSet contains 1: ${contains(intersectionSet, 1)}")
  println(s"The intersectionSet contains 2:${contains(intersectionSet, 2)}")
  println(s"The intersectionSet1 contains 3:${contains(intersectionSet1, 1)}")

  println("Filter")
  val filteredSet: Set = filter(unionSet, (x: Int) => x > 1)
  println("filteredSet with a condition x > 1 applied to the set unionSet")
  printSet(filteredSet)
  val unionSet1: Set = union(unionSet, set3)
  println("unionSet1")
  printSet(unionSet1)
  val filteredSet1: Set = filter(unionSet1, (x: Int) => x > 1)
  println("filteredSet1 with a condition x > 1 applied to the set unionSet1")
  printSet(filteredSet1)

  println("forall")
  val result: Boolean = forall(unionSet1, (x: Int) => x > 0)
  println(s"forall with a condition x > 0 for set unionSet1: $result")
  val result1: Boolean = forall(unionSet1, (x: Int) => x < 0)
  println(s"forall with a condition x < 0 for set unionSet1: $result1")

  println("exists")
  println(s"exists with a condition x > 2 for set unionSet1: ${exists(unionSet1, (x: Int) => x > 2)}")
  println(s"exists with a condition x < 0 for set unionSet1: ${exists(unionSet1, (x: Int) => x < 0)}")

  println("map")
  val mappedSet: Set = map(unionSet1, (x: Int) => x * 2)
  println("new set mappedSet after applying the condition x * 2 to unionSet1")
  printSet(mappedSet)
}
