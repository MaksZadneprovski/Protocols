package com.example.protokols;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.protokols.data_base_package.FreeForm.MainFreeForm;
import com.example.protokols.data_base_package.SilovoyTransformator.MainSilovoyTrans;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

// Добавил Resource Directory в res и выбрал  menu
// Добавил в menu Resource Menu File
public class    MainActivity extends AppCompatActivity {
    private Toolbar toolbarMain;
    private FloatingActionButton fabSave;
    private BottomNavigationView bottomNavigationView;

    // Статичная переменная, чтобы определить, хочу ли я редактировать объект EditSilovoyTrans или создаю новый
    public static boolean isEditSilovoyTrans = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Отключение анимации перехода
        overridePendingTransition(0,0);

        isEditSilovoyTrans = false;

        bottomNavigationView = findViewById(R.id.bottomNavView);
        fabSave = findViewById(R.id.fabMain);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
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
    // Метод : Создает меню в тулбаре из указанного ресурса
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return true;
    }

    // Метод : Обрабатывает нажатия пунктов меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuList){
            Intent i = new Intent(MainActivity.this, ViewingProtokolsList.class);
            startActivity(i);
        }
        return true;
    }

    public void onClickCreateProtocol(View view) {
        Intent i = new Intent(MainActivity.this, MainSilovoyTrans.class);
        startActivity(i);
    }

    public void onClickCreateProtocolFreeForm(View view) {
        Intent i = new Intent(MainActivity.this, MainFreeForm.class);
        startActivity(i);
    }
}
