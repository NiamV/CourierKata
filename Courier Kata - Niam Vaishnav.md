# Courier Kata - Niam Vaishnav

I have used Scala and ScalaTest to solve and test this problem.

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
(Tests from part 1)
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
(Tests from parts 1 and 2)
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



#### 4)

Assuming that the heavy package type overrides the size type, we need to introduce tests for the heavy packages:

- Individual heavy package for different sizes
- Multiple heavy packages
- Heavy package with speedy delivery

To implement this, we need a check in the `Package` class for if the package is heavy. The test results are:

```bash
Run starting. Expected test count is: 30
CourierTest:
(Tests from parts 1 to 3)
- Single heavy (small size)
- Single heavy (XL size)
- Multiple heavy
- Multiple heavy (Speedy)
Run completed in 171 milliseconds.
Total number of tests run: 30
Suites: completed 1, aborted 0
Tests: succeeded 30, failed 0, canceled 0, ignored 0, pending 0
All tests passed.
```



#### 5)

First we can design tests for when there are no clashes in discounts:

- 4, 5 and 8 small parcels (Small parcel mania) 
- 3, 5 and 6 medium parcels (Medium parcel mania)
- 5, 7 and 10 large parcels (Mixed parcel mania)

I also need to change the tests I have previously implemented that have 8 packages. Luckily, the only possible discount that can be applied is Mixed Parcel Mania, so there are no clashes.

We can implement this, assuming there are no clashes, by changing the `cost` function in `CostCalculator`. We can keep track of how many of each package we have seen, and then applying the discounts at the end if we have enough.

Again this passes all of the tests:

```bash
Run starting. Expected test count is: 39
CourierTest:
(Tests from parts 1 to 4)
- Small Parcel mania (4)
- Small Parcel mania (5)
- Small Parcel mania (8)
- Medium Parcel mania (3)
- Medium Parcel mania (4)
- Medium Parcel mania (6)
- Mixed Parcel mania (5)
- Mixed Parcel mania (7)
- Mixed Parcel mania (10)
Run completed in 256 milliseconds.
Total number of tests run: 39
Suites: completed 1, aborted 0
Tests: succeeded 39, failed 0, canceled 0, ignored 0, pending 0
All tests passed.
```



Unfortunately I did not have time to implement the other clash cases. The next things I would do are:

- Decide tests for when clashes may occur, such as having 9 small parcels or 8 medium parcels
- Implement the solution to these cases by adapting `Cost.scala`
- Refactor the discounts code in `Cost.scala` and size cases in `Package.scala` as there is a lot of repeated code that could be put into a function



Niam Vaishnav































