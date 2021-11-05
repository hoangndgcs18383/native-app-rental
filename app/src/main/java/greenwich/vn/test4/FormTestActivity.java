package greenwich.vn.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FormTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_test);

        TextView tvInfoRentalName = findViewById(R.id.tvInfoRentalName);
        TextView tvInfoNameReporter = findViewById(R.id.tvInfoNameReporter);
        TextView tvInfoAddress = findViewById(R.id.tvInfoAddress);
        TextView tvInfoType = findViewById(R.id.tvInfoType);
        TextView tvInfoFurniture = findViewById(R.id.tvInfoFurniture);
        TextView tvInfoNumBed = findViewById(R.id.tvInfoNumBed);
        TextView tvInfoNumKit = findViewById(R.id.tvInfoNumKit);
        TextView tvInfoNumBath = findViewById(R.id.tvInfoNumBath);


        String rentalName = "", nameReporter = "", address = "";
        String type = "", furniture = "", numBed ="", numKit ="", numBath="";

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            rentalName = bundle.getString("rentalName");
            nameReporter = bundle.getString("nameReporter");
            address = bundle.getString("address");
            type = bundle.getString("type");
            furniture = bundle.getString("furniture");
            numBed = bundle.getString("numBed");
            numKit = bundle.getString("numKit");
            numBath = bundle.getString("numBath");
        }

        tvInfoRentalName.setText(rentalName);
        tvInfoNameReporter.setText(nameReporter);
        tvInfoAddress.setText(address);
        tvInfoType.setText(type);
        tvInfoFurniture.setText(furniture);
        tvInfoNumBed.setText(numBed);
        tvInfoNumKit.setText(numKit);
        tvInfoNumBath.setText(numBath);
}}
