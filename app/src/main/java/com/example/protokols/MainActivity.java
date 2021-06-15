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
import android.widget.TextView;
import android.widget.Toast;

import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.data_base_package.FreeForm.FreeFormDao;
import com.example.protokols.data_base_package.FreeForm.MainFreeForm;
import com.example.protokols.data_base_package.SilovoyTransformator.MainSilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

// Добавил Resource Directory в res и выбрал  menu
// Добавил в menu Resource Menu File
public class    MainActivity extends AppCompatActivity {
    private Toolbar toolbarMain;
    private FloatingActionButton fabCalc;
    private BottomNavigationView bottomNavigationView;
    public static SharedPreferences sharedPreferences;
    private TextView tvDiscrepancyMain2;
    private TextInputEditText min1,min2,min3,min4,min5,max1, max2,max3,max4,max5;

    // Статичная переменная, чтобы определить, хочу ли я редактировать объект EditSilovoyTrans или создаю новый
    public static boolean isEditSilovoyTrans = false;
    public static int idForDB;


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
        }

        max1 = findViewById(R.id.max1);
        min1 =findViewById(R.id.min1);
        max2 = findViewById(R.id.max2);
        min2 =findViewById(R.id.min2);
        max3 = findViewById(R.id.max3);
        min3 =findViewById(R.id.min3);
        max4 = findViewById(R.id.max4);
        min4 =findViewById(R.id.min4);
        max5 = findViewById(R.id.max5);
        min5 =findViewById(R.id.min5);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        fabCalc = findViewById(R.id.fabMain);
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

        fabCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

    }

    public static void incrementId(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        idForDB++;
        editor.putInt("ID",MainActivity.idForDB);
        editor.apply();
    }

    public void calculate(){
        double[] min={
                Double.parseDouble((min1.getText()).toString()),
                Double.parseDouble((min2.getText()).toString()),
                Double.parseDouble((min3.getText()).toString()),
                Double.parseDouble((min4.getText()).toString()),
                Double.parseDouble((min5.getText()).toString())
               };
        double[] max={
                Double.parseDouble((max1.getText()).toString()),
                Double.parseDouble((max2.getText()).toString()),
                Double.parseDouble((max3.getText()).toString()),
                Double.parseDouble((max4.getText()).toString()),
                Double.parseDouble((max5.getText()).toString())

        };
        String result[] = new String[5];

        for (int i = 0; i < 5; i++) {
            double res = (max[i]-min[i])/min[i]*100;
             result[i] = String.format ("%.3f",String.valueOf(res));


        }
        tvDiscrepancyMain2.setText(
                        "1  "+ result[0]+"%"+
                        "\n\n2  "+ result[1]+"%"+
                        "\n\n3  "+ result[2]+"%"+
                        "\n\n4  "+ result[3]+"%"+
                        "\n\n5  "+ result[4]+"%");

    }

}
