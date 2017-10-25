package com.ebaykorea.smilecraneapplication.smilecraneapplication;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by younghoonkim on 2017-10-25.
 */

public class CraneThread extends Thread {

    final static String TAG = "CraneThread";

    public String buttonType;
    public String status;


    @Override
    public void run() {
        super.run();
        Retrofit client = new Retrofit.Builder().baseUrl("http://192.168.1.117:5555/").addConverterFactory(GsonConverterFactory.create()).build();
        CraneResponse.CraneInterface service = client.create(CraneResponse.CraneInterface.class);

        Call<CraneResponse> call = service.call_retrofit(buttonType, status);
        call.enqueue(new Callback<CraneResponse>() {
            @Override
            public void onResponse(Call<CraneResponse> call, Response<CraneResponse> response) {
                if(response.isSuccessful()){
                    Log.d(TAG, "onResponse: " + response.message());
                }

            }

            @Override
            public void onFailure(Call<CraneResponse> call, Throwable t) {

                Log.e(TAG,"CRANE 실패 :" + t.getMessage() );
                Log.e(TAG,"요청 메시지 :"+call.request());
            }
        });
    }
}
