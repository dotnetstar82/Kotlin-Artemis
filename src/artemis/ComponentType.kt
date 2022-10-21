package artemis

private var nextBit : Long = 1
private var nextId : Int = 0

public class ComponentType{
    private var bit : Long = 0
    private var id : Int = 0

    {
        bit = nextBit
        nextBit = nextBit shl 1
        id = nextId++
    }

    public fun getBit(): Long{
        return bit
    }

    public fun getId() : Int{
        return id
    }
}