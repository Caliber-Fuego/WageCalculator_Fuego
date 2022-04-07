package com.example.wagecalculator_fuego;

import android.widget.TextView;

public class Calculations {

    MainActivity main = new MainActivity();

    public static void regularRate(double overtimeHour,
                                   double regularHour,
                                   double wage,
                                   double otWage,
                                   double wageTotal,
                                   double totalHours,
                                   TextView hoursWorked,
                                   TextView overtimeHours,
                                   TextView ttalHours,
                                   TextView regularWage,
                                   TextView overtimeWage,
                                   TextView totalWage,
                                   int regularPay,
                                   int overtimePay){
        // Regular Rate:
        // 1 - 8 hours (regular work hours): 100 pesos per hour
        // overtime(calculated each hour after the 8 work hour: 115 pesos per hour

        overtimeHour = Math.max(0, totalHours - 8);
        regularHour = Math.min(totalHours, 8);

        wage = Math.min(totalHours*regularPay, (regularPay*8));
        otWage = overtimeHour*overtimePay;
        wageTotal = wage+otWage;

        hoursWorked.setText(String.valueOf(regularHour));
        overtimeHours.setText(String.valueOf(overtimeHour));
        ttalHours.setText(String.valueOf(totalHours));
        regularWage.setText(String.valueOf(wage));
        overtimeWage.setText(String.valueOf(otWage));
        totalWage.setText(String.valueOf(wageTotal));
    }


}
