object CardValidation {

    private val ACME = "1121"
    private val ALFA = "1111"
    private val AMEX = "3796"

    private fun checkFormat(cardNumber: String) =
        cardNumber.matches(Regex("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}"))

    private fun checkDate(cardNumber: String, expiryDate: String): Boolean {
//        val lastIndex = cardNumber.length - 1
//        val month = cardNumber.substring(lastIndex - 3, lastIndex - 2).toInt()
        return cardNumber.takeLast(4) == expiryDate.replace("/", "")
//            month <= 12 && month >= 1 &&
//            cardNumber.takeLast(2).toInt() >= 22
    }

    private fun checkNumber(cardNumber: String): String?{
        return when(cardNumber.take(4)){
            ACME -> "ACME"
            ALFA -> "ALFA"
            AMEX -> "AMEX"
            else -> null
        }
    }

    fun validation(cardNumber: String, expiryDate: String): String? {
        if (!checkFormat(cardNumber)||!checkDate(cardNumber, expiryDate)) return null
        return checkNumber(cardNumber)
    }
}

