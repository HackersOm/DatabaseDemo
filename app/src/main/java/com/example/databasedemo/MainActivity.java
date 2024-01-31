package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    EditText name,cls,roll,email;
    Button  btnInsert,btnRead,btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edt1);
        cls = findViewById(R.id.edt2);
        roll = findViewById(R.id.edt3);
        email = findViewById(R.id.edt4);

        MySqliteDemo database = new MySqliteDemo(getApplicationContext());

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(name.getText().toString().equals(" ")&&
                        cls.getText().toString().equals(" ")&&
                        roll.getText().toString().equals(" ")&&
                        email.getText().toString().equals(" ")) {
                    Toast.makeText(getApplicationContext(), "Please Enter value in every Field",Toast.LENGTH_SHORT).show();
                }
                else{
                    long val = database.insert(name.getText().toString(), cls.getText().toString(), roll.getText().toString(), email.getText().toString());
                    if (val > 0) {
                        Toast.makeText(getApplicationContext(), val + " Values is inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), val + " insertion is not  successfully", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dialog ts = new Dialog(getApplicationContext());
//                View view = getLayoutInflater().inflate(R.layout.custom_input_box,(ViewGroup)findViewById(R.id.customLayout));
//                ts.setContentView(view);
//
//                Button btnCustom = ts.findViewById(R.id.btnCustom);
//
//                ts.show();
//                EditText edt  = ts.findViewById(R.id.edtCustom);
//                final int[] i = new int[1];
//                btnCustom.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        i[0] = Integer.parseInt(edt.getText().toString());
//                    }
//                });
//                database.delete(i[0]);
//
//            }
//        });
    }
}