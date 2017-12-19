package xyz.ariq.fachry.bebas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Callback;
import retrofit2.Call;

/**
 * Created by user on 19/12/2017.
 */

public class LoginActivity extends BaseActivity{

    private static final  String UNAME = "admin";
    private static final String PWD = "password";

    @BindView(R.id.etUsername)EditText username;
    @BindView(R.id.etPassword)EditText password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);
        ButterKnife.bind(LoginActivity.this);
    }
    @OnClick(R.id.btnLogin)
    void gotoLogin(){
        String u = username.getText().toString();
        String p = password.getText().toString();
        Call<Response> call = getApi().dologin(u,p);
        call.enqueue(new retrofit2.Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        if(validatePwd()){
                String U = username.getText().toString();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("username",U);
                startActivity(i);
                finish();
            } else{
            Toast.makeText(this, "Username/Password is Invalid", Toast.LENGTH_LONG)
                    .show();
        };
    }
    private boolean validatePwd() {
        String u = username.getText().toString();
        String p = password.getText().toString();
        Call<Response> call = getApi().dologin(u,p);
        call.enqueue(new Callb);
        if(u.equals(UNAME) && p.equals(PWD)) {
            return true;
        }else{
            return false;
        }
    }

}