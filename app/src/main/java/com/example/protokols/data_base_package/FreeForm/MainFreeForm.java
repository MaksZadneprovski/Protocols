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
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;
import com.example.protokols.utils.ConstantsMy;

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
        Intent i = new Intent(MainFreeForm.this, ViewingProtokolsList.class);
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
                Intent i = new Intent(MainFreeForm.this, ViewingProtokolsList.class);
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
    // 2 Метод : Запись в БД. Проверяет EditText-ы на заполненность и записывает в БД объект, который создается методом createFreeFormFromEditText()
    private void insertToBd() {

        // Создание объекта  DAO для работы с БД
        FreeFormDao freeFormDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getFreeFormTableDao();

        // Проверяем поля Объект и Дата на заполненность
        if (!(etObject.getText().toString().equals("")) & !(etDate.getText().toString().equals(""))){

            // Проверка: Хотим ли мы создать новый объект в БД или обновить существующий
            if (!MainActivity.isEditSilovoyTrans){

                // Записываем в БД
                freeFormDao.insertFreeForm(createFreeFormFromEditText());

                // Показываем Toast
                Toast.makeText(MainFreeForm.this, "Сохранено", Toast.LENGTH_LONG).show();
            }
            else {
                // Создаем объект по полям для обновления БД
                FreeForm freeFormUpdate = createFreeFormFromEditText();

                // Получение id  объекта для перезаписи в БД из экрана ViewSilovoyTrans
                Intent i = getIntent();
                int idFreeForm = i.getIntExtra(ConstantsMy.ID_KEY, 0);

                freeFormUpdate.setId(idFreeForm);
                freeFormDao.updateFreeForm(freeFormUpdate);

                Toast.makeText(MainFreeForm.this, "Обновлено", Toast.LENGTH_LONG).show();
            }

        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    // 3 Метод : создает объект FreeForm по введенным данным в EditText-ы
    private FreeForm createFreeFormFromEditText() {
        String object = etObject.getText().toString();
        String work = tvWork.getText().toString();
        String date = etDate.getText().toString();
        String notes = etNotes.getText().toString();

        FreeForm freeForm = new FreeForm(object,work,date,notes);
        return freeForm;
    }

    // 6 Метод : Заполняет EditText-ы данными из объекта freeform в случае редактирования
    private void setTextToEditTextFromFreeForm(FreeForm freeForm){
        etObject.setText(freeForm.getmObjectOrPodstancia().toString());
        etDate.setText(freeForm.getmDate().toString());
        etNotes.setText(freeForm.getNotes().toString());
    }

    private void init() {
        tvWork= findViewById(R.id.tvWorkFreeForm);
        etObject = findViewById(R.id.etObjectFreeForm);
        etDate = findViewById(R.id.etDateFreeForm);

        // Date setting
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy EEE HH:mm", Locale.getDefault());
        etDate.setText(dateFormat.format(currentDate));
        etNotes = findViewById(R.id.etNotesFreeForm);

        // Для меню обязательно вызвать setSupportActionBar
        toolbarMain = findViewById(R.id.toolbarMainFreeForm);
        setSupportActionBar(toolbarMain);

        // Установка текста, если осуществляется редактирование
        if (MainActivity.isEditSilovoyTrans){

            // Создание объекта  DAO для работы с БД
            FreeFormDao freeFormDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getFreeFormTableDao();

            // Получаем id объекта SilovoyTrans
            Intent i = getIntent();
            int idFreeForm = i.getIntExtra(ConstantsMy.ID_KEY, 0);

            // По id создается объект silovoyTrans, данные для которого берутся из БД
            FreeForm freeForm = freeFormDao.getFreeFormById(idFreeForm);

            // Метод заполнения полей
            setTextToEditTextFromFreeForm(freeForm);
        }
    }
}