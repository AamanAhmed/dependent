package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed,ed2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = (EditText) findViewById(R.id.departmentname);
        ed2 = (EditText) findViewById(R.id.employeeno);
        btn = (Button) findViewById(R.id.departmentbtn);
        Db d = new Db(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deptname = ed.getText().toString();
                int empno = Integer.parseInt(ed2.getText().toString());
                d.deptinsert(deptname,empno);


                Toast.makeText(MainActivity.this, "Department Added", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, employee.class);
                startActivity(i);
            }
        });
    }
}