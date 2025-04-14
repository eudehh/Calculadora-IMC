package br.fecap.ads.calculadorimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculoIMCActivity extends AppCompatActivity {

    private EditText editPeso, editAltura;
    private Button btnCalcular, btnLimpar, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        // Referências dos componentes
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFechar = findViewById(R.id.btnFechar);

        // Lógica do botão Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        // Lógica do botão Limpar
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        // Lógica do botão Fechar
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Fecha a atividade e volta para a tela anterior
            }
        });
    }

    // Método para calcular o IMC
    private void calcularIMC() {
        String pesoStr = editPeso.getText().toString();
        String alturaStr = editAltura.getText().toString();

        // Verificar se os campos estão preenchidos
        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(CalculoIMCActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Converter para float
        // Converter para float
        float peso = Float.parseFloat(pesoStr);
        float alturaCm = Float.parseFloat(alturaStr);
        float altura = alturaCm / 100f; // Converte cm para metros

        // Calcular IMC
        float imc = peso / (altura * altura);

        // Definir categoria do IMC
        String categoria = getCategoriaIMC(imc);

        // Passar dados para a tela de feedback
        Intent intent = new Intent(CalculoIMCActivity.this, getFeedbackActivity(categoria));
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        intent.putExtra("imc", imc);
        intent.putExtra("categoria", categoria);
        startActivity(intent);
    }

    // Método para retornar a categoria do IMC
    private String getCategoriaIMC(float imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidade grau 1";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }

    // Método para decidir para qual tela de feedback ir
    private Class<?> getFeedbackActivity(String categoria) {
        switch (categoria) {
            case "Abaixo do peso":
                return AbaixoDoPesoActivity.class;
            case "Peso normal":
                return PesoNormalActivity.class;
            case "Sobrepeso":
                return SobrepesoActivity.class;
            case "Obesidade grau 1":
                return ObesidadeGrau1Activity.class;
            case "Obesidade grau 2":
                return ObesidadeGrau2Activity.class;
            case "Obesidade grau 3":
                return ObesidadeGrau3Activity.class;
            default:
                return MainActivity.class;  // Caso algum erro ocorra, volta para a tela principal
        }
    }

    // Método para limpar os campos
    private void limparCampos() {
        editPeso.setText("");
        editAltura.setText("");
    }
}
