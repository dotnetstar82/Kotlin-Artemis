package artemis
import artemis.utils.Bag
import artemis.utils.ImmutableBag;

public class EntityManager (world : World){
    private var world : World  = world
    private var activeEntities : Bag<Entity> = Bag<Entity>()
    private var removedAndAvailable : Bag<Entity> = Bag<Entity>()
    private var nextAvailableId : Int = 0
    private var count : Int = 0
    private var uniqueEntityId : Long = 0
    private var totalCreated : Long = 0
    private var totalRemoved : Long = 0

    private var componentsByType : Bag<Bag<Component>> = Bag<Bag<Component>>(64)
    private var entityComponents : Bag<Component> = Bag<Component>()

}