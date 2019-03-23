package com.romannumber

import com.nhaarman.expect.expect
import org.junit.Test

class RomanNumberUtilsTest {

    /**
     * Checks a valid roman number.
     */
    @Test
    fun testIsRomanNumber_validNumber() {
        expect(RomanNumberUtils.isRomanNumber("I")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("X")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("V")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("C")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("L")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("II")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("III")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("IV")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("VI")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("VII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("VIII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("IX")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XI")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XIII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XIV")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XV")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XVI")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XCIX")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XVII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("XVIII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CCCXXXV")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("LXXIII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("LXXXVIII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("LXXXIII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("LXXXIX")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CX")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CXI")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CXIV")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CXXV")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CCCIII")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CCCXXXV")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CCCXXXIX")).toBe(true)
        expect(RomanNumberUtils.isRomanNumber("CCCXCIX")).toBe(true)
    }

    /**
     * Checks a non-valid roman number - bigger number follow lesser number, e.g "IIXX".
     */
    @Test
    fun testIsRomanNumber_nonValidNumber_biggerNumberFollowLesserNumber() {
        expect(RomanNumberUtils.isRomanNumber("IIXX")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("VL")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("IXC")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("LC")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XXL")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("CIXXI")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XXC")).toBe(false)
    }

    /**
     * Checks a non-valid roman number - there are more than three 'X'/'C'/'I' in a row, e.g "IIII".
     */
    @Test
    fun testIsRomanNumber_nonValidNumber_moreThanThreeXICInARow() {
        expect(RomanNumberUtils.isRomanNumber("XXXX")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("CCCC")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("IIII")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("CIIII")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("CXXXX")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("CXXXXI")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("CCCCI")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XXXXI")).toBe(false)

        // More than three, but not in a row
        expect(RomanNumberUtils.isRomanNumber("XXXIX")).toBe(true)
    }

    /**
     * Checks a non-valid roman number - there are more than one 'V'/'L' in the string, e.g "VVLL".
     */
    @Test
    fun testIsRomanNumber_nonValidNumber_moreThanOneVL() {
        expect(RomanNumberUtils.isRomanNumber("VV")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("LL")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XVV")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("CLL")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("LLX")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("VVLL")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("LLVV")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XVVI")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("CLLI")).toBe(false)
    }

    /**
     * Checks a non-valid roman number - more than one lesser numeral precede a bigger numeral, e.g "IIV".
     */
    @Test
    fun testIsRomanNumber_nonValidNumber_moreThanOneLesserNumeralPrecedeABiggerNumeral() {
        expect(RomanNumberUtils.isRomanNumber("IIV")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("IIX")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XXCII")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XIIV")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XCIIX")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("IIC")).toBe(false)
    }

    /**
     * Checks a non-valid roman number - the string contains non-valid roman numeral, e.g "i@5".
     */
    @Test
    fun testIsRomanNumber_nonValidNumber_notARomanNumeral() {
        expect(RomanNumberUtils.isRomanNumber("asfsd")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("#@67hjj")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("XXiX")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("X ")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber(" X ")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber(" X")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("X III")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber(" ")).toBe(false)
        expect(RomanNumberUtils.isRomanNumber("")).toBe(false)
    }
}