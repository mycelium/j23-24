package funsets

import common._

/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
    type Set = Int => Boolean

    def contains(s: Set, elem: Int): Boolean = s(elem)
    def singletonSet(elem: Int): Set = (n) => if (n == elem) true else false
    def union(s: Set, t: Set): Set = (n) => s(n) || t(n)
    def intersect(s: Set, t: Set): Set = (n) => s(n) && t(n)
    def diff(s: Set, t: Set): Set = (n) => s(n) && !t(n)
    def filter(s: Set, p: Int => Boolean): Set = (n) => s(n) && p(n)

    val bound = 1000

    def forall(s: Set, p: Int => Boolean): Boolean = {
        def iter(a: Int): Boolean = {
            if (a > bound) true
            else if (contains(s, a) && !p(a)) false
            else iter(a + 1)
        }
        iter(-bound)
    }

    def exists(s: Set, p: Int => Boolean): Boolean = {
        def iter(a: Int): Boolean = {
            if (a > bound) false
            else if (contains(s, a) && p(a)) true
            else iter(a + 1)
        }
        iter(-bound)
    }

    def map(s: Set, f: Int => Int): Set = (n) => exists(s, (y: Int) => f(y) == n)

    def toString(s: Set): String = {
        val xs = for (i <- -bound to bound if contains(s, i)) yield i
        xs.mkString("{", ",", "}")
    }

    def printSet(s: Set) = {
        println(toString(s))
    }
}
