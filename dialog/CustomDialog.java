package com.example.anurag_pc.shreyafinalproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import com.example.anurag_pc.shreyafinalproject.MainActivity;
import com.example.anurag_pc.shreyafinalproject.R;
import com.example.anurag_pc.shreyafinalproject.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Anurag-PC on 7/4/2017.
 */

public class CustomDialog extends Dialog {

    private final ICustomDialogListener listener;
    private final String EMAIL="email";
    private final String PASSWORD="password";
    private final String USER="user";

    @BindView(R.id.main_login_email)
    EditText emailEditText;

    @BindView(R.id.main_login_password)
    EditText passwordEditText;

    public interface ICustomDialogListener{
        public void onOKClicked(String msg);
        //public void onCancleClicked();
    }

    @OnClick(R.id.main_inner_login)
    public void login(View view)
    {

        String email= emailEditText.getText().toString();
        String password= passwordEditText.getText().toString();
        //if(check(email,password))
        listener.onOKClicked("Login Success");
       // Intent intent = new Intent(CustomDialog.this, ViewPagerActivity.class);
        //startActivity(intent);
        //listener.onOKClicked();
        cancel();

//        public void login(View v){
//        String email= emailEditText.getText().toString();
//        String password= passwordEditText.getText().toString();
//        if(check(email,password)){
//            shortToast("Login Success");
        }

        @OnClick(R.id.main_inner_forgot_password)
        public void forgotPassword(View view)
        {
            listener.onOKClicked("Don't remember password");
        }


//    private boolean check(String email, String password) {
//        boolean passwordCorrect=true;
//        if(passwordCorrect){
//            SharedPreferences sp= getSharedPreferences(USER,MODE_PRIVATE);
//            SharedPreferences.Editor editor=sp.edit();
//            editor.putString(EMAIL,email);
//            editor.putString(PASSWORD,password);
//            editor.commit();
//            return true;
//
//        }else{
//            return false;
//        }
//
//    }
//
//    private SharedPreferences getSharedPreferences(String user, int modePrivate) {
//    }


    public CustomDialog(@NonNull Context context,ICustomDialogListener listener) {
        super(context, R.style.dialog);
        setContentView(R.layout.main_login);
        //setContentView(R.layout.activity_quiz2);
        ButterKnife.bind(this);
        this.listener=listener;

    }

}
