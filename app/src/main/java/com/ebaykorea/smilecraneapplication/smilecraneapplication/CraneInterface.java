package com.ebaykorea.smilecraneapplication.smilecraneapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by younghoonkim on 2017-10-25.
 */

public interface CraneInterface {
    @Headers({"Accept: application/json"})
    @GET("ip/set_status")
    Call<String> get_Weather_retrofit(@Query("button_type") int buttonType, @Query("status") String status);

}
