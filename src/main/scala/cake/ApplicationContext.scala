package main.scala.cake

import scala.collection.mutable.ListBuffer

/**
 * Created by csouza on 20/05/2015.
 */
trait ApplicationContext {

  // private
  val userServiceComponent = new DefaultUserServiceComponent with UserRepositoryJPAComponent {
    override val em: EntityManager = new EntityManager {
      var users: collection.mutable.Buffer[User] = new ListBuffer[User]

      override def findAll: List[User] = users.toList

      override def save(user: User): Unit = users+=user
    }
  }

  // public
  val userService = userServiceComponent.userService
}
