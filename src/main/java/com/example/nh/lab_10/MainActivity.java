package com.example.nh.lab_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.os.Build.VERSION_CODES.M;


public class MainActivity extends AppCompatActivity {

    MyDbAdapter helper;
    EditText Name, Pass;

    /*
    Data\Data
    MyDatabase.db

    Pk
    UID   Name   Password

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.editName);
        Pass =(EditText)findViewById(R.id.editPass);
        helper = new MyDbAdapter(this);
    }

    public void viewdata(View view){
        String data = helper.getData();
        Message.message(this, data);
    }

    public void addUser(View view){
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();

        if(t1.isEmpty() || t2.isEmpty()){
            Message.message(getApplicationContext(), "Ingrese el nombre y contraseña");
        }
        else {
            if(helper.insertData(t1, t2) <= 0) {
                Message.message(getApplicationContext(), "Error en insercion");
                Name.setText("");
                Pass.setText("");
            }
            else{
                Message.message(getApplicationContext(), "Insercion exitosa");
            }
        }
    }
}
