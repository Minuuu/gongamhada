package Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {

    String URL = "http://10.0.2.2:3000/"; // 서버 API

    private static RetrofitConnection instance;

    public static RetrofitConnection getInstance() {
        if (instance == null) {
            instance = new RetrofitConnection();
        }
        return instance;
    }
    RetrofitAPI server ;
    private RetrofitConnection() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         server = retrofit.create(RetrofitAPI.class);
    }

    public RetrofitAPI getServer() {
        return server;
    }
}
