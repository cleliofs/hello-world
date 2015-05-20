package main.scala.cake

/**
 * Created by csouza on 20/05/2015.
 */
trait EntityManager {
  def findAll: List[User]
  def save(user: User): Unit
}
