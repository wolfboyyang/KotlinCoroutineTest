import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

/**
 * Created by youi1 on 2017/3/28.
 */

fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis();
    val c = AtomicInteger()

    for (i in 1..1_000_000)
        thread(start = true) {
            c.addAndGet(i)
        }
    val elapsedTime = System.currentTimeMillis() - startTime;
    println(c.get())
    println("finished in $elapsedTime ms")
}