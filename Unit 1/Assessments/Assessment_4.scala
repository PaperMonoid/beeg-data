def fib_1(n: Int) : Int = {
    if (n < 2) {
        return n
    } else {
        return fib_1(n - 1) + fib_1(n - 2)
    }
}

println(fib_1(7))



import Math.sqrt
import Math.pow

def fib_2(n: Double) : Double = {
    if (n < 2) {
        return n
    } else {
        var phi = ((1 + sqrt(5)) / 2)
        var j = (pow(phi, n) - pow(1 - phi, n)) / sqrt(5)
        return j
    }
}

println(fib_2(7))


def fib_3(n: Int) : Int = {
    var a: Int = 0
    var b: Int = 1
    var c: Int = 0

    for (k <- 0 until n) {
        c = b + a
        a = b
        b = c
    }

    return a
}

println(fib_3(7))


def fib_4(n: Int) : Int = {
    var a: Int = 0
    var b: Int = 1

    for (k <- 0 until n) {
        b = b + a
        a = b - a
    }

    return a
}

println(fib_4(7))


def fib_5(n: Int) : Int = {
    if (n < 2) {
        return n
    } else {
        var vector: Array[Int] = new Array[Int](n + 1)
        vector(0) = 0
        vector(1) = 1
        for (k <- 2 until n + 1) {
            vector(k) = vector(k - 1) + vector(k - 2)
        }
        return vector(n)
    }
}

println(fib_5(7))