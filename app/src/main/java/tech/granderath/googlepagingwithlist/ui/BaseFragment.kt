package tech.granderath.googlepagingwithlist.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import tech.granderath.googlepagingwithlist.di.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel> : DaggerFragment() {

  @Inject
  lateinit var viewModelFactory: ViewModelFactory

  internal lateinit var viewModel: VM

  inline fun <reified VM : ViewModel> getViewModel(): VM = ViewModelProviders.of(this, viewModelFactory).get(VM::class.java)
}
