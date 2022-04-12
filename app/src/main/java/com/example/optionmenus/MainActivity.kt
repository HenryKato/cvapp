package com.example.optionmenus

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myframgmentapp.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assign and get the object for the FragmentManager by using the below statements
        // supportFragmentManager.beginTransaction().add(R.id.frame1, HomeFragment()).commit()
        fmanager = supportFragmentManager
        //get the object for FragmentTransaction and Initialize the transaction
        tx = fmanager.beginTransaction()
        /* by default we are going to show the HomeFragment in onCreate() method using add() method
            * add() method accepts two parameters -
            * 1. id of fragment 2.object of Fragment class*/
        tx.add(R.id.frame1, HomeFragment())
        // Commit the fragment transaction
        tx.commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
       // Code to get the title and icon on the option overflow
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item:MenuItem):Boolean {
        Toast.makeText(
            applicationContext,
            item.title.toString(),
            Toast.LENGTH_LONG).show()

        //Display the fragment of that item
        when(item.itemId){
            R.id.home -> {
                tx = fmanager.beginTransaction()
                // when the user selects the Home button, we are replacing the HomeFragment
                tx.replace(R.id.frame1, HomeFragment())
                tx.commit()
            }

            R.id.contact -> {
                tx = fmanager.beginTransaction()
                // when the user selects the Home button, we are replacing the HomeFragment
                tx.replace(R.id.frame1, ContactFragment())
                tx.commit()
            }
            R.id.education -> {
                tx = fmanager.beginTransaction()
                // when the user selects the Home button, we are replacing the HomeFragment
                tx.replace(R.id.frame1, EducationFragment())
                tx.commit()
            }
            R.id.skills -> {
                tx = fmanager.beginTransaction()
                // when the user selects the Home button, we are replacing the HomeFragment
                tx.replace(R.id.frame1, SkillsFragment())
                tx.commit()
            }
            R.id.references -> {
                tx = fmanager.beginTransaction()
                // when the user selects the Home button, we are replacing the HomeFragment
                tx.replace(R.id.frame1, ReferencesFragment())
                tx.commit()
            }
            R.id.work -> {
                tx = fmanager.beginTransaction()
                // when the user selects the Home button, we are replacing the HomeFragment
                tx.replace(R.id.frame1, WorkFragment())
                tx.commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
