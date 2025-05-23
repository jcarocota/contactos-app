package com.ebc.contactos_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ebc.contactos_app.dao.ContactDao

class ContactViewModelFactory(private val dao: ContactDao) : ViewModelProvider.Factory  {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(ContactViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContactViewModel(dao) as T
        }

        throw IllegalArgumentException("El parámetro no es de tipo ContactViewModel")
    }
}