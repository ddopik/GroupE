package com.example.ComposeExampleApp.contectlist.ui.main.model





class Contact(val name: String )







private var lastContactId = 0
fun createContactsList(numContacts: Int): ArrayList<Contact> {
    val contacts = ArrayList<Contact>()
    for (i in 1..numContacts) {
        contacts.add( Contact("Person " + ++lastContactId)    )
    }
    return contacts
}
