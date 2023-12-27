package com.example.individualassignment2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText unitsEditText, rebateEditText;
    Button calculateButton, aboutButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        unitsEditText = findViewById(R.id.unitsEditText);
        rebateEditText = findViewById(R.id.rebateEditText);
        calculateButton = findViewById(R.id.calculateButton);
        aboutButton = findViewById(R.id.aboutButton);
        resultTextView = findViewById(R.id.resultTextView);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBill();
            }
        });


        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });
    }

    private void calculateBill() {
        try {
            double unit = Double.parseDouble(unitsEditText.getText().toString());
            double rebate = Double.parseDouble(rebateEditText.getText().toString());

            double totalCost = calculateCost(unit, rebate);
            resultTextView.setText("TOTAL YOUR ELECTRICITY BILL COST: RM" + String.format("%.2f", totalCost));
        } catch (NumberFormatException e) {

            resultTextView.setText("INVALID. PLEASE ENTER AGAIN");
        }
    }

    private double calculateCost(double unit, double rebate) {
        double totalCharge = 0.0;


        if (unit >= 1 && unit <= 200) {
            totalCharge = unit * 0.218;
        } else if (unit >= 201 && unit <= 300) {
            totalCharge = (200 * 0.218) + ((unit - 200) * 0.334);
        } else if (unit >= 301 && unit <= 600) {
            totalCharge = (200 * 0.218) + (100 * 0.334) + ((unit - 300) * 0.516);
        } else if (unit >= 601 && unit <= 900) {
            totalCharge = (200 * 0.218) + (100 * 0.334) + (300 * 0.516) + ((unit - 600) * 0.546);
        }

        return totalCharge * (1 - (rebate / 100));
    }
}
