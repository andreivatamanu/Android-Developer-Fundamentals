package com.example.challengesmodule2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class challenge4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    private Spinner mSpinner;
    private ArrayAdapter mAdapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge4);

        initView();
    }


    private void initView() {
    mSpinner = findViewById(R.id.spinner_challenge);
    mAdapterSpinner = new ArrayAdapter<String>(challenge4.this, android.R.layout.simple_spinner_dropdown_item, getSpinnerList());
    mSpinner.setAdapter(mAdapterSpinner);
    mSpinner.setOnItemSelectedListener(this);


    }

    private ArrayList<String> getSpinnerList() {

    ArrayList<String> sourceList = new ArrayList<>();

        sourceList.add("Cupcake");
        sourceList.add("Donut");
        sourceList.add("Eclair");
        sourceList.add("KitKat");
        sourceList.add("Pie");

        return sourceList;


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String textSelect = getSpinnerList().get(position);
        Toast.makeText(challenge4.this, "Selected:" + textSelect, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
