package com.pengwl.newstop.https;

import com.pengwl.newstop.entry.HttpResult;
import com.pengwl.newstop.entry.Subject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pengwl on 2016/11/25 0025.
 */

public interface HttpService {

    @Headers("Cache-Control: public, max-age=3600")
    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
