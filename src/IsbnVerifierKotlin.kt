fun isValid(stringToVerify: String): Boolean {
    val cleanIsbn = stringToVerify.filterNot { it == '-' }

    if (cleanIsbn.length != 10) {
        return false
    }

    if (cleanIsbn.substring(0, 9).contains('X')) {
        return false
    }

    try {
        val sum = cleanIsbn
            .mapIndexed { index, char ->
                val digit = if (char == 'X' && index == 9) {
                    10
                } else {
                    char.toString().toIntOrNull() ?: throw NumberFormatException("")
                }
                val weight = 10 - index
                weight * digit
            }
            .sum()

        val isValid = sum % 11 == 0
        return isValid
    } catch (e: NumberFormatException) {
        println(e.message)
        return false
    }
}