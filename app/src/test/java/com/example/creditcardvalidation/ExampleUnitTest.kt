package com.example.creditcardvalidation

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun `valid card number`(){
        assertEquals("ACME", CardValidation.validation("1121-4356-1313-1222","12/22"))
        assertEquals("ALFA", CardValidation.validation("1111-4356-1313-1222","12/22"))
        assertEquals("AMEX", CardValidation.validation("3796-4356-1313-1222","12/22"))
    }

    @Test
    fun `invalid format`() {
        assertNull(CardValidation.validation("3796435613131222","12/22"))
        assertNull(CardValidation.validation("1121-a356-1313-1222","12/22"))
        assertNull(CardValidation.validation("1121.4356.1313.1222","12/22"))
        assertNull(CardValidation.validation("1121-4356-14313-1222","12/22"))
        assertNull(CardValidation.validation("1121-4356-1313-1222 ","12/22"))
        assertNull(CardValidation.validation("1121-4356-1222","12/22"))
    }

    @Test
    fun `invalid date`() {
        assertNull(CardValidation.validation("1121-4356-1313-1222","12/20"))
        assertNull(CardValidation.validation("1121-4356-1313-1222","11/22"))
//        assertNull(CardValidation.validation("1121-4356-1313-1219","12/19"))
//        assertNull(CardValidation.validation("1121-4356-1313-1322","13/22"))
    }

    @Test
    fun `invalid card type`() {
        assertNull(CardValidation.validation("1101-4356-1313-1222","12/22"))
        assertNull(CardValidation.validation("0111-4356-1313-1222","12/22"))
    }
}