package temple.edu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etPasswordAgain = findViewById(R.id.et_again);
        Button btForm = findViewById(R.id.bt_form);
        btForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    private void signUp() {
        String name = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String passwordAgain = etPasswordAgain.getText().toString().trim();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"please enter your username",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"please enter your e-mail address",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter your password",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordAgain)){
            Toast.makeText(this,"please enter your password again",Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(passwordAgain)){
            Toast.makeText(this,"please check the password.",Toast.LENGTH_SHORT).show();
            return;
        }
         String msg = "Welcome, "+name+", to the SignUpForm App";
        new AlertDialog.Builder(FormActivity.this)
                .setTitle("tips")
                .setMessage(msg)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }
}
