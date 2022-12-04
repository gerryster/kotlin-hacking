import java.io.BufferedReader
import java.io.InputStreamReader

/*
  Converts a java.awt.Color integer into a hex code.

  Integer colors can be passed in as arguments and/or on standard input.
*/

fun main(args : Array<String>) {
    args.iterator().forEach { rawAwtColor ->
        printColorAndHex(rawAwtColor)
    }

    var br = BufferedReader(InputStreamReader(System.`in`))
    if(br.ready()) {
        var input = br.readLine()
        while(input != null) {
            printColorAndHex(input.trim())
            input = br.readLine()
        }
    }
}

fun printColorAndHex(rawAwtColor: String) {
    var color = java.awt.Color(Integer.parseInt(rawAwtColor))
    println("$rawAwtColor, ${color2hex(color)}")
}

fun color2hex(color : java.awt.Color) : String {
    // Credit goes to https://community.oracle.com/tech/developers/discussion/1206435/convert-java-awt-color-to-hex-string
    // for this.
    var red   = Integer.toHexString(color.getRed())
    var green = Integer.toHexString(color.getGreen())
    var blue  = Integer.toHexString(color.getBlue())

    if (red.length == 1) red = "0$red";
    if (green.length == 1) green = "0$green";
    if (blue.length == 1) blue = "0$blue";

    return "#$red$green$blue"
}