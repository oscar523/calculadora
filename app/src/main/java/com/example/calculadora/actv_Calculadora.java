package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class actv_Calculadora extends AppCompatActivity implements View.OnClickListener {

    TextView txtvisor;
    Button btmais, btmenos, btmultiplicar, btdividir, btpercentagem, btigual;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0;
    Button btlimpar;
    String operador = ""; // Armazena o operador, inicializado vazio
    double lastResult; // Armazena o último resultado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actv_calculadora);

        txtvisor = findViewById(R.id.txt_visor_calculadora);

        // BOTÕES OPERAÇÕES
        btmais = findViewById(R.id.btmais);
        btmais.setOnClickListener(this);
        btmenos = findViewById(R.id.btmenos);
        btmenos.setOnClickListener(this);
        btmultiplicar = findViewById(R.id.btmultiplicar);
        btmultiplicar.setOnClickListener(this);
        btdividir = findViewById(R.id.btdividir);
        btdividir.setOnClickListener(this);
        btpercentagem = findViewById(R.id.btpercentagem);
        btpercentagem.setOnClickListener(this);
        btigual = findViewById(R.id.btigual);
        btigual.setOnClickListener(this);

        // BOTÕES NUMEROS
        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
        bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(this);
        bt5 = findViewById(R.id.bt5);
        bt5.setOnClickListener(this);
        bt6 = findViewById(R.id.bt6);
        bt6.setOnClickListener(this);
        bt7 = findViewById(R.id.bt7);
        bt7.setOnClickListener(this);
        bt8 = findViewById(R.id.bt8);
        bt8.setOnClickListener(this);
        bt9 = findViewById(R.id.bt9);
        bt9.setOnClickListener(this);
        bt0 = findViewById(R.id.bt0);
        bt0.setOnClickListener(this);

        // LIMPAR ECRA
        btlimpar = findViewById(R.id.btlimpar);
        btlimpar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Numeros
        if (v.getId() == R.id.bt1 || v.getId() == R.id.bt2 || v.getId() == R.id.bt3 ||
                v.getId() == R.id.bt4 || v.getId() == R.id.bt5 || v.getId() == R.id.bt6 ||
                v.getId() == R.id.bt7 || v.getId() == R.id.bt8 || v.getId() == R.id.bt9 ||
                v.getId() == R.id.bt0) {
            String numero = ((Button) v).getText().toString();
            txtvisor.append(numero);
        }

        // Operadores
        else if (v.getId() == R.id.btmais || v.getId() == R.id.btmenos ||
                v.getId() == R.id.btmultiplicar || v.getId() == R.id.btdividir) {
            String operador = ((Button) v).getText().toString();
            txtvisor.append(operador);
        }

        // Igual
        else if (v.getId() == R.id.btigual) {
            calcular();
        }

        // Limpa o Visor
        else if (v.getId() == R.id.btlimpar) {
            txtvisor.setText("");
            operador = "";
            lastResult = 0;
        }
    }

    private void calcular() {
        String expressao = txtvisor.getText().toString();

        if (!expressao.isEmpty() && expressao.contains(operador)) {
            String[] partes = expressao.split("[-+*/]");

            double num1 = Double.parseDouble(partes[0]);
            double num2 = Double.parseDouble(partes[1]);
            double resultado = 0;

            if (expressao.contains("+")) {
                resultado = num1 + num2;
            } else if (expressao.contains("-")) {
                resultado = num1 - num2;
            } else if (expressao.contains("*")) {
                resultado = num1 * num2;
            } else if (expressao.contains("/")) {
                if (num2 == 0) {
                    Toast.makeText(this, "Divisão por zero não é permitida", Toast.LENGTH_SHORT).show();
                    return;
                }
                resultado = num1 / num2;
            }

            txtvisor.setText(String.valueOf(resultado));
        } else {
            Toast.makeText(this, "Expressão inválida", Toast.LENGTH_SHORT).show();
        }
    }
}
