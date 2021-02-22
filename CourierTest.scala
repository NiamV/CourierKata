import org.scalatest.FunSuite

class CourierTest extends FunSuite{
    var input: Array[Package] = null
    var costCalculator: CostCalculator = null

    // Tests introduced in part 1
    
    test("Empty"){
        input = Array()
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List(), 0))
    }
    
    test("Single small"){
        input = Array(new Package(3, 5, 8, 1))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("Small"), 3)), 3))
    }

    test("Single medium"){
        input = Array(new Package(15, 25, 40, 2))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("Medium"), 8)), 8))
    }

    test("Single large"){
        input = Array(new Package(30, 50, 80, 4))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("Large"), 15)), 15))
    }

    test("Single extra large"){
        input = Array(new Package(70, 140, 210, 6))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("XL"), 25)), 25))
    }

    test("One of each"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 2),
            new Package(30, 50, 80, 4),
            new Package(70, 140, 210, 6)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Medium"), 8),
                    (Type("Large"), 15),
                    (Type("XL"), 25)
                )
                , 51)
        )
    }

    test("Two of each"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 2),
            new Package(30, 50, 80, 4),
            new Package(70, 140, 210, 6),
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 2),
            new Package(30, 50, 80, 4),
            new Package(70, 140, 210, 6)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Medium"), 8),
                    (Type("Large"), 15),
                    (Type("XL"), 25),
                    (Type("Small"), 3),
                    (Type("Medium"), 8),
                    (Type("Large"), 15),
                    (Type("XL"), 25),
                    (Type("Discount"), -3)
                )
                , 99)
        )
    }

    // Tests introduced in part 2

        test("Empty (Speedy)"){
        input = Array()
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("Speedy"), 0)), 0))
    }
    
    test("Single small (Speedy)"){
        input = Array(new Package(3, 5, 8, 1))
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("Small"), 3), (Type("Speedy"), 3)), 6))
    }

    test("Single medium (Speedy)"){
        input = Array(new Package(15, 25, 40, 2))
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("Medium"), 8), (Type("Speedy"), 8)), 16))
    }

    test("Single large (Speedy)"){
        input = Array(new Package(30, 50, 80, 4))
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("Large"), 15), (Type("Speedy"), 15)), 30))
    }

    test("Single extra large (Speedy)"){
        input = Array(new Package(70, 140, 210, 6))
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("XL"), 25), (Type("Speedy"), 25)), 50))
    }

    test("One of each (Speedy)"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 2),
            new Package(30, 50, 80, 4),
            new Package(70, 140, 210, 6)
        )
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Medium"), 8),
                    (Type("Large"), 15),
                    (Type("XL"), 25),
                    (Type("Speedy"), 51)
                )
                , 102)
        )
    }

    test("Two of each (Speedy)"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 2),
            new Package(30, 50, 80, 4),
            new Package(70, 140, 210, 6),
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 2),
            new Package(30, 50, 80, 4),
            new Package(70, 140, 210, 6)
        )
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Medium"), 8),
                    (Type("Large"), 15),
                    (Type("XL"), 25),
                    (Type("Small"), 3),
                    (Type("Medium"), 8),
                    (Type("Large"), 15),
                    (Type("XL"), 25),
                    (Type("Discount"), -3),
                    (Type("Speedy"), 99),
                )
                , 198)
        )
    }

    // Tests introduced in part 3

    test("Single small (Overweight)"){
        input = Array(new Package(3, 5, 8, 4))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("Small"), 9)), 9))
    }

    test("Single medium (Overweight)"){
        input = Array(new Package(15, 25, 40, 5))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("Medium"), 12)), 12))
    }

    test("Single large (Overweight)"){
        input = Array(new Package(30, 50, 80, 9))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("Large"), 21)), 21))
    }

    test("Single extra large (Overweight)"){
        input = Array(new Package(70, 140, 210, 15))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("XL"), 35)), 35))
    }

    test("One of each, two of which are overweight"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 5),
            new Package(30, 50, 80, 8),
            new Package(70, 140, 210, 9)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Medium"), 12),
                    (Type("Large"), 19),
                    (Type("XL"), 25)
                )
                , 59)
        )
    }

    test("Two of each, one overweight for each"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 2),
            new Package(30, 50, 80, 4),
            new Package(70, 140, 210, 6),
            new Package(3, 5, 8, 3),
            new Package(15, 25, 40, 5),
            new Package(30, 50, 80, 8),
            new Package(70, 140, 210, 12)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Medium"), 8),
                    (Type("Large"), 15),
                    (Type("XL"), 25),
                    (Type("Small"), 7),
                    (Type("Medium"), 12),
                    (Type("Large"), 19),
                    (Type("XL"), 29),
                    (Type("Discount"), -3)
                )
                , 115)
        )
    }

    test("Single small (Speedy, Overweight)"){
        input = Array(new Package(3, 5, 8, 4))
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("Small"), 9), (Type("Speedy"), 9)), 18))
    }

    test("Single medium (Speedy, Overweight)"){
        input = Array(new Package(15, 25, 40, 5))
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("Medium"), 12), (Type("Speedy"), 12)), 24))
    }

    test("Single large (Speedy, Overweight)"){
        input = Array(new Package(30, 50, 80, 9))
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("Large"), 21), (Type("Speedy"), 21)), 42))
    }

    test("Single extra large (Speedy, Overweight)"){
        input = Array(new Package(70, 140, 210, 15))
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == (List((Type("XL"), 35), (Type("Speedy"), 35)), 70))
    }

    test("One of each, two of which are overweight (Speedy)"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 5),
            new Package(30, 50, 80, 8),
            new Package(70, 140, 210, 9)
        )
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Medium"), 12),
                    (Type("Large"), 19),
                    (Type("XL"), 25),
                    (Type("Speedy"), 59)
                )
                , 118)
        )
    }

    test("Two of each, one overweight for each (Speedy)"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(15, 25, 40, 2),
            new Package(30, 50, 80, 4),
            new Package(70, 140, 210, 6),
            new Package(3, 5, 8, 3),
            new Package(15, 25, 40, 5),
            new Package(30, 50, 80, 8),
            new Package(70, 140, 210, 12)
        )
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Medium"), 8),
                    (Type("Large"), 15),
                    (Type("XL"), 25),
                    (Type("Small"), 7),
                    (Type("Medium"), 12),
                    (Type("Large"), 19),
                    (Type("XL"), 29),
                    (Type("Discount"), -3),
                    (Type("Speedy"), 115)
                )
                , 230)
        )
    }

    // Tests introduced in part 4

    test("Single heavy (small size)"){
        input = Array(new Package(3, 5, 8, 60))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("Heavy"), 60)), 60))
    }

    test("Single heavy (XL size)"){
        input = Array(new Package(70, 140, 210, 60))
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == (List((Type("Heavy"), 60)), 60))
    }

    test("Multiple heavy"){
        input = Array(
            new Package(3, 5, 8, 60),
            new Package(15, 25, 40, 70),
            new Package(30, 50, 80, 80),
            new Package(70, 140, 210, 90)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Heavy"), 60),
                    (Type("Heavy"), 70),
                    (Type("Heavy"), 80),
                    (Type("Heavy"), 90)
                )
                , 300)
        )
    }

    test("Multiple heavy (Speedy)"){
        input = Array(
            new Package(3, 5, 8, 60),
            new Package(15, 25, 40, 70),
            new Package(30, 50, 80, 80),
            new Package(70, 140, 210, 90)
        )
        costCalculator = new CostCalculator(input, true)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Heavy"), 60),
                    (Type("Heavy"), 70),
                    (Type("Heavy"), 80),
                    (Type("Heavy"), 90),
                    (Type("Speedy"), 300)
                )
                , 600)
        )
    }

    // Tests introduced in part 5

    test("Small Parcel mania (4)"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 4)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Small"), 3),
                    (Type("Small"), 3),
                    (Type("Small"), 9),
                    (Type("Discount"), -3) // Small
                )
                , 15)
        )
    }

    test("Small Parcel mania (5)"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 4),
            new Package(3, 5, 8, 1)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Small"), 3),
                    (Type("Small"), 3),
                    (Type("Small"), 9),
                    (Type("Small"), 3),
                    (Type("Discount"), -3) // Small
                )
                , 15)
        )
    }

    test("Small Parcel mania (8)"){
        input = Array(
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 4),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 1),
            new Package(3, 5, 8, 4)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Small"), 3),
                    (Type("Small"), 3),
                    (Type("Small"), 3),
                    (Type("Small"), 9),
                    (Type("Small"), 3),
                    (Type("Small"), 3),
                    (Type("Small"), 3),
                    (Type("Small"), 9),
                    (Type("Discount"), -3), // Small
                    (Type("Discount"), -3), // Small
                )
                , 30)
        )
    }

    test("Medium Parcel mania (3)"){
        input = Array(
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 5)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Medium"), 8),
                    (Type("Medium"), 8),
                    (Type("Medium"), 12),
                    (Type("Discount"), -8) //Medium
                )
                , 20)
        )
    }

    test("Medium Parcel mania (4)"){
        input = Array(
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 5)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Medium"), 8),
                    (Type("Medium"), 8),
                    (Type("Medium"), 8),
                    (Type("Medium"), 12),
                    (Type("Discount"), -8) // Medium
                )
                , 28)
        )
    }

    test("Medium Parcel mania (6)"){
        input = Array(
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 5),
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 2),
            new Package(15, 25, 40, 5)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Medium"), 8),
                    (Type("Medium"), 8),
                    (Type("Medium"), 12),
                    (Type("Medium"), 8),
                    (Type("Medium"), 8),
                    (Type("Medium"), 12),
                    (Type("Discount"), -8), // Medium
                    (Type("Discount"), -8), // Medium
                )
                , 40)
        )
    }

    test("Mixed Parcel mania (5)"){
        input = Array(
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 8)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 19),
                    (Type("Discount"), -15)
                )
                , 64)
        )
    }

    test("Mixed Parcel mania (7)"){
        input = Array(
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 8)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 19),
                    (Type("Discount"), -15)
                )
                , 94)
        )
    }

    test("Mixed Parcel mania (10)"){
        input = Array(
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 8),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 4),
            new Package(30, 50, 80, 8)
        )
        costCalculator = new CostCalculator(input, false)

        assert(costCalculator.cost() == 
            (
                List(
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 19),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 15),
                    (Type("Large"), 19),
                    (Type("Discount"), -15),
                    (Type("Discount"), -15)

                )
                , 128)
        )
    }
}