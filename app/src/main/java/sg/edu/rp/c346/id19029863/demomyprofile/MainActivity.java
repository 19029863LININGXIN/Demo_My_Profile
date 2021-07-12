package sg.edu.rp.c346.id19029863.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etGPA;

    @Override
    protected void onPause() {
        super.onPause();
        // Step 1a: Get the user input from the EditText and store it in a variable
        String strName = etName.getText().toString();
        float gpa= Float.parseFloat(etGPA.getText().toString());

        // Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        // Step 1d: Add the key-value pair
        prefEdit.putString("name", strName);
        // How to save GPA?
        prefEdit.putFloat("GPA", gpa);

        // Step 1e: Call commit() to save the changes into SharedPreferences
        prefEdit.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        // Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Step 2b: Retrieve the saved data from the SharedPreferences object
        String strName = prefs.getString("name", "Ningxin");
        // How to retrieve GPA?
        Float gpa = prefs.getFloat("GPA", Float.parseFloat("3.5"));
        // Step 2c: Update the UI element with the value
        etName.setText(strName);
        etGPA.setText(gpa + "");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }
}