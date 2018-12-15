package com.example.nh.lab_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.os.Build.VERSION_CODES.M;


public class MainActivity extends AppCompatActivity {

    MyDbAdapter helper;
    EditText Name, Pass;
    EditText Delete;
    EditText CName, NName;


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

        CName = (EditText)findViewById(R.id.editText3);
        NName = (EditText)findViewById(R.id.editText5);

        Delete = (EditText)findViewById(R.id.editText6);
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
                Name.setText("");
                Pass.setText("");
            }
        }
    }

    public  void delete(View view){
        String uname = Delete.getText().toString();

        if(uname.isEmpty()){
            Message.message(getApplicationContext(), "Ingrese el nombre a borrrar");
        }
        else {
            if(helper.delete(uname) <= 0) {
                Message.message(getApplicationContext(), "Error en borrado");
                Delete.setText("");
            }
            else{
                Message.message(getApplicationContext(), "Borrado exitoso");
                Delete.setText("");
            }
        }
    }

    public void update(View view){
        String t1 = CName.getText().toString();
        String t2 = NName.getText().toString();

        if(t1.isEmpty() || t2.isEmpty()){
            Message.message(getApplicationContext(), "Ingrese el nombre y contraseña");
        }
        else {
            if(helper.updateName(t1,t2) <= 0) {
                Message.message(getApplicationContext(), "Error en actualizacion");
                CName.setText("");
                NName.setText("");
            }
            else{
                Message.message(getApplicationContext(), "Actualizacion exitosa");
                CName.setText("");
                NName.setText("");
            }
        }
    }



}
