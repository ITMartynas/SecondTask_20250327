package com.example.secondtask_20250327;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override //overriding a parent class method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //creating an array to store the selected calculation type
        final String[] selectedCalculationType = new String[1];

        //find and connect UI components from the XLM layout
        Spinner calculationTypeSpinner = findViewById(R.id.calculationTypeSpinner);
        EditText userInputTxt = findViewById(R.id.userInputTxt);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        //set up spinner (dropdown menu) with calculation types
        setupSpinner(calculationTypeSpinner, selectedCalculationType);

        //setup button's click behavior
        setupButton(calculateButton, userInputTxt, selectedCalculationType, resultTextView);
    }

    //method to configure the spinner (dropdown menu) for calculation types
    private void setupSpinner(Spinner calculationTypeSpinner, final String[] selectedCalculationType) {
        //create an adapter to populate the spinner with options from resources
        //this connects the string array in strings.xlm to the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.calculation_types,
                android.R.layout.simple_spinner_item
        );

        //set the layout for the dropdown when spinner is clicked
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //apply the adapter to the spinner, populating it with options
        calculationTypeSpinner.setAdapter(adapter);

        //add a listener to track when an item is selected
        calculationTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //retrieve the calculation types from resources
                String[] calculationTypes = getResources().getStringArray(R.array.calculation_types);
                //store a selected type in the array that was created outside this method
                selectedCalculationType[0] = calculationTypes[position];
            }
            @Override
            //if nothing is selected, do nothing
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //a method to configure the button's click behavior
    private void setupButton(Button calculateButton, EditText userInputTxt, final String[] selectedCalculationType, TextView resultTextView) {
        // Set a click listener for button using lambda expression
        calculateButton.setOnClickListener(v -> calculateAndDisplayResult(userInputTxt, selectedCalculationType, resultTextView));
    }

    //method to perform calculation and display the result
    @SuppressLint("SetTextI18n") //suppress lint warning about text concatenation
    private void calculateAndDisplayResult(EditText userInputTxt, final String[] selectedCalculationType, TextView resultTextView) {
        //get the user input from the EditText
        String userInput = userInputTxt.getText().toString().trim();
        int result; //initiate result variable

        //checks if input is empty
        if (userInput.isEmpty()) {
            resultTextView.setText("Please enter some text");
            return;
        }

        //using try-catch for error handling
        try {
            //check the selected calculation type and perform the corresponding calculation
            if("Word Count".equals(selectedCalculationType[0])) {
                result = Calculator.countWords(userInput);
                resultTextView.setText("Word Count: " + result);
            } else if ("Character Count".equals(selectedCalculationType[0])) {
                result = Calculator.countCharacters(userInput);
                resultTextView.setText("Character Count: " + result);
            } else {
                //handle unexpected calculation types
                resultTextView.setText("Invalid calculation type");
            }
        } catch (Exception e) {
            //catch and display any unexpected errors
            resultTextView.setText("Error calculating: " + e.getMessage());
            }


    }
}
