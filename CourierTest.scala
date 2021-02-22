import org.scalatest.FunSuite

class CourierTest extends FunSuite{
    var input: Array[Package] = null
    var costCalculator: CostCalculator = null
    
    test("Empty"){
        input = Array()
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == (List(), 0))
    }
    
    test("Single small"){
        input = Array(new Package(3, 5, 8))
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == (List((Type("Small"), 3)), 3))
    }

    test("Single medium"){
        input = Array(new Package(15, 25, 40))
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == (List((Type("Medium"), 8)), 8))
    }

    test("Single large"){
        input = Array(new Package(30, 50, 80))
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == (List((Type("Large"), 15)), 15))
    }

    test("Single extra large"){
        input = Array(new Package(70, 140, 210))
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == (List((Type("XL"), 25)), 25))
    }

    test("One of each"){
        input = Array(
            new Package(3, 5, 8),
            new Package(15, 25, 40),
            new Package(30, 50, 80),
            new Package(70, 140, 210)
        )
        costCalculator = new CostCalculator(input)

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
            new Package(3, 5, 8),
            new Package(15, 25, 40),
            new Package(30, 50, 80),
            new Package(70, 140, 210),
            new Package(3, 5, 8),
            new Package(15, 25, 40),
            new Package(30, 50, 80),
            new Package(70, 140, 210)
        )
        costCalculator = new CostCalculator(input)

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
                    (Type("XL"), 25)
                )
                , 102)
        )
    }
}