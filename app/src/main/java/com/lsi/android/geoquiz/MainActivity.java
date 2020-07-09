package com.lsi.android.geoquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;

//import android.view.Menu;
//import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button btnSiguiente;
    private Button btnAtras;
    private TextView txtPregunta;

    private Pregunta[] preguntas={

            new Pregunta(R.string.pregunta1,true),
            new Pregunta(R.string.pregunta2,true),
            new Pregunta(R.string.pregunta3,true),
            new Pregunta(R.string.pregunta4,true),
            new Pregunta(R.string.pregunta5,false),
    };

    int actual = 0;
    //int actual2 = preguntas.length ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        btnSiguiente= (Button)findViewById(R.id.btn_siguiente);
        btnAtras=(Button)findViewById(R.id.btn_atras);
        txtPregunta=(TextView) findViewById(R.id.txt_pregunta);

        setText();



        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText( MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();

                verificarRespuesta(true);
            }

        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                    verificarRespuesta(false);

                }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actual = (actual + 1)% preguntas.length;
                setText();


            }
        });


        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (actual == 0) {
                    actual = preguntas.length - 1;
                } else {
                    actual--;
                }
                setText();

            }
        });





        //public void setContentView(int layoutResID){}
}
    void setText( ) {
        txtPregunta.setText(preguntas[actual].getTextoId());

    }

    void verificarRespuesta(boolean result){
        boolean respuesta =   preguntas[actual].isRespuesta();
        if(respuesta == result){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();

        }

    }
}

