package com.example.ferryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicketToCatalina = 34;
    double costPerTicketToLongBeach = 40;
    int numberOfTickets;
    double TotalCost;
    String tripChoice;

    private EditText tickets;
    private Spinner destinationType;
    private TextView costOfTripTxv;
    private Button computeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tickets = findViewById(R.id.inputOfNumber);
        destinationType = findViewById(R.id.spinner2);
        costOfTripTxv = findViewById(R.id.calculatedCost);
        computeButton = findViewById(R.id.computeButton);

        //onclick method tyle set and then new it will create the whole methid
        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    numberOfTickets = Integer.parseInt(tickets.getText().toString());
                }catch (NumberFormatException e){
                    costOfTripTxv.setText("please enter the number of tickets you need!");
                    return;
                }
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                tripChoice = destinationType.getSelectedItem().toString();
                if (destinationType.getSelectedItemPosition()==0){
                    TotalCost = costPerTicketToCatalina * numberOfTickets;
                }else{
                    TotalCost = costPerTicketToLongBeach * numberOfTickets;
                }

                costOfTripTxv.setText("One way trip " + tripChoice + " for "+ numberOfTickets+" passengers:" +
                        currency.format(TotalCost) );
            }
        });

    }
}