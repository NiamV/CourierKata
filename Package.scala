// Class representing the package
// Parameterised by 3 integers representing the dimensions in centimeters
class Package(width: Int, height: Int, depth: Int){
    // Largest dimension for finding cost
    def maxSize(): Int = {
        return List(width, height, depth).max
    }
}