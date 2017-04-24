import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

// The result type of asyncSomethingUsefulOne is Deferred<Int>
fun asyncSomethingUsefulOne() = async(CommonPool) {
    doSomethingUsefulOne()
}

// The result type of asyncSomethingUsefulTwo is Deferred<Int>
fun asyncSomethingUsefulTwo() = async(CommonPool) {
    doSomethingUsefulTwo()
}

fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val one = asyncSomethingUsefulOne()
        println("One")
        val two = asyncSomethingUsefulTwo()
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}