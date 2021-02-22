// Class to represent the type of the package
// Size can only take the values Small, Medium, Large, XL, Speedy, Heavy, Discount
case class Type(size: String)

// Class representing the package
// Parameterised by 3 integers representing the dimensions in centimeters and kilograms
class Package(width: Int, height: Int, depth: Int, weight: Int){
    // Largest dimension for finding cost
    def maxSize(): Int = {
        return List(width, height, depth).max
    }

    // Determines the cost of the single package
    def cost(): (Type, Int) = {
        // Variable for the cost that is outputted
        var c: (Type, Int) = (null, 0)

        val m = maxSize

        // Heavy parcel
        if(weight > 50){
            c = (Type("Heavy"), weight)
        }

        // Size Cases
        else{
            if(m < 10){
                if(weight > 1){
                    c = (Type("Small"), 3 + 2*(weight - 1))
                } else {
                    c = (Type("Small"), 3)
                }
                
            } else if(m < 50){
                if(weight > 3){
                    c = (Type("Medium"), 8 + 2*(weight - 3))
                } else {
                    c = (Type("Medium"), 8)
                }
            } else if(m < 100){
                if(weight > 6){
                    c = (Type("Large"), 15 + 2*(weight - 6))
                } else {
                    c = (Type("Large"), 15)
                }
            } else {
                if(weight > 10){
                    c = (Type("XL"), 25 + 2*(weight - 10))
                } else {
                    c = (Type("XL"), 25)
                }   
            }
        }

        return c
    }
}