package com.example.adrian.poundseurosanddollars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final static double EURO=1.124765;
    final static double LIBRA=1.53355;
    TextView euros;
    TextView dolares;
    TextView libras;
    TextView resultadoEur;
    TextView resultadoDol;
    TextView resultadoLib;
    EditText campoTexto;
    RadioButton botEuros;
    RadioButton botDolars;
    RadioButton botLibras;
    Button cambiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        euros=(TextView)findViewById(R.id.euro);
        dolares=(TextView)findViewById(R.id.dolar);
        libras=(TextView)findViewById(R.id.libra);
        resultadoEur=(TextView)findViewById(R.id.resEuro);
        resultadoDol=(TextView)findViewById(R.id.resDolar);
        resultadoLib=(TextView)findViewById(R.id.resLibra);
        campoTexto=(EditText)findViewById(R.id.editText);
        botEuros=(RadioButton)findViewById(R.id.botEuros);
        botDolars=(RadioButton)findViewById(R.id.botDolar);
        botLibras=(RadioButton)findViewById(R.id.botLibra);
        cambiar=(Button)findViewById(R.id.button);

        cambiar.setOnClickListener(this);
    }



    public void onClick(View v) {
        try{
        if(campoTexto.getText().toString().isEmpty()||Double.parseDouble(campoTexto.getText().toString())<0) {
            Toast toast=Toast.makeText(this,R.string.Error,Toast.LENGTH_SHORT);
            toast.show();
        }else{
            DecimalFormat money=new DecimalFormat("0.00");
            double dollar=0;

                if (botEuros.isChecked()) {
                    dollar = Double.parseDouble(campoTexto.getText().toString()) * EURO;
                } else if (botLibras.isChecked()) {
                    dollar = Double.parseDouble(campoTexto.getText().toString()) * LIBRA;
                } else {
                    dollar = Double.parseDouble(campoTexto.getText().toString());
                }
                resultadoDol.setText(String.valueOf(money.format(dollar)));
                resultadoEur.setText(String.valueOf(money.format(dollar / EURO)));
                resultadoLib.setText(String.valueOf(money.format(dollar / LIBRA)));
        }
        } catch(Exception e){

            Toast toast=Toast.makeText(this,R.string.Error2,Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
