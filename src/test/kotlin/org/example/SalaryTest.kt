package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SalaryTest {
    companion object {
        private const val BASE_SALARY_DEV: Double = 5000.00
        private const val BASE_SALARY_QA: Double = 6000.00
    }

    @Test
    fun `Salary Increase When Period Worked Is Long`() {
        val salary = Salary(WorkerDev(BASE_SALARY_DEV), 25)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(5600.0, actual)
    }

    @Test
    fun `Salary Increase When Period Worked Is Medium`() {
        val salary = Salary(WorkerQA(BASE_SALARY_QA), 15)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(6480.0, actual)
    }

    @Test
    fun `Salary Increase When Period Worked Is Short`() {
        val salary = Salary(WorkerDev(BASE_SALARY_DEV), 5)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(5150.0, actual)
    }

    @Test
    fun `Salary Increase When The Increase Is Not Applicable`() {
        val salary = Salary(WorkerQA(BASE_SALARY_QA), 3)
        salary.applyIncreaseByPeriod()
        val actual = salary.getSalaryWithIncrease()

        assertEquals(BASE_SALARY_QA, actual)
    }
}