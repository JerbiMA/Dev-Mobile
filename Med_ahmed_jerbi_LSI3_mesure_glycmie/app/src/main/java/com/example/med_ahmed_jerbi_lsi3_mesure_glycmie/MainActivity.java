package com.example.med_ahmed_jerbi_lsi3_mesure_glycmie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private SeekBar sbAge;
    private RadioButton rbtOui, rbtNon;
    private EditText valeur;
    private Button btnConsulter;
    private TextView tvMessage;

    private void init() {
        tv = findViewById(R.id.tv);
        sbAge = findViewById(R.id.sbAge);
        rbtOui = findViewById(R.id.rbtOui);
        rbtNon = findViewById(R.id.rbtNon);
        valeur = findViewById(R.id.valeur);
        btnConsulter = findViewById(R.id.btnConsulter);

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged " + progress);
                // affichage dans le Log de Android studio pour voir les changements détectés sur le SeekBar ..
                tv.setText("Votre âge : " + progress);
                // Mise à jour du TextView par la valeur : progress à chaque changement.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valeurMesuree = valeur.getText().toString();
                double val = Double.parseDouble(valeurMesuree);
                int age = sbAge.getProgress();
                boolean jeune = rbtOui.isChecked();
                //jai un prop dans le toast

                if (age == 0 && valeurMesuree.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "age et valeur mesure invalide", Toast.LENGTH_SHORT).show();
                } else if (age == 0) {
                    Toast.makeText(getApplicationContext(), "age null", Toast.LENGTH_SHORT).show();
                } else if (valeurMesuree.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " valeur mesure invalide", Toast.LENGTH_SHORT).show();
                } else


                if (jeune) {
                    if (age < 6 && age != 0) {
                        if (val >= 5.5 && val <= 10.0) {
                            tvMessage.setText("niveau de glycémie est normal");
                        } else if (val < 5.5){
                            tvMessage.setText("niveau de glycémie est trop bas");
                        }else
                        {
                            tvMessage.setText("niv de glycemi est trop eleve");
                        }
                    } else if (age >= 6 && age < 12) {
                        if (val >= 5.0 && val <= 10.0) {
                            tvMessage.setText("niv de glycemi est normal");
                        } else if (val < 5.0){
                            tvMessage.setText("niv de glycemi est trop bas ");
                        }else{
                            tvMessage.setText("niv de glycemi est trop eleve");
                        }
                    } else if (age >= 12) {
                        if (val >= 5.0 && val <= 7.2) {
                            tvMessage.setText("niv de glycemi est normal");
                        } else if (val < 5.0){
                            tvMessage.setText("niv de glycemi est trop bas");
                        }
                        else {
                            tvMessage.setText("niv de glycemi est trop eleve");
                        }
                    }
                } else {
                    if (val < 10.5) {
                        tvMessage.setText("niv de glycemi est normal");
                    } else {
                        tvMessage.setText("niv de glycemi est trop eleve");
                    }
                }

                valeur.setText("");
                sbAge.setProgress(0);
                rbtOui.setChecked(false);
                rbtNon.setChecked(false);
            }
        });
    }
}