package greenwich.vn.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String btnLoginName = getResources().getString(R.string.tv_loginBtn);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setText(btnLoginName);
        btnLogin.setOnClickListener(btnLoginClick);
    }
    private View.OnClickListener btnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isValid = true;
            TextView tvErrorUsername = findViewById(R.id.tvErrorUsername);
            TextView tvErrorPw = findViewById(R.id.tvErrorPassword);

            TextView tvUsername = findViewById(R.id.tvUsername);
            TextView tvPw = findViewById(R.id.tvPW);

            String errorUsername = "";
            String errorPW = "";
            String username = tvUsername.getText().toString();
            String pw = tvPw.getText().toString();
            String notification_1 = getResources().getString(R.string.notification_1);
            Toast.makeText(v.getContext(), notification_1, Toast.LENGTH_LONG).show();

            if(TextUtils.isEmpty(username)){
                isValid = false;
                errorUsername += "* The field can't be empty. Please enter your username!*";
            }
            if(TextUtils.isEmpty(pw)){
                isValid = false;
                errorPW += "* The field can't be empty. Please enter your password!*";
            }
            if (isValid){
                Toast.makeText(v.getContext(), "Your username: "+username + "\n" + "Your password: "+ pw, Toast.LENGTH_LONG).show();
                Log.w("Main Activity", "This is a Warning Log");
                Log.i("Main Activity", username + "-"+ pw);
                Log.d("Main Activity", "This is a Debug Log");
                Log.v("Main Activity", "This is a Verbose Log");
                Log.e("Main Activity", "This is a Error Log");
                Intent testActivity = new Intent(v.getContext(), HomeActivity.class);
                startActivity(testActivity);
                finish();

            }
            else{
                tvErrorUsername.setText(errorUsername);
                tvErrorPw.setText(errorPW);
            }

        }
    };
}