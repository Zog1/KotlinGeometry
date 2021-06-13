data class Rectangle(
    val id: Int,
    val points: MutableList<Map<Int, Int>>
) : IObjectInterface {
    @Override
    override fun length(x: Int, y: Int): Double = kotlin.math.sqrt((x*x + y*y).toDouble())
    override fun exists(x: Int, y: Int): Boolean = x < 0 || y > 10000
    override fun area(x: Int, y: Int): Double {
          return 0.0
    }
}