package artemis

public class Entity(world : World, id : Int){
    private var id : Int = id
    private var uniqueId : Long = 0
    private var typeBits : Long = 0
    private var systemBits : Long = 0

    private var world : World = world
    private var entityManager : EntityManager

    {
        entityManager = world.getEntityManager()
    }

    public fun getId() : Int{
        return id
    }

    protected fun setUniqueId(uniqueId : Long){
        this.uniqueId = uniqueId
    }

    public fun getUniqueId() : Long{
        return uniqueId
    }

    protected fun getTypedBits() : Long{
        return typeBits
    }

    protected fun addTypeBit (bit : Long){
        typeBits = typeBits or bit
    }

    protected fun removeTypeBit(bit : Long){
        typeBits = typeBits and bit.inv()
    }

    protected fun getSystemBits(): Long{
        return systemBits
    }

    protected fun addSystemBit(bit : Long){
        this.systemBits = systemBits or bit
    }

    protected fun removeSystemBit(bit : Long){
        systemBits = systemBits and bit.inv()
    }

    protected fun setSystemBits(systemBits : Long){
        this.systemBits = systemBits
    }

    protected fun setTypeBits(typeBits : Long) {
        this.typeBits = typeBits
    }

    protected fun reset(){
        systemBits = 0
        typeBits = 0
    }

    [Override]
    public fun toString() : String{
        return "Entity[$id]"
    }
}