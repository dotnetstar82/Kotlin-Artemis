package tests
import artemis.*
import artemis.utils.*
import org.junit.Test as test
import kotlin.test.*

class ComponentTypeTest{
    test fun initialUse(){
        var tp = artemis.ComponentType()
        var a = tp.getBit()
        //var b = tp.getBit()

        print("$a == ${1.toLong()}")

        assertTrue("Instead $a != ${1.toLong()}", {a == 1.toLong() })
        //assertTrue("Instead $b != ${2.toLong()}", {b == 2.toLong() })
    }
}