package nix.summer.practice.chatbot

import java.util.*

fun firstStage() {
    val botName = "Rocky"
    val yearOfCreating = "2022"

    println("Hello! My name is $botName.\nI was created in $yearOfCreating.")
}

fun secondStage() {
    println("Please, remind me your name.")

    val yourName = readLine()

    println("What a great name you have, $yourName!")
}

fun thirdStage() {
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")

    val scan = Scanner(System.`in`)
    val remainderThree = scan.nextInt()
    val remainderFive = scan.nextInt()
    val remainderSeven = scan.nextInt()

    val yourAge = (remainderThree * 70 + remainderFive * 21 + remainderSeven * 15) % 105

    println("Your age is $yourAge; that's a good time to start programming!")
}

fun fourthStage() {
    println("I will prove to you that I can count to any number you want:")

    val scan = Scanner(System.`in`)
    val number = scan.nextInt()
    var x = 1;

    while (x <= number) {
        println("$x !")
        x++
    }
}

fun fifthStage() {
    val correctAnswer = 1

    println("\nLet's play)))\n")

    while (true) {
        println("What is debugging?")
        println("1. Debugging is the process of finding and removing errors in a program.")
        println("2. Debugging is a process of documenting all the errors that occur in a program.")
        println("3. Debugging is the process of finding errors.")

        print("Your answer: ")
        val userAnswer = readLine()

        if (userAnswer == correctAnswer.toString()) {
            println("Great, you right!");
            break
        }

        println("Please, try again.\n")
    }
}

fun main() {
    firstStage()  //the bot says hello
    secondStage() //bot asks for username
    thirdStage() //the bot tries to guess the user's age
    fourthStage() //counting numbers
    fifthStage() //test

    println("Goodbye, have a nice day!")
}