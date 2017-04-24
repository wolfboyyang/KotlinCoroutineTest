import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by youi1 on 2017/3/28.
 */

fun main(args: Array<String>) = runBlocking {
    println("Start")

    for (i in 10 downTo 0)
        println(i)

    // Start a coroutine
    launch(CommonPool) {
        delay(1000L)
        println("Hello")
    }

    delay(2000L)
    //Thread.sleep(2000)
    println("Stop")
}
