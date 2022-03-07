package com.example.areastriangulorectangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText ladoUno, ladoDos, baseUno, alturaUno ;
    RadioButton rectangulo,triangulo;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        ladoUno = (EditText) findViewById(R.id.valorLadoUno);
        ladoDos = (EditText) findViewById(R.id.valorLadoDos);
        baseUno = (EditText) findViewById(R.id.valorBaseUno);
        alturaUno = (EditText) findViewById(R.id.valorAlturaUno);
        rectangulo = (RadioButton) findViewById(R.id.radioAreaRectangulo);
        triangulo = (RadioButton) findViewById(R.id.radioAreaTriangulo);
        resultado = (TextView) findViewById(R.id.resultado);

        String valueBefore = preferences.getString("resultado","");
        resultado.setText("El valor anterior fue: " + valueBefore);
    }

    public void calcularAreas(View view){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor ObjetoEditor = preferencias.edit();

        if (rectangulo.isChecked()){
            if (!ladoUno.getText().toString().isEmpty() && !ladoDos.getText().toString().isEmpty()) {
                float sideOne = Float.parseFloat(ladoUno.getText().toString());
                float sideTwo = Float.parseFloat(ladoDos.getText().toString());
                resultado.setText(String.valueOf(sideOne * sideTwo));
                ObjetoEditor.putString("resultado",resultado.getText().toString());
                ObjetoEditor.commit();
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Debe ingresar valores en 'Lado Uno' y 'Lado Dos' ",Toast.LENGTH_LONG).show();
            }
        };

        if(triangulo.isChecked()){
            if (!alturaUno.getText().toString().isEmpty() && !baseUno.getText().toString().isEmpty()){
                float sideOne = Float.parseFloat(baseUno.getText().toString());
                float sideTwo = Float.parseFloat(alturaUno.getText().toString());
                resultado.setText(String.valueOf( sideOne*sideTwo / 2));
                ObjetoEditor.putString("resultado",resultado.getText().toString());
                ObjetoEditor.commit();
                finish();
            } else{
                Toast.makeText(getApplicationContext(),"Debe ingresar valores en 'Base uno' y 'Altura uno' ",Toast.LENGTH_LONG).show();
            }
        }
   };

    public void limpiarValores(View view){
        ladoUno.setText("");
        ladoDos.setText("");
        baseUno.setText("");
        alturaUno.setText("");
        resultado.setText("Resultado");
    }
}