package tests
import artemis.Component
import artemis.utils.*
import org.junit.Test as test
import kotlin.test.*

class Person (val firstName : String, val lastName : String) : Component(){

}

class ImmutableBagTest{

    test fun addNewItem(){
        val first = Person("Richard", "Nixon")
        var bag = Bag<Component>()
        bag.add(first)

        assertTrue("Bag size must be one", { bag.size() == 1})
    }

    test fun removeExistingItem(){
        val first = Person("Richard", "Nixon")
        var bag = Bag<Component>()
        bag.add(first)

        assertTrue("Bag size must be one", { bag.size() == 1 })

        val remove = bag.remove(first)

        assertTrue("Removal must be successful", { remove })
        assertTrue("Bag size must be zero instead of ${bag.size()}", { bag.size() == 0 })
    }

    test fun growLarge(){
        val first = Person("Richard", "Nixon")
        var bag = Bag<Component>()

        for(i in 1..100)
            bag.add(first)

        assertTrue("Size must be 100 instead of ${bag.size()}", { bag.size() == 100 })
    }

    test fun accessItems(){
        val first = Person("Richard", "Nixon")
        var bag = Bag<Component>()

        for(i in 1..15)
            bag.add(first)

        for(i in 0..bag.size() -1 ){
            val p = bag.get(i) as Person
            print("${p.firstName}, ")
        }
    }
}