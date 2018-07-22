package tech.granderath.googlepagingwithlist.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.fragmentContainer
import tech.granderath.googlepagingwithlist.R
import tech.granderath.googlepagingwithlist.ui.fragment.UserListFragment

class UserListActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (supportFragmentManager.findFragmentById(fragmentContainer.id) == null) {
      supportFragmentManager.beginTransaction().apply {
        add(fragmentContainer.id, UserListFragment())
      }.commit()
    }
  }
}
