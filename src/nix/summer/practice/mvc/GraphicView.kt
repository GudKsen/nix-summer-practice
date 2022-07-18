package nix.summer.practice.mvc

import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.*
import kotlin.system.exitProcess

class GraphicView(override var controller: Controller): JFrame(), View {
    private lateinit var mainFrame: JFrame
    private lateinit var controlPanel: JPanel
    private lateinit var fillPanel: JPanel
    private lateinit var infoLabel: JLabel
    private lateinit var infoLabelTotal:JLabel
    private lateinit var numInputWater: JTextField
    private lateinit var numInput: JTextField
    private lateinit var numInputMilk:JTextField
    private lateinit var numInputCoffeeBeans:JTextField
    private lateinit var infoPanel:JPanel
    private lateinit var buyCoffeePanel:JPanel
    private lateinit var takeMoneyPanel:JPanel

    init {
        createUI()
    }

    override fun startUI() {}

    private fun createUI() {
        title = GraphicView::class.java.toString()
        controlPanel = JPanel().apply { layout = FlowLayout() }

        infoPanel = JPanel().apply { layout = FlowLayout() }
        buyCoffeePanel = JPanel().apply { layout = FlowLayout() }
        fillPanel = JPanel().apply { layout = FlowLayout() }
        takeMoneyPanel = JPanel().apply { layout = FlowLayout() }

        mainFrame = JFrame("Graphic View").apply {
            setSize(400, 500)
            layout = GridLayout(4, 1)
            addWindowListener(object: WindowAdapter() {
                override fun windowClosing(e: WindowEvent?) {
                    exitProcess(0)
                }
            })

            add(infoPanel)
            add(buyCoffeePanel)
            add(fillPanel)
            add(takeMoneyPanel)
            isVisible = true
        }

        createInfoPanel()
        createBuyCoffeePanel()
        createFillPanel()
        createTakeMoneyPanel()
        mainFrame.isVisible = true
    }

    private fun createInfoPanel() {
        infoLabelTotal = JLabel("some text")
        infoPanel.add(infoLabelTotal)
    }

    private fun createBuyCoffeePanel() {
        val espressoButton = JButton("Espresso").apply {
            addActionListener {
                buyCoffee("1")
            }
        }

        val latteButton = JButton("Latte").apply {
            addActionListener {
                buyCoffee("2")
            }
        }

        val cappuccinoButton = JButton("Cappuccino").apply {
            addActionListener {
                buyCoffee("3")
            }
        }

        buyCoffeePanel.add(espressoButton)
        buyCoffeePanel.add(latteButton)
        buyCoffeePanel.add(cappuccinoButton)
    }

    private fun createFillPanel() {
        fillPanel.add(Box.createRigidArea(Dimension(10, 0)))
        infoLabel = JLabel("Water")
        fillPanel.add(infoLabel)

        numInputWater = JTextField("0", 3)
        fillPanel.add(numInputWater)
        fillPanel.add(Box.createRigidArea(Dimension(130, 0)))


        infoLabel = JLabel("Milk")
        fillPanel.add(infoLabel)

        numInputMilk = JTextField("0", 3)
        fillPanel.add(numInputMilk)
        fillPanel.add(Box.createRigidArea(Dimension(30, 0)))


        infoLabel = JLabel("Coffee beans")
        fillPanel.add(infoLabel)

        numInputCoffeeBeans = JTextField("0", 3)
        fillPanel.add(numInputCoffeeBeans)
        fillPanel.add(Box.createRigidArea(Dimension(120, 0)))


        infoLabel = JLabel("Cups")
        fillPanel.add(infoLabel)

        numInput = JTextField("0", 3)
        fillPanel.add(numInput)
        fillPanel.add(Box.createRigidArea(Dimension(60, 0)))

        val fillButton = JButton("Fill").apply {
            addActionListener {
                val ingredients = Resources(water = numInputWater.text.toInt(),
                milk = numInputMilk.text.toInt(),
                coffeeBeans = numInputCoffeeBeans.text.toInt(),
                cups = numInput.text.toInt())
                controller.fillResources(ingredients)
            }
        }
        fillPanel.add(fillButton)
    }

    private fun createTakeMoneyPanel() {
        val takeMoneyButton = JButton("Take money").apply {
            addActionListener {
                controller.takeMoney()
            }
        }
        takeMoneyPanel.add(takeMoneyButton)
    }

    override fun showInfo(info: String): String {
        infoLabelTotal.text = info
        return "Print"
    }

    override fun showInfoResources(info: String) {
        var str = "<html>"
        for (x in info) {
            if (x == '\n') {
                str += "<br>"
            } else {
                str += x
            }
        }
        str += "</html>"
        infoLabelTotal.text = str
    }

    private fun buyCoffee(str: String) {
        val option = OptionForBuyingCoffee(str)
        controller.buyCoffee(option)
    }
}
