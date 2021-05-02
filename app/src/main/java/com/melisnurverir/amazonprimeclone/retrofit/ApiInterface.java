package com.melisnurverir.amazonprimeclone.retrofit;

import com.melisnurverir.amazonprimeclone.model.BannerMovies;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    //@GET("banner_movie.json")
    //@GET("db.json")
    @GET("bannerMovie")
    Observable<List<BannerMovies>> getAllBanners();
}
