package Network;

import VO.OptimizationStreet;
import VO.User;
import VO.UserLoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @GET("/")
    Call<String> getMovieList();
    @POST("/")
    Call<User> getUserList(@Body User user);
    @GET("account/UserLogin")
    Call<UserLoginResponse> userLogin(@Query("user_id") String user_id,
                                      @Query("g_tkn") String g_tkn);
    @POST("/Optimize")
    Call<OptimizationStreet> getOptimizeStreet();

}
