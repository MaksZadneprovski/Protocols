package com.example.protokols.data_base_package.FreeForm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.example.protokols.utils.ConstantsMy;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainFreeForm extends AppCompatActivity {
    private Date currentDate = new Date();
    private TextView tvWork;
    private FloatingActionButton fabSave;
    private EditText etObject, etDate, etNotes;
    public SharedPreferences sharedPreferences;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_free_form);

        // 1.1 Отключение анимации перехода
        overridePendingTransition(0,0);

        init();

        bottomNavigationView = findViewById(R.id.bottomNavView);
        fabSave = findViewById(R.id.fabFreeForm);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(3).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(4).setEnabled(false);
        bottomNavigationView.getMenu().getItem(4).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){
                    Intent i = new Intent(MainFreeForm.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc2){
                    Intent i = new Intent(MainFreeForm.this, ViewingProtokolsList.class);
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

        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertToBd(true);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        insertToBd(false);
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
    private void insertToBd(Boolean save) {

        // Создание объекта  DAO для работы с БД
        FreeFormDao freeFormDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getFreeFormTableDao();

        // Проверяем поля Объект и Дата на заполненность
        if (!(etObject.getText().toString().equals("")) & !(etDate.getText().toString().equals(""))){

            // Проверка: Хотим ли мы создать новый объект в БД или обновить существующий
            if (!MainActivity.isEditSilovoyTrans){

                // Записываем в БД
                freeFormDao.insertFreeForm(createFreeFormFromEditText());

                // Инкрементируем ID
                MainActivity.incrementId();

                // Показываем Toast
                Toast.makeText(MainFreeForm.this, "Протокол сохранён", Toast.LENGTH_SHORT).show();
            }
            else {
                // Создаем объект по полям для обновления БД
                FreeForm freeFormUpdate = createFreeFormFromEditText();

                // Получение id  объекта для перезаписи в БД из экрана ViewSilovoyTrans
                Intent i = getIntent();
                int idFreeForm = i.getIntExtra(ConstantsMy.ID_KEY, 0);

                freeFormUpdate.setId(idFreeForm);
                freeFormDao.updateFreeForm(freeFormUpdate);

                Toast.makeText(MainFreeForm.this, "Протокол обновлён", Toast.LENGTH_SHORT).show();
            }

        }else  {
            if (save) {
                if(etObject.getText().toString().equals("")& (etDate.getText().toString().equals(""))){
                    Toast.makeText(MainFreeForm.this, "Введите наименование объекта и дату", Toast.LENGTH_LONG).show();
                }
                else if(etDate.getText().toString().equals("")) {
                    Toast.makeText(MainFreeForm.this, "Введите дату", Toast.LENGTH_LONG).show();
                }
                else if(etObject.getText().toString().equals("")) {
                    Toast.makeText(MainFreeForm.this, "Введите наименование объекта", Toast.LENGTH_LONG).show();
                }
            }
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    // 3 Метод : создает объект FreeForm по введенным данным в EditText-ы
    private FreeForm createFreeFormFromEditText() {
        int idForBD = MainActivity.idForDB;
        String object = etObject.getText().toString();
        String work = tvWork.getText().toString();
        String date = etDate.getText().toString();
        String notes = etNotes.getText().toString();

        FreeForm freeForm = new FreeForm(idForBD, object,work,date,notes);
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
        fabSave = findViewById(R.id.fabSilovoyTrans);



        // Установка текста, если осуществляется редактирование
        if (MainActivity.isEditSilovoyTrans){

            // Создание объекта  DAO для работы с БД
            FreeFormDao freeFormDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getFreeFormTableDao();

            // Получаем id объекта freeForm
            Intent i = getIntent();
            int idFreeForm = i.getIntExtra(ConstantsMy.ID_KEY, 0);

            // По id создается объект freeForm, данные для которого берутся из БД
            FreeForm freeForm = freeFormDao.getFreeFormById(idFreeForm);

            // Метод заполнения полей
            setTextToEditTextFromFreeForm(freeForm);
        }
    }
}