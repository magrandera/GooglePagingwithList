package tech.granderath.googlepagingwithlist

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import tech.granderath.googlepagingwithlist.di.CommonModule
import tech.granderath.googlepagingwithlist.di.DaggerApplicationComponent
import javax.inject.Inject


class App : DaggerApplication() {

  @Inject
  lateinit var mActivityInjector: DispatchingAndroidInjector<Activity>

  @Inject
  lateinit var mFragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun activityInjector(): DispatchingAndroidInjector<Activity> {
    return mActivityInjector
  }

  override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
    return mFragmentInjector
  }

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerApplicationComponent.builder()
      .commonModule(CommonModule(applicationContext))
      .build()
  }
}
