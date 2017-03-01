package org.chenzc.mvpdemo.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * creator: czc
 * date: 2017/3/2
 * description:
 */

public class ApiUtils {

    public static YiyanApi getYiyanApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.YIYAN_BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(YiyanApi.class);
    }
}
