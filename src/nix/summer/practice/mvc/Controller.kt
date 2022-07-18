package nix.summer.practice.mvc

class Controller(private val model: Model) {
    private lateinit var view: View

    fun attachView(_view: View) {
        view = _view
    }

    fun start() {
        view.showInfo("Information about process")
        view.startUI()
    }

    fun buyCoffee(obj:OptionForBuyingCoffee) {
        val response = model.buy(obj)
        view.showInfo(response.message)
    }

    fun fillResources(res: Resources) {
        view.showInfoResources(model.fill(res))
    }

    fun remaining() {
        view.showInfo(model.showIngredients())
    }

    fun takeMoney() {
        view.showInfo(model.take())
    }
}