package com.example.calculadoradegorjetaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar  seekBarGorjeta;

    private double porcentagem = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     editValor           =  findViewById(R.id.editValor);
     textPorcentagem     =  findViewById(R.id.textPorcentagem);
     textGorjeta         =  findViewById(R.id.textGorjeta);
     textTotal           =  findViewById(R.id.textTotal);
     seekBarGorjeta      =  findViewById(R.id.seekBarGorjeta);


     //Adicionar listener Seek Bar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                 porcentagem = progress;
                 textPorcentagem.setText( Math.round( porcentagem ) + " % ");
                 calcular();



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calcular(){

        String valorRecuperado = editValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valro primeiro!",
                    Toast.LENGTH_SHORT
            ).show();

        }else{

            //Converter string para double
            double valorDigitado = Double.parseDouble( valorRecuperado );

            //Calcular a gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //Exibe a gorjeta e total
            textGorjeta.setText("R$ " + gorjeta );
            textTotal.setText("R$ " + total);

        }

}}
