package fr.iut.pierre.personsvslevel;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_moins = (Button) findViewById(R.id.button_moins);
        btn_moins.setEnabled(false);

        final List<Person> myArrayList = Person.initPersons();

        final ArrayAdapter<Person > myAdapter = new ArrayAdapter<Person>
                (MainActivity.this, android.R.layout.simple_list_item_1 , myArrayList);

        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setAdapter(myAdapter);

        myListView = (ListView) findViewById(R.id.listView);
        final ListView finalMyListView = myListView;
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                final Person item = myAdapter.getItem(i);
                Button btn = (Button) findViewById(R.id.button_moins);
                btn.setEnabled(true);
                TextView tv = (TextView) findViewById(R.id.textView_selectP);
                tv.setText(item.toString());
                if(item.getLevel() == Person.Level.BEGINNER){
                    tv.setTextColor(Person.Level.BEGINNER.getColor());
                }else if(item.getLevel() == Person.Level.EXPERT){
                    tv.setTextColor(Person.Level.EXPERT.getColor());
                }else if(item.getLevel() == Person.Level.USER){
                    tv.setTextColor(Person.Level.USER.getColor());
                }

                btn_moins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myAdapter.remove(item);
                    }
                });
            }
        });

        Switch sw = (Switch) findViewById(R.id.switch_sort);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //myAdapter.sort(Comparator<Person> myAdapter );

                }else{

                }
            }
        });

        Button button_plus = (Button) findViewById(R.id.button_plus);
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AjoutPerson.class);
                startActivity(intent);
            }
        });

    }
}
