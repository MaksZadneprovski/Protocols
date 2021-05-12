package com.example.protokols.data_base_package.SilovoyTransformator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.protokols.MainActivity;
import com.example.protokols.R;
import com.example.protokols.ViewingProtokolsList;
import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.utils.ConstantsForSilovoyTrans;

import java.util.Date;

public class ViewSilovoyTrans extends AppCompatActivity {
    private Toolbar toolbarMain;
    private TextView tvWorkV, tvAV, tvBV, tvCV;
    private EditText etObjectV, etDateV, etPasportCurrentV, etPasportPowerV, etPasportTypeV, etPasportVoltageV, etPasportVoltageKzV, etPasportYearOfManufactureV,
            etPasportZavNumberV, etTemperatureV, etIzolHvKoefV, etIzolHvR15V, etIzolHvR60V, etIzolLvKoefV, etIzolLvR15V, etIzolLvR60V,
            etSwitchOperatingPositionV, etRpnHvAB1V, etRpnHvAB2V, etRpnHvAB3V, etRpnHvAB4V, etRpnHvAB5V, etRpnHvAB6V, etRpnHvAB7V, etRpnHvAB8V,
            etRpnHvAB9V, etRpnHvAB10V, etRpnHvAB11V, etRpnHvAB12V, etRpnHvAB13V, etRpnHvAB14V, etRpnHvAB15V, etRpnHvAB16V, etRpnHvAB17V, etRpnHvAB18V,
            etRpnHvAB19V, etRpnHvAB20V, etRpnHvAB21V, etRpnHvAB22V, etRpnHvAB23V, etRpnHvAB24V, etRpnHvAB25V, etRpnHvBC1V, etRpnHvBC2V, etRpnHvBC3V,
            etRpnHvBC4V, etRpnHvBC5V, etRpnHvBC6V, etRpnHvBC7V, etRpnHvBC8V, etRpnHvBC9V, etRpnHvBC10V, etRpnHvBC11V, etRpnHvBC12V, etRpnHvBC13V,
            etRpnHvBC14V, etRpnHvBC15V, etRpnHvBC16V, etRpnHvBC17V, etRpnHvBC18V, etRpnHvBC19V, etRpnHvBC20V, etRpnHvBC21V, etRpnHvBC22V, etRpnHvBC23V,
            etRpnHvBC24V, etRpnHvBC25V, etRpnHvCA1V, etRpnHvCA2V, etRpnHvCA3V, etRpnHvCA4V, etRpnHvCA5V, etRpnHvCA6V, etRpnHvCA7V, etRpnHvCA8V, etRpnHvCA9V,
            etRpnHvCA10V, etRpnHvCA11V, etRpnHvCA12V, etRpnHvCA13V, etRpnHvCA14V, etRpnHvCA15V, etRpnHvCA16V, etRpnHvCA17V, etRpnHvCA18V, etRpnHvCA19V,
            etRpnHvCA20V, etRpnHvCA21V, etRpnHvCA22V, etRpnHvCA23V, etRpnHvCA24V, etRpnHvCA25V,etNotesV, etRpnLvCnV,etRpnLvBnV,etRpnLvAnV,etWindingConnectionDiagramLvV;
    private int idSilovoyTrans;
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_silovoy_trans);

        init();

        //  Установка нередактируемых полей
        setUneditableEt();

        // Получение объекта из БД
        SilovoyTrans silovoyTrans = getSilovoyTransFromBd();

        // Заполнение полей данными из объекта
        setTextToEditTextFromSilovoyTrans(silovoyTrans);

        // Получение id объекта
        idSilovoyTrans = silovoyTrans.getId();

        // Статичная переменная, чтобы определить, хочу ли я редактировать объект или создаю новый
        // Так как с этого экрана можно нажать кнопку редактировать, то переменная true
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
        if (item.getItemId() == R.id.menuList){

            // Переход на экран списка протоколов
            Intent i = new Intent(ViewSilovoyTrans.this, ViewingProtokolsList.class);
            startActivity(i);
            finish();
        }
        else if (item.getItemId() == R.id.menuEdit){

            // Переход на экран создания объекта, с отправкой id объекта, который нужно редактировать
            Intent i = new Intent(ViewSilovoyTrans.this, MainSilovoyTrans.class);
            i.putExtra(ConstantsForSilovoyTrans.ID_KEY,idSilovoyTrans );
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
        int idOfSelectedItem = i.getIntExtra(ConstantsForSilovoyTrans.ID_KEY, 0);

        // По id создается объект silovoyTrans, данные для которого берутся из БД
        SilovoyTrans silovoyTrans = silovoyTransDao.getSilovoyTransTableById(idOfSelectedItem);

        return silovoyTrans;
    }
    private void setTextToEditTextFromSilovoyTrans(SilovoyTrans silovoyTrans){

        // Заполняем EditText-ы данными из объекта silovoyTrans
        etObjectV.setText(silovoyTrans.getObject().toString());
        etDateV.setText(silovoyTrans.getDate().toString());
        etTemperatureV.setText(silovoyTrans.getTemperature().toString());
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
        etRpnHvAB7V.setText(silovoyTrans.getRpnHvAB7().toString());
        etRpnHvAB8V.setText(silovoyTrans.getRpnHvAB8().toString());
        etRpnHvAB9V.setText(silovoyTrans.getRpnHvAB9().toString());
        etRpnHvAB10V.setText(silovoyTrans.getRpnHvAB10().toString());
        etRpnHvAB11V.setText(silovoyTrans.getRpnHvAB11().toString());
        etRpnHvAB12V.setText(silovoyTrans.getRpnHvAB12().toString());
        etRpnHvAB13V.setText(silovoyTrans.getRpnHvAB13().toString());
        etRpnHvAB14V.setText(silovoyTrans.getRpnHvAB14().toString());
        etRpnHvAB15V.setText(silovoyTrans.getRpnHvAB15().toString());
        etRpnHvAB16V.setText(silovoyTrans.getRpnHvAB16().toString());
        etRpnHvAB17V.setText(silovoyTrans.getRpnHvAB17().toString());
        etRpnHvAB18V.setText(silovoyTrans.getRpnHvAB18().toString());
        etRpnHvAB19V.setText(silovoyTrans.getRpnHvAB19().toString());
        etRpnHvAB20V.setText(silovoyTrans.getRpnHvAB20().toString());
        etRpnHvAB21V.setText(silovoyTrans.getRpnHvAB21().toString());
        etRpnHvAB22V.setText(silovoyTrans.getRpnHvAB22().toString());
        etRpnHvAB23V.setText(silovoyTrans.getRpnHvAB23().toString());
        etRpnHvAB24V.setText(silovoyTrans.getRpnHvAB24().toString());
        etRpnHvAB25V.setText(silovoyTrans.getRpnHvAB25().toString());
        etRpnHvBC1V.setText(silovoyTrans.getRpnHvBC1().toString());
        etRpnHvBC2V.setText(silovoyTrans.getRpnHvBC2().toString());
        etRpnHvBC3V.setText(silovoyTrans.getRpnHvBC3().toString());
        etRpnHvBC4V.setText(silovoyTrans.getRpnHvBC4().toString());
        etRpnHvBC5V.setText(silovoyTrans.getRpnHvBC5().toString());
        etRpnHvBC6V.setText(silovoyTrans.getRpnHvBC6().toString());
        etRpnHvBC7V.setText(silovoyTrans.getRpnHvBC7().toString());
        etRpnHvBC8V.setText(silovoyTrans.getRpnHvBC8().toString());
        etRpnHvBC9V.setText(silovoyTrans.getRpnHvBC9().toString());
        etRpnHvBC10V.setText(silovoyTrans.getRpnHvBC10().toString());
        etRpnHvBC11V.setText(silovoyTrans.getRpnHvBC11().toString());
        etRpnHvBC12V.setText(silovoyTrans.getRpnHvBC12().toString());
        etRpnHvBC13V.setText(silovoyTrans.getRpnHvBC13().toString());
        etRpnHvBC14V.setText(silovoyTrans.getRpnHvBC14().toString());
        etRpnHvBC15V.setText(silovoyTrans.getRpnHvBC15().toString());
        etRpnHvBC16V.setText(silovoyTrans.getRpnHvBC16().toString());
        etRpnHvBC17V.setText(silovoyTrans.getRpnHvBC17().toString());
        etRpnHvBC18V.setText(silovoyTrans.getRpnHvBC18().toString());
        etRpnHvBC19V.setText(silovoyTrans.getRpnHvBC19().toString());
        etRpnHvBC20V.setText(silovoyTrans.getRpnHvBC20().toString());
        etRpnHvBC21V.setText(silovoyTrans.getRpnHvBC21().toString());
        etRpnHvBC22V.setText(silovoyTrans.getRpnHvBC22().toString());
        etRpnHvBC23V.setText(silovoyTrans.getRpnHvBC23().toString());
        etRpnHvBC24V.setText(silovoyTrans.getRpnHvBC24().toString());
        etRpnHvBC25V.setText(silovoyTrans.getRpnHvBC25().toString());
        etRpnHvCA1V.setText(silovoyTrans.getRpnHvCA1().toString());
        etRpnHvCA2V.setText(silovoyTrans.getRpnHvCA2().toString());
        etRpnHvCA3V.setText(silovoyTrans.getRpnHvCA3().toString());
        etRpnHvCA4V.setText(silovoyTrans.getRpnHvCA4().toString());
        etRpnHvCA5V.setText(silovoyTrans.getRpnHvCA5().toString());
        etRpnHvCA6V.setText(silovoyTrans.getRpnHvCA6().toString());
        etRpnHvCA7V.setText(silovoyTrans.getRpnHvCA7().toString());
        etRpnHvCA8V.setText(silovoyTrans.getRpnHvCA8().toString());
        etRpnHvCA9V.setText(silovoyTrans.getRpnHvCA9().toString());
        etRpnHvCA10V.setText(silovoyTrans.getRpnHvCA10().toString());
        etRpnHvCA11V.setText(silovoyTrans.getRpnHvCA11().toString());
        etRpnHvCA12V.setText(silovoyTrans.getRpnHvCA12().toString());
        etRpnHvCA13V.setText(silovoyTrans.getRpnHvCA13().toString());
        etRpnHvCA14V.setText(silovoyTrans.getRpnHvCA14().toString());
        etRpnHvCA15V.setText(silovoyTrans.getRpnHvCA15().toString());
        etRpnHvCA16V.setText(silovoyTrans.getRpnHvCA16().toString());
        etRpnHvCA17V.setText(silovoyTrans.getRpnHvCA17().toString());
        etRpnHvCA18V.setText(silovoyTrans.getRpnHvCA18().toString());
        etRpnHvCA19V.setText(silovoyTrans.getRpnHvCA19().toString());
        etRpnHvCA20V.setText(silovoyTrans.getRpnHvCA20().toString());
        etRpnHvCA21V.setText(silovoyTrans.getRpnHvCA21().toString());
        etRpnHvCA22V.setText(silovoyTrans.getRpnHvCA22().toString());
        etRpnHvCA23V.setText(silovoyTrans.getRpnHvCA23().toString());
        etRpnHvCA24V.setText(silovoyTrans.getRpnHvCA24().toString());
        etRpnHvCA25V.setText(silovoyTrans.getRpnHvCA25().toString());
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
        etRpnHvAB7V.setClickable(false);
        etRpnHvAB8V.setClickable(false);
        etRpnHvAB9V.setClickable(false);
        etRpnHvAB10V.setClickable(false);
        etRpnHvAB11V.setClickable(false);
        etRpnHvAB12V.setClickable(false);
        etRpnHvAB13V.setClickable(false);
        etRpnHvAB14V.setClickable(false);
        etRpnHvAB15V.setClickable(false);
        etRpnHvAB16V.setClickable(false);
        etRpnHvAB17V.setClickable(false);
        etRpnHvAB18V.setClickable(false);
        etRpnHvAB19V.setClickable(false);
        etRpnHvAB20V.setClickable(false);
        etRpnHvAB21V.setClickable(false);
        etRpnHvAB22V.setClickable(false);
        etRpnHvAB23V.setClickable(false);
        etRpnHvAB24V.setClickable(false);
        etRpnHvAB25V.setClickable(false);
        etRpnHvBC1V.setClickable(false);
        etRpnHvBC2V.setClickable(false);
        etRpnHvBC3V.setClickable(false);
        etRpnHvBC4V.setClickable(false);
        etRpnHvBC5V.setClickable(false);
        etRpnHvBC6V.setClickable(false);
        etRpnHvBC7V.setClickable(false);
        etRpnHvBC8V.setClickable(false);
        etRpnHvBC9V.setClickable(false);
        etRpnHvBC10V.setClickable(false);
        etRpnHvBC11V.setClickable(false);
        etRpnHvBC12V.setClickable(false);
        etRpnHvBC13V.setClickable(false);
        etRpnHvBC14V.setClickable(false);
        etRpnHvBC15V.setClickable(false);
        etRpnHvBC16V.setClickable(false);
        etRpnHvBC17V.setClickable(false);
        etRpnHvBC18V.setClickable(false);
        etRpnHvBC19V.setClickable(false);
        etRpnHvBC20V.setClickable(false);
        etRpnHvBC21V.setClickable(false);
        etRpnHvBC22V.setClickable(false);
        etRpnHvBC23V.setClickable(false);
        etRpnHvBC24V.setClickable(false);
        etRpnHvBC25V.setClickable(false);
        etRpnHvCA1V.setClickable(false);
        etRpnHvCA2V.setClickable(false);
        etRpnHvCA3V.setClickable(false);
        etRpnHvCA4V.setClickable(false);
        etRpnHvCA5V.setClickable(false);
        etRpnHvCA6V.setClickable(false);
        etRpnHvCA7V.setClickable(false);
        etRpnHvCA8V.setClickable(false);
        etRpnHvCA9V.setClickable(false);
        etRpnHvCA10V.setClickable(false);
        etRpnHvCA11V.setClickable(false);
        etRpnHvCA12V.setClickable(false);
        etRpnHvCA13V.setClickable(false);
        etRpnHvCA14V.setClickable(false);
        etRpnHvCA15V.setClickable(false);
        etRpnHvCA16V.setClickable(false);
        etRpnHvCA17V.setClickable(false);
        etRpnHvCA18V.setClickable(false);
        etRpnHvCA19V.setClickable(false);
        etRpnHvCA20V.setClickable(false);
        etRpnHvCA21V.setClickable(false);
        etRpnHvCA22V.setClickable(false);
        etRpnHvCA23V.setClickable(false);
        etRpnHvCA24V.setClickable(false);
        etRpnHvCA25V.setClickable(false);
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
        etRpnHvAB7V.setFocusable(false);
        etRpnHvAB8V.setFocusable(false);
        etRpnHvAB9V.setFocusable(false);
        etRpnHvAB10V.setFocusable(false);
        etRpnHvAB11V.setFocusable(false);
        etRpnHvAB12V.setFocusable(false);
        etRpnHvAB13V.setFocusable(false);
        etRpnHvAB14V.setFocusable(false);
        etRpnHvAB15V.setFocusable(false);
        etRpnHvAB16V.setFocusable(false);
        etRpnHvAB17V.setFocusable(false);
        etRpnHvAB18V.setFocusable(false);
        etRpnHvAB19V.setFocusable(false);
        etRpnHvAB20V.setFocusable(false);
        etRpnHvAB21V.setFocusable(false);
        etRpnHvAB22V.setFocusable(false);
        etRpnHvAB23V.setFocusable(false);
        etRpnHvAB24V.setFocusable(false);
        etRpnHvAB25V.setFocusable(false);
        etRpnHvBC1V.setFocusable(false);
        etRpnHvBC2V.setFocusable(false);
        etRpnHvBC3V.setFocusable(false);
        etRpnHvBC4V.setFocusable(false);
        etRpnHvBC5V.setFocusable(false);
        etRpnHvBC6V.setFocusable(false);
        etRpnHvBC7V.setFocusable(false);
        etRpnHvBC8V.setFocusable(false);
        etRpnHvBC9V.setFocusable(false);
        etRpnHvBC10V.setFocusable(false);
        etRpnHvBC11V.setFocusable(false);
        etRpnHvBC12V.setFocusable(false);
        etRpnHvBC13V.setFocusable(false);
        etRpnHvBC14V.setFocusable(false);
        etRpnHvBC15V.setFocusable(false);
        etRpnHvBC16V.setFocusable(false);
        etRpnHvBC17V.setFocusable(false);
        etRpnHvBC18V.setFocusable(false);
        etRpnHvBC19V.setFocusable(false);
        etRpnHvBC20V.setFocusable(false);
        etRpnHvBC21V.setFocusable(false);
        etRpnHvBC22V.setFocusable(false);
        etRpnHvBC23V.setFocusable(false);
        etRpnHvBC24V.setFocusable(false);
        etRpnHvBC25V.setFocusable(false);
        etRpnHvCA1V.setFocusable(false);
        etRpnHvCA2V.setFocusable(false);
        etRpnHvCA3V.setFocusable(false);
        etRpnHvCA4V.setFocusable(false);
        etRpnHvCA5V.setFocusable(false);
        etRpnHvCA6V.setFocusable(false);
        etRpnHvCA7V.setFocusable(false);
        etRpnHvCA8V.setFocusable(false);
        etRpnHvCA9V.setFocusable(false);
        etRpnHvCA10V.setFocusable(false);
        etRpnHvCA11V.setFocusable(false);
        etRpnHvCA12V.setFocusable(false);
        etRpnHvCA13V.setFocusable(false);
        etRpnHvCA14V.setFocusable(false);
        etRpnHvCA15V.setFocusable(false);
        etRpnHvCA16V.setFocusable(false);
        etRpnHvCA17V.setFocusable(false);
        etRpnHvCA18V.setFocusable(false);
        etRpnHvCA19V.setFocusable(false);
        etRpnHvCA20V.setFocusable(false);
        etRpnHvCA21V.setFocusable(false);
        etRpnHvCA22V.setFocusable(false);
        etRpnHvCA23V.setFocusable(false);
        etRpnHvCA24V.setFocusable(false);
        etRpnHvCA25V.setFocusable(false);
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
        etRpnHvAB7V.setFocusableInTouchMode(false);
        etRpnHvAB8V.setFocusableInTouchMode(false);
        etRpnHvAB9V.setFocusableInTouchMode(false);
        etRpnHvAB10V.setFocusableInTouchMode(false);
        etRpnHvAB11V.setFocusableInTouchMode(false);
        etRpnHvAB12V.setFocusableInTouchMode(false);
        etRpnHvAB13V.setFocusableInTouchMode(false);
        etRpnHvAB14V.setFocusableInTouchMode(false);
        etRpnHvAB15V.setFocusableInTouchMode(false);
        etRpnHvAB16V.setFocusableInTouchMode(false);
        etRpnHvAB17V.setFocusableInTouchMode(false);
        etRpnHvAB18V.setFocusableInTouchMode(false);
        etRpnHvAB19V.setFocusableInTouchMode(false);
        etRpnHvAB20V.setFocusableInTouchMode(false);
        etRpnHvAB21V.setFocusableInTouchMode(false);
        etRpnHvAB22V.setFocusableInTouchMode(false);
        etRpnHvAB23V.setFocusableInTouchMode(false);
        etRpnHvAB24V.setFocusableInTouchMode(false);
        etRpnHvAB25V.setFocusableInTouchMode(false);
        etRpnHvBC1V.setFocusableInTouchMode(false);
        etRpnHvBC2V.setFocusableInTouchMode(false);
        etRpnHvBC3V.setFocusableInTouchMode(false);
        etRpnHvBC4V.setFocusableInTouchMode(false);
        etRpnHvBC5V.setFocusableInTouchMode(false);
        etRpnHvBC6V.setFocusableInTouchMode(false);
        etRpnHvBC7V.setFocusableInTouchMode(false);
        etRpnHvBC8V.setFocusableInTouchMode(false);
        etRpnHvBC9V.setFocusableInTouchMode(false);
        etRpnHvBC10V.setFocusableInTouchMode(false);
        etRpnHvBC11V.setFocusableInTouchMode(false);
        etRpnHvBC12V.setFocusableInTouchMode(false);
        etRpnHvBC13V.setFocusableInTouchMode(false);
        etRpnHvBC14V.setFocusableInTouchMode(false);
        etRpnHvBC15V.setFocusableInTouchMode(false);
        etRpnHvBC16V.setFocusableInTouchMode(false);
        etRpnHvBC17V.setFocusableInTouchMode(false);
        etRpnHvBC18V.setFocusableInTouchMode(false);
        etRpnHvBC19V.setFocusableInTouchMode(false);
        etRpnHvBC20V.setFocusableInTouchMode(false);
        etRpnHvBC21V.setFocusableInTouchMode(false);
        etRpnHvBC22V.setFocusableInTouchMode(false);
        etRpnHvBC23V.setFocusableInTouchMode(false);
        etRpnHvBC24V.setFocusableInTouchMode(false);
        etRpnHvBC25V.setFocusableInTouchMode(false);
        etRpnHvCA1V.setFocusableInTouchMode(false);
        etRpnHvCA2V.setFocusableInTouchMode(false);
        etRpnHvCA3V.setFocusableInTouchMode(false);
        etRpnHvCA4V.setFocusableInTouchMode(false);
        etRpnHvCA5V.setFocusableInTouchMode(false);
        etRpnHvCA6V.setFocusableInTouchMode(false);
        etRpnHvCA7V.setFocusableInTouchMode(false);
        etRpnHvCA8V.setFocusableInTouchMode(false);
        etRpnHvCA9V.setFocusableInTouchMode(false);
        etRpnHvCA10V.setFocusableInTouchMode(false);
        etRpnHvCA11V.setFocusableInTouchMode(false);
        etRpnHvCA12V.setFocusableInTouchMode(false);
        etRpnHvCA13V.setFocusableInTouchMode(false);
        etRpnHvCA14V.setFocusableInTouchMode(false);
        etRpnHvCA15V.setFocusableInTouchMode(false);
        etRpnHvCA16V.setFocusableInTouchMode(false);
        etRpnHvCA17V.setFocusableInTouchMode(false);
        etRpnHvCA18V.setFocusableInTouchMode(false);
        etRpnHvCA19V.setFocusableInTouchMode(false);
        etRpnHvCA20V.setFocusableInTouchMode(false);
        etRpnHvCA21V.setFocusableInTouchMode(false);
        etRpnHvCA22V.setFocusableInTouchMode(false);
        etRpnHvCA23V.setFocusableInTouchMode(false);
        etRpnHvCA24V.setFocusableInTouchMode(false);
        etRpnHvCA25V.setFocusableInTouchMode(false);
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
        etRpnHvAB7V = findViewById(R.id.etRpnHvAB7V);
        etRpnHvAB8V = findViewById(R.id.etRpnHvAB8V);
        etRpnHvAB9V = findViewById(R.id.etRpnHvAB9V);
        etRpnHvAB10V = findViewById(R.id.etRpnHvAB10V);
        etRpnHvAB11V = findViewById(R.id.etRpnHvAB11V);
        etRpnHvAB12V = findViewById(R.id.etRpnHvAB12V);
        etRpnHvAB13V = findViewById(R.id.etRpnHvAB13V);
        etRpnHvAB14V = findViewById(R.id.etRpnHvAB14V);
        etRpnHvAB15V = findViewById(R.id.etRpnHvAB15V);
        etRpnHvAB16V = findViewById(R.id.etRpnHvAB16V);
        etRpnHvAB17V = findViewById(R.id.etRpnHvAB17V);
        etRpnHvAB18V = findViewById(R.id.etRpnHvAB18V);
        etRpnHvAB19V = findViewById(R.id.etRpnHvAB19V);
        etRpnHvAB20V = findViewById(R.id.etRpnHvAB20V);
        etRpnHvAB21V = findViewById(R.id.etRpnHvAB21V);
        etRpnHvAB22V = findViewById(R.id.etRpnHvAB22V);
        etRpnHvAB23V = findViewById(R.id.etRpnHvAB23V);
        etRpnHvAB24V = findViewById(R.id.etRpnHvAB24V);
        etRpnHvAB25V = findViewById(R.id.etRpnHvAB25V);
        etRpnHvBC1V = findViewById(R.id.etRpnHvBC1V);
        etRpnHvBC2V = findViewById(R.id.etRpnHvBC2V);
        etRpnHvBC3V = findViewById(R.id.etRpnHvBC3V);
        etRpnHvBC4V = findViewById(R.id.etRpnHvBC4V);
        etRpnHvBC5V = findViewById(R.id.etRpnHvBC5V);
        etRpnHvBC6V = findViewById(R.id.etRpnHvBC6V);
        etRpnHvBC7V = findViewById(R.id.etRpnHvBC7V);
        etRpnHvBC8V = findViewById(R.id.etRpnHvBC8V);
        etRpnHvBC9V = findViewById(R.id.etRpnHvBC9V);
        etRpnHvBC10V = findViewById(R.id.etRpnHvBC10V);
        etRpnHvBC11V = findViewById(R.id.etRpnHvBC11V);
        etRpnHvBC12V = findViewById(R.id.etRpnHvBC12V);
        etRpnHvBC13V = findViewById(R.id.etRpnHvBC13V);
        etRpnHvBC14V = findViewById(R.id.etRpnHvBC14V);
        etRpnHvBC15V = findViewById(R.id.etRpnHvBC15V);
        etRpnHvBC16V = findViewById(R.id.etRpnHvBC16V);
        etRpnHvBC17V = findViewById(R.id.etRpnHvBC17V);
        etRpnHvBC18V = findViewById(R.id.etRpnHvBC18V);
        etRpnHvBC19V = findViewById(R.id.etRpnHvBC19V);
        etRpnHvBC20V = findViewById(R.id.etRpnHvBC20V);
        etRpnHvBC21V = findViewById(R.id.etRpnHvBC21V);
        etRpnHvBC22V = findViewById(R.id.etRpnHvBC22V);
        etRpnHvBC23V = findViewById(R.id.etRpnHvBC23V);
        etRpnHvBC24V = findViewById(R.id.etRpnHvBC24V);
        etRpnHvBC25V = findViewById(R.id.etRpnHvBC25V);
        etRpnHvCA1V = findViewById(R.id.etRpnHvCA1V);
        etRpnHvCA2V = findViewById(R.id.etRpnHvCA2V);
        etRpnHvCA3V = findViewById(R.id.etRpnHvCA3V);
        etRpnHvCA4V = findViewById(R.id.etRpnHvCA4V);
        etRpnHvCA5V = findViewById(R.id.etRpnHvCA5V);
        etRpnHvCA6V = findViewById(R.id.etRpnHvCA6V);
        etRpnHvCA7V = findViewById(R.id.etRpnHvCA7V);
        etRpnHvCA8V = findViewById(R.id.etRpnHvCA8V);
        etRpnHvCA9V = findViewById(R.id.etRpnHvCA9V);
        etRpnHvCA10V = findViewById(R.id.etRpnHvCA10V);
        etRpnHvCA11V = findViewById(R.id.etRpnHvCA11V);
        etRpnHvCA12V = findViewById(R.id.etRpnHvCA12V);
        etRpnHvCA13V = findViewById(R.id.etRpnHvCA13V);
        etRpnHvCA14V = findViewById(R.id.etRpnHvCA14V);
        etRpnHvCA15V = findViewById(R.id.etRpnHvCA15V);
        etRpnHvCA16V = findViewById(R.id.etRpnHvCA16V);
        etRpnHvCA17V = findViewById(R.id.etRpnHvCA17V);
        etRpnHvCA18V = findViewById(R.id.etRpnHvCA18V);
        etRpnHvCA19V = findViewById(R.id.etRpnHvCA19V);
        etRpnHvCA20V = findViewById(R.id.etRpnHvCA20V);
        etRpnHvCA21V = findViewById(R.id.etRpnHvCA21V);
        etRpnHvCA22V = findViewById(R.id.etRpnHvCA22V);
        etRpnHvCA23V = findViewById(R.id.etRpnHvCA23V);
        etRpnHvCA24V = findViewById(R.id.etRpnHvCA24V);
        etRpnHvCA25V = findViewById(R.id.etRpnHvCA25V);
        etNotesV = findViewById(R.id.etNotesV);
        etRpnLvCnV = findViewById(R.id.etRpnLvCnV);
        etRpnLvBnV = findViewById(R.id.etRpnLvBnV);
        etRpnLvAnV = findViewById(R.id.etRpnLvAnV);
    }
}