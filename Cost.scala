// Class that determines the cost of a set of packages
class CostCalculator(packages: Array[Package], speedy: Boolean){

    // Returns an array of packages and costs, and the final costs
    def cost(): (List[(Type, Int)], Int) = {
        var totalCost = 0
        var indivCosts = List[(Type, Int)]()

        // List such that elements in this list have not been used in a discount
        var discountApplied: List[(Type, Int)] = List[(Type, Int)]()

        for(p <- packages){
            indivCosts = indivCosts :+ (p.cost())
            discountApplied = discountApplied :+ (p.cost())
            totalCost += p.cost()._2
        }

        // Discounts
        var unusedSmall = discountApplied.filter(x => x._1 == Type("Small")).sortBy(_._2)
        while(unusedSmall.length >= 4){
            val minCost = unusedSmall.head._2
            indivCosts = indivCosts :+ (Type("Discount"), 0-minCost)
            totalCost = totalCost - minCost

            discountApplied = discountApplied.filter(x => !(x._1 == Type("Small"))) ++ unusedSmall.drop(4)
            
            unusedSmall = discountApplied.filter(x => x._1 == Type("Small")).sortBy(_._2)
        }

        var unusedMedium = discountApplied.filter(x => x._1 == Type("Medium")).sortBy(_._2)
        while(unusedMedium.length >= 3){
            val minCost = unusedMedium.head._2
            indivCosts = indivCosts :+ (Type("Discount"), 0-minCost)
            totalCost = totalCost - minCost

            discountApplied = discountApplied.filter(x => !(x._1 == Type("Medium"))) ++ unusedMedium.drop(3)

            unusedMedium = discountApplied.filter(x => x._1 == Type("Medium")).sortBy(_._2)
        }

        while(discountApplied.length >= 5){
            discountApplied = discountApplied.sortBy(_._2)
            
            val minCost = discountApplied.head._2
            indivCosts = indivCosts :+ (Type("Discount"), 0-minCost)
            totalCost = totalCost - minCost

            discountApplied = discountApplied.drop(5)
        }

        // Cost increase if speedy chosen
        if(speedy){
            indivCosts = indivCosts :+ (Type("Speedy"), totalCost)
            totalCost = totalCost * 2
        }

        return (indivCosts, totalCost)
    }
    
}