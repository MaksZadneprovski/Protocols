package com.example.protokols;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.data_base_package.FreeForm.FreeForm;
import com.example.protokols.data_base_package.FreeForm.FreeFormDao;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;
import com.example.protokols.data_base_package.SilovoyTransformator.ViewSilovoyTrans;
import com.example.protokols.utils.ConstantsMy;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ViewingProtokolsList extends AppCompatActivity {
    private ListView lv;
    private List<SilovoyTrans> silovoyTransList;
    private List <FreeForm> freeFormList;
    private FloatingActionButton fabSave;
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing_protokols_list);

        //Отключение анимации перехода
        overridePendingTransition(0,0);

        // Статичная переменная, чтобы определить, хочу ли я редактировать объект или создаю новый
        // Так как с этого экрана нельзя нажать кнопку редактировать, то переменная false
        MainActivity.isEditSilovoyTrans= false;


        // Инициализация
        lv = findViewById(R.id.lv);

        // Создание  объекта DAO для работы с БД
        SilovoyTransDao silovoyTransDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getSilovoyTransTableDao();
        FreeFormDao freeFormDao = ((AppDelegateBd)getApplicationContext()).getAppDatabaseClass().getFreeFormTableDao();

        // По запросу возвращается список всех объектов из таблицы БД SilovoyTrans
        silovoyTransList = silovoyTransDao.getAll();
        // По запросу возвращается список всех объектов из таблицы БД FreeForm
        freeFormList = freeFormDao.getAll();

        // Конструктор адаптера
        AdapterForList adapter = new AdapterForList(this, getArrayList(silovoyTransList, freeFormList));

        // Установка адаптера для ListView
        lv.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        fabSave = findViewById(R.id.fabViewingProtocols);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){
                    Intent i = new Intent(ViewingProtokolsList.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc2){
                    Intent i = new Intent(ViewingProtokolsList.this, ViewingProtokolsList.class);
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

        // Нажатие на ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassForViewingListProtocols classForViewingListProtocols = getArrayList(silovoyTransList, freeFormList).get(position);
                String work =classForViewingListProtocols.getWork();
                if (work.equals("Испытание\nсилового\nтрансформатора")){
                    Intent i = new Intent(ViewingProtokolsList.this, ViewSilovoyTrans.class);
                    int idOfSelectedItem = classForViewingListProtocols.getId();
                    i.putExtra(ConstantsMy.ID_KEY,idOfSelectedItem );
                    startActivity(i);
                    finish();
                }

            }
        });

        // Долгое нажатие на ListView
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Удаляем объект из БД
                silovoyTransDao.deleteSilovoyTrans(silovoyTransList.get(position));
                // Заново берем данные из БД
                silovoyTransList =silovoyTransDao.getAll();
                freeFormList = freeFormDao.getAll();
                // Обновляем адаптер
                AdapterForList adapter = new AdapterForList(ViewingProtokolsList.this, getArrayList(silovoyTransList, freeFormList));
                lv.setAdapter(adapter);
                return false;
            }
        });
    }

    // Метод : Создает ArrayList из приходящих в параметры List-ов
    private ArrayList<ClassForViewingListProtocols> getArrayList(List<SilovoyTrans> silovoyTransList, List <FreeForm> freeFormList ) {

        ArrayList<ClassForViewingListProtocols> arrayList = new ArrayList<ClassForViewingListProtocols>();

        //  Проход по списку silovoyTransList, создание объекта ClassForViewingListProtocols с такими же полями и занесение его в список
        for (int i = 0; i< silovoyTransList.size(); i++){
            int id = silovoyTransList.get(i).getId();
            String object = silovoyTransList.get(i).getmObjectOrPodstancia();
            String work = silovoyTransList.get(i).getmWork();
            String date = silovoyTransList.get(i).getmDate();
            ClassForViewingListProtocols classForViewingListProtocols = new ClassForViewingListProtocols(id,work,object,date);
            arrayList.add(i,classForViewingListProtocols);
        }

        //  Проход по списку freeFormList, создание объекта ClassForViewingListProtocols с такими же полями и занесение его в список
        for (int i = 0; i< freeFormList.size(); i++){
            int id = freeFormList.get(i).getId();
            String object = freeFormList.get(i).getmObjectOrPodstancia();
            String work = freeFormList.get(i).getmWork();
            String date = freeFormList.get(i).getmDate();
            ClassForViewingListProtocols classForViewingListProtocols = new ClassForViewingListProtocols(id, work,object,date);
            arrayList.add(i,classForViewingListProtocols);
        }

        return arrayList;
    }


}