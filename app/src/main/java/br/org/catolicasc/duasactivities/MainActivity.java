package br.org.catolicasc.duasactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ListView lvPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPokemon = findViewById(R.id.lvPokemon);

        final ArrayList<String> pokemons = new ArrayList<>();

        pokemons.add("Pikachu");
        pokemons.add("Tokepi");
        pokemons.add("Ekans");
        pokemons.add("Raichu");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_list_item_1, pokemons
        );

        lvPokemon.setAdapter(arrayAdapter);
        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("nome", pokemons.get(position));
                startActivity(intent);
            }
        });
    }
}
