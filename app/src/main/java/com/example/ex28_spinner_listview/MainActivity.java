package com.example.ex28_spinner_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    ListView lVstudents;
    Spinner classesSp;
    TextView lastName, firstName, birthDay, phoneNum;
    String[] classesArr, class1names, class2names, class3names, class4names;
    String[][] class1, class2, class3, class4;
    int numberClass = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lVstudents = findViewById(R.id.lVStudents);
        classesSp = findViewById(R.id.classes);
        lastName = findViewById(R.id.lastName);
        firstName = findViewById(R.id.firstName);
        birthDay = findViewById(R.id.birthDay);
        phoneNum = findViewById(R.id.phoneNum);

        classesArr = getResources().getStringArray(R.array.classesArr);
        class1names = getResources().getStringArray(R.array.class1Names);
        class2names = getResources().getStringArray(R.array.class2Names);
        class3names = getResources().getStringArray(R.array.class3Names);
        class4names = getResources().getStringArray(R.array.class4Names);

        class1 = new String[][] {getResources().getStringArray(R.array.class1Birthdays), getResources().getStringArray(R.array.class1PhoneNums)};
        class2 = new String[][] {getResources().getStringArray(R.array.class2Birthdays), getResources().getStringArray(R.array.class2PhoneNums)};
        class3 = new String[][] {getResources().getStringArray(R.array.class3Birthdays), getResources().getStringArray(R.array.class3PhoneNums)};
        class4 = new String[][] {getResources().getStringArray(R.array.class4Birthdays), getResources().getStringArray(R.array.class4PhoneNums)};

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classesArr);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classesSp.setAdapter(spinnerAdapter);
        classesSp.setOnItemSelectedListener(this);

        lVstudents.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        lVstudents.setVisibility(View.INVISIBLE);
        lastName.setVisibility(View.INVISIBLE);
        firstName.setVisibility(View.INVISIBLE);
        birthDay.setVisibility(View.INVISIBLE);
        phoneNum.setVisibility(View.INVISIBLE);

        if (position == 0) {
            return;
        }

        numberClass = position - 1;
        String[] studentsList = {};

        if (numberClass == 0) {
            studentsList = class1names;
        } else if (numberClass == 1) {
            studentsList = class2names;
        } else if (numberClass == 2) {
            studentsList = class3names;
        } else if (numberClass == 3) {
            studentsList = class4names;
        }

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentsList);
        lVstudents.setAdapter(listAdapter);
        lVstudents.setVisibility(View.VISIBLE);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        String selectedName = (String) lVstudents.getItemAtPosition(pos);
        String[] nameParts = selectedName.split(" ");

        if (nameParts.length > 1) {
            String first = nameParts[0];
            String last = nameParts[1];

            if (numberClass == 0) {
                lastName.setText(last);
                firstName.setText(first);
                birthDay.setText(class1[0][pos]);
                phoneNum.setText(class1[1][pos]);
            } else if (numberClass == 1) {
                lastName.setText(last);
                firstName.setText(first);
                birthDay.setText(class2[0][pos]);
                phoneNum.setText(class2[1][pos]);
            } else if (numberClass == 2) {
                lastName.setText(last);
                firstName.setText(first);
                birthDay.setText(class3[0][pos]);
                phoneNum.setText(class3[1][pos]);
            } else if (numberClass == 3) {
                lastName.setText(last);
                firstName.setText(first);
                birthDay.setText(class4[0][pos]);
                phoneNum.setText(class4[1][pos]);
            }
        }

        lastName.setVisibility(View.VISIBLE);
        firstName.setVisibility(View.VISIBLE);
        birthDay.setVisibility(View.VISIBLE);
        phoneNum.setVisibility(View.VISIBLE);
    }
}
