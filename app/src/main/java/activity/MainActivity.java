package activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

import com.example.candle.mimi.R;

import adapter.DisplayPageAdapter;

public class MainActivity extends FragmentActivity {
    //
    private ViewPager mainViewPager;

    //
    private TabLayout mainTabLayout;

    //
    private DisplayPageAdapter mainViewPageAdapter;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // インスタンスを取得
        mainViewPageAdapter = new DisplayPageAdapter(getSupportFragmentManager(), this);
        mainTabLayout = (TabLayout)findViewById(R.id.main_tab_layout);
        mainViewPager = (ViewPager)findViewById(R.id.main_view_pager);

        // ViewPagerの設定
        mainViewPager.setAdapter(mainViewPageAdapter);
        mainViewPager.addOnPageChangeListener(mainPageChangeListener);
        mainViewPager.setOffscreenPageLimit(3);

        // TabLayoutの設定
        mainTabLayout.setupWithViewPager(mainViewPager);
        mainTabLayout.setOnTabSelectedListener(mainTabSelectedListener);
        mainTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        // navigation viewの設定
        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                drawerLayout.closeDrawer(navigationView);
                switch (menuItem.getItemId()) {
                    case R.id.menu_search:
                        android.util.Log.d("kai", "menu search...");

                        Intent intent = new Intent(MainActivity.this, SearchActivity.class);

                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                        return true;
                    case R.id.menu_reload:
                        android.util.Log.d("kai", "menu reload...");
                        return true;
                    case R.id.menu_settings:
                        android.util.Log.d("kai", "menu settings...");
                        return true;
                    default:
                }

                return false;
            }
        });
    }


    public TabLayout.OnTabSelectedListener mainTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            mainViewPager.setCurrentItem(tab.getPosition(), true);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };


    public ViewPager.OnPageChangeListener mainPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

//    public void switchFragment(Class<? extends Fragment> fragment) {
//        try {
//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            Fragment fragmentInstance = fragment.newInstance();
//
//            fragmentTransaction.replace(R.id.container, fragmentInstance);
//        } catch (InstantiationException e) {
//
//        } catch (IllegalAccessException e) {
//
//
//        }
//    }
}
