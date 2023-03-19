package cnam.smb116.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cnam.smb116.tp5.DBHelpers.EnseignantsHelper;
import cnam.smb116.tp5.Model.Enseignant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addEnseignant(View view) {
        // On récupère les caractéristiques de l'enseignant à ajouter en base et on vérifie qu'elles ont bien été renseignées
        final EditText nomInput = findViewById(R.id.nomInput);
        String nom = nomInput.getText().toString();
        if(nom.equals("")) {
            Toast.makeText(this, "Veuillez saisir un nom", Toast.LENGTH_SHORT).show();
            return;
        }

        final EditText prenomInput = findViewById(R.id.prenomInput);
        String prenom = prenomInput.getText().toString();
        if(prenom.equals("")) {
            Toast.makeText(this, "Veuillez saisir un prénom", Toast.LENGTH_SHORT).show();
            return;
        }

        final EditText courrielInput = findViewById(R.id.courrielInput);
        String courriel = courrielInput.getText().toString();
        if(courriel.equals("")) {
            Toast.makeText(this, "Veuillez saisir un courriel", Toast.LENGTH_SHORT).show();
            return;
        }

        Enseignant enseignant = new Enseignant(nomInput.getText().toString(), prenomInput.getText().toString(), courrielInput.getText().toString());
        EnseignantsHelper helper = new EnseignantsHelper(this);
        long inserted = helper.insertEnseignant(enseignant);
        String toastText = inserted + " ligne inséré en base";
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();

        nomInput.getText().clear();
        prenomInput.getText().clear();
        courrielInput.getText().clear();
    }

    public void showEnseignants(View view) {
        Intent intent = new Intent(MainActivity.this, ShowEnseignants.class);
        startActivity(intent);
    }
}