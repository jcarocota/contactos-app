package com.ebc.contactos_app.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ebc.contactos_app.dao.ContactDao
import com.ebc.contactos_app.enity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao
}