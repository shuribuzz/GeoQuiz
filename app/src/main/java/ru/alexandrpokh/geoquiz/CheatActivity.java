package ru.alexandrpokh.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER_IS_TRUE = "ru.alexandrpokh.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "ru.alexandrpokh.geoquiz.answer_shown";
    private  static final String KEY_IS_CHEAT = "cheat";
    private boolean mAnswerIsTrue;
  //  private boolean mIsCheater;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            System.out.println(mAnswerIsTrue);
            mAnswerIsTrue = savedInstanceState.getBoolean(KEY_IS_CHEAT);
        }
        setContentView(R.layout.activity_cheat);
     //   mIsCheater = false;
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);

        setAnswerShownResult(false);

        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
             //   mIsCheater = true;

                setAnswerShownResult(true);
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent dataCheat = new Intent();
        dataCheat.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, dataCheat);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        System.out.println(mAnswerIsTrue + "sav");
        savedInstanceState.putBoolean(KEY_IS_CHEAT, mAnswerIsTrue);
    }

}
