package tech.granderath.googlepagingwithlist.ui.fragment

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.user_list.userList
import tech.granderath.googlepagingwithlist.R
import tech.granderath.googlepagingwithlist.ui.BaseFragment
import tech.granderath.googlepagingwithlist.viewModel.UserListViewModel

class UserListFragment : BaseFragment<UserListViewModel>() {
  private val disposable = CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = getViewModel()
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.user_list, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val userListAdapter = UserListAdapter()

    with(userList) {
      val linearLayoutManager = LinearLayoutManager(view.context)
      layoutManager = linearLayoutManager
      adapter = userListAdapter
      addItemDecoration(DividerItemDecoration(requireContext(), linearLayoutManager.orientation))
    }

    disposable += viewModel.userList
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        userListAdapter.submitList(it)
      }, {
        Log.e("UserListFragment", it.message, it)
      })
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.clear()
  }
}
