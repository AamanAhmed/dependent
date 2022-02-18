package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class employee extends AppCompatActivity {

    EditText name,salary,gender;
    Spinner dropdown;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        name = (EditText) findViewById(R.id.empname);
        dropdown = (Spinner) findViewById(R.id.dept);
        salary = (EditText) findViewById(R.id.empsalary);
        gender = (EditText) findViewById(R.id.empsalary);
        btn = (Button) findViewById(R.id.deptbtn);
        Db d = new Db(this);

        List<String> record = d.fetchdata();
        ArrayAdapter<String> myadapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,record);
        myadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(myadapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empname = name.getText().toString();
                int empsalary = Integer.parseInt(salary.getText().toString());
                int deptid = (int) dropdown.getSelectedItemId();

//                if (empsalary == 0){
//                    salary.requestFocus();
//                    salary.setError("*");
//                }
//               else if (empsalary >= 10000){
//                    salary.requestFocus();
//                    salary.setError("Salary Must be greater than 10,000");
//                }
//                else if (empsalary <= 50000){
//                    salary.requestFocus();
//                    salary.setError("Salary Must be Less than 50,000");
//                }
//                else {

                d.employeeinsert(empname, deptid, empsalary);
                Toast.makeText(employee.this, "Details Saved", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(employee.this, employeename.class);
                startActivity(i);
//            }

            }
        });

    }
}