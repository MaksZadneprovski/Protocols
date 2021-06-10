package com.example.protokols.data_base_package.FreeForm;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.protokols.MainActivity;
import com.example.protokols.R;
import com.example.protokols.ViewingProtokolsList;
import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.data_base_package.SilovoyTransformator.MainSilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;
import com.example.protokols.data_base_package.SilovoyTransformator.ViewSilovoyTrans;
import com.example.protokols.utils.ConstantsMy;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class ViewFreeForm extends AppCompatActivity {
    private TextView tvWork;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fabEdit ;
    private TextInputEditText etObject, etDate, etNotes;
    private int idFreeForm;
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
        FreeForm freeForm = getFreeFormFromBd();

        // Заполнение полей данными из объекта
        setTextToEditTextFromSilovoyTrans(freeForm);

        // Получение id объекта для отправки на экран MainSilovoyTrans, в случае редактирования
        idFreeForm = freeForm.getId();

        // Статичная переменная, чтобы определить, хочу ли я редактировать объект или создаю новый
        MainActivity.isEditSilovoyTrans= true;

        // Меняем значок fab
        fabEdit.setImageResource(R.drawable.ic_edit);

        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход на экран создания объекта, с отправкой id объекта, который нужно редактировать
                Intent i = new Intent(ViewFreeForm.this, MainFreeForm.class);
                i.putExtra(ConstantsMy.ID_KEY,idFreeForm );
                startActivity(i);
                finish();
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){
                    Intent i = new Intent( ViewFreeForm.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc2){
                    Intent i = new Intent( ViewFreeForm.this, ViewingProtokolsList.class);
                    startActivity(i);
                    finish();
                }
                return true;
            }
        });

    } // Конец onCreate
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////

    FreeForm getFreeFormFromBd(){
        // Создание объекта  DAO для работы с БД
        FreeFormDao freeFormDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getFreeFormTableDao();

        // Получаем данные Intent
        Intent i = getIntent();

        // Получаем id объекта SilovoyTrans, по элементу из списка  ViewingProtokolsList, который был нажат
        int idOfSelectedItem = i.getIntExtra(ConstantsMy.ID_KEY, 0);

        // По id создается объект silovoyTrans, данные для которого берутся из БД
        FreeForm freeForm = freeFormDao.getFreeFormById(idOfSelectedItem);

        return freeForm;
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
            Intent i = new Intent(ViewFreeForm.this, ViewingProtokolsList.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    private void setTextToEditTextFromSilovoyTrans(SilovoyTrans silovoyTrans) {

        // Заполняем EditText-ы данными из объекта silovoyTrans
        etObject.setText(silovoyTrans.getmObjectOrPodstancia().toString());
        etDate.setText(silovoyTrans.getmDate().toString());
        etNotes.setText(silovoyTrans.getNotes().toString());
    }

    private void setUneditableEt(){

        etObject.setClickable(false);
        etDate.setClickable(false);
        etNotes.setClickable(false);

        etObject.setLongClickable(false);
        etDate.setLongClickable(false);
        etNotes.setLongClickable(false);

        etObject.setFocusable(false);
        etDate.setFocusable(false);
        etNotes.setFocusable(false);

        etObject.setFocusableInTouchMode(false);
        etDate.setFocusableInTouchMode(false);
        etNotes.setFocusableInTouchMode(false);

        etObject.setCursorVisible(false);
        etDate.setCursorVisible(false);
        etNotes.setCursorVisible(false);

    }
    private void init(){

        // TextView
        tvWork= findViewById(R.id.tvWorkFreeForm);

        // EditText
        etObject = findViewById(R.id.etObjectFreeForm);
        etDate = findViewById(R.id.etDateFreeForm);
        etNotes = findViewById(R.id.etNotesFreeForm);
        fabEdit = findViewById(R.id.fabFreeForm);
        bottomNavigationView = findViewById(R.id.bottomNavView);

        tvWork.setText("Просмотр\nпротокола");

        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);
    }
}
