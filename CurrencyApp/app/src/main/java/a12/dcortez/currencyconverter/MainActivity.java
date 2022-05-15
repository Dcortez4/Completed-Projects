package a12.dcortez.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements UIBind{
    private Spinner spinner1, spinner2;
    EditText txtOriginal;
    private TextView txtResult, txtUpdatedDate, txtRate;
    private CurrencyModel currencyModel = new CurrencyModel();
    private APIBridge apiBridge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Gets rid of the status bar on top like in MindMasters
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // References
        this.apiBridge = new APIBridge(this, getApplicationContext());
        txtOriginal = findViewById(R.id.txtOriginal);   // Identifies the EditText for amount being entered
        txtResult = findViewById(R.id.txtResult);       // Declares the TextView for the result being printed
        txtUpdatedDate = findViewById(R.id.txtUpdatedDate);
        txtRate = findViewById(R.id.txtRate);

        //Used for the spinner and displays set currency types as it was created with a string array
        // if time permits then it will generate a list from the api service for now there are a few currencies
        // After the type is clicked it will set this type to cur1 and cur2 for the apicall.
        this.spinner1 = findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // This prints message to the log to tell us when an item it's clicked and in our case the currency type.
                Log.i("CURRENCYTYPE", spinner1.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        this.spinner2 = findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // This prints message to the log to tell us when an item it's clicked and in our case the currency type.
                Log.i("CURRENCYTYPE", spinner2.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    //Function for when the convert button is clicked.
    public void onConvertClicked(View v) {
        // Will print log calls to check that button was clicked and the user-input
        Log.i("ButtonClicked", "Button was clicked!!");
        Log.i("AmountEntered", txtOriginal.getText().toString());

        // Tried getting the spinner stuff and user input to be saved with a set function but nothing worked
        // and decided to be bold and just call them from there and it made the url work.
        apiBridge.getCurrency(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(),
                                txtOriginal.getText().toString());
    }

    @Override
    public void mapUI(CurrencyModel currencyModel) {
        //This variable has to use what the user types in and if set another way then it's just set to null.
        txtOriginal.setText(txtOriginal.getText().toString());
        // Only variables that use the CurrencyModel since they are  JSONObjects
        //Prints the results of the conversion to the screen and rounds it 2 decimal places
        txtResult.setText(String.format("%.2f", currencyModel.getResult()));
        // Will display the last update date for the rate being used
        txtUpdatedDate.setText(String.valueOf(currencyModel.getUpdate()));
        // Will display how much 1 of the original currency is worth in the one that they user is choosing
        // convert to. Ex: 1 USD = 20.10 MXN
        txtRate.setText(String.format("1 " + spinner1.getSelectedItem().toString() + " = %s "
                                        + spinner2.getSelectedItem().toString(),currencyModel.getRate()));
    }

}