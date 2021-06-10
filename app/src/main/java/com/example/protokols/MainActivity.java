package com.example.protokols;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.data_base_package.FreeForm.FreeFormDao;
import com.example.protokols.data_base_package.FreeForm.MainFreeForm;
import com.example.protokols.data_base_package.SilovoyTransformator.MainSilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

// Добавил Resource Directory в res и выбрал  menu
// Добавил в menu Resource Menu File
public class    MainActivity extends AppCompatActivity {
    private Toolbar toolbarMain;
    private FloatingActionButton fabSave;
    private BottomNavigationView bottomNavigationView;
    public static SharedPreferences sharedPreferences;

    // Статичная переменная, чтобы определить, хочу ли я редактировать объект EditSilovoyTrans или создаю новый
    public static boolean isEditSilovoyTrans = false;
    public static int idForDB =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Отключение анимации перехода
        overridePendingTransition(0,0);

        isEditSilovoyTrans = false;

        sharedPreferences = getSharedPreferences("IdPreferences",MODE_PRIVATE);
        if (sharedPreferences.contains("ID")){
            idForDB=sharedPreferences.getInt("ID",0);
            Toast.makeText(this, idForDB+"", Toast.LENGTH_LONG).show();
        }


        bottomNavigationView = findViewById(R.id.bottomNavView);
        fabSave = findViewById(R.id.fabMain);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(3).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(4).setEnabled(false);
        bottomNavigationView.getMenu().getItem(4).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(0).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){

                }
                else  if (item.getItemId() == R.id.bottomNavIc2){
                    Intent i = new Intent(MainActivity.this, ViewingProtokolsList.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc3){

                }
                else  if (item.getItemId() == R.id.bottomNavIc4){

                }
                return true;
            }
        });

    }

    public static void incrementId(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        idForDB++;
        editor.putInt("ID",MainActivity.idForDB);
        editor.apply();
    }

}
