package br.fecap.ads.calculadorimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAbrirCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Corrigido para o layout correto

        // Referência do botão
        btnAbrirCalculadora = findViewById(R.id.btnCalculadoraIMC);

        // acessar a calculadora de IMC
        btnAbrirCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia a CalculoIMCActivity
                Intent intent = new Intent(MainActivity.this, CalculoIMCActivity.class);
                startActivity(intent);

            }
        });
    }
}
