package artemis.utils

import kotlin.concurrent.execute

public abstract class Timer (delay : Int, repeat : Boolean){
    private var delay : Int = delay
    private var repeat : Boolean  = repeat
    private var acc : Int = 0
    private var done : Boolean = false
    private var stopped : Boolean = false

    public fun update(delta : Int){
        if (!done && !stopped){
            acc += delta

            if (acc >= delay){
                acc -= delay

                if (repeat)
                    reset()
                else
                    done = true

                execute()
            }
        }
    }

    public fun reset(){
       stopped = false
       done = false
       acc = 0
    }

    public fun isDone() : Boolean{
        return done
    }

    public fun isRunning() : Boolean{
        return !done && acc < delay && !stopped
    }

    public fun stop(){
        stopped = true
    }

    public setDelay(delay : int){
        this.delay = delay
    }

    public abstract fun execute()

    public fun getPercentageRemaining() : Float{
        if (done)
            return 100.toFloat()
        else if (stopped)
            return 0.toFloat()
        else
            return 1 -  (delay - acc).toFloat() /  delay.toFloat()
    }

    public fun getDelay() : Int{
        return delay
    }
}