package artemis.utils

public trait ImmutableBag<E> {
    public fun get(index : Int): E
    public fun size() : Int
    public fun isEmpty() : Boolean
}