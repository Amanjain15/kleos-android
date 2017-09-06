package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.Home;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.RetrofitSignUpProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.OtpData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.SignUpRequestData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data.UpdateDetailsData;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.presenter.SignUpPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.presenter.SignUpPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements  SignUpView{

    private SharedPrefs sharedPrefs;
    private SignUpPresenter signUpPresenter;
    private String name1, mobile1, password1, college1, email1, confirm_password1;
    private String otp1;
    private String temp_access_token;
    private SignUpActivity signUpActivity;


    @BindView(R.id.detailsLayout)
    LinearLayout detailsLayout;

    @BindView(R.id.name)
    EditText name;

    @BindView(R.id.mobile)
    EditText mobile;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.proceed)
    Button proceed;

    @BindView(R.id.layout_bar)
    ProgressBar progressBar;

    @BindView(R.id.otp_layout)
    LinearLayout otp_layout;

    @BindView(R.id.otp)
    EditText otp;

    @BindView(R.id.verify)
    Button verify;

    @BindView(R.id.login)
    TextView login;

    @BindView(R.id.resend_otp)
    Button resend_otp;

    @BindView(R.id.updateDetailsLayout)
    LinearLayout updateDetailsLayout;

    @BindView(R.id.update_name)
    EditText update_name;

    @BindView(R.id.update_college)
    AutoCompleteTextView update_college;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.confirm_password)
    EditText confirm_password;

    @BindView(R.id.submit)
    Button submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpActivity=this;
        ButterKnife.bind(signUpActivity);
        otp_layout.setVisibility(View.GONE);
        updateDetailsLayout.setVisibility(View.GONE);
        detailsLayout.setVisibility(View.VISIBLE);
        initialise();
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = name.getText().toString();
                mobile1 = mobile.getText().toString();
                email1 = email.getText().toString();


                hideKeyboard();

                if (mobile1.equals("") || mobile1.equals(null)) {
                    mobile.setError("Please Fill Mobile no.");
                    mobile.setFocusable(true);
                } else if (mobile1.length() != 10) {
                    mobile.setError("Invalid Mobile No.");
                    mobile.setFocusable(true);
                } else if (name1.equals("") || name1.equals(null)) {
                    name.setError("Please Fill Name");
                    name.setFocusable(true);
                } else if (email1.equals("") || email1.equals(null)) {
                    email.setError("Please Fill Email");
                    email.setFocusable(true);
                } else {
                    signUpPresenter.requestOtp(name1, mobile1, email1);
                }

            }
        });

        resend_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resend_otp.setVisibility(View.INVISIBLE);
                signUpPresenter.resendOtp(temp_access_token);
            }
        });
    }

    private void initialise() {
        sharedPrefs = new SharedPrefs(this);
        signUpPresenter = new SignUpPresenterImpl(this,new RetrofitSignUpProvider());
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void showMessage(String message) {
        Toaster.showShortMessage(signUpActivity,message);
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
    public void onOtpSend(OtpData otpData) {
        temp_access_token = otpData.getTemp_access_token();
        otp_layout.setVisibility(View.VISIBLE);
        detailsLayout.setVisibility(View.GONE);
        updateDetailsLayout.setVisibility(View.GONE);
        otp.setFocusable(true);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp1 = otp.getText().toString();
                if (otp1.equals("") || otp1.equals(null)) {
                    otp.setError("Please Fill OTP.");
                    otp.setFocusable(true);
                } else {

                    signUpPresenter.verifyOtp(temp_access_token,otp1);
                }
            }
        });
    }

    @Override
    public void onOtpVerified(SignUpRequestData signUpRequestData) {
        sharedPrefs.setAccessToken(signUpRequestData.getAccess_token());
        sharedPrefs.setName(signUpRequestData.getName());
        otp_layout.setVisibility(View.GONE);
        detailsLayout.setVisibility(View.GONE);
        updateDetailsLayout.setVisibility(View.VISIBLE);
        update_name.setText(sharedPrefs.getName());

        ArrayAdapter<String> collegeAdapter = new ArrayAdapter<String>
                (signUpActivity, android.R.layout.simple_list_item_1,
                        signUpRequestData.getCollegeDetailsList());
        update_college.setAdapter(collegeAdapter);
        update_college.setThreshold(1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1=name.getText().toString();
                college1=update_college.getText().toString();
                password1 = password.getText().toString();
                confirm_password1 = confirm_password.getText().toString();
                hideKeyboard();
                if (college1.equals("") || college1.equals(null)) {
                    update_college.setError("Please Fill College");
                    update_college.setFocusable(true);
                } else if (name1.equals("") || name1.equals(null)) {
                    name.setError("Please Fill Name");
                    name.setFocusable(true);
                } else if (password1.equals("") || password1.equals(null)) {
                    password.setError("Please Fill Password");
                    password.setFocusable(true);
                } else if (!password1.equals(confirm_password1)) {
                    password.setError("Passwords do not match");
                    confirm_password.setError("Passwords do not match");
                    confirm_password.setFocusable(true);
                } else {
                    signUpPresenter.updateDetails(sharedPrefs.getAccessToken(),name1,college1,password1);
                }
            }
        });


    }

    @Override
    public void onDetailsUpdate(UpdateDetailsData updateDetailsData) {
        Intent intent= new Intent(SignUpActivity.this, Home.class);
        startActivity(intent);
        finish();
    }


    //Button Handlers


    @Override
    public void enable_signUp(boolean show) {
        if (show) {
            proceed.setEnabled(true);
        } else {
            proceed.setEnabled(false);
        }
    }

    @Override
    public void enable_otp(boolean show) {
        if (show) {
            verify.setEnabled(true);
        } else {
            verify.setEnabled(false);
        }
    }
    @Override
    public void enable_update(boolean show) {
        if (show) {
            submit.setEnabled(true);
        } else {
            submit.setEnabled(false);
        }
    }
}
