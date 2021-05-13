package com.example.protokols;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.protokols.data_base_package.SilovoyTransformator.MainSilovoyTrans;

// Добавил Resource Directory в res и выбрал  menu
// Добавил в menu Resource Menu File
public class MainActivity extends AppCompatActivity {
    private Toolbar toolbarMain;

    // Статичная переменная, чтобы определить, хочу ли я редактировать объект EditSilovoyTrans или создаю новый
    public static boolean isEditSilovoyTrans = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Отключение анимации перехода
        overridePendingTransition(0,0);

        // Для меню обязательно вызвать setSupportActionBar
        toolbarMain = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);
        toolbarMain.setTitle("Application");

        isEditSilovoyTrans = false;

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
}
