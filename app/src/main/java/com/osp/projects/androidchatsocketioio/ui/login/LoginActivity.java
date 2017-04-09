package com.osp.projects.androidchatsocketioio.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;
import com.osp.projects.androidchatsocketioio.ui.rooms.RoomsActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{

    private LoginPresenter loginPresenter;
    private EditText txtNickname;
    private Button btnJoin;
    private MySharedPreference mySharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySharedPreference = new MySharedPreference(this);
        if(mySharedPreference.getUser().getUserId() > 0){
            navigateToMain();
        }
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNickname = (EditText) findViewById(R.id.txtNickName);
        btnJoin = (Button) findViewById(R.id.btnJoin);

        loginPresenter = new LoginPresenterImpl(this, mySharedPreference);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        btnJoin.setOnClickListener(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setUsernameError() {

    }

    @Override
    public void setPasswordError() {

    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(this, RoomsActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnJoin:
                    loginPresenter.validateJoin(txtNickname.getText().toString().trim());
                break;
        }
    }
}
