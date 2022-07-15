package nix.summer.practice.mvc

import java.util.*

class TerminalView(override var controller: Controller): View{
    override fun showInfo(info: String): String {
        println(info)
        return "Print"
    }

    override fun startUI() {
        start()
    }

    private fun start() {
        do {
            println("Write action (buy, fill, take, remaining, exit):")
            val choice = readLine()

            when (choice) {
                "buy" -> {
                    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                    val optionCoffee = readLine()

                    if (optionCoffee != null) {
                        val obj = OptionForBuyingCoffee(optionCoffee)
                        controller.buyCoffee(obj)
                    }
                }

                "fill" -> {
                    val scan = Scanner(System.`in`)

                    println("Write how many ml of water you want to add:")
                    val waterInput = scan.nextInt()

                    println("Write how many ml of milk you want to add:")
                    val milkInput = scan.nextInt()

                    println("Write how many grams of coffee beans you want to add:")
                    val coffeeBeansInput = scan.nextInt()

                    println("Write how many disposable coffee cups you want to add:")
                    val cupsInput = scan.nextInt()

                    val res = Resources(waterInput, milkInput, coffeeBeansInput, cupsInput)
                    controller.fillResources(res)
                }

                "take" -> {
                    controller.takeMoney()
                }

                "remaining" -> {
                    controller.remaining()
                }

                else -> {
                    if (choice != "exit") {
                        println("Invalid option")
                    }
                }
            }
        } while (choice != "exit")
    }

    override fun showInfoResources(info: String) {
        println(info)
    }
}