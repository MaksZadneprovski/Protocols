package com.example.protokols.data_base_package.SilovoyTransformator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.protokols.MainActivity;
import com.example.protokols.R;
import com.example.protokols.ViewingProtokolsList;

public class ViewSilovoyTrans extends AppCompatActivity {
    private Toolbar toolbarMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_silovoy_trans);

        // Для меню обязательно вызвать setSupportActionBar
        toolbarMain = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);
        toolbarMain.setTitle("Application");
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
            Intent i = new Intent(ViewSilovoyTrans.this, ViewingProtokolsList.class);
            startActivity(i);
        }
        return true;
    }

    public void onClickCreateProtocol(View view) {
        Intent i = new Intent(ViewSilovoyTrans.this, MainSilovoyTrans.class);
        startActivity(i);
    }
}