package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SalaryTest {
    companion object {
        private const val BASE_SALARY_DEV: Double = 5000.00
        private const val BASE_SALARY_QA: Double = 6000.00
    }

    @Test
    fun `Salary Increase When Period Worked Is Long - DEV`() {
        val salary = Salary(WorkerDev(BASE_SALARY_DEV), 25)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(5600.0, actual)
    }

    @Test
    fun `Salary Increase When Period Worked Is Long - QA`() {
        val salary = Salary(WorkerQA(BASE_SALARY_QA), 25)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(7200.0, actual)
    }


    @Test
    fun `Salary Increase When Period Worked Is Medium - DEV`() {
        val salary = Salary(WorkerDev(BASE_SALARY_DEV), 15)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(5300.0, actual)
    }

    @Test
    fun `Salary Increase When Period Worked Is Medium - QA`() {
        val salary = Salary(WorkerQA(BASE_SALARY_QA), 15)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(6480.0, actual)
    }

    @Test
    fun `Salary Increase When Period Worked Is Short - DEV`() {
        val salary = Salary(WorkerDev(BASE_SALARY_DEV), 5)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(5150.0, actual)
    }

    @Test
    fun `Salary Increase When Period Worked Is Short - QA`() {
        val salary = Salary(WorkerQA(BASE_SALARY_QA), 5)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(6300.0, actual)
    }

    @Test
    fun `Salary Increase When The Increase Is Not Applicable`() {
        val salary = Salary(WorkerQA(BASE_SALARY_QA), 3)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(BASE_SALARY_QA, actual)
    }
}