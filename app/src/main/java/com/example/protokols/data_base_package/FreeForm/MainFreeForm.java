package com.example.protokols.data_base_package.FreeForm;

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
import android.widget.Toast;

import com.example.protokols.MainActivity;
import com.example.protokols.R;
import com.example.protokols.ViewingProtokolsList;
import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.data_base_package.SilovoyTransformator.MainSilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;
import com.example.protokols.utils.ConstantsForSilovoyTrans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainFreeForm extends AppCompatActivity {
    private Date currentDate = new Date();
    private TextView tvWork;
    private EditText etObject, etDate, etNotes;
    private Toolbar toolbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_free_form);

        init();
    }



    // Метод : Создает меню в тулбаре из указанного ресурса
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_create_protocol, menu);
        return true;
    }

    // Метод : Обрабатывает нажатия пунктов меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i = new Intent(MainSilovoyTrans.this, ViewingProtokolsList.class);
        if (item.getItemId() == R.id.menuSave){
            insertToBd();
            startActivity(i);
            finish();
        }
        return true;
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
    private void insertToBd() {

        // Создание объекта  DAO для работы с БД
        SilovoyTransDao silovoyTransDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getSilovoyTransTableDao();

        // Проверяем поля Объект и Дата на заполненность
        if (!(etObject.getText().toString().equals("")) & !(etDate.getText().toString().equals(""))){

            // Проверка: Хотим ли мы создать новый объект в БД или обновить существующий
            if (!MainActivity.isEditSilovoyTrans){

                // Записываем в БД
                silovoyTransDao.insertSilovoyTrans(createSilovoyTransFromEditText());

                // Показываем Toast
                Toast.makeText(MainSilovoyTrans.this, "Сохранено", Toast.LENGTH_LONG).show();
            }
            else {
                // Создаем объект по полям для обновления БД
                SilovoyTrans silovoyTransUpdate = createSilovoyTransFromEditText();

                // Получение id  объекта для перезаписи в БД из экрана ViewSilovoyTrans
                Intent i = getIntent();
                int idSilovoyTrans = i.getIntExtra(ConstantsForSilovoyTrans.ID_KEY, 0);

                silovoyTransUpdate.setId(idSilovoyTrans);
                silovoyTransDao.updateSilovoyTrans(silovoyTransUpdate);

                Toast.makeText(MainSilovoyTrans.this, "Обновлено", Toast.LENGTH_LONG).show();
            }

        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    // 3 Метод : создает объект SilovoyTrans по введенным данным в EditText-ы
    private SilovoyTrans createSilovoyTransFromEditText() {
        String object = etObject.getText().toString();
        String work = tvWork.getText().toString();
        String date = etDate.getText().toString();
        String temperature = etTemperature.getText().toString();
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
        String UnitsDCresistance = getUnitsDCresistance();
        String QuantityRpn = getQuantityRpn() ;
        String SwitchOperationPosition = etSwitchOperatingPosition.getText().toString();;
        String RpnHvAB1 = etRpnHvAB1.getText().toString();
        String RpnHvAB2 = etRpnHvAB2.getText().toString();
        String RpnHvAB3 = etRpnHvAB3.getText().toString();
        String RpnHvAB4 = etRpnHvAB4.getText().toString();
        String RpnHvAB5 = etRpnHvAB5.getText().toString();
        String RpnHvAB6 = etRpnHvAB6.getText().toString();
        String RpnHvAB7 = etRpnHvAB7.getText().toString();
        String RpnHvAB8 = etRpnHvAB8.getText().toString();
        String RpnHvAB9 = etRpnHvAB9.getText().toString();
        String RpnHvAB10 = etRpnHvAB10.getText().toString();
        String RpnHvAB11 = etRpnHvAB11.getText().toString();
        String RpnHvAB12 = etRpnHvAB12.getText().toString();
        String RpnHvAB13 = etRpnHvAB13.getText().toString();
        String RpnHvAB14 = etRpnHvAB14.getText().toString();
        String RpnHvAB15 = etRpnHvAB15.getText().toString();
        String RpnHvAB16 = etRpnHvAB16.getText().toString();
        String RpnHvAB17 = etRpnHvAB17.getText().toString();
        String RpnHvAB18 = etRpnHvAB18.getText().toString();
        String RpnHvAB19 = etRpnHvAB19.getText().toString();
        String RpnHvAB20 = etRpnHvAB20.getText().toString();
        String RpnHvAB21 = etRpnHvAB21.getText().toString();
        String RpnHvAB22 = etRpnHvAB22.getText().toString();
        String RpnHvAB23 = etRpnHvAB23.getText().toString();
        String RpnHvAB24 = etRpnHvAB24.getText().toString();
        String RpnHvAB25 = etRpnHvAB25.getText().toString();
        String RpnHvBC1 = etRpnHvBC1.getText().toString();
        String RpnHvBC2 = etRpnHvBC2.getText().toString();
        String RpnHvBC3 = etRpnHvBC3.getText().toString();
        String RpnHvBC4 = etRpnHvBC4.getText().toString();
        String RpnHvBC5 = etRpnHvBC5.getText().toString();
        String RpnHvBC6 = etRpnHvBC6.getText().toString();
        String RpnHvBC7 = etRpnHvBC7.getText().toString();
        String RpnHvBC8 = etRpnHvBC8.getText().toString();
        String RpnHvBC9 = etRpnHvBC9.getText().toString();
        String RpnHvBC10 = etRpnHvBC10.getText().toString();
        String RpnHvBC11 = etRpnHvBC11.getText().toString();
        String RpnHvBC12 = etRpnHvBC12.getText().toString();
        String RpnHvBC13 = etRpnHvBC13.getText().toString();
        String RpnHvBC14 = etRpnHvBC14.getText().toString();
        String RpnHvBC15 = etRpnHvBC15.getText().toString();
        String RpnHvBC16 = etRpnHvBC16.getText().toString();
        String RpnHvBC17 = etRpnHvBC17.getText().toString();
        String RpnHvBC18 = etRpnHvBC18.getText().toString();
        String RpnHvBC19 = etRpnHvBC19.getText().toString();
        String RpnHvBC20 = etRpnHvBC20.getText().toString();
        String RpnHvBC21 = etRpnHvBC21.getText().toString();
        String RpnHvBC22 = etRpnHvBC22.getText().toString();
        String RpnHvBC23 = etRpnHvBC23.getText().toString();
        String RpnHvBC24 = etRpnHvBC24.getText().toString();
        String RpnHvBC25 = etRpnHvBC25.getText().toString();
        String RpnHvCA1 = etRpnHvCA1.getText().toString();
        String RpnHvCA2 = etRpnHvCA2.getText().toString();
        String RpnHvCA3 = etRpnHvCA3.getText().toString();
        String RpnHvCA4 = etRpnHvCA4.getText().toString();
        String RpnHvCA5 = etRpnHvCA5.getText().toString();
        String RpnHvCA6 = etRpnHvCA6.getText().toString();
        String RpnHvCA7 = etRpnHvCA7.getText().toString();
        String RpnHvCA8 = etRpnHvCA8.getText().toString();
        String RpnHvCA9 = etRpnHvCA9.getText().toString();
        String RpnHvCA10 = etRpnHvCA10.getText().toString();
        String RpnHvCA11 = etRpnHvCA11.getText().toString();
        String RpnHvCA12 = etRpnHvCA12.getText().toString();
        String RpnHvCA13 = etRpnHvCA13.getText().toString();
        String RpnHvCA14 = etRpnHvCA14.getText().toString();
        String RpnHvCA15 = etRpnHvCA15.getText().toString();
        String RpnHvCA16 = etRpnHvCA16.getText().toString();
        String RpnHvCA17 = etRpnHvCA17.getText().toString();
        String RpnHvCA18 = etRpnHvCA18.getText().toString();
        String RpnHvCA19 = etRpnHvCA19.getText().toString();
        String RpnHvCA20 = etRpnHvCA20.getText().toString();
        String RpnHvCA21 = etRpnHvCA21.getText().toString();
        String RpnHvCA22 = etRpnHvCA22.getText().toString();
        String RpnHvCA23 = etRpnHvCA23.getText().toString();
        String RpnHvCA24 = etRpnHvCA24.getText().toString();
        String RpnHvCA25 = etRpnHvCA25.getText().toString();
        String WindingConnectionDiagramLv =getWindingConnectionDiagramLv();
        String RpnLvAn = etRpnLvAn.getText().toString();
        String RpnLvBn = etRpnLvBn.getText().toString();
        String RpnLvCn = etRpnLvCn.getText().toString();
        String Notes = etNotes.getText().toString();

        SilovoyTrans silovoyTrans = new SilovoyTrans(object,work, date,temperature,PasportType,
                PasportZavNumber,
                PasportPower,
                PasportVoltage,
                PasportCurrent,
                PasportVoltageKz,
                PasportYearOfManufacture,
                IzolHvR15,
                IzolHvR60,
                IzolHvKoef, IzolLvR15, IzolLvR60, IzolLvKoef, UnitsDCresistance, QuantityRpn, SwitchOperationPosition, RpnHvAB1, RpnHvAB2,
                RpnHvAB3, RpnHvAB4, RpnHvAB5, RpnHvAB6, RpnHvAB7, RpnHvAB8, RpnHvAB9, RpnHvAB10, RpnHvAB11, RpnHvAB12, RpnHvAB13, RpnHvAB14,
                RpnHvAB15, RpnHvAB16, RpnHvAB17, RpnHvAB18, RpnHvAB19, RpnHvAB20, RpnHvAB21, RpnHvAB22, RpnHvAB23, RpnHvAB24, RpnHvAB25, RpnHvBC1,
                RpnHvBC2, RpnHvBC3, RpnHvBC4, RpnHvBC5, RpnHvBC6, RpnHvBC7, RpnHvBC8, RpnHvBC9, RpnHvBC10, RpnHvBC11,
                RpnHvBC12, RpnHvBC13, RpnHvBC14, RpnHvBC15, RpnHvBC16, RpnHvBC17, RpnHvBC18, RpnHvBC19, RpnHvBC20, RpnHvBC21, RpnHvBC22,
                RpnHvBC23, RpnHvBC24, RpnHvBC25, RpnHvCA1, RpnHvCA2, RpnHvCA3, RpnHvCA4, RpnHvCA5, RpnHvCA6, RpnHvCA7, RpnHvCA8, RpnHvCA9,
                RpnHvCA10, RpnHvCA11, RpnHvCA12, RpnHvCA13, RpnHvCA14, RpnHvCA15, RpnHvCA16, RpnHvCA17, RpnHvCA18, RpnHvCA19, RpnHvCA20,
                RpnHvCA21, RpnHvCA22, RpnHvCA23, RpnHvCA24, RpnHvCA25, WindingConnectionDiagramLv, RpnLvAn, RpnLvBn, RpnLvCn, Notes);
        return silovoyTrans;
    }

    // 6 Метод : Заполняет EditText-ы данными из объекта silovoyTrans в случае редактирования
    private void setTextToEditTextFromSilovoyTrans(SilovoyTrans silovoyTrans){
        etObject.setText(silovoyTrans.getObject().toString());
        etDate.setText(silovoyTrans.getDate().toString());
        etTemperature.setText(silovoyTrans.getTemperature().toString());
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
        etRpnHvAB7.setText(silovoyTrans.getRpnHvAB7().toString());
        etRpnHvAB8.setText(silovoyTrans.getRpnHvAB8().toString());
        etRpnHvAB9.setText(silovoyTrans.getRpnHvAB9().toString());
        etRpnHvAB10.setText(silovoyTrans.getRpnHvAB10().toString());
        etRpnHvAB11.setText(silovoyTrans.getRpnHvAB11().toString());
        etRpnHvAB12.setText(silovoyTrans.getRpnHvAB12().toString());
        etRpnHvAB13.setText(silovoyTrans.getRpnHvAB13().toString());
        etRpnHvAB14.setText(silovoyTrans.getRpnHvAB14().toString());
        etRpnHvAB15.setText(silovoyTrans.getRpnHvAB15().toString());
        etRpnHvAB16.setText(silovoyTrans.getRpnHvAB16().toString());
        etRpnHvAB17.setText(silovoyTrans.getRpnHvAB17().toString());
        etRpnHvAB18.setText(silovoyTrans.getRpnHvAB18().toString());
        etRpnHvAB19.setText(silovoyTrans.getRpnHvAB19().toString());
        etRpnHvAB20.setText(silovoyTrans.getRpnHvAB20().toString());
        etRpnHvAB21.setText(silovoyTrans.getRpnHvAB21().toString());
        etRpnHvAB22.setText(silovoyTrans.getRpnHvAB22().toString());
        etRpnHvAB23.setText(silovoyTrans.getRpnHvAB23().toString());
        etRpnHvAB24.setText(silovoyTrans.getRpnHvAB24().toString());
        etRpnHvAB25.setText(silovoyTrans.getRpnHvAB25().toString());
        etRpnHvBC1.setText(silovoyTrans.getRpnHvBC1().toString());
        etRpnHvBC2.setText(silovoyTrans.getRpnHvBC2().toString());
        etRpnHvBC3.setText(silovoyTrans.getRpnHvBC3().toString());
        etRpnHvBC4.setText(silovoyTrans.getRpnHvBC4().toString());
        etRpnHvBC5.setText(silovoyTrans.getRpnHvBC5().toString());
        etRpnHvBC6.setText(silovoyTrans.getRpnHvBC6().toString());
        etRpnHvBC7.setText(silovoyTrans.getRpnHvBC7().toString());
        etRpnHvBC8.setText(silovoyTrans.getRpnHvBC8().toString());
        etRpnHvBC9.setText(silovoyTrans.getRpnHvBC9().toString());
        etRpnHvBC10.setText(silovoyTrans.getRpnHvBC10().toString());
        etRpnHvBC11.setText(silovoyTrans.getRpnHvBC11().toString());
        etRpnHvBC12.setText(silovoyTrans.getRpnHvBC12().toString());
        etRpnHvBC13.setText(silovoyTrans.getRpnHvBC13().toString());
        etRpnHvBC14.setText(silovoyTrans.getRpnHvBC14().toString());
        etRpnHvBC15.setText(silovoyTrans.getRpnHvBC15().toString());
        etRpnHvBC16.setText(silovoyTrans.getRpnHvBC16().toString());
        etRpnHvBC17.setText(silovoyTrans.getRpnHvBC17().toString());
        etRpnHvBC18.setText(silovoyTrans.getRpnHvBC18().toString());
        etRpnHvBC19.setText(silovoyTrans.getRpnHvBC19().toString());
        etRpnHvBC20.setText(silovoyTrans.getRpnHvBC20().toString());
        etRpnHvBC21.setText(silovoyTrans.getRpnHvBC21().toString());
        etRpnHvBC22.setText(silovoyTrans.getRpnHvBC22().toString());
        etRpnHvBC23.setText(silovoyTrans.getRpnHvBC23().toString());
        etRpnHvBC24.setText(silovoyTrans.getRpnHvBC24().toString());
        etRpnHvBC25.setText(silovoyTrans.getRpnHvBC25().toString());
        etRpnHvCA1.setText(silovoyTrans.getRpnHvCA1().toString());
        etRpnHvCA2.setText(silovoyTrans.getRpnHvCA2().toString());
        etRpnHvCA3.setText(silovoyTrans.getRpnHvCA3().toString());
        etRpnHvCA4.setText(silovoyTrans.getRpnHvCA4().toString());
        etRpnHvCA5.setText(silovoyTrans.getRpnHvCA5().toString());
        etRpnHvCA6.setText(silovoyTrans.getRpnHvCA6().toString());
        etRpnHvCA7.setText(silovoyTrans.getRpnHvCA7().toString());
        etRpnHvCA8.setText(silovoyTrans.getRpnHvCA8().toString());
        etRpnHvCA9.setText(silovoyTrans.getRpnHvCA9().toString());
        etRpnHvCA10.setText(silovoyTrans.getRpnHvCA10().toString());
        etRpnHvCA11.setText(silovoyTrans.getRpnHvCA11().toString());
        etRpnHvCA12.setText(silovoyTrans.getRpnHvCA12().toString());
        etRpnHvCA13.setText(silovoyTrans.getRpnHvCA13().toString());
        etRpnHvCA14.setText(silovoyTrans.getRpnHvCA14().toString());
        etRpnHvCA15.setText(silovoyTrans.getRpnHvCA15().toString());
        etRpnHvCA16.setText(silovoyTrans.getRpnHvCA16().toString());
        etRpnHvCA17.setText(silovoyTrans.getRpnHvCA17().toString());
        etRpnHvCA18.setText(silovoyTrans.getRpnHvCA18().toString());
        etRpnHvCA19.setText(silovoyTrans.getRpnHvCA19().toString());
        etRpnHvCA20.setText(silovoyTrans.getRpnHvCA20().toString());
        etRpnHvCA21.setText(silovoyTrans.getRpnHvCA21().toString());
        etRpnHvCA22.setText(silovoyTrans.getRpnHvCA22().toString());
        etRpnHvCA23.setText(silovoyTrans.getRpnHvCA23().toString());
        etRpnHvCA24.setText(silovoyTrans.getRpnHvCA24().toString());
        etRpnHvCA25.setText(silovoyTrans.getRpnHvCA25().toString());
        etNotes.setText(silovoyTrans.getNotes().toString());
        etRpnLvCn.setText(silovoyTrans.getRpnLvCn().toString());
        etRpnLvBn.setText(silovoyTrans.getRpnLvBn().toString());
        etRpnLvAn.setText(silovoyTrans.getRpnLvAn().toString());
    }

    private void init() {
        tvWork= findViewById(R.id.tvWork);
        etObject = findViewById(R.id.etObjectV);
        etDate = findViewById(R.id.etDate);
        // Date setting
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy EEE HH:mm", Locale.getDefault());
        etDate.setText(dateFormat.format(currentDate));
        etNotes = findViewById(R.id.etNotes);
        // Для меню обязательно вызвать setSupportActionBar
        toolbarMain = findViewById(R.id.toolbarMainFreeForm);
        setSupportActionBar(toolbarMain);
    }
}