package com.example.resultactcal

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.resultactcal.databinding.ActivityTaskManagementBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TaskManagementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTaskManagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTaskManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.bottomNavigationView

        val navController = findNavController(R.id.nav_host_fragment_activity)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_create_task,
                R.id.navigation_to_do,
                R.id.navigation_doing,
                R.id.navigation_done
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sign_out_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.sign_out) {
            val intent = Intent(this, LoginSignupActivity::class.java)
            intent.putExtra(LoginSignupActivity.RESET, LoginSignupActivity.SIGN_OUT)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}