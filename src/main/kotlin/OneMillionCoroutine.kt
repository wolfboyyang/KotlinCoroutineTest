import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

/**
 * Created by youi1 on 2017/3/28.
 */
fun main(args: Array<String>) {
    val c = AtomicInteger()

    val time = measureTimeMillis {
        for (i in 1..1_000_000)
            launch(CommonPool) {
                c.addAndGet(i)
            }
    }

    println(c.get())
    println("finished in $time ms")
}