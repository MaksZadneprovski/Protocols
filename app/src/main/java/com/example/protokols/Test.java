package com.example.protokols;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class Test extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private TextInputEditText et;
    private ConstraintLayout cLObject;
    private ConstraintLayout cLMeterage;
    private Date currentDate = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.silovoy_trans);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        cLObject = findViewById(R.id.ConstrLayoutObject);
        cLMeterage = findViewById(R.id.ConstrLayoutMeterage);

        cLObject.setVisibility(View.VISIBLE);
        cLMeterage.setVisibility(View.GONE);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){
                    Intent i = new Intent(Test.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc2){
                    Intent i = new Intent(Test.this, ViewingProtokolsList.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc3){
                    cLObject.setVisibility(View.VISIBLE);
                    cLMeterage.setVisibility(View.GONE);
                }
                else  if (item.getItemId() == R.id.bottomNavIc4){
                    cLObject.setVisibility(View.GONE);
                    cLMeterage.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });
    }


}
