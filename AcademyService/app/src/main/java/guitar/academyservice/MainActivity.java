package guitar.academyservice;

import androidx.appcompat.app.AppCompatActivity;
import guitar.academyservice.ui.login.LoginActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.PrecomputedText;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button intentButton = findViewById(R.id.loginButton);

        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public class NetworkTask extends AsyncTask<String, Void, String> {
        @Override
        //준비작업 수행
        protected void onPreExecute() {
            super.onPreExecute();
        }
        /**
         * 본 작업을 쓰레드로 처리해준다.
         * @param params
         * @return */

        @Override
        protected String doInBackground(String... params) {
            // HTTP 요청 준비 작업
            HttpClient.Builder http = new HttpClient.Builder("POST", "http://자신의아이피주소:8080/SpringToAndroid/android");
            // HTTP 요청 전송
            HttpClient post = http.create();
            post.request();
            // 응답 상태코드 가져오기
            int statusCode = post.getHttpStatusCode();
            // 응답 본문 가져오기
            String body = post.getBody();
            return body;
        }

        /** * doInBackground 종료되면 동작한다. * @param s : doInBackground가 리턴한 값이 들어온다. */
        @Override
        protected void onPostExecute(String s) {
            Log.d("HTTP_RESULT", s);
        }
    }
}
