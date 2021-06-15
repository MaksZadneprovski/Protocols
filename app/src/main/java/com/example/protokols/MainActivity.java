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
public class MainActivity extends AppCompatActivity {
    private Toolbar toolbarMain;
    private FloatingActionButton fabCalc;
    private BottomNavigationView bottomNavigationView;
    public static SharedPreferences sharedPreferences;
    private TextView tvDiscrepancyMain2;
    private TextInputEditText min1, min2, min3, min4, min5, max1, max2, max3, max4, max5;

    // Статичная переменная, чтобы определить, хочу ли я редактировать объект EditSilovoyTrans или создаю новый
    public static boolean isEditSilovoyTrans = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Отключение анимации перехода
        overridePendingTransition(0, 0);

        isEditSilovoyTrans = false;


        tvDiscrepancyMain2 = findViewById(R.id.tvDiscrepancyMain2);
        max1 = findViewById(R.id.max1);
        min1 = findViewById(R.id.min1);
        max2 = findViewById(R.id.max2);
        min2 = findViewById(R.id.min2);
        max3 = findViewById(R.id.max3);
        min3 = findViewById(R.id.min3);
        max4 = findViewById(R.id.max4);
        min4 = findViewById(R.id.min4);
        max5 = findViewById(R.id.max5);
        min5 = findViewById(R.id.min5);

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
                if (item.getItemId() == R.id.bottomNavIc1) {

                } else if (item.getItemId() == R.id.bottomNavIc2) {
                    Intent i = new Intent(MainActivity.this, ViewingProtokolsList.class);
                    startActivity(i);
                    finish();
                } else if (item.getItemId() == R.id.bottomNavIc3) {

                } else if (item.getItemId() == R.id.bottomNavIc4) {

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


    public void calculate() {
        double[] min = new double[5];

        if (!(min1.getText()).toString().isEmpty()) {
            min[0] = Double.parseDouble((min1.getText()).toString());
        } else {
            min[0] = 1;
        }
        if (!(min2.getText()).toString().isEmpty()) {
            min[1] = Double.parseDouble((min2.getText()).toString());
        } else {
            min[1] = 1;
        }
        if (!(min3.getText()).toString().isEmpty()) {
            min[2] = Double.parseDouble((min3.getText()).toString());
        } else {
            min[2] = 1;
        }
        if (!(min4.getText()).toString().isEmpty()) {
            min[3] = Double.parseDouble((min4.getText()).toString());
        } else {
            min[3] = 1;
        }
        if (!(min5.getText()).toString().isEmpty()) {
            min[4] = Double.parseDouble((min5.getText()).toString());
        } else {
            min[4] = 1;
        }


    double[] max = new double[5];
        if (!(max1.getText()).toString().isEmpty()) {
            max[0] = Double.parseDouble((max1.getText()).toString());
        } else {
            max[0] = 1;
        }
        if (!(max2.getText()).toString().isEmpty()) {
            max[1] = Double.parseDouble((max2.getText()).toString());
        } else {
            max[1] = 1;
        }
        if (!(max3.getText()).toString().isEmpty()) {
            max[2] = Double.parseDouble((max3.getText()).toString());
        } else {
            max[2] = 1;
        }
        if (!(max4.getText()).toString().isEmpty()) {
            max[3] = Double.parseDouble((max4.getText()).toString());
        } else {
            max[3] = 1;
        }
        if (!(max5.getText()).toString().isEmpty()) {
            max[4] = Double.parseDouble((max5.getText()).toString());
        } else {
            max[4] = 1;
        }

    String result[] = new String[5];
    String s;

        for(
    int i = 0;
    i< 5;i++)

    {
        if (max[i] != 0 & min[i] != 0) {
            double res = (max[i] - min[i]) / min[i] * 100;
            s = String.format("%.3f", res);
            if (s.indexOf(',') != -1) s = s.replace(",", ".");
            result[i] = s;
        } else result[i] = "1";


    }
        tvDiscrepancyMain2.setText(
                "1  "+result[0].

    toString()+"%"+
            "\n\n2  "+result[1].

    toString()+"%"+
            "\n\n3  "+result[2].

    toString()+"%"+
            "\n\n4  "+result[3].

    toString()+"%"+
            "\n\n5  "+result[4].

    toString()+"%"+
            "\n\n\n\n\n\n\n"
            );

}

}
