class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckingAccount(var charge: Double = 1.0, initialBalance: Double) extends BankAccount(initialBalance) {
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


trait Has3FreeTransactions extends CheckingAccount {
  val freeTransactionsPerMonth = 3
  private var transactionCount = 0

  override def deposit(amount: Double) = {
    if (transactionCount < freeTransactionsPerMonth) {
      charge = 0
      super.deposit(amount)
    } else {
      charge = 1
      super.deposit(amount)
    }
    transactionCount+=1
    currentBalance
  }

  def resetTransactionCount = transactionCount = 0
}

class SavingsAccount extends CheckingAccount(initialBalance = 0)  with Has3FreeTransactions {
  def earnMonthlyInterest = {
    deposit(currentBalance + (0.01 * currentBalance))
    resetTransactionCount
  }

}

val c3 = new SavingsAccount
c3.deposit(10)
c3.deposit(10)
c3.deposit(10)
c3.deposit(10)
c3.deposit(10)
c3.currentBalance
c3.earnMonthlyInterest
c3.currentBalance
c3.deposit(10)
c3.deposit(10)
