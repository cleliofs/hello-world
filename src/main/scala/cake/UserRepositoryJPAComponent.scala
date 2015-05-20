package main.scala.cake

/**
 * Created by csouza on 20/05/2015.
 */
trait UserRepositoryJPAComponent extends UserRepositoryComponent {
  val em: EntityManager
  def userLocator = new UserLocatorJPA(em)
  def userUpdater = new UserUpdaterJPA(em)

  class UserLocatorJPA(val em: EntityManager) extends UserLocator {
    override def findAll: List[User] = em.findAll
  }
  class UserUpdaterJPA(val em: EntityManager) extends UserUpdater {
    override def save(user: User): Unit = em.save(user)
  }
}
