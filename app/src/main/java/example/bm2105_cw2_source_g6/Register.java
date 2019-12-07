package example.bm2105_cw2_source_g6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.bm2105_cw2_source_g6.database.DatabaseHelper;

public class Register extends AppCompatActivity {

    private EditText mpasswordReg;
    private EditText musernameReg;
    private EditText mcontactReg;
    private Button msubmitofReg;
    private EditText maddresssReg;
    private DatabaseHelper databaseHelper;
    private Validation validate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mpasswordReg =(EditText)findViewById(R.id.password1);
        musernameReg =(EditText)findViewById(R.id.username1);
        mcontactReg = (EditText) findViewById(R.id.contact);
        maddresssReg = (EditText) findViewById(R.id.address);
        msubmitofReg = (Button) findViewById(R.id.btnsubmitofregister);
        validate = new Validation(this);



    }

    public void submitofRegister(View view) {
        String user =  musernameReg.getText().toString();
        String passwords =  mpasswordReg.getText().toString();
        String contacts =  mcontactReg.getText().toString();
        String address =  maddresssReg.getText().toString();



        if(user.isEmpty()|| passwords.isEmpty()|| contacts.isEmpty()
        || address.isEmpty()) {
            Toast.makeText(this,
                    "Please fill up all the field",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(validate.InputDataofResgister(user,
                passwords,contacts, address)){
            Intent intent = new Intent(this, Signin.class);
            startActivity(intent);

        } else {
            Toast.makeText(this,
                    "Username has been taken", Toast.LENGTH_SHORT).show();
        }


    }
}
