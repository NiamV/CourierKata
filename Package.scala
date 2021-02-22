// Class to represent the type of the package
// Size can only take the values Small, Medium, Large, XL
case class Type(size: String)

// Class representing the package
// Parameterised by 3 integers representing the dimensions in centimeters
class Package(width: Int, height: Int, depth: Int){
    // Largest dimension for finding cost
    def maxSize(): Int = {
        return List(width, height, depth).max
    }

    // Determines the cost of the single package
    def cost(): (Type, Int) = {
        // Variable for the cost that is outputted
        var c: (Type, Int) = (null, 0)

        val m = maxSize

        // Cases
        if(m < 10){
            c = (Type("Small"), 3)
        } else if(m < 50){
            c = (Type("Medium"), 8)
        } else if(m < 100){
            c = (Type("Large"), 15)
        } else {
            c = (Type("XL"), 25)
        }

        return c
    }
}