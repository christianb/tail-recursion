import java.math.BigInteger

/**
 * The factorial of a positive integer n, denoted by n!, is the product of all positive integers less than or equal to n.
 * The value of 0! is 1.
 */
fun fac(n: Long): BigInteger {
    if (n <= 1) return BigInteger.ONE

    return BigInteger.valueOf(n) * fac(n - 1)
}

fun facTailRecursion(n: Long): BigInteger = go(n, BigInteger.ONE)

/**
 * Using the keyword tailrec let the compiler rewrite the recursive code into imperative code to avoid stack overflow.
 */
private tailrec fun go(n: Long, acc: BigInteger): BigInteger {
    if (n <= 1) return acc

    return go(n-1, BigInteger.valueOf(n) * acc)
}
