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

public class Form_3Activity extends AppCompatActivity {

    String[] types = {"Flat", "House", "Pen House", "Bungalow"};
    String[] furniture = {"Furnished", "Unfurnished", "Part-furnished"};
//    getResources().getStringArray(R.array.types)

    AutoCompleteTextView autoCompleteTypeTextView;
    AutoCompleteTextView autoCompleteFurnitureTextView;

    ArrayAdapter<String> adapterTypeItems;
    ArrayAdapter<String> adapterFurnitureItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form3);

        autoCompleteTypeTextView = findViewById(R.id.selectType);
        autoCompleteFurnitureTextView = findViewById(R.id.selectFurniture);
        adapterTypeItems = new ArrayAdapter<String>(this, R.layout.list_item, types);
        adapterFurnitureItems = new ArrayAdapter<String>(this, R.layout.list_item, furniture);
        autoCompleteTypeTextView.setAdapter(adapterTypeItems);
        autoCompleteFurnitureTextView.setAdapter(adapterFurnitureItems);
        autoCompleteTypeTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String type = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Type: "+type, Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteFurnitureTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String furniture = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Furniture: "+furniture, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSubmitForm = findViewById(R.id.btnSubmit);
        btnSubmitForm.setOnClickListener(btnSubmit);
        Button btnBackForm_2 = findViewById(R.id.btnBack_3);
        btnBackForm_2.setOnClickListener(this.btnBackForm_2);
    }

    private View.OnClickListener btnSubmit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isValid = true;
            TextView selectErrorType = findViewById(R.id.selectErrorType);
            TextView selectErrorFurniture = findViewById(R.id.selectErrorFurniture);
            TextView tvErrorPrice = findViewById(R.id.tvErrorPrice);

            TextView selectType = findViewById(R.id.selectType);
            TextView selectFurniture = findViewById(R.id.selectFurniture);
            TextView tvPrice = findViewById(R.id.tvPrice);
            TextView tvNote = findViewById(R.id.tvNote);

            String type = selectType.getText().toString();
            String furniture = selectFurniture.getText().toString();
            String price = tvPrice.getText().toString();
            String note = tvNote.getText().toString();

            String errorSelectType = "";
            String errorSelectFurniture = "";
            String errorPrice = "";


            if(TextUtils.isEmpty(type)){
                isValid = false;
                errorSelectType += "* The field must be select. Please select property type!*";
            }
            if(TextUtils.isEmpty(furniture)){
                isValid = false;
                errorSelectFurniture += "* The field must be select. Please select property furniture!*";
            }
            if(TextUtils.isEmpty(price)){
                isValid = false;
                errorPrice += "* The field must be select. Please enter price!*";
            }
            if (isValid){
                Bundle rentalInfo = new Bundle();

                rentalInfo.putString("type", type);
                rentalInfo.putString("furniture", furniture);
                rentalInfo.putString("price", price);
                rentalInfo.putString("note", note);

                Intent test = new Intent(v.getContext(), FormTestActivity.class);
                test.putExtras(rentalInfo);
                startActivity(test);
                finish();

            }
            else{
                selectErrorType.setText(errorSelectType);
                selectErrorFurniture.setText(errorSelectFurniture);
                tvErrorPrice.setText(errorPrice);
            }
        }
    };
    private  View.OnClickListener btnBackForm_2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent test = new Intent(v.getContext(), Form_2Activity.class);
            startActivity(test);
            finish();
        }
    };
}