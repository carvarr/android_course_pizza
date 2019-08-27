package curso.carlos.pizza

class Pizza (
    var name: String = TODO(),
    var price: Double = TODO(),
    var image: String = TODO()
) {
    companion object {
        const val PIZZA_PARAM_NAME = "PIZZA_NAME"
        const val PIZZA_PARAM_PRICE = "PRODUCT_DESC"
        const val PIZZA_PARAM_IMG = "PRODUCT_IMG"
    }
}