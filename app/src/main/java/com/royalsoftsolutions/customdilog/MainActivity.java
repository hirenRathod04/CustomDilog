package com.royalsoftsolutions.customdilog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        dialog = new Dialog ( MainActivity.this );
        dialog.setContentView ( R.layout.custom_dialog );//OPEN DILOG XML FILE
        dialog.getWindow ().setBackgroundDrawable ( getDrawable ( R.drawable.background ) );//set dilog background with shape and color
       // dialog.getWindow ().setLayout ( ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT );
        dialog.setCancelable ( false );
        dialog.getWindow ().getAttributes ().windowAnimations = R.style.animation;
        button = findViewById ( R.id.button);
        Button buttonOk = dialog.findViewById ( R.id.buttonOk );
        Button buttonCancel = dialog.findViewById ( R.id.buttonCancel );
        buttonOk.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText ( MainActivity.this,"ok",Toast.LENGTH_SHORT ).show ();
                dialog.dismiss ();
            }
        } );
        buttonCancel.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText ( MainActivity.this,"cancel",Toast.LENGTH_SHORT ).show ();
                dialog.dismiss ();

            }
        } );
        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        } );
    }
}