
import org.scalatest.{DiagrammedAssertions, FunSpec}

class SomeOtherClass(field: Int)
case class MyCaseClass(stringyThing: String, something: SomeOtherClass)

class MacroCompileErrorSpec extends FunSpec with DiagrammedAssertions {

  describe("assert macro") {
    it("should not fail to compile when comparing to a case class created with a field constructed inline") {
      val something = MyCaseClass("a", new SomeOtherClass(1))

      assert(something == MyCaseClass("b", new SomeOtherClass(2)))
    }
  }

}
