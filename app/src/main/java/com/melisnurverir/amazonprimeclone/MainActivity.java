package com.melisnurverir.amazonprimeclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;
import com.melisnurverir.amazonprimeclone.adapter.BannerMoviesPagerAdapter;
import com.melisnurverir.amazonprimeclone.adapter.MainRecyclerAdapter;
import com.melisnurverir.amazonprimeclone.model.AllCategory;
import com.melisnurverir.amazonprimeclone.model.BannerMovies;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout indicatorTab,categoryTab;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeBannerList;
    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);


        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"Friends",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner1.png?alt=media&token=d34c1ced-602a-4275-877e-d60dbdcc1124",""));
        homeBannerList.add(new BannerMovies(2,"Harry Potter",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner2.png?alt=media&token=57058baf-b5d1-4815-9f34-0f744f2413b6",""));
        homeBannerList.add(new BannerMovies(3,"The Notebook",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner3.png?alt=media&token=09ad316a-8ab5-4447-affe-4b804fc38f67",""));
        homeBannerList.add(new BannerMovies(4,"Winx Club",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner4.png?alt=media&token=817fe031-41ae-44fb-a49c-f48f64d971c9",""));
        homeBannerList.add(new BannerMovies(5,"Peaky Blinders",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner5.png?alt=media&token=9f5ebeca-71f1-4141-9248-5d6041dbc502",""));


        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"Bridgerton",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/tvshowbanner1.png?alt=media&token=e7e5c210-3591-4208-a381-5d431f9f1518",""));
        tvShowBannerList.add(new BannerMovies(2,"The Crown",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/tvshowbanner2.png?alt=media&token=d44c97a0-92af-4fd2-8e59-bb2e1a6b8cd4",""));
        tvShowBannerList.add(new BannerMovies(3,"Anne With an E",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/tvshowbanner3.png?alt=media&token=60e48a9c-5a47-48a4-afd1-25e1e48f529f",""));
        tvShowBannerList.add(new BannerMovies(4,"Unorthodox",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/tvshowbanner4.png?alt=media&token=d71da06f-6735-4c93-a5d5-7baf7961cf4c",""));


        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1,"Carmen Sandiego",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner1.png?alt=media&token=bfc058d8-7c28-41f1-8616-c4b9d2e977be",""));
        kidsBannerList.add(new BannerMovies(2,"Smurfs : Lost Village",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner2.png?alt=media&token=8a4c9665-31e0-4ba2-954e-b97355982c1d",""));
        kidsBannerList.add(new BannerMovies(3,"Paw Patrol",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner3.png?alt=media&token=e06e353f-54b6-41d7-8f3e-cd8fd34ee4b7",""));
        kidsBannerList.add(new BannerMovies(4,"Pup Academy",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner4.png?alt=media&token=489d0035-ac00-49da-b713-a7a27b43ad7d",""));
        kidsBannerList.add(new BannerMovies(5,"Full Out 2",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner5.png?alt=media&token=f6b96d4a-7e36-4151-848c-18e59b506a4b",""));



        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"Enola Holmes",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/moviebanner1.png?alt=media&token=5a972f9d-4222-4a76-836e-944a7f39e699",""));
        movieBannerList.add(new BannerMovies(2,"The Great Gatsby",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/moviebanner2.png?alt=media&token=9ec35e86-3f7e-437d-a025-84b7053b1229",""));
        movieBannerList.add(new BannerMovies(3,"Interstellar",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/moviebanner3.png?alt=media&token=f95a84b8-02de-4e0f-be4a-0251eaf5f1bc",""));

        setBannerMoviesPagerAdapter(homeBannerList); // default selected tab

        // tab change data
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setBannerMoviesPagerAdapter(homeBannerList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Hollywood"));
        allCategoryList.add(new AllCategory(2,"Indie"));
        allCategoryList.add(new AllCategory(3,"Kids"));

        setMainRecycler(allCategoryList);
    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMoviesViewPager= findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this,bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),4000,6000);
        indicatorTab.setupWithViewPager(bannerMoviesViewPager,true);
    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannerMoviesViewPager.getCurrentItem() < homeBannerList.size() - 1){
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                    }
                    else {
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public void setMainRecycler(List<AllCategory> allCategoryList){

        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager  layoutManager= new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mainRecycler.setLayoutManager(layoutManager);

        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }

}