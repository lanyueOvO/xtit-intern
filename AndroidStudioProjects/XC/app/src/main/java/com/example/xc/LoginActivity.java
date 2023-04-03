package com.example.xc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mUsernameEditText = findViewById(R.id.EDit_username);
        mPasswordEditText = findViewById(R.id.EDit_password);
        mLoginButton = findViewById(R.id.btn_login);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
//                username.equals("admin") && password.equals("admin")
                if (password.equals("admin")){
                    SharedPreferences sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
                    // 创建SharedPreferences.Editor对象
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("username", username);
                    editor.apply();

                    Toast.makeText(LoginActivity.this, "欢迎回来"+username, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "登录失败,用户名或密码不存在", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginActivity that = (LoginActivity) o;
        return Objects.equals(mUsernameEditText, that.mUsernameEditText) && Objects.equals(mPasswordEditText, that.mPasswordEditText) && Objects.equals(mLoginButton, that.mLoginButton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mUsernameEditText, mPasswordEditText, mLoginButton);
    }
}
