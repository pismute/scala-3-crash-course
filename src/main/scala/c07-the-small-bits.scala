/**
 * Chapter 7: The small bits - minor changes you'll likely use
 */

/**
 * Example 1: New case class private constructor behavior
 */
case class Person private (name: String)

// The following won't compile as apply and copy are now private.
// They can only be used in the companion object.

// val person: Person = Person("name")
// val newPerson = person.copy(name = "other")

/**
 * Example 2: Top level definitions
 * [] They replace package objects
 * [] Compiler generates a synthetic object for those (srcfilename$package)
 */
def topLevelDefinitions =
  ???

/**
 * Example 3: Strict equality
 * [] == implemented in terms of .equals
 * [] opt-in: import scala.language.strictEquality or -language:strictEquality flag
 * [] CanEqual type class using derives or given
 */
object StrictEquality:
  import scala.language.strictEquality
  case class A(text: String) derives CanEqual
  case class B(number: Int) derives CanEqual

  given CanEqual[A, B] = CanEqual.derived
  given CanEqual[B, A] = CanEqual.derived

  // Both are compiling fine!
  A("") == A("")
  A("") == B(10)
  B(10) == A("")

/**
 * Example 4: 22 limit is dropped
 * [] In Scala 3 it compiles
 * [] In Scala 2: error: too many elements for tuple: 30, allowed: 22
 */
type twentyFiveIntTuple = (
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int
)
type fOftwentyFiveArity = (
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int,
    Int
) => Unit
