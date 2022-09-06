package com.example.creditcardvalidation

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

object CardValidation {

    private val cardTypes = HashMap<String, String>()
    init {
        cardTypes["ACME"] = "1121"
        cardTypes["ALFA"] = "1111"
        cardTypes["AMEX"] = "3796"
    }

    private fun checkFormat(cardNumber: String) =
        cardNumber.matches(Regex("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}"))

    private fun checkDate(cardNumber: String, expiryDate: String): Boolean {
        val expMonth = expiryDate.take(2).toInt()
        val expDate = SimpleDateFormat("MM/yy", Locale.UK).parse(expiryDate) ?: return false
        return cardNumber.takeLast(4) == expiryDate.replace("/", "") &&
                expDate >= Date() && expMonth >= 1 && expMonth <= 12
    }

    private fun checkType(cardNumber: String): String?{
        for (type in cardTypes) {
            if (type.value == cardNumber.take(4)) return type.key
        }
        return null
    }

    fun validation(cardNumber: String, expiryDate: String): String? {
        if (!checkFormat(cardNumber) || !checkDate(cardNumber, expiryDate)) return null
        return checkType(cardNumber)
    }
}

