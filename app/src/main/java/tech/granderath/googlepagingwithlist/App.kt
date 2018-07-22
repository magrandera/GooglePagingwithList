package tech.granderath.googlepagingwithlist

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class KudosApp : DaggerApplication() {

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerApplicationComponent.create()
  }
}
