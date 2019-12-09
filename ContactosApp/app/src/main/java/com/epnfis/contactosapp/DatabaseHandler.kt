package com.epnfis.contactosapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues







class DatabaseHandler (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createContactsTable = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")")
        db.execSQL(createContactsTable)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }


    fun addContact(contact: contact)  {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(KEY_NAME, contact.name)
            put(KEY_PH_NO, contact.phone_number)
        }

        db.insert(TABLE_CONTACTS, null, values)
        db.close()
    }


    fun getContact(id: Int): contact {
        val db = this.readableDatabase

        val cursor = db.query(
            TABLE_CONTACTS, arrayOf(KEY_ID, KEY_NAME, KEY_PH_NO),
            "$KEY_ID=?", arrayOf(id.toString()), null, null, null, null
        )
        cursor?.moveToFirst()

        return contact(
            Integer.parseInt(cursor!!.getString(0)),
            cursor.getString(1), cursor.getString(2)
        )
    }


    fun getAllContacts(): List<contact> {
        val contactList = ArrayList<contact>()

        val sql_select = "SELECT * FROM $TABLE_CONTACTS"

        val db = this.readableDatabase
        val cursor = db.rawQuery(sql_select, null)

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                val contact = contact()
                contact.id = (Integer.parseInt(cursor.getString(0)))
                contact.name = (cursor.getString(1))
                contact.phone_number = (cursor.getString(2))
                contactList.add(contact)
            }
        }
        return contactList
    }


    fun updateContact(contact: contact): Int {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(KEY_NAME, contact.name)
            put(KEY_PH_NO, contact.phone_number)
        }

        return db.update( TABLE_CONTACTS, values, "$KEY_ID=?",  arrayOf(contact.id.toString())
        )
    }


    fun deleteContact(contact: contact) {
        val db = this.writableDatabase
        db.delete(
            TABLE_CONTACTS, "$KEY_ID =?",
            arrayOf(contact.id.toString())
        )
        db.close()
    }

    companion object {

        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "contactsManager.db"
        private const val TABLE_CONTACTS = "contacts"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PH_NO = "phone_number"
    }
}
