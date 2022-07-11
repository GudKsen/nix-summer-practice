package nix.summer.practice.coffeemachine

import java.util.*

enum class CoffeeRecipe(val water: Int, val milk:Int, val coffeeBeans:Int, val price:Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6)
}



class CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var cups = 9
    private var money = 550

    private fun isEnoughIngredients(waterNeed: Int, milkNeed:Int, coffeeBeansNeed: Int): String {
        val message: String
        var counterForCups = 0

        var waterTmp = water
        var milkTmp = milk
        var coffeeBeansTmp = coffeeBeans
        var cupsTmp = cups

        while (true) {
            waterTmp -= waterNeed
            milkTmp -= milkNeed
            coffeeBeansTmp -= coffeeBeansNeed
            cupsTmp -= 1
            if (waterTmp >= 0 && milkTmp >= 0 && coffeeBeansTmp >= 0 && cupsTmp >= 0) {
                counterForCups++
            }
            else {
                break
            }
        }

        message = if (counterForCups > 0) {
            "I have enough resources, making you a coffee!"
        } else  {
            when {
                waterTmp <= 0 -> {
                    "Sorry, not enough water!"
                }
                milkTmp <= 0 -> {
                    "Sorry, not enough milk!"
                }
                coffeeBeansTmp <= 0 -> {
                    "Sorry, not enough coffee beans!"
                }
                else -> {
                    "Sorry, not enough cups!"
                }
            }
        }

        return message
    }

    private fun showIngredients() {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$coffeeBeans of coffee beans")
        println("$cups of disposable cups")
        println("$money of money")
    }

    private fun calculateIngredients(coffee: CoffeeRecipe) {
        val msg: String = isEnoughIngredients(coffee.water, coffee.milk, coffee.coffeeBeans)
        if (msg == "I have enough resources, making you a coffee!") {
            water -= coffee.water
            milk -= coffee.milk
            coffeeBeans -= coffee.coffeeBeans
            money += coffee.price
            cups -= 1
        }
        println(msg)
    }

    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val option = readLine()
        if (option == "1" || option == "2" || option == "3" || option == "back") {
            when(option) {
                "1" -> {
                    calculateIngredients(CoffeeRecipe.ESPRESSO)
                }

                "2" -> {
                    calculateIngredients(CoffeeRecipe.LATTE)
                }

                "3" -> {
                    calculateIngredients(CoffeeRecipe.CAPPUCCINO)
                }
            }
        } else {
            println("Invalid option")
        }
    }

    private fun fill() {
        val scan = Scanner(System.`in`)

        println("Write how many ml of water you want to add:")
        val waterInput = scan.nextInt()
        water += waterInput

        println("Write how many ml of milk you want to add:")
        val milkInput = scan.nextInt()
        milk += milkInput

        println("Write how many grams of coffee beans you want to add:")
        val coffeeBeansInput = scan.nextInt()
        coffeeBeans += coffeeBeansInput

        println("Write how many disposable coffee cups you want to add:")
        val cupsInput = scan.nextInt()
        cups += cupsInput
    }

    private fun take() {
        println("I gave you $money")
        money = 0
    }

    fun start() {
        do {
            println("Write action (buy, fill, take, remaining, exit):")
            val option = readLine()

            when (option) {
                "buy" -> {
                    buy()
                }

                "fill" -> {
                    fill()
                }

                "take" -> {
                    take()
                }

                "remaining" -> {
                    showIngredients()
                }

                else -> {
                    if (option != "exit") {
                        println("Invalid option")
                    }
                }
            }

        } while (option != "exit")
    }
}
