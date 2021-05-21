package com.example.protokols.data_base_package.SilovoyTransformator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.protokols.MainActivity;
import com.example.protokols.R;
import com.example.protokols.ViewingProtokolsList;
import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.utils.ConstantsMy;

public class ViewSilovoyTrans extends AppCompatActivity {
    private Toolbar toolbarMain;
    private TextView tvWorkV, tvAV, tvBV, tvCV;
    private EditText etObjectV, etDateV, etPasportCurrentV, etPasportPowerV, etPasportTypeV, etPasportVoltageV, etPasportVoltageKzV, etPasportYearOfManufactureV,
            etPasportZavNumberV, etTemperatureV, etIzolHvKoefV, etIzolHvR15V, etIzolHvR60V, etIzolLvKoefV, etIzolLvR15V, etIzolLvR60V,
            etSwitchOperatingPositionV, etRpnHvAB1V, etRpnHvAB2V, etRpnHvAB3V, etRpnHvAB4V, etRpnHvAB5V, etRpnHvAB6V, etRpnHvBC1V, etRpnHvBC2V, etRpnHvBC3V,
            etRpnHvBC4V, etRpnHvBC5V, etRpnHvBC6V, etRpnHvCA1V, etRpnHvCA2V, etRpnHvCA3V, etRpnHvCA4V, etRpnHvCA5V, etRpnHvCA6V,
            etNotesV, etRpnLvCnV,etRpnLvBnV,etRpnLvAnV,etWindingConnectionDiagramLvV;
    private int idSilovoyTrans;
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_silovoy_trans);

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

    } // Конец onCreate
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    // Метод : Создает меню в тулбаре из указанного ресурса
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_silovoy_trans, menu);
        return true;
    }

    // Метод : Обрабатывает нажатия пунктов меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuEdit){

            // Переход на экран создания объекта, с отправкой id объекта, который нужно редактировать
            Intent i = new Intent(ViewSilovoyTrans.this, MainSilovoyTrans.class);
            i.putExtra(ConstantsMy.ID_KEY,idSilovoyTrans );

            startActivity(i);
            finish();
        }
        return true;
    }

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
        etObjectV.setText(silovoyTrans.getmObjectOrPodstancia().toString());
        etDateV.setText(silovoyTrans.getmDate().toString());
        etTemperatureV.setText(silovoyTrans.getmTemperature().toString());
        etPasportCurrentV.setText(silovoyTrans.getPasportCurrent().toString());
        etPasportPowerV.setText(silovoyTrans.getPasportPower().toString());
        etPasportTypeV.setText(silovoyTrans.getPasportType().toString());
        etPasportVoltageV.setText(silovoyTrans.getPasportVoltage().toString());
        etPasportVoltageKzV.setText(silovoyTrans.getPasportVoltageKz().toString());
        etPasportYearOfManufactureV.setText(silovoyTrans.getPasportYearOfManufacture().toString());
        etPasportZavNumberV.setText(silovoyTrans.getPasportZavNumber().toString());
        etIzolHvKoefV.setText(silovoyTrans.getIzolHvKoef().toString());
        etIzolHvR15V.setText(silovoyTrans.getIzolHvR15().toString());
        etIzolHvR60V.setText(silovoyTrans.getIzolHvR60().toString());
        etIzolLvKoefV.setText(silovoyTrans.getIzolLvKoef().toString());
        etIzolLvR15V.setText(silovoyTrans.getIzolLvR15().toString());
        etIzolLvR60V.setText(silovoyTrans.getIzolLvR60().toString());
        etSwitchOperatingPositionV.setText(silovoyTrans.getSwitchOperationPosition().toString());
        etRpnHvAB1V.setText(silovoyTrans.getRpnHvAB1().toString());
        etRpnHvAB2V.setText(silovoyTrans.getRpnHvAB2().toString());
        etRpnHvAB3V.setText(silovoyTrans.getRpnHvAB3().toString());
        etRpnHvAB4V.setText(silovoyTrans.getRpnHvAB4().toString());
        etRpnHvAB5V.setText(silovoyTrans.getRpnHvAB5().toString());
        etRpnHvAB6V.setText(silovoyTrans.getRpnHvAB6().toString());
        etRpnHvBC1V.setText(silovoyTrans.getRpnHvBC1().toString());
        etRpnHvBC2V.setText(silovoyTrans.getRpnHvBC2().toString());
        etRpnHvBC3V.setText(silovoyTrans.getRpnHvBC3().toString());
        etRpnHvBC4V.setText(silovoyTrans.getRpnHvBC4().toString());
        etRpnHvBC5V.setText(silovoyTrans.getRpnHvBC5().toString());
        etRpnHvBC6V.setText(silovoyTrans.getRpnHvBC6().toString());
        etRpnHvCA1V.setText(silovoyTrans.getRpnHvCA1().toString());
        etRpnHvCA2V.setText(silovoyTrans.getRpnHvCA2().toString());
        etRpnHvCA3V.setText(silovoyTrans.getRpnHvCA3().toString());
        etRpnHvCA4V.setText(silovoyTrans.getRpnHvCA4().toString());
        etRpnHvCA5V.setText(silovoyTrans.getRpnHvCA5().toString());
        etRpnHvCA6V.setText(silovoyTrans.getRpnHvCA6().toString());
        etNotesV.setText(silovoyTrans.getNotes().toString());
        etRpnLvCnV.setText(silovoyTrans.getRpnLvCn().toString());
        etRpnLvBnV.setText(silovoyTrans.getRpnLvBn().toString());
        etRpnLvAnV.setText(silovoyTrans.getRpnLvAn().toString());
    }

    private void setUneditableEt(){
    etObjectV.setClickable(false);
    etDateV.setClickable(false);
        etTemperatureV.setClickable(false);
        etPasportCurrentV.setClickable(false);
        etPasportPowerV.setClickable(false);
        etPasportTypeV.setClickable(false);
        etPasportVoltageV.setClickable(false);
        etPasportVoltageKzV.setClickable(false);
        etPasportYearOfManufactureV.setClickable(false);
        etPasportZavNumberV.setClickable(false);
        etIzolHvKoefV.setClickable(false);
        etIzolHvR15V.setClickable(false);
        etIzolHvR60V.setClickable(false);
        etIzolLvKoefV.setClickable(false);
        etIzolLvR15V.setClickable(false);
        etIzolLvR60V.setClickable(false);
        etSwitchOperatingPositionV.setClickable(false);
        etRpnHvAB1V.setClickable(false);
        etRpnHvAB2V.setClickable(false);
        etRpnHvAB3V.setClickable(false);
        etRpnHvAB4V.setClickable(false);
        etRpnHvAB5V.setClickable(false);
        etRpnHvAB6V.setClickable(false);

        etRpnHvBC1V.setClickable(false);
        etRpnHvBC2V.setClickable(false);
        etRpnHvBC3V.setClickable(false);
        etRpnHvBC4V.setClickable(false);
        etRpnHvBC5V.setClickable(false);
        etRpnHvBC6V.setClickable(false);

        etRpnHvCA1V.setClickable(false);
        etRpnHvCA2V.setClickable(false);
        etRpnHvCA3V.setClickable(false);
        etRpnHvCA4V.setClickable(false);
        etRpnHvCA5V.setClickable(false);
        etRpnHvCA6V.setClickable(false);

        etNotesV.setClickable(false);
        etRpnLvCnV.setClickable(false);
        etRpnLvBnV.setClickable(false);
        etRpnLvAnV.setClickable(false);

        etObjectV.setFocusable(false);
        etDateV.setFocusable(false);
        etTemperatureV.setFocusable(false);
        etPasportCurrentV.setFocusable(false);
        etPasportPowerV.setFocusable(false);
        etPasportTypeV.setFocusable(false);
        etPasportVoltageV.setFocusable(false);
        etPasportVoltageKzV.setFocusable(false);
        etPasportYearOfManufactureV.setFocusable(false);
        etPasportZavNumberV.setFocusable(false);
        etIzolHvKoefV.setFocusable(false);
        etIzolHvR15V.setFocusable(false);
        etIzolHvR60V.setFocusable(false);
        etIzolLvKoefV.setFocusable(false);
        etIzolLvR15V.setFocusable(false);
        etIzolLvR60V.setFocusable(false);
        etSwitchOperatingPositionV.setFocusable(false);
        etRpnHvAB1V.setFocusable(false);
        etRpnHvAB2V.setFocusable(false);
        etRpnHvAB3V.setFocusable(false);
        etRpnHvAB4V.setFocusable(false);
        etRpnHvAB5V.setFocusable(false);
        etRpnHvAB6V.setFocusable(false);
        etRpnHvBC1V.setFocusable(false);
        etRpnHvBC2V.setFocusable(false);
        etRpnHvBC3V.setFocusable(false);
        etRpnHvBC4V.setFocusable(false);
        etRpnHvBC5V.setFocusable(false);
        etRpnHvBC6V.setFocusable(false);
        etRpnHvCA1V.setFocusable(false);
        etRpnHvCA2V.setFocusable(false);
        etRpnHvCA3V.setFocusable(false);
        etRpnHvCA4V.setFocusable(false);
        etRpnHvCA5V.setFocusable(false);
        etRpnHvCA6V.setFocusable(false);
        etNotesV.setFocusable(false);
        etRpnLvCnV.setFocusable(false);
        etRpnLvBnV.setFocusable(false);
        etRpnLvAnV.setFocusable(false);

        etObjectV.setFocusableInTouchMode(false);
        etDateV.setFocusableInTouchMode(false);
        etTemperatureV.setFocusableInTouchMode(false);
        etPasportCurrentV.setFocusableInTouchMode(false);
        etPasportPowerV.setFocusableInTouchMode(false);
        etPasportTypeV.setFocusableInTouchMode(false);
        etPasportVoltageV.setFocusableInTouchMode(false);
        etPasportVoltageKzV.setFocusableInTouchMode(false);
        etPasportYearOfManufactureV.setFocusableInTouchMode(false);
        etPasportZavNumberV.setFocusableInTouchMode(false);
        etIzolHvKoefV.setFocusableInTouchMode(false);
        etIzolHvR15V.setFocusableInTouchMode(false);
        etIzolHvR60V.setFocusableInTouchMode(false);
        etIzolLvKoefV.setFocusableInTouchMode(false);
        etIzolLvR15V.setFocusableInTouchMode(false);
        etIzolLvR60V.setFocusableInTouchMode(false);
        etSwitchOperatingPositionV.setFocusableInTouchMode(false);
        etRpnHvAB1V.setFocusableInTouchMode(false);
        etRpnHvAB2V.setFocusableInTouchMode(false);
        etRpnHvAB3V.setFocusableInTouchMode(false);
        etRpnHvAB4V.setFocusableInTouchMode(false);
        etRpnHvAB5V.setFocusableInTouchMode(false);
        etRpnHvAB6V.setFocusableInTouchMode(false);
        etRpnHvBC1V.setFocusableInTouchMode(false);
        etRpnHvBC2V.setFocusableInTouchMode(false);
        etRpnHvBC3V.setFocusableInTouchMode(false);
        etRpnHvBC4V.setFocusableInTouchMode(false);
        etRpnHvBC5V.setFocusableInTouchMode(false);
        etRpnHvBC6V.setFocusableInTouchMode(false);
        etRpnHvCA1V.setFocusableInTouchMode(false);
        etRpnHvCA2V.setFocusableInTouchMode(false);
        etRpnHvCA3V.setFocusableInTouchMode(false);
        etRpnHvCA4V.setFocusableInTouchMode(false);
        etRpnHvCA5V.setFocusableInTouchMode(false);
        etRpnHvCA6V.setFocusableInTouchMode(false);
        etNotesV.setFocusableInTouchMode(false);
        etRpnLvCnV.setFocusableInTouchMode(false);
        etRpnLvBnV.setFocusableInTouchMode(false);
        etRpnLvAnV.setFocusableInTouchMode(false);



    }
    private void init(){
        // Для меню обязательно вызвать setSupportActionBar
        toolbarMain = findViewById(R.id.toolbarViewSilovoyTrans);
        setSupportActionBar(toolbarMain);
        toolbarMain.setTitle("Application");

        // TextView
        tvWorkV= findViewById(R.id.tvWorkV);
        tvAV= findViewById(R.id.tvSchemaFazaAV);
        tvBV= findViewById(R.id.tvSchemaFazaBV);
        tvCV= findViewById(R.id.tvSchemaFazaCV);
        // EditText
        etObjectV = findViewById(R.id.etObjectV);
        etDateV = findViewById(R.id.etDateV);
        etTemperatureV = findViewById(R.id.etTemperatureV);
        etPasportCurrentV = findViewById(R.id.etPasportCurrentV);
        etPasportPowerV = findViewById(R.id.etPasportPowerV);
        etPasportTypeV = findViewById(R.id.etPasportTypeV);
        etPasportVoltageV = findViewById(R.id.etPasportVoltageV);
        etPasportVoltageKzV = findViewById(R.id.etPasportVoltageKzV);
        etPasportYearOfManufactureV = findViewById(R.id.etPasportYearOfManufactureV);
        etPasportZavNumberV = findViewById(R.id.etPasportZavNumberV);
        etIzolHvKoefV = findViewById(R.id.etIzolHvKoefV);
        etIzolHvR15V = findViewById(R.id.etIzolHvR15V);
        etIzolHvR60V = findViewById(R.id.etIzolHvR60V);
        etIzolLvKoefV = findViewById(R.id.etIzolLvKoefV);
        etIzolLvR15V = findViewById(R.id.etIzolLvR15V);
        etIzolLvR60V = findViewById(R.id.etIzolLvR60V);
        etSwitchOperatingPositionV = findViewById(R.id.etSwitchOperatingPositionV);
        etRpnHvAB1V = findViewById(R.id.etRpnHvAB1V);
        etRpnHvAB2V = findViewById(R.id.etRpnHvAB2V);
        etRpnHvAB3V = findViewById(R.id.etRpnHvAB3V);
        etRpnHvAB4V = findViewById(R.id.etRpnHvAB4V);
        etRpnHvAB5V = findViewById(R.id.etRpnHvAB5V);
        etRpnHvAB6V = findViewById(R.id.etRpnHvAB6V);

        etRpnHvBC1V = findViewById(R.id.etRpnHvBC1V);
        etRpnHvBC2V = findViewById(R.id.etRpnHvBC2V);
        etRpnHvBC3V = findViewById(R.id.etRpnHvBC3V);
        etRpnHvBC4V = findViewById(R.id.etRpnHvBC4V);
        etRpnHvBC5V = findViewById(R.id.etRpnHvBC5V);
        etRpnHvBC6V = findViewById(R.id.etRpnHvBC6V);

        etRpnHvCA1V = findViewById(R.id.etRpnHvCA1V);
        etRpnHvCA2V = findViewById(R.id.etRpnHvCA2V);
        etRpnHvCA3V = findViewById(R.id.etRpnHvCA3V);
        etRpnHvCA4V = findViewById(R.id.etRpnHvCA4V);
        etRpnHvCA5V = findViewById(R.id.etRpnHvCA5V);
        etRpnHvCA6V = findViewById(R.id.etRpnHvCA6V);

        etNotesV = findViewById(R.id.etNotesV);
        etRpnLvCnV = findViewById(R.id.etRpnLvCnV);
        etRpnLvBnV = findViewById(R.id.etRpnLvBnV);
        etRpnLvAnV = findViewById(R.id.etRpnLvAnV);
    }
}