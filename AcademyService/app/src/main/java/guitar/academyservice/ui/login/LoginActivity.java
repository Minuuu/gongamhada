package guitar.academyservice.ui.login;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.skt.Tmap.TMapView;

import guitar.academyservice.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                String username = usernameEditText.getText().toString();
                if(username != "")
                    Log.d("logtest", username + " start");
                else
                    Log.d("logtest", "input username!!");
            }
        });

        TMapView tmapView = new TMapView(this);
        tmapView.setSKTMapApiKey("c12f44ac-89a3-4580-993b-44df9a168afd");
    }
}
