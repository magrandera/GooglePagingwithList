package tech.granderath.googlepagingwithlist.di

import android.content.Context
import dagger.Module
import dagger.Provides
import tech.granderath.googlepagingwithlist.data.UserRepository

@Module
class CommonModule(
  private val appContext: Context
) {

  @Provides
  fun provideAppContext() = appContext

  @Provides
  fun providesUserRepository() = UserRepository()
}
