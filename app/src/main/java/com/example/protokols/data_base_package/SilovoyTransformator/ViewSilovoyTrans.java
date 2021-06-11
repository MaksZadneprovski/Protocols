package com.example.protokols.data_base_package.SilovoyTransformator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.protokols.MainActivity;
import com.example.protokols.R;
import com.example.protokols.ViewingProtokolsList;
import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.utils.ConstantsMy;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;

public class ViewSilovoyTrans extends AppCompatActivity {
    private TextView tvWork, tv10,tvDiscrepancy1, tvDiscrepancy2;
    private BottomNavigationView bottomNavigationView;
    private ConstraintLayout cLObject;
    private ConstraintLayout cLMeterage;
    private ImageButton fabSetConstant;
    private FloatingActionButton  fabEdit ;
    private TextInputEditText etObject, etDate, etPasportCurrent, etPasportPower, etPasportType, etPasportVoltage, etPasportVoltageKz, etPasportYearOfManufacture,
            etPasportZavNumber, etTemperature, etIzolHvKoef, etIzolHvR15, etIzolHvR60, etIzolLvKoef, etIzolLvR15, etIzolLvR60,
            etSwitchOperatingPosition, etRpnHvAB1, etRpnHvAB2, etRpnHvAB3, etRpnHvAB4, etRpnHvAB5, etRpnHvAB6, etRpnHvBC1, etRpnHvBC2, etRpnHvBC3,
            etRpnHvBC4, etRpnHvBC5, etRpnHvBC6, etRpnHvCA1, etRpnHvCA2, etRpnHvCA3, etRpnHvCA4, etRpnHvCA5, etRpnHvCA6,
            etNotes, etRpnLvCn,etRpnLvBn,etRpnLvAn,etSetConstantForRpn;
    private int idSilovoyTrans;
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.silovoy_trans);

        //Отключение анимации перехода
        overridePendingTransition(0,0);

        init();

        //  Установка нередактируемых полей
        setUneditableEt();

        // Получение объекта из БД
        SilovoyTrans silovoyTrans = getSilovoyTransFromBd();

        // Заполнение полей данными из объекта
        setTextToEditTextFromSilovoyTrans(silovoyTrans);

        // Получение id объекта для отправки на экран MainSilovoyTrans, в случае редактирования
        idSilovoyTrans = silovoyTrans.getId();

        // Статичная переменная, чтобы определить, хочу ли я редактировать объект или создаю новый
        MainActivity.isEditSilovoyTrans= true;

        // Меняем значок fab
        fabEdit.setImageResource(R.drawable.ic_edit);

        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на экран создания объекта, с отправкой id объекта, который нужно редактировать
                Intent i = new Intent(ViewSilovoyTrans.this, MainSilovoyTrans.class);
                i.putExtra(ConstantsMy.ID_KEY,idSilovoyTrans );

                startActivity(i);
                finish();
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){
                    Intent i = new Intent( ViewSilovoyTrans.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc2){
                    Intent i = new Intent( ViewSilovoyTrans.this, ViewingProtokolsList.class);
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

        // Расчет расхождения
        Discrepancy discrepancy = new Discrepancy();
        String[] s = discrepancy.countingDiscrepancy(silovoyTrans);
        tvDiscrepancy2.setText(
                "1 ступень "+ s[0]+"%"+
                "\n\n2 ступень "+ s[1]+"%"+
                "\n\n3 ступень "+ s[2]+"%"+
                "\n\n4 ступень "+ s[3]+"%"+
                "\n\n5 ступень "+ s[4]+"%"
        );

    } // Конец onCreate
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    SilovoyTrans getSilovoyTransFromBd(){
        // Создание объекта  DAO для работы с БД
        SilovoyTransDao silovoyTransDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getSilovoyTransTableDao();

        // Получаем данные Intent
        Intent i = getIntent();

        // Получаем id объекта SilovoyTrans, по элементу из списка  ViewingProtokolsList, который был нажат
        int idOfSelectedItem = i.getIntExtra(ConstantsMy.ID_KEY, 0);

        // По id создается объект silovoyTrans, данные для которого берутся из БД
        SilovoyTrans silovoyTrans = silovoyTransDao.getSilovoyTransTableById(idOfSelectedItem);

        return silovoyTrans;
    }

    // Методы обработки кнопки назад
//    @Override
//    public void onBackPressed() {
//        // super.onBackPressed();
//        Intent i = new Intent(ViewSilovoyTrans.this, ViewingProtokolsList.class);
//        startActivity(i);
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK==keyCode){
            Intent i = new Intent(ViewSilovoyTrans.this, ViewingProtokolsList.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    private void setTextToEditTextFromSilovoyTrans(SilovoyTrans silovoyTrans){

        // Заполняем EditText-ы данными из объекта silovoyTrans
        etObject.setText(silovoyTrans.getmObjectOrPodstancia().toString());
        etDate.setText(silovoyTrans.getmDate().toString());
        etTemperature.setText(silovoyTrans.getmTemperature().toString());
        etPasportCurrent.setText(silovoyTrans.getPasportCurrent().toString());
        etPasportPower.setText(silovoyTrans.getPasportPower().toString());
        etPasportType.setText(silovoyTrans.getPasportType().toString());
        etPasportVoltage.setText(silovoyTrans.getPasportVoltage().toString());
        etPasportVoltageKz.setText(silovoyTrans.getPasportVoltageKz().toString());
        etPasportYearOfManufacture.setText(silovoyTrans.getPasportYearOfManufacture().toString());
        etPasportZavNumber.setText(silovoyTrans.getPasportZavNumber().toString());
        etIzolHvKoef.setText(silovoyTrans.getIzolHvKoef().toString());
        etIzolHvR15.setText(silovoyTrans.getIzolHvR15().toString());
        etIzolHvR60.setText(silovoyTrans.getIzolHvR60().toString());
        etIzolLvKoef.setText(silovoyTrans.getIzolLvKoef().toString());
        etIzolLvR15.setText(silovoyTrans.getIzolLvR15().toString());
        etIzolLvR60.setText(silovoyTrans.getIzolLvR60().toString());
        etSwitchOperatingPosition.setText(silovoyTrans.getSwitchOperationPosition().toString());
        etRpnHvAB1.setText(silovoyTrans.getRpnHvAB1().toString());
        etRpnHvAB2.setText(silovoyTrans.getRpnHvAB2().toString());
        etRpnHvAB3.setText(silovoyTrans.getRpnHvAB3().toString());
        etRpnHvAB4.setText(silovoyTrans.getRpnHvAB4().toString());
        etRpnHvAB5.setText(silovoyTrans.getRpnHvAB5().toString());
        etRpnHvAB6.setText(silovoyTrans.getRpnHvAB6().toString());
        etRpnHvBC1.setText(silovoyTrans.getRpnHvBC1().toString());
        etRpnHvBC2.setText(silovoyTrans.getRpnHvBC2().toString());
        etRpnHvBC3.setText(silovoyTrans.getRpnHvBC3().toString());
        etRpnHvBC4.setText(silovoyTrans.getRpnHvBC4().toString());
        etRpnHvBC5.setText(silovoyTrans.getRpnHvBC5().toString());
        etRpnHvBC6.setText(silovoyTrans.getRpnHvBC6().toString());
        etRpnHvCA1.setText(silovoyTrans.getRpnHvCA1().toString());
        etRpnHvCA2.setText(silovoyTrans.getRpnHvCA2().toString());
        etRpnHvCA3.setText(silovoyTrans.getRpnHvCA3().toString());
        etRpnHvCA4.setText(silovoyTrans.getRpnHvCA4().toString());
        etRpnHvCA5.setText(silovoyTrans.getRpnHvCA5().toString());
        etRpnHvCA6.setText(silovoyTrans.getRpnHvCA6().toString());
        etNotes.setText(silovoyTrans.getNotes().toString());
        etRpnLvCn.setText(silovoyTrans.getRpnLvCn().toString());
        etRpnLvBn.setText(silovoyTrans.getRpnLvBn().toString());
        etRpnLvAn.setText(silovoyTrans.getRpnLvAn().toString());

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    private void setUneditableEt(){

        etObject.setClickable(false);
        etDate.setClickable(false);
        etTemperature.setClickable(false);
        etPasportCurrent.setClickable(false);
        etPasportPower.setClickable(false);
        etPasportType.setClickable(false);
        etPasportVoltage.setClickable(false);
        etPasportVoltageKz.setClickable(false);
        etPasportYearOfManufacture.setClickable(false);
        etPasportZavNumber.setClickable(false);
        etIzolHvKoef.setClickable(false);
        etIzolHvR15.setClickable(false);
        etIzolHvR60.setClickable(false);
        etIzolLvKoef.setClickable(false);
        etIzolLvR15.setClickable(false);
        etIzolLvR60.setClickable(false);
        etSwitchOperatingPosition.setClickable(false);
        etRpnHvAB1.setClickable(false);
        etRpnHvAB2.setClickable(false);
        etRpnHvAB3.setClickable(false);
        etRpnHvAB4.setClickable(false);
        etRpnHvAB5.setClickable(false);
        etRpnHvAB6.setClickable(false);
        etRpnHvBC1.setClickable(false);
        etRpnHvBC2.setClickable(false);
        etRpnHvBC3.setClickable(false);
        etRpnHvBC4.setClickable(false);
        etRpnHvBC5.setClickable(false);
        etRpnHvBC6.setClickable(false);
        etRpnHvCA1.setClickable(false);
        etRpnHvCA2.setClickable(false);
        etRpnHvCA3.setClickable(false);
        etRpnHvCA4.setClickable(false);
        etRpnHvCA5.setClickable(false);
        etRpnHvCA6.setClickable(false);
        etNotes.setClickable(false);
        etRpnLvCn.setClickable(false);
        etRpnLvBn.setClickable(false);
        etRpnLvAn.setClickable(false);
        etSetConstantForRpn.setClickable(false);

        etObject.setLongClickable(false);
        etDate.setLongClickable(false);
        etTemperature.setLongClickable(false);
        etPasportCurrent.setLongClickable(false);
        etPasportPower.setLongClickable(false);
        etPasportType.setLongClickable(false);
        etPasportVoltage.setLongClickable(false);
        etPasportVoltageKz.setLongClickable(false);
        etPasportYearOfManufacture.setLongClickable(false);
        etPasportZavNumber.setLongClickable(false);
        etIzolHvKoef.setLongClickable(false);
        etIzolHvR15.setLongClickable(false);
        etIzolHvR60.setLongClickable(false);
        etIzolLvKoef.setLongClickable(false);
        etIzolLvR15.setLongClickable(false);
        etIzolLvR60.setLongClickable(false);
        etSwitchOperatingPosition.setLongClickable(false);
        etRpnHvAB1.setLongClickable(false);
        etRpnHvAB2.setLongClickable(false);
        etRpnHvAB3.setLongClickable(false);
        etRpnHvAB4.setLongClickable(false);
        etRpnHvAB5.setLongClickable(false);
        etRpnHvAB6.setLongClickable(false);
        etRpnHvBC1.setLongClickable(false);
        etRpnHvBC2.setLongClickable(false);
        etRpnHvBC3.setLongClickable(false);
        etRpnHvBC4.setLongClickable(false);
        etRpnHvBC5.setLongClickable(false);
        etRpnHvBC6.setLongClickable(false);
        etRpnHvCA1.setLongClickable(false);
        etRpnHvCA2.setLongClickable(false);
        etRpnHvCA3.setLongClickable(false);
        etRpnHvCA4.setLongClickable(false);
        etRpnHvCA5.setLongClickable(false);
        etRpnHvCA6.setLongClickable(false);
        etNotes.setLongClickable(false);
        etRpnLvCn.setLongClickable(false);
        etRpnLvBn.setLongClickable(false);
        etRpnLvAn.setLongClickable(false);
        etSetConstantForRpn.setLongClickable(false);

        etObject.setFocusable(false);
        etDate.setFocusable(false);
        etTemperature.setFocusable(false);
        etPasportCurrent.setFocusable(false);
        etPasportPower.setFocusable(false);
        etPasportType.setFocusable(false);
        etPasportVoltage.setFocusable(false);
        etPasportVoltageKz.setFocusable(false);
        etPasportYearOfManufacture.setFocusable(false);
        etPasportZavNumber.setFocusable(false);
        etIzolHvKoef.setFocusable(false);
        etIzolHvR15.setFocusable(false);
        etIzolHvR60.setFocusable(false);
        etIzolLvKoef.setFocusable(false);
        etIzolLvR15.setFocusable(false);
        etIzolLvR60.setFocusable(false);
        etSwitchOperatingPosition.setFocusable(false);
        etRpnHvAB1.setFocusable(false);
        etRpnHvAB2.setFocusable(false);
        etRpnHvAB3.setFocusable(false);
        etRpnHvAB4.setFocusable(false);
        etRpnHvAB5.setFocusable(false);
        etRpnHvAB6.setFocusable(false);
        etRpnHvBC1.setFocusable(false);
        etRpnHvBC2.setFocusable(false);
        etRpnHvBC3.setFocusable(false);
        etRpnHvBC4.setFocusable(false);
        etRpnHvBC5.setFocusable(false);
        etRpnHvBC6.setFocusable(false);
        etRpnHvCA1.setFocusable(false);
        etRpnHvCA2.setFocusable(false);
        etRpnHvCA3.setFocusable(false);
        etRpnHvCA4.setFocusable(false);
        etRpnHvCA5.setFocusable(false);
        etRpnHvCA6.setFocusable(false);
        etNotes.setFocusable(false);
        etRpnLvCn.setFocusable(false);
        etRpnLvBn.setFocusable(false);
        etRpnLvAn.setFocusable(false);
        etSetConstantForRpn.setFocusable(false);

        etObject.setFocusableInTouchMode(false);
        etDate.setFocusableInTouchMode(false);
        etTemperature.setFocusableInTouchMode(false);
        etPasportCurrent.setFocusableInTouchMode(false);
        etPasportPower.setFocusableInTouchMode(false);
        etPasportType.setFocusableInTouchMode(false);
        etPasportVoltage.setFocusableInTouchMode(false);
        etPasportVoltageKz.setFocusableInTouchMode(false);
        etPasportYearOfManufacture.setFocusableInTouchMode(false);
        etPasportZavNumber.setFocusableInTouchMode(false);
        etIzolHvKoef.setFocusableInTouchMode(false);
        etIzolHvR15.setFocusableInTouchMode(false);
        etIzolHvR60.setFocusableInTouchMode(false);
        etIzolLvKoef.setFocusableInTouchMode(false);
        etIzolLvR15.setFocusableInTouchMode(false);
        etIzolLvR60.setFocusableInTouchMode(false);
        etSwitchOperatingPosition.setFocusableInTouchMode(false);
        etRpnHvAB1.setFocusableInTouchMode(false);
        etRpnHvAB2.setFocusableInTouchMode(false);
        etRpnHvAB3.setFocusableInTouchMode(false);
        etRpnHvAB4.setFocusableInTouchMode(false);
        etRpnHvAB5.setFocusableInTouchMode(false);
        etRpnHvAB6.setFocusableInTouchMode(false);
        etRpnHvBC1.setFocusableInTouchMode(false);
        etRpnHvBC2.setFocusableInTouchMode(false);
        etRpnHvBC3.setFocusableInTouchMode(false);
        etRpnHvBC4.setFocusableInTouchMode(false);
        etRpnHvBC5.setFocusableInTouchMode(false);
        etRpnHvBC6.setFocusableInTouchMode(false);
        etRpnHvCA1.setFocusableInTouchMode(false);
        etRpnHvCA2.setFocusableInTouchMode(false);
        etRpnHvCA3.setFocusableInTouchMode(false);
        etRpnHvCA4.setFocusableInTouchMode(false);
        etRpnHvCA5.setFocusableInTouchMode(false);
        etRpnHvCA6.setFocusableInTouchMode(false);
        etNotes.setFocusableInTouchMode(false);
        etRpnLvCn.setFocusableInTouchMode(false);
        etRpnLvBn.setFocusableInTouchMode(false);
        etRpnLvAn.setFocusableInTouchMode(false);
        etSetConstantForRpn.setFocusableInTouchMode(false);

        etObject.setCursorVisible(false);
        etDate.setCursorVisible(false);
        etTemperature.setCursorVisible(false);
        etPasportCurrent.setCursorVisible(false);
        etPasportPower.setCursorVisible(false);
        etPasportType.setCursorVisible(false);
        etPasportVoltage.setCursorVisible(false);
        etPasportVoltageKz.setCursorVisible(false);
        etPasportYearOfManufacture.setCursorVisible(false);
        etPasportZavNumber.setCursorVisible(false);
        etIzolHvKoef.setCursorVisible(false);
        etIzolHvR15.setCursorVisible(false);
        etIzolHvR60.setCursorVisible(false);
        etIzolLvKoef.setCursorVisible(false);
        etIzolLvR15.setCursorVisible(false);
        etIzolLvR60.setCursorVisible(false);
        etSwitchOperatingPosition.setCursorVisible(false);
        etRpnHvAB1.setCursorVisible(false);
        etRpnHvAB2.setCursorVisible(false);
        etRpnHvAB3.setCursorVisible(false);
        etRpnHvAB4.setCursorVisible(false);
        etRpnHvAB5.setCursorVisible(false);
        etRpnHvAB6.setCursorVisible(false);
        etRpnHvBC1.setCursorVisible(false);
        etRpnHvBC2.setCursorVisible(false);
        etRpnHvBC3.setCursorVisible(false);
        etRpnHvBC4.setCursorVisible(false);
        etRpnHvBC5.setCursorVisible(false);
        etRpnHvBC6.setCursorVisible(false);
        etRpnHvCA1.setCursorVisible(false);
        etRpnHvCA2.setCursorVisible(false);
        etRpnHvCA3.setCursorVisible(false);
        etRpnHvCA4.setCursorVisible(false);
        etRpnHvCA5.setCursorVisible(false);
        etRpnHvCA6.setCursorVisible(false);
        etNotes.setCursorVisible(false);
        etRpnLvCn.setCursorVisible(false);
        etRpnLvBn.setCursorVisible(false);
        etRpnLvAn.setCursorVisible(false);
        etSetConstantForRpn.setCursorVisible(false);



    }
    private void init(){

        // TextView
        tvWork= findViewById(R.id.tvWork);
        tv10= findViewById(R.id.tv10);
        tvDiscrepancy1= findViewById(R.id.tvDiscrepancy1);
        tvDiscrepancy2= findViewById(R.id.tvDiscrepancy2);

        // EditText
        etObject = findViewById(R.id.etObject);
        etDate = findViewById(R.id.etDate);
        etTemperature = findViewById(R.id.etTemperature);
        etPasportCurrent = findViewById(R.id.etPasportCurrent);
        etPasportPower = findViewById(R.id.etPasportPower);
        etPasportType = findViewById(R.id.etPasportType);
        etPasportVoltage = findViewById(R.id.etPasportVoltage);
        etPasportVoltageKz = findViewById(R.id.etPasportVoltageKz);
        etPasportYearOfManufacture = findViewById(R.id.etPasportYearOfManufacture);
        etPasportZavNumber = findViewById(R.id.etPasportZavNumber);
        etIzolHvKoef = findViewById(R.id.etIzolHvKoef);
        etIzolHvR15 = findViewById(R.id.etIzolHvR15);
        etIzolHvR60 = findViewById(R.id.etIzolHvR60);
        etIzolLvKoef = findViewById(R.id.etIzolLvKoef);
        etIzolLvR15 = findViewById(R.id.etIzolLvR15);
        etIzolLvR60 = findViewById(R.id.etIzolLvR60);
        etSwitchOperatingPosition = findViewById(R.id.etSwitchOperatingPosition);
        etRpnHvAB1 = findViewById(R.id.etRpnHvAB1);
        etRpnHvAB2 = findViewById(R.id.etRpnHvAB2);
        etRpnHvAB3 = findViewById(R.id.etRpnHvAB3);
        etRpnHvAB4 = findViewById(R.id.etRpnHvAB4);
        etRpnHvAB5 = findViewById(R.id.etRpnHvAB5);
        etRpnHvAB6 = findViewById(R.id.etRpnHvAB6);

        etRpnHvBC1 = findViewById(R.id.etRpnHvBC1);
        etRpnHvBC2 = findViewById(R.id.etRpnHvBC2);
        etRpnHvBC3 = findViewById(R.id.etRpnHvBC3);
        etRpnHvBC4 = findViewById(R.id.etRpnHvBC4);
        etRpnHvBC5 = findViewById(R.id.etRpnHvBC5);
        etRpnHvBC6 = findViewById(R.id.etRpnHvBC6);

        etRpnHvCA1 = findViewById(R.id.etRpnHvCA1);
        etRpnHvCA2 = findViewById(R.id.etRpnHvCA2);
        etRpnHvCA3 = findViewById(R.id.etRpnHvCA3);
        etRpnHvCA4 = findViewById(R.id.etRpnHvCA4);
        etRpnHvCA5 = findViewById(R.id.etRpnHvCA5);
        etRpnHvCA6 = findViewById(R.id.etRpnHvCA6);

        etNotes = findViewById(R.id.etNotes);
        etRpnLvCn = findViewById(R.id.etRpnLvCn);
        etRpnLvBn = findViewById(R.id.etRpnLvBn);
        etRpnLvAn = findViewById(R.id.etRpnLvAn);
        etSetConstantForRpn = findViewById(R.id.etSetConstantForRpn);
        fabEdit = findViewById(R.id.fabSilovoyTrans);
        fabSetConstant = findViewById(R.id.fabSetConstant);
        bottomNavigationView = findViewById(R.id.bottomNavView);
        cLObject = findViewById(R.id.ConstrLayoutObject);
        cLMeterage = findViewById(R.id.ConstrLayoutMeterage);

        cLObject.setVisibility(View.VISIBLE);
        cLMeterage.setVisibility(View.GONE);
        etSetConstantForRpn.setVisibility(View.GONE);
        fabSetConstant.setVisibility(View.GONE);
        tv10.setVisibility(View.GONE);

        tvWork.setText("Просмотр\nпротокола");

        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);
    }

}