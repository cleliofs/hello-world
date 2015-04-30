class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckingAccount(charge: Double = 1.0, initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double) = super.deposit(amount - charge)
  override def withdraw(amount: Double) = super.withdraw(amount + charge)

}

object CheckingAccount {
  def apply(charge: Double, initialBalance: Double) = new CheckingAccount(charge, initialBalance)
}

val c1 = new CheckingAccount(initialBalance = 10.0)
val c2 = CheckingAccount(1.0, 10.0)
//c2.deposit(10)
//c2.currentBalance
c2.withdraw(8)
c2.currentBalance


class SavingsAccount extends BankAccount(initialBalance = 0) {
  private var transactionCount = 0
  def earnMonthlyInterest = {
    deposit(currentBalance + (0.01 * currentBalance))
    transactionCount=0
  }
}