package com.app.shopping.Interceptor;

import android.content.Context;
import android.util.Base64;

import androidx.annotation.NonNull;

import com.app.shopping.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AccessTokenInterceptor implements Interceptor {
    Context context;
    public AccessTokenInterceptor() {
        this.context=context;

    }
    @NonNull

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        String keys=new StringBuilder().append(BuildConfig.CONSUMER_KEY).append(BuildConfig.CONSUMER_SECRET).toString();
        String ka=new
                StringBuilder().append(BuildConfig.CONSUMER_SECRET).toString();
        String kk=new
                StringBuilder().append(BuildConfig.CONSUMER_KEY).toString();
        String full=kk+":"+ka;
        System.out.println(full);




//        String keys = BuildConfig.CONSUMER_KEY + ":" + BuildConfig.CONSUMER_SECRET;

        Request request = chain.request().newBuilder()
                .addHeader("Authorization", "Basic " + Base64.encodeToString(full.getBytes(), Base64.NO_WRAP))
                .build();
        System.out.println(request.toString());
        return chain.proceed(request);
    }
}