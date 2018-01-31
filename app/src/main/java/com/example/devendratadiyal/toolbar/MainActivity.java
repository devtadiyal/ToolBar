package com.example.devendratadiyal.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Toolbar tb;
    ListView lv;
    ArrayAdapter<String> arrayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = (Toolbar) findViewById(R.id.toolbar);
        lv = (ListView) findViewById(R.id.listview);

        tb.setTitle("    Devendra");
        setSupportActionBar(tb);
        tb.setSubtitle("     Tadiyal");
        getSupportActionBar().setIcon(getDrawable(R.drawable.ic_action_name));
        ArrayList<String> al = new ArrayList<>();
        al.addAll(Arrays.asList(getResources().getStringArray(R.array.namelist)));
        arrayadapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(arrayadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mii = getMenuInflater();
        mii.inflate(R.menu.settings,menu);

        MenuItem mi = menu.findItem(R.id.search1);
        SearchView sv = (SearchView) mi.getActionView();

      sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String query) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {

               arrayadapter.getFilter().filter(newText);
               return false;
           }
       });

        return true;

    }
}
