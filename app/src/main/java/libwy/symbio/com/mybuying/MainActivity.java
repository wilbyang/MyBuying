package libwy.symbio.com.mybuying;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import libwy.symbio.com.mybuying.model.Sku;
import libwy.symbio.com.mybuying.view.MakeOrderDialogFragment;
import libwy.symbio.com.mybuying.view.SkuFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
      SkuFragment.OnListFragmentInteractionListener,
      MakeOrderDialogFragment.MakeOrderDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        Boolean login = sharedPreferences.getBoolean("login", Boolean.FALSE);
        if (!login) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {

            setContentView(R.layout.activity_main);


            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

            // Setting ViewPager for each Tabs
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);
            tabs.setupWithViewPager(viewPager);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);


        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.nav_camera) {

            fragment = SkuFragment.newInstance("Products");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onListFragmentInteraction(Sku item) {

        Intent intent = new Intent(this, SkuDetailActivity.class);
        intent.putExtra("sku", item);

        startActivity(intent);
        /*
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
              MainActivity.this);
        LayoutInflater li = this.getLayoutInflater();
        View promptsView = li.inflate(R.layout.alert_dialog, null);
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder.setTitle("Title Dialog");
        alertDialogBuilder
              .setMessage("Message Dialog")
              .setCancelable(true)
              .setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int arg1) {
                            // Handle Positive Button

                        }
                    })
              .setNegativeButton("No",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int arg1) {
                            // Handle Negative Button
                            dialog.cancel();
                        }
                    });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        */


    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(SkuFragment.newInstance("milk_powder_food_supplements"), "奶粉辅食");
        adapter.addFragment(SkuFragment.newInstance("kids_nutrition"), "儿童营养");
        adapter.addFragment(SkuFragment.newInstance("adult_health"), "养生保健");
        adapter.addFragment(SkuFragment.newInstance("beauty"), "丽人美妆");
        adapter.addFragment(SkuFragment.newInstance("kids_daily"), "宝宝日用");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
