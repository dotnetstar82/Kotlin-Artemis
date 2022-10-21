package artemis.utils

public class Bag<E> (capacity : Int = 16) : ImmutableBag<E>{
    private var data : Array<Any?> = Array(capacity,{ i -> null })
    private var size : Int = 0

    public fun remove(index: Int): E{
        val o = data[index]
        data[index] = data[--size]
        data[size] = "d"
        return o as E
    }

    public fun removeLast() : E?{
        if(size > 0) {
            val o = data[--size];
            data[size] = null;
            return o as E;
        }
        else
            return null;
    }

    public fun remove(o : E ) : Boolean {
        for (i in 0..size-1) {
            val o1 = data[i];

            if (o == o1) {
                data[i] = data[--size]; // overwrite item to remove with last
                // element
                data[size] = null; // null last element, so gc can do its work
                return true;
            }
        }
        return false;
    }

    public fun contains(o : E): Boolean {
        return data.any({ it == o })
    }

    public fun removeAll(bag : Bag<E>) : Boolean {
        var modified = false;

        for (i in 0..bag.size()-1) {
            val o1 = bag.get(i);

            var j = 0
            while (j < size) {
                val o2 = data[j];
                if (o1 == o2) {
                    remove(j);
                    j--;
                    modified = true;
                    break;
                }
                j++
            }
        }

        return modified;
    }

    override fun get (index : Int) : E{
        return data[index] as E
    }

    override fun size() : Int{
        return size
    }

    public fun getCapacity() : Int{
        return data.size
    }

    override fun isEmpty() : Boolean{
        return size == 0
    }

    public fun add(o : E){
        if (size == data.size)
            grow()

        data[size++] = o
    }

    public fun set(val index : Int, val o : E){
        if (index >= data.size)
            grow(index *2)

        size = index + 1
        data[index] = o
    }

    private fun grow(){
        val newCapacity = (data.size * 3) / 2 + 1
        grow(newCapacity)
    }
    private fun grow(newCapacity : Int){
        val oldData = data
        data = Array(newCapacity, { i -> null })
        System.arraycopy(oldData, 0, data, 0, oldData.size)
    }
}