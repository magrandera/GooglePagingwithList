package tech.granderath.googlepagingwithlist.data

import tech.granderath.googlepagingwithlist.model.User
import javax.inject.Singleton

@Singleton
class UserRepository {

  private val users = mutableListOf<User>()

  init {
    for (i in 0..100) {
      users.add(User("tester$i", "Tester Num$i"))
    }
  }

  fun getUsers() : List<User> {
    return users
  }
}
