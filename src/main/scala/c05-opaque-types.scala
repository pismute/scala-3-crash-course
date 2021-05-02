/**
 * Chapter 5: Opaque types
 */

object AnyValDrawbacks:
  object ValueClasses {
    case class PaymentId(id: String) extends AnyVal
    val paymentId = PaymentId("abc")
    def printName(paymentId: PaymentId) = println(paymentId.id)
    // val somePaymentId: Option[PaymentId] = Some(PaymentId("abc")) // this will box :(
  }
// More on that: https://failex.blogspot.com/2017/04/the-high-cost-of-anyval-subclasses.html

object OpaqueTypes:
  /**
   * Example 1: From value classes to Opaque Types.
   */
  case class FirstName(value: String) extends AnyVal

  /**
   * Example 2: Defining companion object with constructors and extensions.
   */

  /**
   * Example 3: Type bounds.
   */

  ???

object OpaqueTypesUsage:
  ???

/**
 * Exercises
 */

//
// Exercise 1: Use Opaque types.
//
object OpaqueTypeExercises:
  import java.util.Locale
  opaque type Country = String
  extension (x: Country) def code: String = x
  object Country:
    private val validCodes = Locale.getISOCountries

    def fromIso2CountryCode(code: String): Option[Country] = Some(code).filter(validCodes.contains)

    def unsafeFromIso2CountryCode(code: String): Country = fromIso2CountryCode(code)
      .getOrElse(
        throw new IllegalStateException(s"Cannot parse country from String. Expected country code. Got '$code'.")
      )

    val Germany: Country = "DE"
    val UnitedKingdom: Country = "GB"

@main def opaqueTypeExercisesMain =
  import OpaqueTypeExercises._
  val country: Option[Country] = Country.fromIso2CountryCode("DE")
  println(country)
  println(country.map(_.code))
