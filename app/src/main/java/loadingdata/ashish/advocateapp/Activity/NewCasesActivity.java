package loadingdata.ashish.advocateapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import loadingdata.ashish.advocateapp.Database.DbHelper;
import loadingdata.ashish.advocateapp.R;

public class NewCasesActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Address, Email, Name, Contact;
    RadioButton casetype;
    RadioGroup rg;
    Button Submit;
    DbHelper mydb;
    boolean isEmail = false, Isname, isContactnumber, isCourtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cases);
        mydb = new DbHelper(this);
        Address = (EditText) findViewById(R.id.etAddress);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        Email = (EditText) findViewById(R.id.etEmail);
        Name = (EditText) findViewById(R.id.username);
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
        String stname, staddress, stemail, stContact, stradiotext;

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

        staddress = Address.getText().toString().replaceAll("\\s+", " ");
        if (staddress.equals("") || staddress.equals(null)) {
            Address.requestFocus();
            Address.setError("Field Mandatory");
        } else if (staddress.matches("^[\\p{L} .'-]+$")) {
            isCourtName = true;
        } else {
            Address.requestFocus();
            Address.setError("Enter teh valid Address");
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

//        stcasenumber = Casenumebr.getText().toString();
//        if (stcasenumber.equals("") || stcasenumber.equals(null)) {
//            Casenumebr.requestFocus();
//            Casenumebr.setError("Field Mandatory");
//        } else if (Patterns.PHONE.matcher(stcasenumber).matches() && stcasenumber.length() == 8) {
//            iscaseNumber = true;
//        } else {
//            Casenumebr.requestFocus();
//            Casenumebr.setError("Enter a valid number");
//        }

            stemail=Email.getText().toString();
        if (Email.getText().toString().trim().equals("") || !Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches())
            isEmail=true;
        int selectedid = rg.getCheckedRadioButtonId();
        casetype = (RadioButton) findViewById(selectedid);
        stradiotext = casetype.getText().toString();
        if (stradiotext.equals("") || stradiotext.equals(null)) {
            Toast.makeText(this, "Please select the option", Toast.LENGTH_LONG).show();
        }


        if (Isname && isEmail && isContactnumber && isCourtName)
            SubmitToSql(stname,staddress,stContact,stemail,stradiotext);
    }

    private void SubmitToSql(String stname, String staddress, String stContact, String stemail,String stradiotext) {
        boolean is_Inserted = mydb.insertData(stname,staddress,stContact,stemail,stradiotext);
        if (is_Inserted == true) {
            Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
            Address.setText("");
            Name.setText("");
            casetype.setChecked(false);
            Contact.setText("");
            Email.setText("");
            Intent profileDescription=new Intent(NewCasesActivity.this,UserProfileDescription.class);
            startActivity(profileDescription);
        } else {
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }
}
