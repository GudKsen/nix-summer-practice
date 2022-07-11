package nix.summer.practice.coffeemachine

import java.util.*

fun messageAboutCoffeePreparation() {
    println("Starting to make a coffee in NIX office")
    println("Grinding coffee beans")
    println("Boiling water")
    println("Mixing boiled water with crushed coffee beans")
    println("Pouring coffee into the cup")
    println("Pouring some milk into the cup")
    println("Coffee is ready! Go to work!")
}

fun countIngredients() {
    println("Write how many cups of coffee you will need:")

    val countOfCupsString = readLine()
    val countOfCups = countOfCupsString!!.toInt()

    val waterForOneCup = 200
    val milkForOneCup = 50
    val coffeeBeansForOneCup = 15

    val waterTotalNumber = waterForOneCup * countOfCups
    val milkTotalNumber = milkForOneCup * countOfCups
    val coffeeBeansTotalNumber = coffeeBeansForOneCup * countOfCups

    println("For $countOfCups cups of coffee you will need:")
    println("$waterTotalNumber ml of water")
    println("$milkTotalNumber ml of milk")
    println("$coffeeBeansTotalNumber g of coffee beans")
}

fun countOfLeftIngredients() {
    val waterForOneCup = 200
    val milkForOneCup = 50
    val coffeeBeansForOneCup = 15

    val scan = Scanner(System.`in`)

    println("Write how many ml of water the coffee machine has:")
    var water = scan.nextInt()

    println("Write how many ml of milk the coffee machine has:")
    var milk = scan.nextInt()

    println("Write how many grams of coffee beans the coffee machine has:")
    var coffeeBeans = scan.nextInt()

    println("Write how many cups of coffee you will need:")
    val cups = scan.nextInt()

    var counterForCups = 0
    while (true) {
        water -= waterForOneCup
        milk -= milkForOneCup
        coffeeBeans -= coffeeBeansForOneCup
        if (water >= 0 && milk >= 0 && coffeeBeans >= 0) {
            counterForCups++
        }
        else {
            break
        }
    }

    when {
        counterForCups == cups -> {
            println("Yes, I can make that amount of coffee")
        }
        counterForCups > cups -> {
            println("Yes, I can make that amount of coffee (and even ${counterForCups - cups} more than that)")
        }
        counterForCups < cups -> {
            println("No, I can make only $counterForCups cups of coffee")
        }
    }
}

fun main() {
    messageAboutCoffeePreparation()
    countIngredients()
    countOfLeftIngredients()

    val coffee = CoffeeMachine()
    coffee.start()
}
