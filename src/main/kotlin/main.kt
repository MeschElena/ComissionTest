enum class TypeCard {
    Mastercard, Visa, VKPay, Maestro, Mir
}

fun main() {
    val typeCard: TypeCard = TypeCard.Mastercard
    val summaMonth = 100000_00
    val transfer = 20000_00

    if (limit(transfer, summaMonth, typeCard)) {
        val comission = calcComission(transfer, summaMonth, typeCard)
        println("Ваша комиссия составила: $comission")
    } else println("Операция не проведена. Вы превысили лимит.")
}

fun calcComission(
    transfer: Int,
    summaMonth: Int = 0,
    typeCard: TypeCard = TypeCard.VKPay
): Int {
    return when (typeCard) {
        TypeCard.Maestro, TypeCard.Mastercard -> if (transfer + summaMonth <= 75000_00) 0 else (transfer * 0.006).toInt() + 20_00
        TypeCard.Visa, TypeCard.Mir -> if ((transfer * 0.0075).toInt() <= 35_00) 35_00 else (transfer * 0.0075).toInt()
        TypeCard.VKPay -> 0
    }
}

fun limit(
    transfer: Int,
    summaMonth: Int = 0,
    typeCard: TypeCard = TypeCard.VKPay
): Boolean {
    return if (typeCard == TypeCard.VKPay) {
        transfer <= 15000_00 && summaMonth + transfer <= 40000_00
    } else {
        transfer <= 150000_00 && summaMonth + transfer <= 600000_00
    }
}