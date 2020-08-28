# How does Tail Recursion work?

Simple recursion can be very memory inefficient when the recursion gets longer with every recursion step.

## Classic Recursion
A factorial function `fac` is defined as:

```
fac 1 = 1
fac n = n * fac (n - 1)
```

Lets calculate the factorial for `n = 4`:
```
fac 4 = 4 * fac 3
      = 4 * (3 * fac 2)
      = 4 * (3 * (2 * fac 1))
      = 4 * (3 * (2 * 1))
      = 4 * (3 * 2)
      = 4 * 6
      = 24
```
While processing the recursion the term that is being evaluated gets longer. The recursion has to "memory" parts of its results. At the end when the recursion reaches the final condition the whole term can be solved. This is a problem for memory.

## Tail Recursion
Using tail recursion we can improve the factorial algorithm in terms of memory. We gonna introduce a helper function `go` which takes two parameters `n` and an accumulator `acc`.

```
go 1 a = a
go n a = go (n - 1) (n * acc)
```

The difference to classic recursion is that the term `go (n - 1) (n * acc)` can calculate its input parameters `n - 1` and `n * acc` immediately and pass it to the recursive function `go`. The `go` function is called last.

```
fac 4 = go 4 1
      = go 3 4 = go (4 -1) (4 * 1)
      = go 2 12
      = go 1 24
      = 24
```
Now its much more memory efficient. Every recursion step is just a call to a function with two inputs.

## Stack Overflow
A general problem with recursion is stack overflow. Every call to the recursive function increases your call stack. At some point you program will crash with a `StackOverflowException`.

You can avoid this by transforming a recursive function into an imperative function.

In Kotlin you can tell the compiler with the `tailrec` keyword to optimize that function for you.

## Links
* [Tail Recursion Explained](https://www.youtube.com/watch?v=_JtPhF8MshA)
