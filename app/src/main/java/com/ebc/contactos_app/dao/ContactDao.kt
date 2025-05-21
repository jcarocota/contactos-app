package com.ebc.contactos_app.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ebc.contactos_app.enity.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert
    fun insert(contact: Contact): Long

    @Update
    fun update(contact: Contact): Int

    @Delete
    fun delete(contact: Contact): Int

    @Query("SELECT * FROM contacts ORDER BY id DESC")
    fun getAll(): Flow<List<Contact>>
}