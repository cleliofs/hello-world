package main.scala.cake

/**
 * Created by csouza on 20/05/2015.
 */
trait DefaultUserServiceComponent extends UserServiceComponent {
  this: UserRepositoryComponent =>

  def userService = new DefaultUserService

  class DefaultUserService extends UserService {
    override def findAll: List[User] = userLocator.findAll

    override def save(user: User): Unit = userUpdater.save(user)
  }
}
