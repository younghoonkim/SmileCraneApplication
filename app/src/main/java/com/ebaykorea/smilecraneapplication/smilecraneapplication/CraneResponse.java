package com.ebaykorea.smilecraneapplication.smilecraneapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by younghoonkim on 2017-10-25.
 */

public class CraneResponse {

    public interface CraneInterface {
        @Headers({"Accept: application/json"})
        @GET("set_status_args")
        Call<CraneResponse> call_retrofit(@Query("button_type") String buttonType, @Query("status") String status);

    }

}
