package com.romannumber

class RomanNumberUtils {
    companion object {

        // This array represents all the roman numerals and all the legal lesser-numeral-numeral combinations, in descending order.
        // The reason the array values are ordered by descending order is so we can enforce the fact that valid numerals appear in a descending order in terms of their numeric value.
        private val romanLiteralsArr: Array<String> = arrayOf("C", "XC", "L" , "XL", "X", "IX", "V", "IV", "I")

        /**
         * Determines if a string represents a valid Roman number.
         * @return true or false.
         */
        fun isRomanNumber(_strToVerify: String) : Boolean {
            var isRomanNumber: Boolean = true
            if (_strToVerify.isNullOrEmpty() || !isValidRomanCharNumOfOccurrences(_strToVerify)) {
                isRomanNumber = false
            } else {
                val romanLiteralsArrSize: Int = romanLiteralsArr.size
                var strToVerify: String = _strToVerify
                var romanLiteralsArrIndex: Int = 0
                // The assumption here is that the literal array is ordered by descending order.
                while(romanLiteralsArrIndex < romanLiteralsArrSize && !strToVerify.isEmpty()) {
                    var curLiteral: String = romanLiteralsArr[romanLiteralsArrIndex]
                    // Since each valid numeral is evaluated only once, we'll read all of their occurrences.
                    while (strToVerify.startsWith(curLiteral)) {
                        strToVerify = strToVerify.substring(curLiteral.length)
                    }

                    romanLiteralsArrIndex++
                }
                // An empty string at this stage indicates that we have successfully passed through the entire number without encountering any misplaced numerals.
                isRomanNumber = strToVerify.isEmpty()
            }

            return isRomanNumber;
        }

        /**
         * Determines if a string holds a valid roman char number of occurrences.
         * @return true or false.
         */
        private fun isValidRomanCharNumOfOccurrences(str: String): Boolean {
            var isValidRomanCharNumOfOccurrences: Boolean = true
            var strCharArr: CharArray = str.toCharArray()
            var charArrIndex: Int = 0
            var vCharCount: Int = 0
            var lCharCount: Int = 0
            val strCharArrSize: Int = strCharArr.size

            while (charArrIndex < strCharArrSize) {
                var curChar = strCharArr[charArrIndex]
                // If the current char is 'X'/'I'/'C', verify that the next 3 chars aren't equal to it.
                if (curChar == 'X' || curChar == 'I' || curChar == 'C') {
                    if (charArrIndex + 3 < strCharArrSize &&
                            curChar == strCharArr[charArrIndex + 1] &&
                            curChar == strCharArr[charArrIndex + 2] &&
                            curChar == strCharArr[charArrIndex + 3]) {
                        isValidRomanCharNumOfOccurrences = false
                        break
                    }
                // If the current char is equal to 'V'/'L', increment the corresponding counter and check if it's bigger than 1.
                } else if (curChar == 'V') {
                    if (++vCharCount > 1) {
                        isValidRomanCharNumOfOccurrences = false
                        break
                    }
                } else if (curChar == 'L') {
                    if (++lCharCount > 1) {
                        isValidRomanCharNumOfOccurrences = false
                        break
                    }
                // If the current char isn't equal to 'X'/'I'/'C'/'V'/'L', than it's not a valid roman numeral.
                } else {
                    isValidRomanCharNumOfOccurrences = false
                    break
                }

                charArrIndex++
            }

            return isValidRomanCharNumOfOccurrences
        }
    }
}