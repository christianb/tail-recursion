# How does Tail Recursion work?

Simple recursion can be very inefficient when the recursion gets longer with every recursion step. This is very memory inefficiten.

## Normal Recursion
A factorial function `fac` is defined as:
```
fac 1 = 1
fac n = n * fac (n - 1)
```

And a sample calculation:
```
fac 4 = 4 * fac 3
      = 4 * (3 * fac 2)
      = 4 * (3 * (2 * fac 1))
      = 4 * (3 * (2 * 1))
      = 4 * (3 * 2)
      = 4 * 6
      = 24
```
As you can see, because the recursion needs to "memorize" its result and calculate all together when the last recursion step has been processed.

## Tail recursion
Using tail recursion we can improve the factorial algorithm in terms of memory. We gonna introduce a helper function `go` which takes two parameters `n` and an accumulator `acc`

```
go 1 a = a
go n a = go (n - 1) (n * acc)
```
This expression can be separated in three steps:<br>
First: `n - 1`<br>
Second: `n * acc`<br>
Third: call `go` with the two input values

As you can see is that the last step is the call to the recursion function. No ohter values has to be computated after the evaluation of the recursive funciton call and this decrease the amount of memory that is needed.

```
fac 4 = go 4 1
      = go 3 4 = go (4 -1) (4 * 1)
      = go 2 12
      = go 1 24
      = 24
```
Now its much more memory efficient. Every recursion step is just a call to a function with two inputs.
