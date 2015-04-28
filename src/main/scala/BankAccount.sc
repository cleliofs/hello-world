import java.math.{BigDecimal => BigDecimal}

class BankAccount {
  private var _balance = new BigDecimal("0") ;

  def balance = _balance

  def deposit(amount: Double): Unit = {
    _balance = _balance.add(new BigDecimal(amount))
  }

  def deposit(amount: BigDecimal): Unit = {
    _balance=_balance.add(amount)
  }

  def withdraw(amount: BigDecimal): Unit = {
    _balance=_balance.subtract(amount)
  }
}

val b = new BankAccount
b.deposit(10.00)
b.deposit(20.00)
b.balance