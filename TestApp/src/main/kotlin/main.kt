import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReaderBuilder
import com.opencsv.CSVReaderHeaderAware
import org.apache.commons.lang3.StringUtils
import java.awt.geom.Area
import java.io.FileReader
import java.lang.Double.parseDouble
import java.lang.invoke.StringConcatFactory

fun main() {
    val reader = CSVReaderBuilder(FileReader("C:\\Users\\mznbo\\Downloads\\data.csv"))
        .withCSVParser(CSVParserBuilder().withSeparator('\n').build()).build()
        var line = reader.readNext()
        var circles: MutableList<Circle> = mutableListOf()
        var rectangles: MutableList<Rectangle> = mutableListOf()
        var lines: MutableList<Line> = mutableListOf()
        var errors: MutableList<String> = mutableListOf()
        var regex = "[0-9]+,L,[0-9]+-[0-9]+;[0-9]+.*".toRegex()

        while (line != null) {
            //println(line?.get(0))
           if (line[0].contains('C')) {
                if (line[0].contains(";")) {
                    if (line[0].first() != 'C'){

                    var x: String = ""
                    var y: String
                    var r: String

                    println(line[0])

                    x = line[0].substring(
                        StringUtils.ordinalIndexOf(
                            line[0],
                            ",", 2
                        ) + 1, line[0].indexOf(';')
                    )

                    y = x.substring(x.indexOf('-') + 1, x.length)
                    x = x.substring(0, x.indexOf('-'))
                    r = line[0].substringAfter(';')

                    circles.add(
                        Circle(
                            line[0].substringBefore(',').toInt(),
                           x.toInt(),
                            y.toInt(),
                            r.toInt()
                        )
                    )

                    }else{
                        errors.add(line[0].split(',')[1])
                    }
                } else {
                    errors.add(line[0].substringBefore(","))
                }

            }
           /* if (!line[0].matches(regex)) {
                var points = mutableListOf<Int>()
                var x: MutableList<Int> = mutableListOf()
                var y: MutableList<Int> = mutableListOf()

                var temp: String = ""

                while(temp.contains(';')){
                    temp = line[0].substring(
                        StringUtils.ordinalIndexOf(
                            line[0],
                            ",", 2
                        ) + 1, line[0].indexOf(';'))
                    y.add(temp.substring(x.indexOf('-') + 1, temp.length).toInt())
                    x.add(temp.substring(0, temp.indexOf('-')).toInt())
                }

                if(x.size>0){
                var tmpMap : MutableList<Map<Int, Int>> = mutableListOf()
                for (i in 0..x.size)
                    tmpMap.add(mapOf(x[i] to y[i]))
                lines.add(Line(
                    line[0].substringBefore(',').toInt(),
                    tmpMap
                ))}

            }else{
                //errors.add(line[0])
                errors.add(line[0].substring(firstDigit(line[0]), line[0].indexOf(',')))
            }*/
            line = reader.readNext()

    }

   errors.forEach{
        println(it + " - invalid format")
    }
    println("Number of circles - " + circles.size)
    showArea(circles[3])
    showLength(circles[3])
}

fun firstDigit(s: String): Int{
    for (i in 0..s.length){
        if (s.get(i).isDigit()){
            return i
        }
    }
    return 0
}

fun showArea(circle: Circle){
    println("The area of circle #"+circle.id)
    println("Area - " + circle.area(circle.x, circle.y))
}

fun showLength(circle: Circle){
    println("The area of circle #"+circle.id)
    println("Length - " + circle.length(circle.x, circle.y))
}