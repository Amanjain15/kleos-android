package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.Home;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.model.RetrofitLoginProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.model.data.LoginData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.presenter.LoginPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.login.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private SharedPrefs sharedPreferences;
    private LoginPresenter loginPresenter;
    private Toaster toaster;
    private static LoginActivity loginActivity;
    private String mobile1, password1;

    @BindView(R.id.mobile)
    EditText mobile;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.button_login)
    Button button_login;
    @BindView(R.id.button_sign_up)
    Button button_sign_up;
    @BindView(R.id.forgot_password)
    TextView forgot_password;
    @BindView(R.id.layout_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginActivity = this;
        ButterKnife.bind(loginActivity);
        intialize();
        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (mobile.getText().toString().length() == 10) {
                    hideKeyboard();
//                    password.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile1 = mobile.getText().toString();
                password1 = password.getText().toString();
                hideKeyboard();
                if (mobile1.equals("") || mobile1.equals(null)) {
                    mobile.setError("Please Fill Mobile no.");
                    mobile.setFocusable(true);
                } else if (mobile1.length() != 10) {
                    mobile.setError("Invalid Mobile No.");
                    mobile.setFocusable(true);
                } else if (password1.equals("") || password1.equals(null)) {
                    password.setError("Please Fill Password");
                    password.setFocusable(true);
                } else {
                    loginPresenter.requestLogin(mobile1, password1);
                }

            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.showShortMessage(loginActivity,"Yet to be Made");
//                Intent i = new Intent(LoginActivity.this, ForgotActivity.class);
//                startActivity(i);
            }
        });

        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.showShortMessage(loginActivity,"Yet to be Made");
//                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
//                startActivity(i);
            }
        });
    }

    private void intialize() {
        sharedPreferences = new SharedPrefs(loginActivity);
        loginPresenter = new LoginPresenterImpl(loginActivity, new RetrofitLoginProvider());

    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void showMessage(String error) {
        Toaster.showShortMessage(loginActivity,error);
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLoginSuccess(LoginData loginData) {
        sharedPreferences.setAccessToken(loginData.getAccess_token());
        sharedPreferences.setLoggedIn(true);
        Intent i = new Intent(LoginActivity.this, Home.class);
        startActivity(i);
        finish();
    }
    @Override
    public void disable_login(boolean show) {
        if (show) {
            button_login.setEnabled(true);
        } else {
            button_login.setEnabled(false);
        }
    }
}
