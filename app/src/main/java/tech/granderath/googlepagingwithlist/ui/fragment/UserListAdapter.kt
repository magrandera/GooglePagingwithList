package tech.granderath.googlepagingwithlist.ui.fragment

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_list_item.view.userName
import kotlinx.android.synthetic.main.user_list_item.view.userUserName
import tech.granderath.googlepagingwithlist.R
import tech.granderath.googlepagingwithlist.model.User
import tech.granderath.googlepagingwithlist.ui.fragment.UserListAdapter.UserViewHolder

class UserListAdapter : PagedListAdapter<User, UserViewHolder>(DIFF_CALLBACK) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
    val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
    return UserViewHolder(inflatedView)
  }

  override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
    val user = getItem(position)
    if (user != null) {
      holder.bindUser(user)
    }
  }

  class UserViewHolder(
    var view: View
  ): RecyclerView.ViewHolder(view) {

    fun bindUser(user: User) {
      view.userName.text = user.name
      view.userUserName.text = user.username
    }
  }

  companion object {
    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {

      override fun areItemsTheSame(oldUser: User,
                                   newUser: User): Boolean =
        oldUser.username == newUser.username

      override fun areContentsTheSame(oldUser: User,
                                      newUser: User): Boolean =
        oldUser == newUser
    }
  }
}
