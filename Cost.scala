// Class that determines the cost of a set of packages
class CostCalculator(packages: Array[Package], speedy: Boolean){

    // Returns an array of 
    def cost(): (List[(Type, Int)], Int) = {
        var totalCost = 0
        var indivCosts = List[(Type, Int)]()

        for(p <- packages){
            indivCosts = indivCosts :+ (p.cost())
            totalCost += p.cost()._2
        }

        if(speedy){
            indivCosts = indivCosts :+ (Type("Speedy"), totalCost)
            totalCost = totalCost * 2
        }

        return (indivCosts, totalCost)
    }
    
}