package tech.granderath.googlepagingwithlist.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import android.arch.paging.RxPagedListBuilder
import io.reactivex.BackpressureStrategy.LATEST
import tech.granderath.googlepagingwithlist.data.ListDataSource
import tech.granderath.googlepagingwithlist.data.UserRepository
import tech.granderath.googlepagingwithlist.model.User
import javax.inject.Inject

class UserListViewModel @Inject constructor(
  private val userRepository: UserRepository
) : ViewModel() {
  val userList = RxPagedListBuilder(ListDataSource<User>(
      userRepository.getUsers()),
      PagedList.Config.Builder()
        .setPageSize(10)
        .setPrefetchDistance(10)
        .setInitialLoadSizeHint(10)
        .setEnablePlaceholders(true)
        .build()
      ).buildFlowable(LATEST)
}
