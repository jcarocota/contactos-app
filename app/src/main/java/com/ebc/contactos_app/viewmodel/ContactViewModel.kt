package com.ebc.contactos_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebc.contactos_app.dao.ContactDao
import com.ebc.contactos_app.enity.Contact
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ContactViewModel(private val dao: ContactDao): ViewModel() {
    val conacts: StateFlow<List<Contact>> = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}