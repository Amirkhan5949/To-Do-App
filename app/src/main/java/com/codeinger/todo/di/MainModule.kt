package com.codeinger.todo.di

import android.content.Context
import com.codeinger.todo.data.room.dao.CaregoryDao
import com.codeinger.todo.data.room.dao.KeepDao
import com.codeinger.todo.data.room.database.MyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun getCategoryDao(myDataBase: MyDataBase): CaregoryDao = myDataBase.categoryDao()

    @Provides
    @Singleton
    fun getKeepDao(myDataBase: MyDataBase ): KeepDao = myDataBase.keepDao()

    @Provides
    @Singleton
    fun getMyRoomDataBase(@ApplicationContext appContext: Context) : MyDataBase = MyDataBase.getDatabase(appContext)

}
