package main.scala.cake

/**
 * Created by csouza on 20/05/2015.
 */
object Application extends App with ApplicationContext {
  userService.save(User("cleliofs"))
  userService.save(User("testuser"))
  userService.save(User("newuser"))
  userService.save(User("newuser2"))
  userService.findAll.foreach(println)
}
