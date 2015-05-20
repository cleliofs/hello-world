package main.scala.cake

/**
 * Created by csouza on 20/05/2015.
 */
trait UserRepositoryComponent {
  def userLocator: UserLocator
  def userUpdater: UserUpdater

  trait UserLocator {
    def findAll: List[User]
  }

  trait UserUpdater {
    def save(user: User)
  }
}
