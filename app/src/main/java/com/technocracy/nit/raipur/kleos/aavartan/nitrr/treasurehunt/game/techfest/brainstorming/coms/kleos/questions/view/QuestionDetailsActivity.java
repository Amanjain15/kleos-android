package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.view;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.R;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Keys;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.SharedPrefs;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.Toaster;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.GlideImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.helper.image_loader.ImageLoader;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.model.RetrofitQuestionProvider;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.presenter.QuestionPresenter;
import com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.questions.presenter.QuestionPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionDetailsActivity extends AppCompatActivity implements QuestionResponseView  {

    private String name;
    private String number;
    private String image;
    private String content;
    private boolean answered;

    private Context context;
    private SharedPrefs sharedPrefs;
    private QuestionPresenter questionPresenter;
    private ImageLoader imageLoader;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageLayout)
    RelativeLayout imageLayout;
    @BindView(R.id.imageProgressBar)
    ProgressBar imageProgressBar;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.question_content)
    TextView question_content;
    @BindView(R.id.answer)
    EditText answer;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.submit)
    ImageView submit;
    private int a=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_details);
        ButterKnife.bind(this);
        if (getIntent() != null){
            Bundle bundle = getIntent().getExtras();
            name = bundle.getString(Keys.KEY_QUESTION_NAME);
            number = bundle.getString(Keys.KEY_QUESTION_N0);
            image=bundle.getString(Keys.KEY_QUESTION_IMAGE);
            content=bundle.getString(Keys.KEY_QUESTION_CONTENT);
            answered=bundle.getBoolean(Keys.KEY_ANSWERED);
            Log.d("QuestionDetailsActivty",answered+" "+bundle.getBoolean(Keys.KEY_ANSWERED));
        }

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setFocusable(true);
            }
        });
        toolbar.setTitle(name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initialize();
        final Context context = this;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageViewerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(Keys.KEY_QUESTION_NAME, name);
                bundle.putString(Keys.KEY_QUESTION_IMAGE, image);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        question_content.setText(content);
        if(answered){
            submit.setVisibility(View.GONE);
            answer.setVisibility(View.GONE);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
                String answer1= answer.getText().toString();
                if (answer1.equals("")||answer1.equals(null)){
                    answer.setError("Please Fill Answer");
                    answer.requestFocus();
                }else {
                    questionPresenter.responseQuestion(sharedPrefs.getAccessToken(),number,answer1);
                }
            }
        });

    }
    private void initialize() {
        context=this;
        sharedPrefs = new SharedPrefs(context);
        imageLoader= new GlideImageLoader(context);
        imageLoader.loadImage(image,imageView,imageProgressBar);
        questionPresenter=new QuestionPresenterImpl(new RetrofitQuestionProvider(),this);
    }

    @Override
    public void onRightAnswer() {
        Toaster.showShortMessage(context,"Correct Answer");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },500);
    }

    @Override
    public void showLoading(boolean show) {
        if (show){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }
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
        Toaster.showShortMessage(context,message);
    }

    @Override
    public void enableSubmit(boolean s) {
        if (s){
            submit.setEnabled(true);
        }else{
            submit.setEnabled(false);
        }
    }

}
