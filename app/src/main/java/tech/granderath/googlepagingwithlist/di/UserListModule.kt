package tech.granderath.googlepagingwithlist.di

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import tech.granderath.googlepagingwithlist.di.viewmodel.ViewModelKey
import tech.granderath.googlepagingwithlist.ui.fragment.UserListFragment
import tech.granderath.googlepagingwithlist.viewModel.UserListViewModel

@Module
interface UserListModule {

  @ContributesAndroidInjector
  fun contributesUserListFragment(): UserListFragment

  @Binds
  @IntoMap
  @ViewModelKey(UserListViewModel::class)
  fun bindUserListViewModel(vm: UserListViewModel): ViewModel
}
