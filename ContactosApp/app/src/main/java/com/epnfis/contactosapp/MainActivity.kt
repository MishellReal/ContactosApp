package com.epnfis.contactosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*var db = DatabaseHandler(this)

        Log.d("Insert", "Inserting...");
        db.addContact(contact("AAA", "1233211232"));
        Log.d("Insert AAA", "Success!");
        db.addContact(contact("BBB", "9143493981"));
        Log.d("Insert BBB", "Success!");


        Log.d("Reading:", "Reading all contacts...")
        val contacts = db.getAllContacts()
        for (cn in contacts) {
            val log = "Id: " + cn.id + " ,Name: " + cn.name + " ,Phone: " +
                    cn.phone_number
            Log.d("Name: ", log)
        }


        Log.d("Update:", "AAA->CCC")
        val contact1 = db.getContact(2)
        Log.d("Old Contact", contact1.name)
        contact1.name = "CCC"
        contact1.phone_number = "321321321"
        Log.d("New Contact", contact1.name)
        db.updateContact(contact1)

        Log.d("Deleting:", "Deleting all contacts...")
        for (c in contacts) {
            val log = "Id: " + c.id + " ,Name: " + c.name + " ,Phone: " +
                    c.phone_number
            Log.d("Delete: ", log)
            db.deleteContact(c)
        }*/

    }

    fun onclickButtonInsertar (view: View){
        var intentInsertar = Intent(this, IngresarContactoActivity::class.java)
        startActivity(intentInsertar)

    }

    fun onclickButtonModificar (view: View){
        var intentModificar = Intent(this, ModificarContactoActivity::class.java)
        startActivity(intentModificar)

    }

    fun onclickButtonConsultarId (view: View){
        var intentConsultarId = Intent(this, ConsultarIdActivity::class.java)
        startActivity(intentConsultarId)

    }

    fun onclickButtonEliminar (view: View){
        var intentEliminar = Intent(this, EliminarContactoActivity::class.java)
        startActivity(intentEliminar)

    }

    fun onclickButtonConsultar (view: View){
        var intentConsultar = Intent(this, ConsultarContactoActivity::class.java)
        startActivity(intentConsultar)

    }


}

