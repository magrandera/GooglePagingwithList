package tech.granderath.googlepagingwithlist.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import tech.granderath.googlepagingwithlist.App
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AndroidSupportInjectionModule::class,
  CommonModule::class,
  UserListModule::class
])
interface ApplicationComponent : AndroidInjector<App>
