package com.example.mensajetoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.SeekBar;
import android.widget.Toast;

/*
Autor: Juan Francisco Sánchez González
Fecha: 30/10/2023
Clase: Actividad con un SeekBar que mostrará un mensaje Toast más alto o más bajo en pantalla según el valor
       pulsado en él.
*/

public class MainActivity extends AppCompatActivity {

    private SeekBar seekbar;

    // Márgenes para el mensaje Toast
    private static final int MARGEN  = 50;
    private static final int SIN_MARGEN  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar = (SeekBar) findViewById(R.id.seekBar);

        // Listener cambio de progreso del SeekBar
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // Instancia objeto Toast
            Toast toast = Toast.makeText(getApplicationContext(), getResources().getText(R.string.app_name), Toast.LENGTH_SHORT);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Según la posición del progreso (SeekBar) se cambia la ubicación para mostrar el mensaje Toast
                switch (progress) {
                   case 1:
                       toast.setGravity(Gravity.BOTTOM, SIN_MARGEN, MARGEN);
                       break;
                   case 2:
                       toast.setGravity(Gravity.CENTER, SIN_MARGEN, SIN_MARGEN);
                       break;
                   case 3:
                       toast.setGravity(Gravity.TOP, SIN_MARGEN, MARGEN);
                       break;
               }
               // Se muestra el mensaje Toast
                toast.show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Reiniciamos el SeekBar
                seekbar.setProgress(0);
            }
        });
    }
}