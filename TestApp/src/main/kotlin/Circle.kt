data class Circle(
    val id : Int,
    val x : Int,
    val y : Int,
    val r : Int
) : IObjectInterface {
    @Override
    override fun area(x: Int, y: Int):Double = kotlin.math.PI*y*y
    override fun exists(x: Int, y: Int): Boolean = x < 0 || y > 10000
    override fun length(x: Int, y: Int): Double = kotlin.math.sqrt((x*x + y*y).toDouble())
}