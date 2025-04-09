package dev.alexrodrigues.labs_csd_228.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.alexrodrigues.labs_csd_228.data.dao.UserDao
import dev.alexrodrigues.labs_csd_228.data.dao.ShiftDao
import dev.alexrodrigues.labs_csd_228.data.entities.UserEntity
import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity

/**
 * The Room database for this app
 */
@Database(entities = [UserEntity::class, ShiftEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun shiftDao(): ShiftDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Get the singleton instance of the database
         * @param context The application context
         */
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}