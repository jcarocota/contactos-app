package com.ebc.contactos_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.ebc.contactos_app.viewmodel.ContactViewModel
import com.ebc.contactos_app.viewmodel.ContactViewModelFactory

@Composable
fun ContactScreen(vm:ContactViewModel, modifier: Modifier = Modifier) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val contactList by vm.contacts.collectAsState()

    Column(
        Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = {phone = it},
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                vm.addContact(name, phone)
            }
        ) {
            Text("Agregar Contacto")
        }
        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(contactList) { contact ->
                Row(
                    Modifier.fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(text = contact.name)
                        Text(text = contact.phone)
                    }
                }
            }
        }
    }

}
