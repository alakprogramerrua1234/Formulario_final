package com.example.pc_1.eeeees;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView fecha;
    int dia,mes,año,faltan=0,id;
    String formu[]={"","","","","","","",""};
    Calendar calendario;
    Button afecha;
    Spinner ciudades;
    EditText nombre,n2,contraseña,c2,rcontraseña,correo,co2,sx2,fecha2,ciudad2,pasatiempos2;
    RadioButton femenino,masculino;
    CheckBox juegos,dibujo,cantar,nadar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fecha = findViewById(R.id.eFechaid);
        afecha = findViewById(R.id.bFecha);
        ciudades = findViewById(R.id.sciudadid);
        nombre = findViewById(R.id.eUserid);
        contraseña = findViewById(R.id.ePasswordid);
        rcontraseña = findViewById(R.id.eRPasswordid);
        correo = findViewById(R.id.eEmailid);
        masculino = findViewById(R.id.rMasculino);
        femenino = findViewById(R.id.rFemenino);
        juegos = findViewById(R.id.cGames);
        dibujo = findViewById(R.id.cDraw);
        nadar = findViewById(R.id.cNadar);
        cantar = findViewById(R.id.cSing);
        n2 = findViewById(R.id.n2id);
        c2 = findViewById(R.id.c2id);
        co2 = findViewById(R.id.co2id);
        sx2 = findViewById(R.id.sexo2id);
        fecha2 = findViewById(R.id.fecha2id);
        ciudad2 = findViewById(R.id.ciudad2id);
        pasatiempos2 = findViewById(R.id.pasatiempos2id);

        calendario = Calendar.getInstance();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);

        fecha.setText(dia+"/"+mes+"/"+año);

        afecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialogopicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = i1+1;
                        fecha.setText(i2+"/"+i1+"/"+i);
                    }
                },año,mes,dia);
                dialogopicker.show();
            }
        });

        ArrayAdapter <CharSequence> adaptador = ArrayAdapter.createFromResource(this , R.array.ciudades_col , android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudades.setAdapter(adaptador);
    }

    public void onRadioButtonClicked(View view) {
        switch (view.getId()){
            case R.id.rFemenino:
                if(femenino.isChecked()){
                    formu[4] = "SEXO : Masculino";
                }
                break;
            case R.id.rMasculino:
                if(masculino.isChecked()){
                    formu[4] = "SEXO : Femenino";
                }
                break;
        }
    }

    public void onCheckBoxClicked(View view) {

        switch (view.getId()){
            case R.id.cGames:
                if(juegos.isChecked()){
                    id = view.getId();
                }
                break;
            case R.id.cDraw:
                if(dibujo.isChecked()){
                    id = view.getId();
                }
                break;
            case R.id.cSing:
                if(cantar.isChecked()){
                    id = view.getId();
                }
                break;
            case R.id.cNadar:
                if(nadar.isChecked()){
                    id = view.getId();
                }
                break;
        }
    }

    public void Aceptar(View view) {

        switch (id){
            case R.id.cGames:
                if(juegos.isChecked()){
                    formu[7] ="";
                    if(dibujo.isChecked())
                    formu[7] = formu[7]+"dibujar,";
                    if(cantar.isChecked())
                        formu[7] = formu[7]+"cantar,";
                    if(nadar.isChecked())
                        formu[7] = formu[7]+"nadar,";
                    formu[7] =formu[7]+"bailar.";
                }else {
                    formu[7] ="";
                    if(dibujo.isChecked())
                        formu[7] = formu[7]+"dibujar,";
                    if(cantar.isChecked())
                        formu[7] = formu[7]+"cantar,";
                    if(nadar.isChecked())
                        formu[7] = formu[7]+"nadar.";
                };
                break;
            case R.id.cDraw:
                if(dibujo.isChecked()){
                    formu[7] ="";
                    if(juegos.isChecked())
                        formu[7] = formu[7]+"bailar,";
                    if(cantar.isChecked())
                        formu[7] = formu[7]+"cantar,";
                    if(nadar.isChecked())
                        formu[7] = formu[7]+"nadar,";
                    formu[7] =formu[7]+"dibujar.";
                }else {
                    formu[7] ="";
                    if(juegos.isChecked())
                        formu[7] = formu[7]+"bailar,";
                    if(cantar.isChecked())
                        formu[7] = formu[7]+"cantar,";
                    if(nadar.isChecked())
                        formu[7] = formu[7]+"nadar.";
                };
                break;
            case R.id.cSing:
                if(cantar.isChecked()){
                    formu[7] ="";
                    if(dibujo.isChecked())
                        formu[7] = formu[7]+"dibujar,";
                    if(juegos.isChecked())
                        formu[7] = formu[7]+"bailar,";
                    if(nadar.isChecked())
                        formu[7] = formu[7]+"nadar,";
                    formu[7] =formu[7]+"cantar.";
                }else {
                    formu[7] ="";
                    if(dibujo.isChecked())
                        formu[7] = formu[7]+"dibujar,";
                    if(juegos.isChecked())
                        formu[7] = formu[7]+"bailar,";
                    if(nadar.isChecked())
                        formu[7] = formu[7]+"nadar.";
                };
                break;
            case R.id.cNadar:
                if(nadar.isChecked()){
                    formu[7] ="";
                    if(dibujo.isChecked())
                        formu[7] = formu[7]+"dibujar,";
                    if(cantar.isChecked())
                        formu[7] = formu[7]+"cantar,";
                    if(juegos.isChecked())
                        formu[7] = formu[7]+"bailar,";
                    formu[7] =formu[7]+"nadar.";
                }else {
                    formu[7] ="";
                    if(dibujo.isChecked())
                        formu[7] = formu[7]+"dibujar,";
                    if(cantar.isChecked())
                        formu[7] = formu[7]+"cantar,";
                    if(juegos.isChecked())
                        formu[7] = formu[7]+"bailar.";
                };
                break;
        }

        formu[0] = nombre.getText().toString();
        formu[1] = contraseña.getText().toString();
        formu[2] = rcontraseña.getText().toString();
        formu[3] = correo.getText().toString();
        formu[5] = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(año);
        formu[6] = ciudades.getSelectedItem().toString();

        for(int i=0 ; i<8 ; i++){
            if(formu[i].matches("")){
                Toast.makeText(this,"Faltan datos", Toast.LENGTH_SHORT).show();
                faltan=1;
                break;
            }
        }

        if(faltan==0) {

            if (Objects.equals(formu[1], formu[2])) {
                n2.setText("Su usuario es "+formu[0]);
                c2.setText("Su contraseña es "+formu[1]);
                co2.setText("Su correo es "+formu[3]);
                sx2.setText(formu[4]);
                fecha2.setText( "FECHA : "+formu[5]);
                ciudad2.setText("Usted vive en "+formu[6]);
                pasatiempos2.setText("HOBBIES: "+formu[7]);
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                faltan = 2;
            }
        }
        faltan=0;

    }
}
