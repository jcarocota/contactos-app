package com.ebc.contactos_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebc.contactos_app.dao.ContactDao
import com.ebc.contactos_app.enity.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ContactViewModel(private val dao: ContactDao): ViewModel() {
    val contacts: StateFlow<List<Contact>> = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())


    fun addContact(name: String, phone: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val myContact = Contact(name = name, phone = phone)
            dao.insert(myContact)
        }

    }

    fun editContact(myContact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(myContact)
        }
    }

    fun removeContact(myContact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.delete(myContact)
        }
    }
}