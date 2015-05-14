
import java.time.LocalDate

import org.scalatest.{DiagrammedAssertions, FunSpec}

class SomeOtherClass(field: Int)

object SomeOtherClass {
  def create(field: Int) = new SomeOtherClass(field)
}

case class MyCaseClass(stringyThing: String, something: SomeOtherClass)

class MacroCompileErrorSpec extends FunSpec with DiagrammedAssertions {

  describe("assert macro") {
    it("should not fail to compile when comparing to a case class created with a field constructed inline") {
      val something = MyCaseClass("a", new SomeOtherClass(1))

      assert(something == MyCaseClass("b", new SomeOtherClass(2)))
    }

    it("should not fail to compile when comparing to a case class created with a method") {
      val something = MyCaseClass("a", new SomeOtherClass(1))

      assert(something == MyCaseClass("b", SomeOtherClass.create(2)))
    }

    it("should not fail to compile when comparing to a java class created with static factory method") {
      val myLocalDate = LocalDate.parse("2015-05-14")

      assert(myLocalDate == LocalDate.parse("2015-05-14"))
    }

  }

}
