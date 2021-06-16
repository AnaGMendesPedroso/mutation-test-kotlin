package org.example

import kotlin.math.round

class Salary(
    private var worker: Worker,
    private var periodWorked: Int
) {
    private companion object {
        const val LONG_PERIOD: Int = 25

        const val SHORT_PERIOD: Int = 5

        const val MIDDLE_PERIOD: Int = 15
    }
    private var salaryWithIncrease: Double = this.worker.baseSalary
    private val qaFee: QAFee = QAFee()
    private val devFee: DevFee = DevFee()

    fun applyIncreaseByPeriod() {
        if (this.periodWorked >= LONG_PERIOD && this.worker.role == "DEV") {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.worker.baseSalary, this.devFee.maximumIncrease)
            return
        }

        if (this.periodWorked >= LONG_PERIOD && this.worker.role == "QA") {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.worker.baseSalary, this.qaFee.maximumIncrease)
            return
        }

        if (this.periodWorked >= MIDDLE_PERIOD && this.worker.role == "DEV") {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.worker.baseSalary, this.devFee.mediumIncrease)
            return
        }

        if (this.periodWorked >= MIDDLE_PERIOD && this.worker.role == "QA") {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.worker.baseSalary, this.qaFee.mediumIncrease)
            return
        }

        if (this.periodWorked >= SHORT_PERIOD && this.worker.role == "DEV") {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.worker.baseSalary, this.devFee.minimumIncrease)
        }

        if (this.periodWorked >= SHORT_PERIOD && this.worker.role == "QA") {
            this.salaryWithIncrease += this.calculateIncreaseAmount(this.worker.baseSalary, this.qaFee.minimumIncrease)
        }
    }

    private fun calculateIncreaseAmount(baseSalary: Double, fee: Double): Double {
        return round((baseSalary / 100) * fee)
    }

    fun getSalaryWithIncrease(): Double {
        return this.salaryWithIncrease
    }
}