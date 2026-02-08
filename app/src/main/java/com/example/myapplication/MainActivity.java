package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.function.IntToDoubleFunction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calchomem(View view) {
        EditText editAltura = findViewById(R.id.editAltura);
        EditText editPeso = findViewById(R.id.editPeso);
        TextView txtresultado = findViewById(R.id.txtresultado);

        double na = Double.parseDouble(editAltura.getText().toString());
        double np = Double.parseDouble(editPeso.getText().toString());

        double r = np / (na*na);

        String msg = "";

        DecimalFormat df = new DecimalFormat("#.##");

        if (r <20.7){
           msg = "abaixo do peso! seu IMC é: ";
        } else if (r <26.4) {
           msg = "no peso ideal! seu IMC é: ";
        } else if (r < 27.8) {
           msg = "levemente acima do peso,seu IMC é: ";
        } else if (r < 31.1) {
           msg = "acima do peso, seu IMC é: ";
        } else if (r > 31.1) {
           msg = "voce está obeso, seu IMC é: ";
        }

        txtresultado.setText(msg + df.format(r));

    }

    public void calcMulher(View view) {
        EditText editAltura = findViewById(R.id.editAltura);
        EditText editPeso = findViewById(R.id.editPeso);
        TextView txtresultado = findViewById(R.id.txtresultado);

        double na = Double.parseDouble(editAltura.getText().toString());
        double np = Double.parseDouble(editPeso.getText().toString());

        double r = np / (na*na);

        String msg = "";

        DecimalFormat df = new DecimalFormat("#.##");

        if (r <19.1){
            msg = "abaixo do peso! seu IMC é: ";
        } else if (r <25.8) {
            msg = "no peso ideal! seu IMC é: ";
        } else if (r < 27.3) {
            msg = "levemente acima do peso,seu IMC é: ";
        } else if (r < 32.3) {
            msg = "acima do peso, seu IMC é: ";
        } else if (r > 32.3) {
            msg = "voce está obesa, seu IMC é: ";
        }

        txtresultado.setText(msg + df.format(r));

    }

    public void limpa(View view) {
        EditText editAltura = findViewById(R.id.editAltura);
        EditText editPeso = findViewById(R.id.editPeso);
        TextView txtresultado = findViewById(R.id.txtresultado);

        txtresultado.setText("");
        editAltura.setText("");
        editPeso.setText("");

    }
}