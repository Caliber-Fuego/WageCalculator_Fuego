package com.example.wagecalculator_fuego;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editName, editHours;
    TextView hoursWorked, overtimeHours, totalHours, regularWage, overtimeWage, totalWage;
    RadioGroup radioEmployee;
    Button calculate;
    RadioButton employeeType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //XML Ids for EditTexts, TextViews, RadioGroups and Buttons
        editName = findViewById(R.id.editName);
        editHours = findViewById(R.id.editHours);
        hoursWorked   = findViewById(R.id.regularHours);
        overtimeHours = findViewById(R.id.overtimeHours);
        totalHours    = findViewById(R.id.totalHours);
        regularWage   = findViewById(R.id.regularWage);
        overtimeWage  = findViewById(R.id.overtimeWage);
        totalWage     = findViewById(R.id.totalWage);
        radioEmployee = findViewById(R.id.groupEmployeeType);
        calculate = findViewById(R.id.calculateWage);

        //OnClickListener for Button
        calculate.setOnClickListener(this);
    }

    public void checkButton(View v){
        //Method to detect the checked Radio Button and gets their ID
        int radioId = radioEmployee.getCheckedRadioButtonId();
        employeeType = findViewById(radioId);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.calculateWage:

                //Method to detect the checked Radio Button and gets their ID
                int radioId = radioEmployee.getCheckedRadioButtonId();
                employeeType = findViewById(radioId);
                //Gets the String of the respective Radio Button ID
                String employeePosition = String.valueOf(employeeType.getText());

                //Default Values
                double regularHour = 0;
                double overtimeHour = 0;
                double totalHours = Double.parseDouble(editHours.getText().toString());

                double wage = 0;
                double otWage = 0;
                double wageTotal = 0;

                //Switch statement for Strings from the Radio Buttons
                switch (employeePosition){
                    case "Regular" :
                        // Regular Rate:
                        // 1 - 8 hours (regular work hours): 100 pesos per hour
                        // overtime(calculated each hour after the 8 work hour: 115 pesos per hour

                        overtimeHour = Math.max(0, totalHours - 8);
                        regularHour = Math.min(totalHours, 8);

                        wage = Math.min(totalHours*100, (100*8));
                        otWage = overtimeHour*120;
                        wageTotal = wage+otWage;

                        hoursWorked.setText(String.valueOf(regularHour));
                        overtimeHours.setText(String.valueOf(overtimeHour));
                        this.totalHours.setText(String.valueOf(totalHours));
                        regularWage.setText(String.valueOf(wage));
                        overtimeWage.setText(String.valueOf(otWage));
                        totalWage.setText(String.valueOf(wageTotal));
                        break;
                    case "Probationary":
                        // Probationary Employee:
                        // 1-8 hours: 90 pesos per hour
                        // overtime: 100 pesos per hour

                        overtimeHour = Math.max(0, totalHours - 8);
                        regularHour = Math.min(totalHours, 8);

                        wage = Math.min(totalHours*90, (90*8));
                        otWage = overtimeHour*100;
                        wageTotal = wage+otWage;

                        hoursWorked.setText(String.valueOf(regularHour));
                        overtimeHours.setText(String.valueOf(overtimeHour));
                        this.totalHours.setText(String.valueOf(totalHours));
                        regularWage.setText(String.valueOf(wage));
                        overtimeWage.setText(String.valueOf(otWage));
                        totalWage.setText(String.valueOf(wageTotal));
                        break;
                    case "Part-Time":
                        // Part-time workers:
                        // 1-8 hours: 75 pesos per hour
                        // overtime: 90 pesos per hour

                        overtimeHour = Math.max(0, totalHours - 8);
                        regularHour = Math.min(totalHours, 8);

                        wage = Math.min(totalHours*75, (75*8));
                        otWage = overtimeHour*90;
                        wageTotal = wage+otWage;
                        hoursWorked.setText(String.valueOf(regularHour));
                        overtimeHours.setText(String.valueOf(overtimeHour));
                        this.totalHours.setText(String.valueOf(totalHours));

                        regularWage.setText(String.valueOf(wage));
                        overtimeWage.setText(String.valueOf(otWage));
                        totalWage.setText(String.valueOf(wageTotal));
                        break;
                }
        }
    }
}