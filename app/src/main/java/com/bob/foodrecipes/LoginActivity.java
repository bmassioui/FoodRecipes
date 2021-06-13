package com.bob.foodrecipes;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

import adapters.DatabaseAdapter;

public class LoginActivity extends ToolbarActivity {

    private TextInputLayout mLoginId;
    private TextInputLayout mPassword;

    private DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseAdapter = DatabaseAdapter.getInstance(this);

        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("Log in to your account");

        mLoginId = findViewById(R.id.login_id);
        mPassword = findViewById(R.id.login_password);
    }

    public void onLoginPressed(View view) {
        String email = mLoginId.getEditText().getText().toString();
        String password = mPassword.getEditText().getText().toString();

        if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
            loginUser(email, password);
        }
    }

    private void loginUser(String loginId, String password) {
        boolean status = databaseAdapter.signIn(loginId, password);
        if (status) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_LONG).show();
        }
    }

    public void onCreateAccountPressed(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}
