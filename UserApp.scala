package scalaprep.day1

object UserApp extends App{

  trait UserService {
    def getUser (id:String) : Option[User]

  }

  case class User (id:String, name:String, age:Int)

  class UserServiceImpl extends UserService {
    private val users = Map (
      "1" -> User("1", "Alice",30),
      "2" -> User("1", "Bob",25)
    )

    def getUser (id:String) : Option[User] = users.get(id)
  }


  def fetchUserDetails (service: UserServiceImpl, userId: String): String = {
    service.getUser(userId) match {
      case Some(user) => s"User found: ${user.name}, age ${user.age}"
      case None => "User not found"

    }

  }

val userService = new UserServiceImpl

println(fetchUserDetails(userService, "1"))
  println(fetchUserDetails(userService, "3"))



}
