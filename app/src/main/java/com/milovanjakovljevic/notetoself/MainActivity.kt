package com.milovanjakovljevic.notetoself

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milovanjakovljevic.notetoself.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    //private var tempNote = Note()
    private val noteList = ArrayList<Note>()
    private var recyclerView: RecyclerView? = null
    private var adapter: NoteAdapter? = null
    private var showDividers:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)



        binding.fab.setOnClickListener { view ->
            val dialog=DialogNewNote()
            dialog.show(supportFragmentManager,"")
        }
        recyclerView =
            findViewById<View>(R.id.recyclerView)
                    as RecyclerView
        adapter = NoteAdapter(this, noteList)
        val layoutManager =
            LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
// Add a neat dividing line between items in the list

// set the adapter
        recyclerView!!.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        val prefs=getSharedPreferences("Note to self",Context.MODE_PRIVATE)
        showDividers=prefs.getBoolean("dividers",true)
        // Add a neat dividing line between list items
        if (showDividers)
            recyclerView!!.addItemDecoration(
                DividerItemDecoration(
                    this, LinearLayoutManager.VERTICAL))
        else {
            // check there are some dividers
            // or the app will crash
            if (recyclerView!!.itemDecorationCount > 0)
                recyclerView!!.removeItemDecorationAt(0)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this,SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else ->super.onOptionsItemSelected(item)
        }
    }

  /*  override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
    fun createNewNote(n: Note) {
        // Temporary code
        //tempNote = n
        noteList.add(n)
        adapter!!.notifyDataSetChanged()
    }
    fun showNote(noteToShow: Int) {
        val dialog = DialogShowNote()
        dialog.sendNoteSelected(noteList[noteToShow])
        dialog.show(supportFragmentManager, "")
    }
}