package fr.iut.pierre.personsvslevel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AjoutPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_person);

        Button ok = (Button) findViewById(R.id.button_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed = (EditText) findViewById(R.id.editText);
                String name = ed.getText().toString();

                RadioGroup rd = (RadioGroup) findViewById(R.id.radioGroup);
                int select = rd.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(select);
                String text;

                text = rb.getText().toString();

                Person.Level level = null;

                if(text.equals("Beginner")){
                    level = Person.Level.BEGINNER;
                }else if (text.equals("User")){
                    level = Person.Level.USER;
                }else if (text.equals("Expert")){
                    level = Person.Level.EXPERT;
                }

                if(!name.equals("") && (level != null)){
                    Person p = new Person(name,level);
                    Intent intent = new Intent(AjoutPerson.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(AjoutPerson.this,
                            "Mauvaise saisie", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}
