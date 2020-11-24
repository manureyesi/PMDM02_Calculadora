package net.iessanclemente.pmdm.pmdm02_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.iessanclemente.pmdm.pmdm02_calculadora.service.CalculadoraPrimos;

import static net.iessanclemente.pmdm.pmdm02_calculadora.R.*;

public class MainActivity extends AppCompatActivity {

    private Button botonCalcular;
    private EditText numeroCalcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        this.botonCalcular = findViewById(id.buttonCalcular);

        this.numeroCalcular = findViewById(id.numeroCalcular);

        this.resultado = findViewById(id.resultadoTexto);

        // Function para el click
        this.botonCalcular.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {
        final String TAG = "onClick:";

        String textoNumeroCalcular = this.numeroCalcular.getText().toString();
        if (!textoNumeroCalcular.isEmpty()) {

            Integer numeroCalcular = null;
            // Transformar Número
            try {
                numeroCalcular = Integer.valueOf(textoNumeroCalcular);
            } catch (NumberFormatException e) {
                Log.e(TAG, String.format("Error ao parsear a cadea %s, non se corresponde cun formato de número", textoNumeroCalcular));
            }

            Integer resultado = null;
            if (numeroCalcular != null) {
                Log.i(TAG, String.format("Se calcula la posicion %s de un número primo", numeroCalcular));
                resultado = CalculadoraPrimos.calcularPrimo(numeroCalcular);

                this.resultado.setText(String.format(
                        getString(string.app_texto_respuesta_calcular),
                        numeroCalcular.toString(), resultado.toString()));

            }
        }

    }

}