package com.ishanfx.pacelauncher;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.ishanfx.pacelauncher.homepages.HomeFirstPage;
import com.ishanfx.pacelauncher.homepages.HomeSecondPage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPagerHomeScreenPages;
    PagerAdapter mFragementPageAdapter;
    Fragment[] pageFragment;
    ImageView imageViewMasterWalpaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imageViewMasterWalpaper = (ImageView) findViewById(
                R.id.imageViewMasterWalpaper
        );
        pageFragment = new Fragment[]{new HomeFirstPage(),new HomeSecondPage()};
        setupViewPager();
        //getCurrentWallpaper();
    }

    public void showApps(View view) {
        Intent intent = new Intent(this,AppListActivity.class);
        startActivity(intent);
    }

    private void getCurrentWallpaper(){
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(
                this
        );
        imageViewMasterWalpaper.setImageDrawable(wallpaperManager.getDrawable());
    }
    private void setupViewPager() {
        viewPagerHomeScreenPages = (ViewPager) findViewById(R.id.viewPagerHomePages);
        mFragementPageAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPagerHomeScreenPages.setAdapter(mFragementPageAdapter);
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pageFragment[position];
        }

        @Override
        public int getCount() {
            return pageFragment.length;
        }
    }
}
