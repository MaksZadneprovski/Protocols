package com.example.protokols.data_base_package.SilovoyTransformator;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.protokols.MainActivity;
import com.example.protokols.R;
import com.example.protokols.ViewingProtokolsList;
import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.data_base_package.FreeForm.MainFreeForm;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;
import com.example.protokols.utils.ConstantsMy;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainSilovoyTrans extends AppCompatActivity {
    TextView tvWork ,tvDiscrepancy1, tvDiscrepancy2;
    BottomNavigationView bottomNavigationView;
    private ConstraintLayout cLObject;
    private boolean flagForSave= true;
    private ConstraintLayout cLMeterage;
    private ImageButton btnSetConstantForRpn;
    private FloatingActionButton  fabSave;
    private Date currentDate = new Date();
    public SharedPreferences sharedPreferences;
    private TextInputEditText etObject, etDate, etPasportCurrent, etPasportPower, etPasportType, etPasportVoltage, etPasportVoltageKz, etPasportYearOfManufacture,
            etPasportZavNumber, etTemperature, etIzolHvKoef, etIzolHvR15, etIzolHvR60, etIzolLvKoef, etIzolLvR15, etIzolLvR60,
            etSwitchOperatingPosition, etRpnHvAB1, etRpnHvAB2, etRpnHvAB3, etRpnHvAB4, etRpnHvAB5, etRpnHvAB6, etRpnHvBC1, etRpnHvBC2, etRpnHvBC3,
            etRpnHvBC4, etRpnHvBC5, etRpnHvBC6, etRpnHvCA1, etRpnHvCA2, etRpnHvCA3, etRpnHvCA4, etRpnHvCA5, etRpnHvCA6,
            etNotes, etRpnLvCn,etRpnLvBn,etRpnLvAn,etSetConstantForRpn;
    public final String TAG = "MyLogger";

    // Date setting
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy EEE HH:mm", Locale.getDefault());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.silovoy_trans);

        bottomNavigationView = findViewById(R.id.bottomNavView);
            cLObject = findViewById(R.id.ConstrLayoutObject);
            cLMeterage = findViewById(R.id.ConstrLayoutMeterage);
        fabSave = findViewById(R.id.fabSilovoyTrans);

        cLObject.setVisibility(View.VISIBLE);
        cLMeterage.setVisibility(View.GONE);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){
                    Intent i = new Intent(MainSilovoyTrans.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc2){
                    Intent i = new Intent(MainSilovoyTrans.this, ViewingProtokolsList.class);
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

        /////////////////////////////////////////////////////////////////////////////////////////////
        // 1.1 Отключение анимации перехода
        overridePendingTransition(0,0);

        /////////////////////////////////////////////////////////////////////////////////////////////
        init();

        ////////////////////////////////////////////////////////////////////////////////////////////

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagForSave = false;
                try {
                    insertToBd(true);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });

        btnSetConstantForRpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setConstant(etSetConstantForRpn.getText().toString());
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (flagForSave) {
            try {
                insertToBd(false);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    // Метод обработки кнопки назад
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK==keyCode){
            if (MainActivity.isEditSilovoyTrans){
                Intent i = new Intent(MainSilovoyTrans.this, ViewingProtokolsList.class);
                startActivity(i);
                finish();
            }
            else {
                finish();
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    // 2 Метод : Запись в БД. Проверяет EditText-ы на заполненность и записывает в БД объект, который создается методом createSilovoyTransFromEditText()
    private void insertToBd(boolean save) throws ParseException {

        // Создание объекта  DAO для работы с БД
        SilovoyTransDao silovoyTransDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getSilovoyTransTableDao();

        // Проверяем поля Объект и Дата на заполненность
        if (!(etObject.getText().toString().equals("")) & !(etDate.getText().toString().equals(""))){

            // Проверка: Хотим ли мы создать новый объект в БД или обновить существующий
            if (!MainActivity.isEditSilovoyTrans){

                // Записываем в БД
                silovoyTransDao.insertSilovoyTrans(createSilovoyTransFromEditText());


                // Показываем Toast
                Toast.makeText(MainSilovoyTrans.this, "Протокол сохранён", Toast.LENGTH_SHORT).show();
            }
            else {
                // Создаем объект по полям для обновления БД
                SilovoyTrans silovoyTransUpdate = createSilovoyTransFromEditText();

                // Получение id  объекта для перезаписи в БД из экрана ViewSilovoyTrans
                Intent i = getIntent();
                int idSilovoyTrans = i.getIntExtra(ConstantsMy.ID_KEY, 0);

                silovoyTransUpdate.setId(idSilovoyTrans);
                silovoyTransDao.updateSilovoyTrans(silovoyTransUpdate);

                Toast.makeText(MainSilovoyTrans.this, "Протокол обновлён", Toast.LENGTH_LONG).show();
            }
            Intent i = new Intent(MainSilovoyTrans.this, ViewingProtokolsList.class);
            startActivity(i);
            finish();

        }
        else  {
            if (save) {
                if(etObject.getText().toString().equals("")& (etDate.getText().toString().equals(""))){
                    Toast.makeText(MainSilovoyTrans.this, "Введите наименование объекта и дату", Toast.LENGTH_LONG).show();
                }
                else if(etDate.getText().toString().equals("")) {
                    Toast.makeText(MainSilovoyTrans.this, "Введите дату", Toast.LENGTH_LONG).show();
                }
                else if(etObject.getText().toString().equals("")) {
                    Toast.makeText(MainSilovoyTrans.this, "Введите наименование объекта", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    // 3 Метод : создает объект SilovoyTrans по введенным данным в EditText-ы
    private SilovoyTrans createSilovoyTransFromEditText() throws ParseException {
        String object = etObject.getText().toString();
        String work = "Испытание\nсилового\nтрансформатора";
        long date=1;
        Date d = new SimpleDateFormat("dd.MM.yy EEE HH:mm").parse(etDate.getText().toString());
        date = d.getTime();        String temperature = etTemperature.getText().toString();
        String PasportType = etPasportType.getText().toString();
        String PasportZavNumber = etPasportZavNumber.getText().toString();
        String PasportPower = etPasportPower.getText().toString();
        String PasportVoltage = etPasportVoltage.getText().toString();
        String PasportCurrent = etPasportCurrent.getText().toString();
        String PasportVoltageKz = etPasportVoltageKz.getText().toString();
        String PasportYearOfManufacture = etPasportYearOfManufacture.getText().toString();
        String IzolHvR15 = etIzolHvR15.getText().toString();
        String IzolHvR60 = etIzolHvR60.getText().toString();
        String IzolHvKoef = etIzolHvKoef.getText().toString();
        String IzolLvR15 = etIzolLvR15.getText().toString();
        String IzolLvR60 = etIzolLvR60.getText().toString();
        String IzolLvKoef = etIzolLvKoef.getText().toString();
        String SwitchOperationPosition = etSwitchOperatingPosition.getText().toString();

        String RpnHvAB1 = etRpnHvAB1.getText().toString();
        String RpnHvAB2 = etRpnHvAB2.getText().toString();
        String RpnHvAB3 = etRpnHvAB3.getText().toString();
        String RpnHvAB4 = etRpnHvAB4.getText().toString();
        String RpnHvAB5 = etRpnHvAB5.getText().toString();
        String RpnHvAB6 = etRpnHvAB6.getText().toString();

        String RpnHvBC1 = etRpnHvBC1.getText().toString();
        String RpnHvBC2 = etRpnHvBC2.getText().toString();
        String RpnHvBC3 = etRpnHvBC3.getText().toString();
        String RpnHvBC4 = etRpnHvBC4.getText().toString();
        String RpnHvBC5 = etRpnHvBC5.getText().toString();
        String RpnHvBC6 = etRpnHvBC6.getText().toString();

        String RpnHvCA1 = etRpnHvCA1.getText().toString();
        String RpnHvCA2 = etRpnHvCA2.getText().toString();
        String RpnHvCA3 = etRpnHvCA3.getText().toString();
        String RpnHvCA4 = etRpnHvCA4.getText().toString();
        String RpnHvCA5 = etRpnHvCA5.getText().toString();
        String RpnHvCA6 = etRpnHvCA6.getText().toString();

        String RpnLvAn = etRpnLvAn.getText().toString();
        String RpnLvBn = etRpnLvBn.getText().toString();
        String RpnLvCn = etRpnLvCn.getText().toString();
        String Notes = etNotes.getText().toString();

        SilovoyTrans silovoyTrans = new SilovoyTrans(object,work, date,temperature,PasportType, PasportZavNumber, PasportPower, PasportVoltage,
                PasportCurrent, PasportVoltageKz, PasportYearOfManufacture, IzolHvR15, IzolHvR60, IzolHvKoef, IzolLvR15, IzolLvR60, IzolLvKoef,
                 SwitchOperationPosition, RpnHvAB1, RpnHvAB2, RpnHvAB3, RpnHvAB4, RpnHvAB5, RpnHvAB6,  RpnHvBC1, RpnHvBC2, RpnHvBC3,
                RpnHvBC4, RpnHvBC5, RpnHvBC6,  RpnHvCA1, RpnHvCA2, RpnHvCA3, RpnHvCA4, RpnHvCA5, RpnHvCA6, RpnLvAn,
                RpnLvBn, RpnLvCn, Notes);
        return silovoyTrans;
    }

    // 6 Метод : Заполняет EditText-ы данными из объекта silovoyTrans в случае редактирования
    private void setTextToEditTextFromSilovoyTrans(SilovoyTrans silovoyTrans){

        tvWork.setText("Редактирование\nпротокола");
        etObject.setText(silovoyTrans.getmObjectOrPodstancia().toString());
        etDate.setText(dateFormat.format(silovoyTrans.getmDate()) );
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



    private void init() {
        // Buttons
        btnSetConstantForRpn =findViewById(R.id.fabSetConstant);
        // TextView
        tvWork= findViewById(R.id.tvWork);
        tvDiscrepancy1= findViewById(R.id.tvDiscrepancy1);
        tvDiscrepancy2= findViewById(R.id.tvDiscrepancy2);
        tvDiscrepancy1.setVisibility(View.GONE);
        tvDiscrepancy2.setVisibility(View.GONE);

        // EditText
        etObject = findViewById(R.id.etObject);
        etDate = findViewById(R.id.etDate);
        etDate.setText(dateFormat.format(currentDate));
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




        // Установка текста, если осуществляется редактирование
        if (MainActivity.isEditSilovoyTrans){

            // Создание объекта  DAO для работы с БД
            SilovoyTransDao silovoyTransDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getSilovoyTransTableDao();

            // Получаем id объекта SilovoyTrans
            Intent i = getIntent();
            int idSilovoyTrans = i.getIntExtra(ConstantsMy.ID_KEY, 0);

            // По id создается объект silovoyTrans, данные для которого берутся из БД
            SilovoyTrans silovoyTrans = silovoyTransDao.getSilovoyTransTableById(idSilovoyTrans);

            // Метод заполнения полей
            setTextToEditTextFromSilovoyTrans(silovoyTrans);


        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    //  Методы : Получают String и вставляют ее в поля сопротивления
    private void setConstant (String constantForEt) {
        etRpnHvAB1.setText(constantForEt);
        etRpnHvAB1.setSelection(etRpnHvAB1.getText().length());
        etRpnHvAB2.setText(constantForEt);
        etRpnHvAB2.setSelection(etRpnHvAB2.getText().length());
        etRpnHvAB3.setText(constantForEt);
        etRpnHvAB3.setSelection(etRpnHvAB3.getText().length());
        etRpnHvAB4.setText(constantForEt);
        etRpnHvAB4.setSelection(etRpnHvAB4.getText().length());
        etRpnHvAB5.setText(constantForEt);
        etRpnHvAB5.setSelection(etRpnHvAB5.getText().length());
        etRpnHvBC1.setText(constantForEt);
        etRpnHvBC1.setSelection(etRpnHvBC1.getText().length());
        etRpnHvBC2.setText(constantForEt);
        etRpnHvBC2.setSelection(etRpnHvBC2.getText().length());
        etRpnHvBC3.setText(constantForEt);
        etRpnHvBC3.setSelection(etRpnHvBC3.getText().length());
        etRpnHvBC4.setText(constantForEt);
        etRpnHvBC4.setSelection(etRpnHvBC4.getText().length());
        etRpnHvBC5.setText(constantForEt);
        etRpnHvBC5.setSelection(etRpnHvBC5.getText().length());
        etRpnHvCA1.setText(constantForEt);
        etRpnHvCA1.setSelection(etRpnHvCA1.getText().length());
        etRpnHvCA2.setText(constantForEt);
        etRpnHvCA2.setSelection(etRpnHvCA2.getText().length());
        etRpnHvCA3.setText(constantForEt);
        etRpnHvCA3.setSelection(etRpnHvCA3.getText().length());
        etRpnHvCA4.setText(constantForEt);
        etRpnHvCA4.setSelection(etRpnHvCA4.getText().length());
        etRpnHvCA5.setText(constantForEt);
        etRpnHvCA5.setSelection(etRpnHvCA5.getText().length());
    }
}
