package com.example.scorecheckingapp.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.R.layout.activity_football
import com.example.scorecheckingapp.databinding.ActivityFootballBinding
import com.example.scorecheckingapp.fragments.FootballFavouriteFragment
import com.example.scorecheckingapp.fragments.FootballNewsFragment
import com.example.scorecheckingapp.fragments.FootballScoreFragment
import com.example.scorecheckingapp.fragments.FootballWatchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class FootballActivity : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityFootballBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFootballBinding.inflate(layoutInflater)

        //Used for giving activity only night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(binding.root)

        drawerLayout = findViewById(R.id.footballActivityId)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent = Intent(this, activity_football::class.java)

        setFragments(FootballScoreFragment(),"Score")

        binding.bottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_scores -> setFragments(FootballScoreFragment(),"Score")
                R.id.menu_favourites -> setFragments(FootballFavouriteFragment(),"Favourite")
                R.id.menu_news -> setFragments(FootballNewsFragment(),"News")
                R.id.menu_watch -> setFragments(FootballWatchFragment(),"Watch")
                else -> true
            }
        }

        binding.optionMenuDrawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.option_menu_cricket -> setActivity(CricketActivity())
                else -> setActivity(FootballActivity())
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(actionBarDrawerToggle.onOptionsItemSelected(item)){
           return true
       }

        return super.onOptionsItemSelected(item)
    }


    private fun setFragments(fragment: Fragment, tag: String): Boolean {
        supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment_container, fragment, tag)
            title = tag
            addToBackStack(title as String)
            commit()
        }
        return true
    }

    private fun setActivity(activity: Activity): Boolean {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
        return true

    }  }

private fun BottomNavigationView.selectedItemId(menuNews: Int) {

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
