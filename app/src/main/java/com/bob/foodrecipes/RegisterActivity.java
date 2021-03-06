package com.bob.foodrecipes;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import adapters.DatabaseAdapter;
import models.User;
import utils.UserPreferences;

public class RegisterActivity extends ToolbarActivity {

    private DatabaseAdapter databaseAdapter;

    private TextInputLayout mUsername;
    private TextInputLayout mEmail;
    private TextInputLayout mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseAdapter = DatabaseAdapter.getInstance(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mUsername = findViewById(R.id.reg_display_name);
        mEmail = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.login_password);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateAccountPressed(View view) {
        String username = mUsername.getEditText().getText().toString();
        String email = mEmail.getEditText().getText().toString();
        String password = mPassword.getEditText().getText().toString();

        registerUser(new User(username, email, password));
    }

    private void registerUser(User user) {
        databaseAdapter.addNewUser(user);

        UserPreferences.clear(this);

        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
