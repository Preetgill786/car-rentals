package com.example.carrentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity  implements  AdapterView.OnItemSelectedListener, View.OnClickListener {
    ImageView iVimg;
    Spinner sp;
    EditText etRent,etdays,etTotal,etdeposit;
    Button btnrent;
    static  int i;
    double qnty,delivery;
    double[] price = {150, 170, 100, 190, 80, 200};
    int[] imageList={R.drawable.ferrari,R.drawable.bmw,R.drawable.audi,R.drawable.honda,R.drawable.bentley};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        iVimg=findViewById(R.id.img);
        sp=findViewById(R.id.cars);
        etRent=findViewById(R.id.rentRate);
        etdays=findViewById(R.id.days);
        etTotal=findViewById(R.id.total);
        etdeposit= findViewById(R.id.deposit);
        btnrent=findViewById(R.id.rent);



        iVimg.setBackgroundResource(R.drawable.ferrari);


        List<String> cars = new ArrayList<String>();
        cars.add("Ferrari ");
        cars.add("BMW");
        cars.add("AUDI");
//.add("MUSTANG");
        cars.add("HONDA");
        cars.add("BENTLEY");

        //create an adapter and fill it from the list
        ArrayAdapter<String> carAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cars);
        //make the drop down style
        carAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        //fill the spinner with the adapter items
        sp.setAdapter(carAdapter);
        sp.setOnItemSelectedListener(this);

        btnrent.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        i = position;
        Double pr = new Double(price[i]);
        etRent.setText(pr.toString());
        int img = imageList[i];
        iVimg.setBackgroundResource(img);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
