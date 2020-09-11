import java.math.BigInteger

fun fib(n: Long): BigInteger {
    if (n <= 0) return BigInteger.ZERO
    if (n <= 1) return BigInteger.ONE

    return fib(n - 1) + fib(n - 2)
}

fun fibTailRecursion(n: Long): BigInteger = go(n, BigInteger.ZERO, BigInteger.ONE)

/**
 * Using the keyword tailrec let the compiler rewrite the recursive code into imperative code to avoid stack overflow.
 * @param [a] current Fibonacci number.
 * @param [b] next Fibonnaci number.
 *
 * fib 4 = go 4 (0,1)
 *       = go 3 (1,1)
 *       = go 2 (1,2)
 *       = go 1 (2,3)
 *       = 3
 */
private tailrec fun go(n: Long, a: BigInteger, b: BigInteger): BigInteger {
    if (n <= 0) return a
    if (n <= 1) return b

    return go(n -1, b, a + b)
}
