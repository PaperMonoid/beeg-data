import scala.math.sqrt

def computeRadius(diameter: Double) : Double = {
    return diameter / 2.0
}
println(computeRadius(12))

def isPrime(n: Int) : Boolean = {
    val m = sqrt(n).toInt
    for(i <- 2 to m){
        if (n % i == 0) {
            return false
        }
    }
    return true
}
println(isPrime(11))

var bird = "tweet"
println($"I'm writing a ${bird}")

val sentence = "Hello Luke, I'm your father!"
println(sentence.slice(6, 10))

/**
 * val is used to declare immutable constants
 * var is used to declare variables
 */

val tuple = (2, 4, 5, 1, 2, 3, 3.1416, 23)
println(tuple._7)