package greenwich.vn.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_tv_login);
        String notification_1 = getResources().getString(R.string.notification_1);
        Toast.makeText(this, notification_1, Toast.LENGTH_LONG).show();

//        String btnNextName = getResources().getString(R.string.tv_nextBtn);
        Button btnNextForm = findViewById(R.id.btnNextForm);
        btnNextForm.setOnClickListener(btnNextClick);


    }
    private View.OnClickListener btnNextClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isValid = true;


            TextView tvErrorRentalName = findViewById(R.id.tvErrorRentalNameTest);
            TextView tvErrorNameReported = findViewById(R.id.tvErrorNameReportTest);
            TextView tvErrorAddress = findViewById(R.id.tvErrorAddress);
//            TextView tvErrorKit = findViewById(R.id.tvErrorNumKit);
//            TextView tvErrorBath = findViewById(R.id.tvErrorNumBath);
//            TextView tvErrorPrice = findViewById(R.id.tvErrorPrice);

            TextView tvRentalName = findViewById(R.id.tvRentalName);
            TextView tvNameReporter = findViewById(R.id.tvNameReporter);
            TextView tvAddress = findViewById(R.id.tvAddress);
//            TextView tvNumKit = findViewById(R.id.tvNumKit);
//            TextView tvNumBath = findViewById(R.id.tvNumBath);
//            TextView tvPrice = findViewById(R.id.tvPrice);
//            TextView tvNote = findViewById(R.id.tvNote);

            String rentalName = tvRentalName.getText().toString();
            String nameReporter = tvNameReporter.getText().toString();
            String address = tvAddress.getText().toString();
//            String numKit = tvNumKit.getText().toString();
//            String numBath = tvNumBath.getText().toString();
//            String price = tvPrice.getText().toString();
//            String numNote = tvNote.getText().toString();

            String errorRentalName = "";
            String errorNameReporter = "";
            String errorAddress = "";
            String errorNumKit = "";
            String errorNumBath = "";
            String errorPrice = "";
            if(TextUtils.isEmpty(rentalName)){
                isValid = false;
                errorRentalName += "* The field can't be empty. Please enter rental name!*";
            }
            if(TextUtils.isEmpty(nameReporter)){
                isValid = false;
                errorNameReporter += "* The field can't be empty. Please enter name reporter!*";
            }
            if(TextUtils.isEmpty(address)){
                isValid = false;
                errorAddress += "* The field can't be empty. Please enter address!*";
            }
//            if(TextUtils.isEmpty(numKit)){
//                isValid = false;
//                errorNumKit += "* The field can't be empty. Please select your number of kitten!";
//            }
//            if(TextUtils.isEmpty(numBath)){
//                isValid = false;
//                errorNumBath += "* The field can't be empty. Please select your number of bathroom!";
//            }
//            if(TextUtils.isEmpty(price)){
//                isValid = false;
//                errorPrice += "* The field can't be empty. Please select your number of price!";
//            }
            if (isValid){
//                Bundle rentalInfo = new Bundle();
//                rentalInfo.putString("rentalName", rentalName);
//                rentalInfo.putString("nameReporter", nameReporter);
//                rentalInfo.putString("address", address);
////                rentalInfo.putString("numKit", numKit);
////                rentalInfo.putString("numBath", numBath);
////                rentalInfo.putString("price", price);
////                rentalInfo.putString("note", numNote);
//
//                Intent putText = new Intent(v.getContext(), FormTestActivity.class);
                Intent test = new Intent(v.getContext(), Form_2Activity.class);

//                putText.putExtras(rentalInfo);
                startActivity(test);
                finish();

            }
            else{
                tvErrorRentalName.setText(errorRentalName);
                tvErrorNameReported.setText(errorNameReporter);
                tvErrorAddress.setText(errorAddress);
//                tvErrorKit.setError(errorNumKit);
//                tvErrorBath.setError(errorNumBath);
//                tvErrorPrice.setError(errorPrice);
            }
        }
    };

}