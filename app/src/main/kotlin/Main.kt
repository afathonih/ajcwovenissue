import com.app.Animal0Factory
import com.app.Animal0Type

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val fish = Animal0Factory(Animal0Type.FISH)
    fish.sound()
}