import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcComission_Mastercard() {
        //arrange
        val transfer = 20000_00
        val summaMonth = 100000_00
        val typeCard = TypeCard.Mastercard

        //act
        val result = calcComission(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(15000, result)
    }

    @Test
    fun calcComission_Visa() {
        //arrange
        val transfer = 20000_00
        val summaMonth = 100000_00
        val typeCard = TypeCard.Visa

        //act
        val result = calcComission(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(15000, result)
    }

    @Test
    fun calcComission_VKPay() {
        //arrange
        val transfer = 20000_00
        val summaMonth = 100000_00
        val typeCard = TypeCard.VKPay

        //act
        val result = calcComission(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(0, result)
    }

    @Test
    fun calcComission_Mir() {
        //arrange
        val transfer = 200_00
        val summaMonth = 100000_00
        val typeCard = TypeCard.Mir

        //act
        val result = calcComission(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(3500, result)
    }

    @Test
    fun calcComission_Maestro() {
        //arrange
        val transfer = 200_00
        val summaMonth = 10000_00
        val typeCard = TypeCard.Maestro

        //act
        val result = calcComission(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(0, result)
    }

    @Test
    fun calcComission_default() {
        //arrange
        val transfer = 2000_00
    //    val summaMonth = 10000_00
      //  val typeCard = TypeCard.Maestro

        //act
        val result = calcComission(
            transfer = transfer,
       //     summaMonth = summaMonth,
      //      typeCard = typeCard
        )

        //assert
        assertEquals(0, result)
    }

    @Test
    fun limit_Maestro() {
        //arrange
        val transfer = 200_00
        val summaMonth = 10000_00
        val typeCard = TypeCard.Maestro

        //act
        val result = limit(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(true, result)
    }

    @Test
    fun limit_VKPay() {
        //arrange
        val transfer = 2000_00
        val summaMonth = 10000_00
        val typeCard = TypeCard.VKPay

        //act
        val result = limit(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(true, result)
    }

    @Test
    fun limit_default() {
        //arrange
        val transfer = 20000_00
        val summaMonth = 10000_00
     //   val typeCard = TypeCard.VKPay

        //act
        val result = limit(
            transfer = transfer,
            summaMonth = summaMonth,
      //      typeCard = typeCard
        )

        //assert
        assertEquals(false, result)
    }

    @Test
    fun limit_Visa() {
        //arrange
        val transfer = 20000_00
        val summaMonth = 1000000_00
        val typeCard = TypeCard.Visa

        //act
        val result = limit(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(false, result)
    }

    @Test
    fun limit_MasterCard() {
        //arrange
        val transfer = 200000_00
        val summaMonth = 10000_00
        val typeCard = TypeCard.Mastercard

        //act
        val result = limit(
            transfer = transfer,
            summaMonth = summaMonth,
            typeCard = typeCard
        )

        //assert
        assertEquals(false, result)
    }
}