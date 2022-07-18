package nix.summer.practice.mvc

fun main() {
    val model = Model()
    val controller = Controller(model)
    println("Choose interface 1 - terminal, 2 - graphic interface")
    val choose = readLine()

    if (choose == "1" || choose == "2") {
        val inter: View
        when (choose) {
            "1" -> {
                inter = TerminalView(controller)
                controller.attachView(inter)
            }

            "2" -> {
                inter = GraphicView(controller)
                controller.attachView(inter)
            }
        }
        controller.start()
    } else {
        println("Invalid option")
    }
}
