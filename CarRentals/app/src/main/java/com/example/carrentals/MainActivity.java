package com.example.carrentals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static customer cust[] = new customer[3];
    EditText etUserName, etPassword;
    Button btnok,btncancel;
    public static String customerName;
    public static int custIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.UserName);
        etPassword = findViewById(R.id.password);
        btnok = findViewById(R.id.ok);
        btncancel=findViewById(R.id.cancel);

        btnok.setOnClickListener(this);
        btncancel.setOnClickListener(this);

        cust[0]= new customer(123456,"Sara",23,"9056661234","sarasara","123456");
        cust[1]= new customer(456799,"John",20,"4567893456","johnjohn","123456");
        cust[2]= new customer(741852,"Robert",27,"6412348790","robertrobert","123456");
    }

    @Override

        public void onClick(View v)
    {
        switch(v.getId()) {
            case R.id.ok:
                    String userEntry = etUserName.getText().toString();
                String passEntry = etPassword.getText().toString();
                int custId = searchUser(cust, userEntry, passEntry);
                if (custId == -1)
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                else {
                    int i = findCustomerById(cust, custId);
                    custIndex = i;
                    customerName = cust[i].getName();
                    Intent go = new Intent(this, Main2Activity.class);
                    startActivity(go);
                }
                break;
            case R.id.cancel:
                etUserName.setText("");
                etPassword.setText("");
                break;
        }
        }



    public static int searchUser(customer cust[],String user, String pass)
    {
        int id;
        for (int i =0;i<cust.length;i++)
            if(user.equals(cust[i].getUsername()) && pass.equals(cust[i].getPassword()))
            {id=cust[i].getId();
                return id;}
        return -1;


    }
    public static int findCustomerById(customer cust[],int custId)
    {
        for(int i=0;i<cust.length;i++)
            if(cust[i].getId()==custId)
                return i;
        return -1;
    }
}



