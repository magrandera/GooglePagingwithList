package tech.granderath.googlepagingwithlist.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
  private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    val creator: Provider<out ViewModel> = creators[modelClass]
        ?: creators.entries.find { (key, _) -> modelClass.isAssignableFrom(key) }?.value
        ?: throw IllegalArgumentException("unknown model class $modelClass")

    @Suppress("UNCHECKED_CAST")
    return creator.get() as T
  }
}
