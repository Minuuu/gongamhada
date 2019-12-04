package guitar.academyservice;

import androidx.appcompat.app.AppCompatActivity;

import Network.RetrofitConnection;
import VO.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String TAG = "HTTP_RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button intentButton = findViewById(R.id.loginButton);

        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitConnection retrofitConnection = RetrofitConnection.getInstance();
                User u = new User();
                u.ID = "1234";
                Call<User> call = retrofitConnection.getServer().getUserList(u);
                call.enqueue(new Callback<User>() {

                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.v(TAG,"okok");
                        User uu = response.body();
                        //uu.MSG =
                        Log.v(TAG,uu.msg);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.v(TAG,"fail");
                    }
                });
            }
        });

    }


}
