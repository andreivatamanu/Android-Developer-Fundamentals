package com.example.challengesmodule2;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class challenge1 extends AppCompatActivity {

    private EditText mEditTextMail;
    private EditText mEditTextPhone;
    private CheckBox mCheckBoxTerms;
    private TextView mCheckboxError;
    private TextView mTextViewInfoText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge1);
        initView();
    }

    private void initView() {

        mEditTextMail = findViewById(R.id.edit_text_email);
        mEditTextPhone = findViewById(R.id.edit_text_phone);
        mTextViewInfoText = findViewById(R.id.text_view_response);
        mTextViewInfoText.setVisibility(View.GONE);
        mCheckboxError = findViewById(R.id.checkbox_not);
        mCheckboxError.setVisibility(View.GONE);
        mCheckBoxTerms = findViewById(R.id.checkbox_terms);

    }

    public void submitInfo(View view) {

        mCheckboxError.setText(getString(R.string.empty));
        mCheckboxError.setVisibility(View.GONE);
        mTextViewInfoText.setText(getString(R.string.empty));
        mTextViewInfoText.setVisibility(View.GONE);

        validate();

        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private void validate() {

        String eMail = mEditTextMail.getText().toString();
        String phone = mEditTextPhone.getText().toString();
        boolean isChecked = mCheckBoxTerms.isChecked();

        if (isChecked) {
            if (mCheckBoxTerms != null && mEditTextMail != null && mEditTextPhone != null) {
                if (!phone.isEmpty() && isValidEmail(eMail)) {
                    mTextViewInfoText.setVisibility(View.VISIBLE);
                    mTextViewInfoText.setText(getString(R.string.enter, eMail, phone, true));
                }
                if (phone.isEmpty()) {
                    mEditTextPhone.setError(getString(R.string.phone_error_hint));
                    mEditTextPhone.requestFocus();
                }
                if (eMail.isEmpty() || !isValidEmail(eMail)) {
                    mEditTextMail.setError(getString(R.string.email_error_hint));
                    mEditTextMail.requestFocus();
                }
            }
        } else {
            mCheckboxError.setVisibility(View.VISIBLE);
            mCheckboxError.setText(getString(R.string.accept_error));
        }
    }

}
