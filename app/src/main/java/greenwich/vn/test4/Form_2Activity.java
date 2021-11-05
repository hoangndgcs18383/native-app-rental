package greenwich.vn.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Form_2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);


        Button btnNextForm = findViewById(R.id.btnNext_2);
        btnNextForm.setOnClickListener(btnNext);
        Button btnBackForm = findViewById(R.id.btnBack_2);
        btnBackForm.setOnClickListener(btnBack);
    }

    private View.OnClickListener btnNext = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isValid = true;
//            TextView selectErrorType = findViewById(R.id.selectErrorType);
//            TextView selectErrorFurniture = findViewById(R.id.selectErrorFurniture);
            TextView tvErrorBed = findViewById(R.id.tvErrorNumBed);
            TextView tvErrorKit = findViewById(R.id.tvErrorNumKit);
            TextView tvErrorBath = findViewById(R.id.tvErrorNumBath);

//            TextView tvRentalName = findViewById(R.id.tvRentalName);
//            TextView tvNameReporter = findViewById(R.id.tvNameReporter);
//            TextView tvAddress = findViewById(R.id.tvAddress);
//            TextView selectType = findViewById(R.id.selectType);
//            TextView selectFurniture = findViewById(R.id.selectFurniture);
            TextView tvNumBed = findViewById(R.id.numBed);
            TextView tvNumKit = findViewById(R.id.numKit);
            TextView tvNumBath = findViewById(R.id.numBath);



//            String rentalName = tvRentalName.getText().toString();
//            String nameReporter = tvNameReporter.getText().toString();
//            String address = tvAddress.getText().toString();
//            String type = selectType.getText().toString();
//            String furniture = selectFurniture.getText().toString();
            String numBed = tvNumBed.getText().toString();
            String numKit = tvNumKit.getText().toString();
            String numBath = tvNumBath.getText().toString();

//
//            String errorSelectType = "";
//            String errorSelectFurniture = "";
            String errorNumBed = "";
            String errorNumKit = "";
            String errorNumBath = "";

//            if(TextUtils.isEmpty(type)){
//                isValid = false;
//                errorSelectType += "* The field must be select. Please select property type!*";
//            }
//            if(TextUtils.isEmpty(furniture)){
//                isValid = false;
//                errorSelectFurniture += "* The field must be select. Please select property furniture!*";
//            }
            if(TextUtils.isEmpty(numBed)){
                isValid = false;
                errorNumBed += "* The field can't be empty. Please enter number of bedroom*";
            }
            if(TextUtils.isEmpty(numKit)){
                isValid = false;
                errorNumKit += "* The field can't be empty. Please select number of kitten!*";
            }
            if(TextUtils.isEmpty(numBath)){
                isValid = false;
                errorNumBath += "* The field can't be empty. Please select number of bathroom!*";
            }
            if (isValid){
                Bundle rentalInfo = new Bundle();

//                rentalInfo.putString("rentalName", rentalName);
//                rentalInfo.putString("nameReporter", nameReporter);
//                rentalInfo.putString("address", address);
//                rentalInfo.putString("type", type);
//                rentalInfo.putString("furniture", furniture);
                rentalInfo.putString("numBed", numBed);
                rentalInfo.putString("numKit", numKit);
                rentalInfo.putString("numBath", numBath);

                Intent test = new Intent(v.getContext(), Form_3Activity.class);
                test.putExtras(rentalInfo);
                startActivity(test);
                finish();

            }
            else{
//                selectErrorType.setText(errorSelectType);
//                selectErrorFurniture.setText(errorSelectFurniture);
                tvErrorBed.setText(errorNumBed);
                tvErrorKit.setText(errorNumKit);
                tvErrorBath.setText(errorNumBath);
            }
        }
    };
    private  View.OnClickListener btnBack = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent test = new Intent(v.getContext(), FormActivity.class);
            startActivity(test);
            finish();
        }
    };
}