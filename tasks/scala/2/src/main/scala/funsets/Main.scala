package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
}

//
//object Main extends App {
//
//
//  //  тестовые множества
//  val set1: funsets.FunSets.Set = funsets.FunSets.singletonSet(1)
//  val set2: funsets.FunSets.Set = funsets.FunSets.singletonSet(2)
//  val set3: funsets.FunSets.Set = funsets.FunSets.singletonSet(3)
//  val set4: funsets.FunSets.Set = funsets.FunSets.singletonSet(4)
//  val set5: funsets.FunSets.Set = funsets.FunSets.singletonSet(5)
//
//
//  println("set1 = " + funsets.FunSets.toString(set1))
//  println("set2 = " + funsets.FunSets.toString(set2))
//  println("set3 = " + funsets.FunSets.toString(set3))
//  println("set4 = " + funsets.FunSets.toString(set4))
//  println("set5 = " + funsets.FunSets.toString(set5))
//
//  val unionSet: funsets.FunSets.Set =   funsets.FunSets.union(set3, funsets.FunSets.union(set1, set2))
//  println("Union of set1, set2, set3 (unionSet1) = " + funsets.FunSets.toString(unionSet))
//
//  val unionSet2: funsets.FunSets.Set = funsets.FunSets.union(set5, funsets.FunSets.union(set4, funsets.FunSets.union(set3,  set2)))
//  println("Union of  set2, set3,set4,set5, (unionSet2) = " + funsets.FunSets.toString(unionSet2))
//
//  val intersectSet: funsets.FunSets.Set = funsets.FunSets.intersect(unionSet2, unionSet)
//  println("Intersection of unionSet and unionSet2 = " + funsets.FunSets.toString(intersectSet))
//
//  val diffSet: funsets.FunSets.Set = funsets.FunSets.diff(unionSet, set2)
//  println("Difference of unionSet and set2 = " + funsets.FunSets.toString(diffSet))
//
//  val filteredSet: funsets.FunSets.Set = funsets.FunSets.filter(unionSet, (x: Int) => x > 1)
//  println("Filtered set (elements > 1) = " + funsets.FunSets.toString(filteredSet))
//
//  val filteredSet2: funsets.FunSets.Set = funsets.FunSets.filter(unionSet2, (x: Int) => x < 1)
//  println("Filtered unionSet2 (elements < 1) = " + funsets.FunSets.toString(filteredSet2))
//
//
//  val f: Int => Int = (x: Int) => x * 2
//  val mappedSet: funsets.FunSets.Set = funsets.FunSets.map(unionSet, f)
//  println("Mapped unionSet (each element multiplied by 2) = " + funsets.FunSets.toString(mappedSet))
//
//
//
//
//
//  println("Forall elements in unionSet1 > 2: " + funsets.FunSets.forall(unionSet, (x: Int) => x > 2))
//  println("Forall elements in unionSet1 > 0: " + funsets.FunSets.forall(unionSet, (x: Int) => x > 0))
//  println()
//  println("Exists element in unionSet1 == 1: " + funsets.FunSets.exists(unionSet, (x: Int) => x == 1))
//  println("Exists element in unionSet1 == 2: " + funsets.FunSets.exists(unionSet, (x: Int) => x == 2))
//  println("Exists element in unionSet1 == 3: " + funsets.FunSets.exists(unionSet, (x: Int) => x == 3))
//  println("Exists element in unionSet1 == 4: " + funsets.FunSets.exists(unionSet, (x: Int) => x == 4))
//}