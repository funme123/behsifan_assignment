package example.bm2105_cw2_source_g6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.bm2105_cw2_source_g6.Common.Common;
import example.bm2105_cw2_source_g6.database.DatabaseHelper;

public class EdittPage extends AppCompatActivity {

    private EditText mEditUsername;
    private EditText mEditContact;
    private EditText mEditAddress;
    private DatabaseHelper databaseHelper;
    private Button mSubmitPersonal;
    private Button mEditPersonal;
    private Validation validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editt_page);
        mEditContact = (EditText) findViewById(R.id.editcontact1);
        mEditUsername = (EditText) findViewById(R.id.editusername1);
        mEditAddress = (EditText) findViewById(R.id.address1);
        databaseHelper = new DatabaseHelper(this);
        validation = new Validation(this);
        mEditPersonal = (Button) findViewById(R.id.btnEditPersonal);
        mSubmitPersonal = (Button) findViewById(R.id.btnSubmitEditPersonal);

        mSubmitPersonal.setEnabled(false);
        mEditContact.setEnabled(false);
        mEditUsername.setEnabled(false);
        mEditAddress.setEnabled(false);

        mEditUsername.setText(Common.currentUser.getUserName());
        mEditContact.setText(Common.currentUser.getContactNum());
        mEditAddress.setText(Common.currentUser.getAddress());






    }

    public void Edit(View view) {
        mSubmitPersonal.setEnabled(true);
        mEditContact.setEnabled(true);
        mEditAddress.setEnabled(true);

    }

    public void Submit(View view) {
        String contact = mEditContact.getText().toString();
        String address = mEditAddress.getText().toString();
        if(validation.changeContact(
                contact) && validation.changeAddress(address)) {

            mSubmitPersonal.setEnabled(false);
            mEditContact.setEnabled(false);
            mEditAddress.setEnabled(false);

            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }

        else {
            Toast.makeText(this,
                    "Please fill up the contact and address field",
                    Toast.LENGTH_SHORT).show();
        }

    }
}
