package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_portal.*

const val NEW_PORTAL = "NEW_PORTAL"

class AddPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)
        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a portal!"
        btnAddPortal.setOnClickListener { onSaveClick() }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun onSaveClick() {
        val title = inpTitle.text.toString()
        val url = inpUrl.text.toString()
        if (title.isNotBlank() && url.isNotBlank()) {
            val portal = Portal(title,url)
            val resultIntent = Intent()
            resultIntent.putExtra(NEW_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The title and url cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }
    }
}
