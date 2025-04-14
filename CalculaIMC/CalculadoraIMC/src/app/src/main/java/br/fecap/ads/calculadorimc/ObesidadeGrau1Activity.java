package br.fecap.ads.calculadorimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ObesidadeGrau1Activity extends AppCompatActivity {

    private TextView txtPeso, txtAltura, txtIMC, txtCategoria;
    private ImageView imgCategoria;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obesidade_grau_1);

        // Referências dos componentes
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtIMC = findViewById(R.id.txtIMC);
        txtCategoria = findViewById(R.id.txtCategoria);
        imgCategoria = findViewById(R.id.imgCategoria);
        btnFechar = findViewById(R.id.btnFechar);

        // Receber dados da intent
        Intent intent = getIntent();
        float peso = intent.getFloatExtra("peso", 0);
        float altura = intent.getFloatExtra("altura", 0);
        float imc = intent.getFloatExtra("imc", 0);
        String categoria = intent.getStringExtra("categoria");

        // Exibir dados na tela
        txtPeso.setText("Peso: " + peso + " kg");
        txtAltura.setText("Altura: " + altura + " m");
        txtIMC.setText("IMC: " + String.format("%.2f", imc));
        txtCategoria.setText(categoria);

        // Exibir imagem e mensagem motivacional
        imgCategoria.setImageResource(R.drawable.obesidade_um);
        // Mensagem motivacional
        txtCategoria.append("\n\"Atenção! Seu IMC indica obesidade grau 1. Isso pode impactar sua saúde no futuro. É um bom momento para procurar um profissional da saúde e começar a cuidar melhor do seu corpo. Você consegue!\"");

        // Lógica do botão Fechar
        btnFechar.setOnClickListener(v -> finish());
    }
}
