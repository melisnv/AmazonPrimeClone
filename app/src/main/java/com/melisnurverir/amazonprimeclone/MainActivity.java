package com.melisnurverir.amazonprimeclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.melisnurverir.amazonprimeclone.adapter.BannerMoviesPagerAdapter;
import com.melisnurverir.amazonprimeclone.adapter.MainRecyclerAdapter;
import com.melisnurverir.amazonprimeclone.model.AllCategory;
import com.melisnurverir.amazonprimeclone.model.BannerMovies;
import com.melisnurverir.amazonprimeclone.model.CategoryItem;

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

    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;

    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indicatorTab = findViewById(R.id.tab_indicator);
        categoryTab = findViewById(R.id.tabLayout);

        nestedScrollView = findViewById(R.id.nested_scroll);
        appBarLayout = findViewById(R.id.appbar);

        homeBannerList = new ArrayList<>();
        homeBannerList.add(new BannerMovies(1,"Friends",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner1.png?alt=media&token=d34c1ced-602a-4275-877e-d60dbdcc1124","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeBannerList.add(new BannerMovies(2,"Harry Potter",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner2.png?alt=media&token=57058baf-b5d1-4815-9f34-0f744f2413b6","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeBannerList.add(new BannerMovies(3,"The Notebook",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner3.png?alt=media&token=09ad316a-8ab5-4447-affe-4b804fc38f67","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeBannerList.add(new BannerMovies(4,"Winx Club",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner4.png?alt=media&token=817fe031-41ae-44fb-a49c-f48f64d971c9","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeBannerList.add(new BannerMovies(5,"Peaky Blinders",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/homebanner5.png?alt=media&token=9f5ebeca-71f1-4141-9248-5d6041dbc502","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));


        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"Bridgerton",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/tvshowbanner1.png?alt=media&token=e7e5c210-3591-4208-a381-5d431f9f1518","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        tvShowBannerList.add(new BannerMovies(2,"The Crown",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/tvshowbanner2.png?alt=media&token=d44c97a0-92af-4fd2-8e59-bb2e1a6b8cd4","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        tvShowBannerList.add(new BannerMovies(3,"Anne With an E",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/tvshowbanner3.png?alt=media&token=60e48a9c-5a47-48a4-afd1-25e1e48f529f","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        tvShowBannerList.add(new BannerMovies(4,"Unorthodox",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/tvshowbanner4.png?alt=media&token=d71da06f-6735-4c93-a5d5-7baf7961cf4c","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));


        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1,"Carmen Sandiego",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner1.png?alt=media&token=bfc058d8-7c28-41f1-8616-c4b9d2e977be","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        kidsBannerList.add(new BannerMovies(2,"Smurfs : Lost Village",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner2.png?alt=media&token=8a4c9665-31e0-4ba2-954e-b97355982c1d","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        kidsBannerList.add(new BannerMovies(3,"Paw Patrol",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner3.png?alt=media&token=e06e353f-54b6-41d7-8f3e-cd8fd34ee4b7","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        kidsBannerList.add(new BannerMovies(4,"Pup Academy",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner4.png?alt=media&token=489d0035-ac00-49da-b713-a7a27b43ad7d","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        kidsBannerList.add(new BannerMovies(5,"Full Out 2",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/kidsbanner5.png?alt=media&token=f6b96d4a-7e36-4151-848c-18e59b506a4b","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));



        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"Enola Holmes",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/moviebanner1.png?alt=media&token=5a972f9d-4222-4a76-836e-944a7f39e699","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        movieBannerList.add(new BannerMovies(2,"The Great Gatsby",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/moviebanner2.png?alt=media&token=9ec35e86-3f7e-437d-a025-84b7053b1229","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        movieBannerList.add(new BannerMovies(3,"Interstellar",
                "https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/moviebanner3.png?alt=media&token=f95a84b8-02de-4e0f-be4a-0251eaf5f1bc","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));

        setBannerMoviesPagerAdapter(homeBannerList); // default selected tab

        // tab change data
        categoryTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setScrollDefaultState();
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setScrollDefaultState();
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

        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Friends","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/friends.png?alt=media&token=6e6ea841-81a8-49d9-ba2b-52705c689e3a","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem1.add(new CategoryItem(2,"Killing Eve","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/killingeve.png?alt=media&token=b4bb6803-a4cb-454f-b270-4276ce1b1950","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem1.add(new CategoryItem(3,"Europhia","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/euphoria.png?alt=media&token=9755813c-99b3-44ce-a2c7-cd9cf851a9e8","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem1.add(new CategoryItem(4,"Normal People","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/normalpeople.png?alt=media&token=6c926173-89f9-4055-80a6-dba1caf2416a","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem1.add(new CategoryItem(5,"West World","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/westworld.png?alt=media&token=ef07b3ce-21e2-4957-832a-48a30deea977","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));

        List<CategoryItem> homeCatListItem2 = new ArrayList<>();
        homeCatListItem2.add(new CategoryItem(1,"Babylon Berlin","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/babylonberlin.png?alt=media&token=ddfc7b39-1256-4b83-a64e-b265f083cd5f","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem2.add(new CategoryItem(2,"Stolen Lives","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/cal%C4%B1nm%C4%B1shayatlar.png?alt=media&token=bffc6e89-91f7-439f-9ff5-40fc0cdea5d2","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem2.add(new CategoryItem(3,"Ramy","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/ramy.png?alt=media&token=40978684-e0f2-4d7d-887e-e39c7b8e1b0a","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem2.add(new CategoryItem(4,"Benim Varos Hikayem","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/varoshikayem.png?alt=media&token=ee5a4b0c-2fc3-4022-b664-330ee6846953","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem2.add(new CategoryItem(5,"We Are Who We Are","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/wearewhoweare.png?alt=media&token=24437cd8-6f95-4df1-8ec1-cf590671f0fc","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));

        List<CategoryItem> homeCatListItem3 = new ArrayList<>();
        homeCatListItem3.add(new CategoryItem(1,"The Crimes of Grindelwald","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/fantastic1.png?alt=media&token=0a60f435-60ff-428f-a30d-cb304b5a0376","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem3.add(new CategoryItem(2,"Fantastic Beasts","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/fantastic2.png?alt=media&token=06fc961c-e65b-4c84-8def-c4fedd4dc9da","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem3.add(new CategoryItem(3,"Futbolin","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/futbolin.png?alt=media&token=5c8aed64-1f63-4d4c-b41c-b95d08ad6799","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem3.add(new CategoryItem(4,"Gamonya","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/gamonya.png?alt=media&token=613d5be9-58ec-4d8d-95ee-37f5a3325c20","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem3.add(new CategoryItem(5,"Wonder","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/wonder.png?alt=media&token=aba6b5cf-738b-4d08-81d1-5c468d61e189","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));

        List<CategoryItem> homeCatListItem4 = new ArrayList<>();
        homeCatListItem4.add(new CategoryItem(1,"Gone Girl","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/gonegirl.png?alt=media&token=6282515a-7770-46c1-ae5d-7a7f2912407e","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem4.add(new CategoryItem(2,"The Handmaid's Tale","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.png?alt=media&token=b5348764-b9cc-40a6-8ec4-9280d3ff1cde","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem4.add(new CategoryItem(3,"The ABC Murders","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/murders.png?alt=media&token=baa0c2e2-16ce-4574-b916-e8d11fe32650","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem4.add(new CategoryItem(4,"The Revenant","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/therevenant.png?alt=media&token=a39a92e7-e924-46ff-b0f6-224a033bf28c","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));
        homeCatListItem4.add(new CategoryItem(5,"The Young Pope","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/youngpope.png?alt=media&token=a5ee6ba1-3310-41a6-9062-297e3f09890a","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/handmaidstale.mp4?alt=media&token=8838e423-5448-4749-9191-3816304fe582"));

        /*List<CategoryItem> homeCatListItem5 = new ArrayList<>();
        homeCatListItem5.add(new CategoryItem(1,"Phillipines","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/phillippines.png?alt=media&token=58f90831-9003-4db2-b842-f87665fca2e4",""));
        homeCatListItem5.add(new CategoryItem(2,"Cryptometer","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/cryptometer.png?alt=media&token=99152ff5-ea2b-4b99-b3f0-9c33c7667760",""));
        homeCatListItem5.add(new CategoryItem(3,"Digital Flirting","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/digitalflirting.png?alt=media&token=903ce01f-c995-4412-8925-bc60ea97c754",""));
        homeCatListItem5.add(new CategoryItem(4,"Bize Gezmek Olsun","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/bizegezmekolsun.png?alt=media&token=0a147734-0d05-4a3b-aba8-2489645f4fd4",""));
        homeCatListItem5.add(new CategoryItem(5,"My Art","https://firebasestorage.googleapis.com/v0/b/primeclone-e8a29.appspot.com/o/myart.png?alt=media&token=a9c95711-c673-4ec4-b778-741a98ab1cc0",""));
        */


        allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(1,"Watch next Tv and Movies",homeCatListItem1));
        allCategoryList.add(new AllCategory(2,"Indie Movies",homeCatListItem2));
        allCategoryList.add(new AllCategory(3,"Kids and Family Movies",homeCatListItem3));
        allCategoryList.add(new AllCategory(4,"Amazon Original Series",homeCatListItem4));
        //allCategoryList.add(new AllCategory(5,"Documentaries",homeCatListItem5));



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

    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
    }

}