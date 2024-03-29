package com.example.scorecheckingapp.activity

import android.app.AlertDialog
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.Settings.ACTION_SETTINGS
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.databinding.ActivityFootballBinding
import com.example.scorecheckingapp.fragments.*
import com.example.scorecheckingapp.fragments.Cricket.CricketScoreTabFragment
import com.example.scorecheckingapp.fragments.Football.*
import com.example.scorecheckingapp.fragments.News.NewsFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import java.util.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(),
    InternetBroadcastReceiver.ConnectivityReceiverListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityFootballBinding
    private var snackbar: Snackbar? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFootballBinding.inflate(layoutInflater)

        //Used for giving activity only night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setContentView(binding.root)

        registerReceiver(
            InternetBroadcastReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )

        drawerLayout = findViewById(R.id.footballActivityId)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FootballScoreTabFragment()).commit()
        setBottomMenu(FootballScoreTabFragment(), "LiveScore")
    }


    private fun setBottomMenu(bottomFragment: Fragment, title: String): Boolean {
        binding.bottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_scores -> setFragments(bottomFragment, title)
                R.id.menu_favourites -> setFragments(FavouriteFragment(), "Favourite")
                R.id.menu_news -> setFragments(NewsFragment(), "News")
//                R.id.menu_watch -> setFragments(WatchFragment(), "Watch")
                else -> true
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            binding.optionMenuDrawer.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.option_menu_football -> {
                        setBottomMenu(
                            FootballScoreTabFragment(),
                            "LiveScore"
                        ); setFragments(FootballScoreTabFragment(), "LiveScore");

                        binding.bottomNavMenu.menu.findItem(R.id.menu_scores)
                            .setIcon(R.drawable.football)
                        true
                    }
                    R.id.option_menu_cricket -> {
                        setBottomMenu(CricketScoreTabFragment(), "LiveScore");setFragments(
                            CricketScoreTabFragment(),
                            "LiveScore"
                        );
                        binding.bottomNavMenu.menu.findItem(R.id.menu_scores)
                            .setIcon(R.drawable.cricket_ball)
                        true
                    }

                    R.id.options_menu_help -> {
                        setFragments(HelpFragment(), "Help")
                    }

                    R.id.options_menu_aboutUS -> {
                        setFragments(AboutUsFragment(), "AboutUs")
                    }
                    R.id.options_menu_account -> {
                        setFragments(AccountFragment(), "Account")
                    }
                    else -> setBottomMenu(FootballScoreTabFragment(), "LiveScore")
                }
            }
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    private fun setFragments(fragment: Fragment, title: String): Boolean {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            setTitle(title)
            addToBackStack(null)
            commit()
            drawerLayout.closeDrawers()
        }
        return true
    }


    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected)
    }

    override fun onResume() {
        super.onResume()
        InternetBroadcastReceiver.connectivityReceiverListener = this
    }

    private fun showNetworkMessage(isConnected: Boolean) {
        val builder = AlertDialog.Builder(this)
        val alertDialog: AlertDialog
        if (!isConnected) {
            snackbar = Snackbar.make(
                findViewById(R.id.footballActivityId),
                "You Are Offline !!",
                Snackbar.LENGTH_SHORT
            )
            snackbar?.duration = BaseTransientBottomBar.LENGTH_INDEFINITE
            snackbar?.show()

            builder.setMessage("Check Your Internet Connection !!")
            builder.setTitle("No Internet")
            builder.setCancelable(true)
            builder.setPositiveButton("Settings") { dialog, which ->
                startActivity(Intent(ACTION_SETTINGS))
            }
            builder.setNegativeButton("Back") { dialog, which ->
                finish()
            }

            alertDialog = builder.create()
            alertDialog.show()

        } else {
            snackbar?.dismiss()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

}

/*


     override fun onBackPressed() {
        // if your using fragment then you can do this way
        val fragments = supportFragmentManager.backStackEntryCount;
        if (fragments == 1) {
           AlertDialog.Builder (this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",DialogInterface.OnClickListener() {
                    override fun onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();


        } else {
            if (supportFragmentManager.backStackEntryCount > 1) {
                supportFragmentManager.popBackStack();
                var selectedFragment: Nothing? = null;
                List<Fragment>() fragments = getSupportFragmentManager.getFragments ();
                for (Fragment fragment : fragments) {
                    if (fragment != null && fragment.isVisible()) {
                        selectedFragment = fragment;
                        break;
                    }
                }
                if (selectedFragment instanceof yourFirstFragment) {
                    navigation.setSelectedItemId(R.id.your_first_item);
                } if (selectedFragment instanceof yourSecondFragment) {
                    navigation.setSelectedItemId(R.id.your_second_item);
                } if (selectedFragment instanceof yourThirdFragment) {
                    navigation.setSelectedItemId(R.id.your_third_item);
                } else {
                    super.onBackPressed();
                }

            } else {
                super.onBackPressed();
            }
        }
    }


*/


/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.option_menu_football) {
            val intent = Intent(this, FootballActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.option_menu_cricket) {
            val intent = Intent(this, CricketActivity::class.java)
            startActivity(intent)

        }
        return true
    }
}*/

/* when(it.itemId.toInt()){
//                    R.id.option_menu_football -> R.layout.activity_football
          if (it.itemId == R.layout.activity_football){
              val intent = Intent(this, FootballActivity::class.java)
              startActivity(intent)
          } else if(it.itemId == R.layout.activity_cricket){
              val intent = Intent(this, CricketActivity::class.java)
              startActivity(intent)

          } ->*//*
 true

onOptionsItemSelected(R.menu.option_menu)
*/
