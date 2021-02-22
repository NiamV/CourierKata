import org.scalatest.FunSuite

class CourierTest extends FunSuite{
    var input: Array[Package] = null
    var costCalculator: CostCalculator = null
    
    test("Empty"){
        input = Array()
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == 0)
    }
    
    test("Single small"){
        input = Array(new Package(3, 5, 8))
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == 3)
    }

    test("Single medium"){
        input = Array(new Package(15, 25, 40))
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == 8)
    }

    test("Single large"){
        input = Array(new Package(30, 50, 80))
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == 15)
    }

    test("Single extra large"){
        input = Array(new Package(70, 140, 210))
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == 25)
    }

    test("One of each"){
        input = Array(
            new Package(3, 5, 8),
            new Package(15, 25, 40),
            new Package(30, 50, 80),
            new Package(70, 140, 210)
        )
        costCalculator = new CostCalculator(input)

        assert(costCalculator.cost() == 51)
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

        assert(costCalculator.cost() == 102)
    }
}