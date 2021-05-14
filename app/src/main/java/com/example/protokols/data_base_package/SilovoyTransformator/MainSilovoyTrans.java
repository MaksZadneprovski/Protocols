package com.example.protokols.data_base_package.SilovoyTransformator;

import androidx.annotation.NonNull;
import  androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.protokols.MainActivity;
import com.example.protokols.R;
import com.example.protokols.ViewingProtokolsList;
import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.utils.ConstantsForSilovoyTrans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainSilovoyTrans extends AppCompatActivity {
    private Toolbar toolbarMain;
    private ImageView btnPasport, btnIzol, btnSoprot, btnSchema;
    private LinearLayout linearLayoutPasport,linearLayoutRpn, linearLayoutIzol, linearLayoutSchema, linearLayoutProcent;
    private TableLayout tableRpnHvAB,tableRpnHvAB10,tableRpnHvAB25, tableRpnHvBC,tableRpnHvBC10,tableRpnHvBC25,
            tableRpnHvCA, tableRpnHvCA10,tableRpnHvCA25, tableRpnLv;
    private RadioGroup rgSchema, rgQuantityRpn;
    private RadioButton rbZvezda,rbTreugol,rbOm,rbmOm, rbQuantityRpn5,rbQuantityRpn10,rbQuantityRpn25;
    private TextView tvWork, tvA, tvB, tvC;
    private Date currentDate = new Date();
    private Button btnSave,btnSetConstantForRpn;
    private EditText etObject, etDate, etPasportCurrent, etPasportPower, etPasportType, etPasportVoltage, etPasportVoltageKz, etPasportYearOfManufacture,
            etPasportZavNumber, etTemperature, etIzolHvKoef, etIzolHvR15, etIzolHvR60, etIzolLvKoef, etIzolLvR15, etIzolLvR60,
            etSwitchOperatingPosition, etRpnHvAB1, etRpnHvAB2, etRpnHvAB3, etRpnHvAB4, etRpnHvAB5, etRpnHvAB6, etRpnHvAB7, etRpnHvAB8,
            etRpnHvAB9, etRpnHvAB10, etRpnHvAB11, etRpnHvAB12, etRpnHvAB13, etRpnHvAB14, etRpnHvAB15, etRpnHvAB16, etRpnHvAB17, etRpnHvAB18,
            etRpnHvAB19, etRpnHvAB20, etRpnHvAB21, etRpnHvAB22, etRpnHvAB23, etRpnHvAB24, etRpnHvAB25, etRpnHvBC1, etRpnHvBC2, etRpnHvBC3,
            etRpnHvBC4, etRpnHvBC5, etRpnHvBC6, etRpnHvBC7, etRpnHvBC8, etRpnHvBC9, etRpnHvBC10, etRpnHvBC11, etRpnHvBC12, etRpnHvBC13,
            etRpnHvBC14, etRpnHvBC15, etRpnHvBC16, etRpnHvBC17, etRpnHvBC18, etRpnHvBC19, etRpnHvBC20, etRpnHvBC21, etRpnHvBC22, etRpnHvBC23,
            etRpnHvBC24, etRpnHvBC25, etRpnHvCA1, etRpnHvCA2, etRpnHvCA3, etRpnHvCA4, etRpnHvCA5, etRpnHvCA6, etRpnHvCA7, etRpnHvCA8, etRpnHvCA9,
            etRpnHvCA10, etRpnHvCA11, etRpnHvCA12, etRpnHvCA13, etRpnHvCA14, etRpnHvCA15, etRpnHvCA16, etRpnHvCA17, etRpnHvCA18, etRpnHvCA19,
            etRpnHvCA20, etRpnHvCA21, etRpnHvCA22, etRpnHvCA23, etRpnHvCA24, etRpnHvCA25,etNotes, etRpnLvCn,etRpnLvBn,etRpnLvAn,etWindingConnectionDiagramLv,etSetConstantForRpn;
    public final String TAG = "MyLogger";

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    // 1 onCreate :
        // 1.1 Отключение анимации перехода
        // 1.2 Создание  объекта DAO для работы с БД
        // 1.3 Обработчик нажатия радиокнопки, выбирающей схему вторички
        // 1.4 Обработчик нажатия радиокнопки, выбирающей количество ступеней рпн

    // Метод : Создает меню в тулбаре из указанного ресурса

    // Метод : Обрабатывает нажатия пунктов меню

    // Метод обработки кнопки назад



    // Инициализация

    //  Обработчики нажатия скрывающегося поля


    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silovoy_trans);

        /////////////////////////////////////////////////////////////////////////////////////////////
        // 1.1 Отключение анимации перехода
        overridePendingTransition(0,0);

        /////////////////////////////////////////////////////////////////////////////////////////////
        // 1.2 Создание объекта  DAO для работы с БД
        SilovoyTransDao silovoyTransDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getSilovoyTransTableDao();

        /////////////////////////////////////////////////////////////////////////////////////////////
        init();

        ////////////////////////////////////////////////////////////////////////////////////////////
        // 1.3 Обработчик нажатия радиокнопки, выбирающей схему вторички
        rgSchema.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case (R.id.silTransImgRadioSchemaZvezda):
                        tvA.setText("a-n");
                        tvB.setText("b-n");
                        tvC.setText("c-n");
                        break;
                    case (R.id.silTransImgRadioSchemaTreugol):
                        tvA.setText("a-b");
                        tvB.setText("b-c");
                        tvC.setText("c-a");
                        break;
                }
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////
        // 1.4 Обработчик нажатия радиокнопки, выбирающей количество ступеней рпн
        rgQuantityRpn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case (R.id.rbQuantityRpn5):
                        setVisibileQuantity5();
                        break;
                    case (R.id.rbQuantityRpn10):
                        setVisibileQuantity10();
                        break;
                    case (R.id.rbQuantityRpn25):
                        setVisibileQuantity25();
                        break;
                }
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////
    } // Конец onCreate

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

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    // Методы : проверяют радиокнопки и возвращают результат в виде строки
    private String  getUnitsDCresistance() {
        String s ="Om";
        if (rbOm.isChecked()){ s = "Om"; } else { s = "mOm"; }return s ;
    }

    private String  getQuantityRpn() {
        String s ="5";
        if (rbQuantityRpn5.isChecked()){ s = "5"; } else if (rbQuantityRpn10.isChecked()){ s = "10"; }else  { s = "25"; }return s ;
    }

    private String  getWindingConnectionDiagramLv() {
        String s ="zvezda";
        if (rbOm.isChecked()){ s = "zvezda"; } else { s = "treug"; }return s ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    // Инициализация
    private void init(){
        // Buttons
        btnPasport = findViewById(R.id.silTransImgBtnPasport);
        btnIzol = findViewById(R.id.silTransImgBtnIzol);
        btnSoprot = findViewById(R.id.silTransImgBtnSoprotiv);
        btnSchema = findViewById(R.id.silTransImgBtnSchema);
        rgSchema = findViewById(R.id.silTransImgRadioGroupSchema);
        rgQuantityRpn = findViewById(R.id.rgQuantityRpn);
        rbTreugol = findViewById(R.id.silTransImgRadioSchemaTreugol);
        rbZvezda = findViewById(R.id.silTransImgRadioSchemaZvezda);
        rbOm = findViewById(R.id.silTransImgRadioSchemaOm);
        rbQuantityRpn5 = findViewById(R.id.rbQuantityRpn5);
        rbQuantityRpn10 = findViewById(R.id.rbQuantityRpn10);
        rbQuantityRpn25 = findViewById(R.id.rbQuantityRpn25);
        btnSetConstantForRpn =findViewById(R.id.btnSetConstantForRpn);

        // TextView
        tvWork= findViewById(R.id.tvWork);
        tvA= findViewById(R.id.tvSchemaFazaA);
        tvB= findViewById(R.id.tvSchemaFazaB);
        tvC= findViewById(R.id.tvSchemaFazaC);
        //LinearLayout
        linearLayoutPasport = findViewById(R.id.linearLayoutPasport);
        linearLayoutIzol = findViewById(R.id.linaerLayoutIzol);
        linearLayoutRpn =findViewById(R.id.linearLayoutRpnInf);
        linearLayoutSchema = findViewById(R.id.linearLayoutSchema);
        linearLayoutProcent = findViewById(R.id.linearLayoutProcent);
        // Tables
        tableRpnHvAB = findViewById(R.id.tableRpnHvAB);
        tableRpnHvAB10 = findViewById(R.id.tableRpnHvAB10);
        tableRpnHvAB25 = findViewById(R.id.tableRpnHvAB25);
        tableRpnHvBC = findViewById(R.id.tableRpnHvBC);
        tableRpnHvBC10 = findViewById(R.id.tableRpnHvBC10);
        tableRpnHvBC25 = findViewById(R.id.tableRpnHvBC25);
        tableRpnHvCA = findViewById(R.id.tableRpnHvCA);
        tableRpnHvCA10 = findViewById(R.id.tableRpnHvCA10);
        tableRpnHvCA25 = findViewById(R.id.tableRpnHvCA25);
        tableRpnLv = findViewById(R.id.tableRpnLv);
        // Initial Visibility
        linearLayoutPasport.setVisibility(linearLayoutPasport.GONE);
        linearLayoutIzol.setVisibility(linearLayoutIzol.GONE);
        linearLayoutRpn.setVisibility(linearLayoutRpn.GONE);
        tableRpnHvAB.setVisibility(tableRpnHvAB.GONE);
        tableRpnHvAB10.setVisibility(tableRpnHvAB10.GONE);
        tableRpnHvAB25.setVisibility(tableRpnHvAB25.GONE);
        tableRpnHvBC.setVisibility(tableRpnHvBC.GONE);
        tableRpnHvBC10.setVisibility(tableRpnHvBC10.GONE);
        tableRpnHvBC25.setVisibility(tableRpnHvBC25.GONE);
        tableRpnHvCA.setVisibility(tableRpnHvCA.GONE);
        tableRpnHvCA10.setVisibility(tableRpnHvCA10.GONE);
        tableRpnHvCA25.setVisibility(tableRpnHvCA25.GONE);
        tableRpnLv.setVisibility(tableRpnLv.GONE);
        linearLayoutSchema.setVisibility(tableRpnLv.GONE);
        linearLayoutProcent.setVisibility(tableRpnLv.GONE);
        rgSchema.setVisibility(rgSchema.GONE);
        rbZvezda.setChecked(true);
        rbOm.setChecked(true);
        rbQuantityRpn5.setChecked(true);
        // Date setting
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy EEE HH:mm", Locale.getDefault());
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
         etRpnHvAB7 = findViewById(R.id.etRpnHvAB7);
         etRpnHvAB8 = findViewById(R.id.etRpnHvAB8);
         etRpnHvAB9 = findViewById(R.id.etRpnHvAB9);
         etRpnHvAB10 = findViewById(R.id.etRpnHvAB10);
         etRpnHvAB11 = findViewById(R.id.etRpnHvAB11);
         etRpnHvAB12 = findViewById(R.id.etRpnHvAB12);
         etRpnHvAB13 = findViewById(R.id.etRpnHvAB13);
         etRpnHvAB14 = findViewById(R.id.etRpnHvAB14);
         etRpnHvAB15 = findViewById(R.id.etRpnHvAB15);
         etRpnHvAB16 = findViewById(R.id.etRpnHvAB16);
         etRpnHvAB17 = findViewById(R.id.etRpnHvAB17);
         etRpnHvAB18 = findViewById(R.id.etRpnHvAB18);
         etRpnHvAB19 = findViewById(R.id.etRpnHvAB19);
         etRpnHvAB20 = findViewById(R.id.etRpnHvAB20);
         etRpnHvAB21 = findViewById(R.id.etRpnHvAB21);
         etRpnHvAB22 = findViewById(R.id.etRpnHvAB22);
         etRpnHvAB23 = findViewById(R.id.etRpnHvAB23);
         etRpnHvAB24 = findViewById(R.id.etRpnHvAB24);
         etRpnHvAB25 = findViewById(R.id.etRpnHvAB25);
         etRpnHvBC1 = findViewById(R.id.etRpnHvBC1);
         etRpnHvBC2 = findViewById(R.id.etRpnHvBC2);
         etRpnHvBC3 = findViewById(R.id.etRpnHvBC3);
         etRpnHvBC4 = findViewById(R.id.etRpnHvBC4);
         etRpnHvBC5 = findViewById(R.id.etRpnHvBC5);
         etRpnHvBC6 = findViewById(R.id.etRpnHvBC6);
         etRpnHvBC7 = findViewById(R.id.etRpnHvBC7);
         etRpnHvBC8 = findViewById(R.id.etRpnHvBC8);
         etRpnHvBC9 = findViewById(R.id.etRpnHvBC9);
         etRpnHvBC10 = findViewById(R.id.etRpnHvBC10);
         etRpnHvBC11 = findViewById(R.id.etRpnHvBC11);
         etRpnHvBC12 = findViewById(R.id.etRpnHvBC12);
         etRpnHvBC13 = findViewById(R.id.etRpnHvBC13);
         etRpnHvBC14 = findViewById(R.id.etRpnHvBC14);
         etRpnHvBC15 = findViewById(R.id.etRpnHvBC15);
         etRpnHvBC16 = findViewById(R.id.etRpnHvBC16);
         etRpnHvBC17 = findViewById(R.id.etRpnHvBC17);
         etRpnHvBC18 = findViewById(R.id.etRpnHvBC18);
         etRpnHvBC19 = findViewById(R.id.etRpnHvBC19);
         etRpnHvBC20 = findViewById(R.id.etRpnHvBC20);
         etRpnHvBC21 = findViewById(R.id.etRpnHvBC21);
         etRpnHvBC22 = findViewById(R.id.etRpnHvBC22);
         etRpnHvBC23 = findViewById(R.id.etRpnHvBC23);
         etRpnHvBC24 = findViewById(R.id.etRpnHvBC24);
         etRpnHvBC25 = findViewById(R.id.etRpnHvBC25);
         etRpnHvCA1 = findViewById(R.id.etRpnHvCA1);
         etRpnHvCA2 = findViewById(R.id.etRpnHvCA2);
         etRpnHvCA3 = findViewById(R.id.etRpnHvCA3);
         etRpnHvCA4 = findViewById(R.id.etRpnHvCA4);
         etRpnHvCA5 = findViewById(R.id.etRpnHvCA5);
         etRpnHvCA6 = findViewById(R.id.etRpnHvCA6);
         etRpnHvCA7 = findViewById(R.id.etRpnHvCA7);
         etRpnHvCA8 = findViewById(R.id.etRpnHvCA8);
         etRpnHvCA9 = findViewById(R.id.etRpnHvCA9);
         etRpnHvCA10 = findViewById(R.id.etRpnHvCA10);
         etRpnHvCA11 = findViewById(R.id.etRpnHvCA11);
         etRpnHvCA12 = findViewById(R.id.etRpnHvCA12);
         etRpnHvCA13 = findViewById(R.id.etRpnHvCA13);
         etRpnHvCA14 = findViewById(R.id.etRpnHvCA14);
         etRpnHvCA15 = findViewById(R.id.etRpnHvCA15);
         etRpnHvCA16 = findViewById(R.id.etRpnHvCA16);
         etRpnHvCA17 = findViewById(R.id.etRpnHvCA17);
         etRpnHvCA18 = findViewById(R.id.etRpnHvCA18);
         etRpnHvCA19 = findViewById(R.id.etRpnHvCA19);
         etRpnHvCA20 = findViewById(R.id.etRpnHvCA20);
         etRpnHvCA21 = findViewById(R.id.etRpnHvCA21);
         etRpnHvCA22 = findViewById(R.id.etRpnHvCA22);
         etRpnHvCA23 = findViewById(R.id.etRpnHvCA23);
         etRpnHvCA24 = findViewById(R.id.etRpnHvCA24);
         etRpnHvCA25 = findViewById(R.id.etRpnHvCA25);
        etNotes = findViewById(R.id.etNotes);
        etRpnLvCn = findViewById(R.id.etRpnLvCn);
        etRpnLvBn = findViewById(R.id.etRpnLvBn);
        etRpnLvAn = findViewById(R.id.etRpnLvAn);
        etSetConstantForRpn = findViewById(R.id.etSetConstantForRpn);
        // Для меню обязательно вызвать setSupportActionBar
        toolbarMain = findViewById(R.id.toolbarMainSilovoyTrans);
        setSupportActionBar(toolbarMain);

        // Установка текста, если осуществляется редактирование
        if (MainActivity.isEditSilovoyTrans){

            // Создание объекта  DAO для работы с БД
            SilovoyTransDao silovoyTransDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getSilovoyTransTableDao();

            // Получаем id объекта SilovoyTrans
            Intent i = getIntent();
            int idSilovoyTrans = i.getIntExtra(ConstantsForSilovoyTrans.ID_KEY, 0);

            // По id создается объект silovoyTrans, данные для которого берутся из БД
            SilovoyTrans silovoyTrans = silovoyTransDao.getSilovoyTransTableById(idSilovoyTrans);

            // Метод заполнения полей
            setTextToEditTextFromSilovoyTrans(silovoyTrans);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
     //  Обработчики нажатия скрывающегося поля
    public void onClickBtnPasport(View view) {
        if (linearLayoutPasport.getVisibility()==View.GONE){
            linearLayoutPasport.setVisibility(linearLayoutPasport.VISIBLE);
            btnPasport.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
        }
        else {
            linearLayoutPasport.setVisibility(linearLayoutPasport.GONE);
            btnPasport.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
        }
    }

    public void onClickBtnIzol(View view) {
        if (linearLayoutIzol.getVisibility()==View.GONE){
            linearLayoutIzol.setVisibility(linearLayoutIzol.VISIBLE);
            btnIzol.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
        }
        else {
            linearLayoutIzol.setVisibility(linearLayoutIzol.GONE);
            btnIzol.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
        }
    }

    public void onClickBtnSoprot(View view) {
        if (tableRpnHvAB.getVisibility()==View.GONE){
            linearLayoutRpn.setVisibility(linearLayoutRpn.VISIBLE);
            tableRpnHvAB.setVisibility(tableRpnHvAB.VISIBLE);
            tableRpnHvBC.setVisibility(tableRpnHvBC.VISIBLE);
            tableRpnHvCA.setVisibility(tableRpnHvCA.VISIBLE);
            tableRpnLv.setVisibility(tableRpnLv.VISIBLE);
            linearLayoutSchema.setVisibility(linearLayoutSchema.VISIBLE);
            linearLayoutProcent.setVisibility(linearLayoutSchema.VISIBLE);
            btnSoprot.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
            rbQuantityRpn5.setChecked(true);
        }
        else {
            linearLayoutRpn.setVisibility(linearLayoutRpn.GONE);
            tableRpnHvAB.setVisibility(tableRpnHvAB.GONE);
            tableRpnHvAB10.setVisibility(tableRpnHvAB10.GONE);
            tableRpnHvAB25.setVisibility(tableRpnHvAB25.GONE);
            tableRpnHvBC.setVisibility(tableRpnHvBC.GONE);
            tableRpnHvBC10.setVisibility(tableRpnHvBC10.GONE);
            tableRpnHvBC25.setVisibility(tableRpnHvBC25.GONE);
            tableRpnHvCA.setVisibility(tableRpnHvCA.GONE);
            tableRpnHvCA10.setVisibility(tableRpnHvCA10.GONE);
            tableRpnHvCA25.setVisibility(tableRpnHvCA25.GONE);
            tableRpnLv.setVisibility(tableRpnLv.GONE);
            linearLayoutSchema.setVisibility(tableRpnLv.GONE);
            linearLayoutProcent.setVisibility(tableRpnLv.GONE);
            btnSoprot.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);

        }
    }

    public void onClickBtnSchema(View view) {
        if (rgSchema.getVisibility()==View.GONE){
            rgSchema.setVisibility(rgSchema.VISIBLE);
            btnSchema.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
        }
        else {
            rgSchema.setVisibility(rgSchema.GONE);
            btnSchema.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    // Методы : устанавливают видимость необходимого количества полей ступеней РПН
    private void setVisibileQuantity25() {
        tableRpnHvAB.setVisibility(tableRpnHvAB.VISIBLE);
        tableRpnHvBC.setVisibility(tableRpnHvBC.VISIBLE);
        tableRpnHvCA.setVisibility(tableRpnHvCA.VISIBLE);
        tableRpnHvAB10.setVisibility(tableRpnHvAB10.VISIBLE);
        tableRpnHvBC10.setVisibility(tableRpnHvBC10.VISIBLE);
        tableRpnHvCA10.setVisibility(tableRpnHvCA10.VISIBLE);
        tableRpnHvAB25.setVisibility(tableRpnHvAB25.VISIBLE);
        tableRpnHvBC25.setVisibility(tableRpnHvBC25.VISIBLE);
        tableRpnHvCA25.setVisibility(tableRpnHvCA25.VISIBLE);

    }

    private void setVisibileQuantity10() {
        tableRpnHvAB.setVisibility(tableRpnHvAB.VISIBLE);
        tableRpnHvBC.setVisibility(tableRpnHvBC.VISIBLE);
        tableRpnHvCA.setVisibility(tableRpnHvCA.VISIBLE);
        tableRpnHvAB10.setVisibility(tableRpnHvAB10.VISIBLE);
        tableRpnHvBC10.setVisibility(tableRpnHvBC10.VISIBLE);
        tableRpnHvCA10.setVisibility(tableRpnHvCA10.VISIBLE);
        tableRpnHvAB25.setVisibility(tableRpnHvAB25.GONE);
        tableRpnHvBC25.setVisibility(tableRpnHvBC25.GONE);
        tableRpnHvCA25.setVisibility(tableRpnHvCA25.GONE);
    }

    private void setVisibileQuantity5() {
        tableRpnHvAB.setVisibility(tableRpnHvAB.VISIBLE);
        tableRpnHvBC.setVisibility(tableRpnHvBC.VISIBLE);
        tableRpnHvCA.setVisibility(tableRpnHvCA.VISIBLE);
        tableRpnHvAB10.setVisibility(tableRpnHvAB10.GONE);
        tableRpnHvBC10.setVisibility(tableRpnHvBC10.GONE);
        tableRpnHvCA10.setVisibility(tableRpnHvCA10.GONE);
        tableRpnHvAB25.setVisibility(tableRpnHvAB25.GONE);
        tableRpnHvBC25.setVisibility(tableRpnHvBC25.GONE);
        tableRpnHvCA25.setVisibility(tableRpnHvCA25.GONE);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    //  Метод : Проверка количества нужных к заполнению полей  сопротивления константой (5, 10, 25)
    public void onClickBtnSetConstant(View view) {
        String constantForEt = etSetConstantForRpn.getText().toString();
        if (rbQuantityRpn5.isChecked()){
            setConstant5(constantForEt);
        }
        else if (rbQuantityRpn10.isChecked()){
            setConstant5(constantForEt);
            setConstant10(constantForEt);
        }
        else if (rbQuantityRpn25.isChecked()){
            setConstant5(constantForEt);
            setConstant10(constantForEt);
            setConstant25(constantForEt);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    //  Методы : Получают String и вставляют ее в поля сопротивления
    private void setConstant5 (String constantForEt) {
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
    private void setConstant10 (String constantForEt) {
        etRpnHvAB6.setText(constantForEt);
        etRpnHvAB6.setSelection(etRpnHvAB6.getText().length());
        etRpnHvAB7.setText(constantForEt);
        etRpnHvAB7.setSelection(etRpnHvAB7.getText().length());
        etRpnHvAB8.setText(constantForEt);
        etRpnHvAB8.setSelection(etRpnHvAB8.getText().length());
        etRpnHvAB9.setText(constantForEt);
        etRpnHvAB9.setSelection(etRpnHvAB9.getText().length());
        etRpnHvAB10.setText(constantForEt);
        etRpnHvAB10.setSelection(etRpnHvAB10.getText().length());
        etRpnHvBC6.setText(constantForEt);
        etRpnHvBC6.setSelection(etRpnHvBC6.getText().length());
        etRpnHvBC7.setText(constantForEt);
        etRpnHvBC7.setSelection(etRpnHvBC7.getText().length());
        etRpnHvBC8.setText(constantForEt);
        etRpnHvBC8.setSelection(etRpnHvBC8.getText().length());
        etRpnHvBC9.setText(constantForEt);
        etRpnHvBC9.setSelection(etRpnHvBC9.getText().length());
        etRpnHvBC10.setText(constantForEt);
        etRpnHvBC10.setSelection(etRpnHvBC10.getText().length());
        etRpnHvCA6.setText(constantForEt);
        etRpnHvCA6.setSelection(etRpnHvCA6.getText().length());
        etRpnHvCA7.setText(constantForEt);
        etRpnHvCA7.setSelection(etRpnHvCA7.getText().length());
        etRpnHvCA8.setText(constantForEt);
        etRpnHvCA8.setSelection(etRpnHvCA8.getText().length());
        etRpnHvCA9.setText(constantForEt);
        etRpnHvCA9.setSelection(etRpnHvCA9.getText().length());
        etRpnHvCA10.setText(constantForEt);
        etRpnHvCA10.setSelection(etRpnHvCA10.getText().length());
    }
    private void setConstant25 (String constantForEt) {
        etRpnHvAB11.setText(constantForEt);
        etRpnHvAB11.setSelection(etRpnHvAB11.getText().length());
        etRpnHvAB12.setText(constantForEt);
        etRpnHvAB12.setSelection(etRpnHvAB12.getText().length());
        etRpnHvAB13.setText(constantForEt);
        etRpnHvAB13.setSelection(etRpnHvAB13.getText().length());
        etRpnHvAB14.setText(constantForEt);
        etRpnHvAB14.setSelection(etRpnHvAB14.getText().length());
        etRpnHvAB15.setText(constantForEt);
        etRpnHvAB15.setSelection(etRpnHvAB15.getText().length());
        etRpnHvAB16.setText(constantForEt);
        etRpnHvAB16.setSelection(etRpnHvAB16.getText().length());
        etRpnHvAB17.setText(constantForEt);
        etRpnHvAB17.setSelection(etRpnHvAB17.getText().length());
        etRpnHvAB18.setText(constantForEt);
        etRpnHvAB18.setSelection(etRpnHvAB18.getText().length());
        etRpnHvAB19.setText(constantForEt);
        etRpnHvAB19.setSelection(etRpnHvAB19.getText().length());
        etRpnHvAB20.setText(constantForEt);
        etRpnHvAB20.setSelection(etRpnHvAB20.getText().length());
        etRpnHvAB21.setText(constantForEt);
        etRpnHvAB21.setSelection(etRpnHvAB21.getText().length());
        etRpnHvAB22.setText(constantForEt);
        etRpnHvAB22.setSelection(etRpnHvAB22.getText().length());
        etRpnHvAB23.setText(constantForEt);
        etRpnHvAB23.setSelection(etRpnHvAB23.getText().length());
        etRpnHvAB24.setText(constantForEt);
        etRpnHvAB24.setSelection(etRpnHvAB24.getText().length());
        etRpnHvAB25.setText(constantForEt);
        etRpnHvAB25.setSelection(etRpnHvAB25.getText().length());
        etRpnHvBC11.setText(constantForEt);
        etRpnHvBC11.setSelection(etRpnHvBC11.getText().length());
        etRpnHvBC12.setText(constantForEt);
        etRpnHvBC12.setSelection(etRpnHvBC12.getText().length());
        etRpnHvBC13.setText(constantForEt);
        etRpnHvBC13.setSelection(etRpnHvBC13.getText().length());
        etRpnHvBC14.setText(constantForEt);
        etRpnHvBC14.setSelection(etRpnHvBC14.getText().length());
        etRpnHvBC15.setText(constantForEt);
        etRpnHvBC15.setSelection(etRpnHvBC15.getText().length());
        etRpnHvBC16.setText(constantForEt);
        etRpnHvBC16.setSelection(etRpnHvBC16.getText().length());
        etRpnHvBC17.setText(constantForEt);
        etRpnHvBC17.setSelection(etRpnHvBC17.getText().length());
        etRpnHvBC18.setText(constantForEt);
        etRpnHvBC18.setSelection(etRpnHvBC18.getText().length());
        etRpnHvBC19.setText(constantForEt);
        etRpnHvBC19.setSelection(etRpnHvBC19.getText().length());
        etRpnHvBC20.setText(constantForEt);
        etRpnHvBC20.setSelection(etRpnHvBC20.getText().length());
        etRpnHvBC21.setText(constantForEt);
        etRpnHvBC21.setSelection(etRpnHvBC21.getText().length());
        etRpnHvBC22.setText(constantForEt);
        etRpnHvBC22.setSelection(etRpnHvBC22.getText().length());
        etRpnHvBC23.setText(constantForEt);
        etRpnHvBC23.setSelection(etRpnHvBC23.getText().length());
        etRpnHvBC24.setText(constantForEt);
        etRpnHvBC24.setSelection(etRpnHvBC24.getText().length());
        etRpnHvBC25.setText(constantForEt);
        etRpnHvBC25.setSelection(etRpnHvBC25.getText().length());
        etRpnHvCA11.setText(constantForEt);
        etRpnHvCA11.setSelection(etRpnHvCA11.getText().length());
        etRpnHvCA12.setText(constantForEt);
        etRpnHvCA12.setSelection(etRpnHvCA12.getText().length());
        etRpnHvCA13.setText(constantForEt);
        etRpnHvCA13.setSelection(etRpnHvCA13.getText().length());
        etRpnHvCA14.setText(constantForEt);
        etRpnHvCA14.setSelection(etRpnHvCA14.getText().length());
        etRpnHvCA15.setText(constantForEt);
        etRpnHvCA15.setSelection(etRpnHvCA15.getText().length());
        etRpnHvCA16.setText(constantForEt);
        etRpnHvCA16.setSelection(etRpnHvCA16.getText().length());
        etRpnHvCA17.setText(constantForEt);
        etRpnHvCA17.setSelection(etRpnHvCA17.getText().length());
        etRpnHvCA18.setText(constantForEt);
        etRpnHvCA18.setSelection(etRpnHvCA18.getText().length());
        etRpnHvCA19.setText(constantForEt);
        etRpnHvCA19.setSelection(etRpnHvCA19.getText().length());
        etRpnHvCA20.setText(constantForEt);
        etRpnHvCA20.setSelection(etRpnHvCA20.getText().length());
        etRpnHvCA21.setText(constantForEt);
        etRpnHvCA21.setSelection(etRpnHvCA21.getText().length());
        etRpnHvCA22.setText(constantForEt);
        etRpnHvCA22.setSelection(etRpnHvCA22.getText().length());
        etRpnHvCA23.setText(constantForEt);
        etRpnHvCA23.setSelection(etRpnHvCA23.getText().length());
        etRpnHvCA24.setText(constantForEt);
        etRpnHvCA24.setSelection(etRpnHvCA24.getText().length());
        etRpnHvCA25.setText(constantForEt);
        etRpnHvCA25.setSelection(etRpnHvCA25.getText().length());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////



}