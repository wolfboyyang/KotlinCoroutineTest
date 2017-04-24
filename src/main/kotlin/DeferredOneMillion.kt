import kotlinx.coroutines.experimental.*
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by youi1 on 2017/3/28.
 */
fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis();

    val deferred = (1..1_000_000).map { n ->
        async(CommonPool) {
            workload(n)
        }
    }

    runBlocking {
        val sum = deferred.sumBy { it.await() }

        val elapsedTime = System.currentTimeMillis() - startTime;
        println("Sum: $sum")
        println("finished in $elapsedTime ms")
    }
}

suspend fun workload(n: Int): Int {
    delay(1000L)
    return n
}