import java.math.BigInteger

fun fib(n: Long): BigInteger {
    if (n <= 0) return BigInteger.ZERO
    if (n <= 1) return BigInteger.ONE

    return fib(n - 1) + fib(n - 2)
}

fun fibTailRecursion(n: Long): BigInteger = go(n, BigInteger.ZERO, BigInteger.ONE)

/**
 * Using the keyword tailrec let the compiler rewrite the recursive code into imperative code to avoid stack overflow.
 */
private tailrec fun go(n: Long, a: BigInteger, b: BigInteger): BigInteger {
    if (n <= 0) return a
    if (n <= 1) return b

    return go(n -1, b, a + b)
}
