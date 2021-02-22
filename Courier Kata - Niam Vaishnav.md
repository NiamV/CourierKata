# Courier Kata - Niam Vaishnav

#### 1)

For this section, I have created a class `Package` that encapsulates a single package, and a class `CostCalculator` that will determine the cost of a list of packages stored in an array. The tests I need are:

- Test for no items
- Test for an individual item
- Test for multiple unique items
- Test for multiple duplicate items

The test results are as follows:

```bash
Run starting. Expected test count is: 7
CourierTest:
- Empty
- Single small
- Single medium
- Single large
- Single extra large
- One of each
- Two of each
Run completed in 214 milliseconds.
Total number of tests run: 7
Suites: completed 1, aborted 0
Tests: succeeded 7, failed 0, canceled 0, ignored 0, pending 0
All tests passed.
```



#### 2)

We can add a new parameter to cost, a boolean `speedy` that represents if Speedy Shipping was chosen. The same tests can be used again, this time with this cost added if required.

The test results are:

```bash
Run starting. Expected test count is: 14
CourierTest:
- Empty
- Single small
- Single medium
- Single large
- Single extra large
- One of each
- Two of each
- Empty (Speedy)
- Single small (Speedy)
- Single medium (Speedy)
- Single large (Speedy)
- Single extra large (Speedy)
- One of each (Speedy)
- Two of each (Speedy)
Run completed in 151 milliseconds.
Total number of tests run: 14
Suites: completed 1, aborted 0
Tests: succeeded 14, failed 0, canceled 0, ignored 0, pending 0
All tests passed.
```



#### 3)

Now we can add a new parameter to `Package` for the weight. For the testing, we need to duplicate all of the tests so far, one of which has the weights within the limit, and the other without.

This again passes all of the tests:

```scala
Run starting. Expected test count is: 26
CourierTest:
- Empty
- Single small
- Single medium
- Single large
- Single extra large
- One of each
- Two of each
- Empty (Speedy)
- Single small (Speedy)
- Single medium (Speedy)
- Single large (Speedy)
- Single extra large (Speedy)
- One of each (Speedy)
- Two of each (Speedy)
- Single small (Overweight)
- Single medium (Overweight)
- Single large (Overweight)
- Single extra large (Overweight)
- One of each, two of which are overweight
- Two of each, one overweight for each
- Single small (Speedy, Overweight)
- Single medium (Speedy, Overweight)
- Single large (Speedy, Overweight)
- Single extra large (Speedy, Overweight)
- One of each, two of which are overweight (Speedy)
- Two of each, one overweight for each (Speedy)
Run completed in 172 milliseconds.
Total number of tests run: 26
Suites: completed 1, aborted 0
Tests: succeeded 26, failed 0, canceled 0, ignored 0, pending 0
All tests passed.
```

