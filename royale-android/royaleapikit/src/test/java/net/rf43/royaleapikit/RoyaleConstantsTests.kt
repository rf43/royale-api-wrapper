package net.rf43.royaleapikit

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class RoyaleConstantsTests {

    @Test
    fun testMySuspendFunction(): Unit = runBlocking {
        println("Running a delay test. We will run a test every second for 5 seconds incrementing a var by 1 each sec")
        var i = 0
        println("Value of i => $i")
        println("delaying for 1 sec")
        delay(1000)
        println("Value of i => $i")
        assertEquals(i, 0, "Some failure message???")
        println("Incrementing i...")
        i += 1
        println("delaying for 1 sec")
        delay(1000)
        println("Value of i => $i")
        assertEquals(i, 1, "Some failure message???")
        println("Incrementing i...")
        i += 1
        println("delaying for 1 sec")
        delay(1000)
        println("Value of i => $i")
        assertEquals(i, 2, "Some failure message???")
        println("Incrementing i...")
        i += 1
        println("delaying for 1 sec")
        delay(1000)
        println("Value of i => $i")
        assertEquals(i, 3, "Some failure message???")
        println("Incrementing i...")
        i += 1
        println("delaying for 1 sec")
        delay(1000)
        println("Value of i => $i")
        assertEquals(i, 4, "Some failure message???")
        println("Incrementing i...")
        i += 1
        println("delaying for 1 sec")
        delay(1000)

        assertEquals(i, 5, "Some failure message???")
    }
}