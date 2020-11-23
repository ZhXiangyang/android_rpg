package fr.yncrea.android_rpg.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class getJson {

    public static final String BASE_URL = "https://jarjarbinksisen.github.io/Adventure101/";
    public static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public GetEvents create(Class<GetEvents> retrofitInterfaceClass) { return null;}
}
