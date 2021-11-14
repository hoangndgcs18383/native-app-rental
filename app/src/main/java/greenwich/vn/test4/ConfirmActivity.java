package greenwich.vn.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        TextView tvInfoRentalName = findViewById(R.id.tvInfoRentalName);
        TextView tvInfoNameReporter = findViewById(R.id.tvInfoNameReporter);
        TextView tvInfoAddress = findViewById(R.id.tvInfoAddress);
        TextView tvInfoType = findViewById(R.id.tvInfoType);
        TextView tvInfoFurniture = findViewById(R.id.tvInfoFurniture);
        TextView tvInfoNumBed = findViewById(R.id.tvInfoNumBed);
        TextView tvInfoPrice = findViewById(R.id.tvInfoPrice);
        TextView tvInfoNote = findViewById(R.id.tvInfoNote);


        String rentalName = "", nameReporter = "", address = "";
        String type = "", furniture = "", numBed ="", price = "", note = "";

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            rentalName = bundle.getString("rentalName");
            nameReporter = bundle.getString("nameReporter");
            address = bundle.getString("address");
            type = bundle.getString("type");
            furniture = bundle.getString("furniture");
            numBed = bundle.getString("numBed");
            price = bundle.getString("price");
            note = bundle.getString("note");
        }

        tvInfoRentalName.setText(rentalName);
        tvInfoNameReporter.setText(nameReporter);
        tvInfoAddress.setText(address);
        tvInfoType.setText(type);
        tvInfoFurniture.setText(furniture);
        tvInfoNumBed.setText(numBed);
        tvInfoPrice.setText(price);
        tvInfoNote.setText(note);

        Button btnConfirm = findViewById(R.id.btnConfirmDetail);
        btnConfirm.setOnClickListener(_btnConfirmClick);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private View.OnClickListener _btnConfirmClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent putText = new Intent(v.getContext(), SuccesfulActivity.class);
            startActivity(putText);
            finish();
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
