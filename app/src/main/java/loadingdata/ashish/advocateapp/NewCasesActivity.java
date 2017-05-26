package loadingdata.ashish.advocateapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NewCasesActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Court, Casenumebr, Name, Contact;
    RadioButton casetype;
    RadioGroup rg;
    Button Submit;
    DbHelper mydb;
    boolean iscaseNumber = false, Isname, isContactnumber, isCourtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cases);
        mydb = new DbHelper(this);
        Court = (EditText) findViewById(R.id.courtname);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        Casenumebr = (EditText) findViewById(R.id.etcasenumber);
        Name = (EditText) findViewById(R.id.etClientName);
        Contact = (EditText) findViewById(R.id.etContact);
        Submit = (Button) findViewById(R.id.submit);
        Submit.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                validate();
        }
    }

    private void validate() {
        String stname, stcourtname, stcasenumber, stContact, stradiotext;

        stname = Name.getText().toString().replaceAll("\\s+", " ");
        if (stname.equals("") || stname.equals(null)) {
            Name.requestFocus();
            Name.setError("Field Mandatory");
        } else if (stname.matches("^[\\p{L} .'-]+$")) {
            Isname = true;
        } else {
            Name.requestFocus();
            Name.setError("Enter a valid userName");
        }

        stcourtname = Court.getText().toString().replaceAll("\\s+", " ");
        if (stcourtname.equals("") || stcourtname.equals(null)) {
            Court.requestFocus();
            Court.setError("Field Mandatory");
        } else if (stcourtname.matches("^[\\p{L} .'-]+$")) {
            isCourtName = true;
        } else {
            Court.requestFocus();
            Court.setError("Enter teh valid Court Name");
        }

        stContact = Contact.getText().toString();
        if (stContact.equals("") || stContact.equals(null)) {
            Contact.requestFocus();
            Contact.setError("Field Mandatory");
        } else if (Patterns.PHONE.matcher(stContact).matches() && stContact.length() == 10) {
            isContactnumber = true;
        } else {
            Contact.requestFocus();
            Contact.setError("Enter a valid number");
        }

        stcasenumber = Casenumebr.getText().toString();
        if (stcasenumber.equals("") || stcasenumber.equals(null)) {
            Casenumebr.requestFocus();
            Casenumebr.setError("Field Mandatory");
        } else if (Patterns.PHONE.matcher(stcasenumber).matches() && stcasenumber.length() == 8) {
            iscaseNumber = true;
        } else {
            Casenumebr.requestFocus();
            Casenumebr.setError("Enter a valid number");
        }


        int selectedid = rg.getCheckedRadioButtonId();
        casetype = (RadioButton) findViewById(selectedid);
        stradiotext = casetype.getText().toString();
        if (stradiotext.equals("") || stradiotext.equals(null)) {
            Toast.makeText(this, "Please select the option", Toast.LENGTH_LONG).show();
        }


        if (Isname && iscaseNumber && isContactnumber && isCourtName)
            SubmitToSql(stcasenumber, stname, stContact, stradiotext, stcourtname);
    }

    private void SubmitToSql(String stcasenumber, String stname, String stContact, String stradiotext, String stcourtname) {
        boolean is_Inserted = mydb.insertData(stcasenumber, stname, stContact, stradiotext, stcourtname);
        if (is_Inserted == true) {
            Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
            Court.setText("");
            Name.setText("");
            casetype.setChecked(false);
            Contact.setText("");
            Casenumebr.setText("");
        } else {
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }
}
