import java.text.SimpleDateFormat
import java.util.*

object CardValidation {

    private const val ACME = "1121"
    private const val ALFA = "1111"
    private const val AMEX = "3796"

    private fun checkFormat(cardNumber: String) =
        cardNumber.matches(Regex("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}"))

    private fun checkDate(cardNumber: String, expiryDate: String): Boolean {
        val expDate = SimpleDateFormat("MM/yy").parse(expiryDate)
        val expMonth = expiryDate.take(2).toInt()
        return cardNumber.takeLast(4) == expiryDate.replace("/", "") &&
                expDate.compareTo(Date()) >= 0 && expMonth >= 1 && expMonth <= 12
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

