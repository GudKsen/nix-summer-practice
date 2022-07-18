package nix.summer.practice.mvc

interface View {
    var controller: Controller

    fun showInfo(info: String): String

    fun startUI()

    fun showInfoResources(info: String)
}