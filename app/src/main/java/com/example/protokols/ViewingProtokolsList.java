package com.example.protokols;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class ViewingProtokolsList extends AppCompatActivity {
    private ListView lv;
    private Toolbar toolbarMain;
    private List<SilovoyTrans> silovoyTransList;
    private List <FreeForm> freeFormList;


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

        // Для меню обязательно вызвать setSupportActionBar
        toolbarMain = findViewById(R.id.toolbarViewProtocols);
        setSupportActionBar(toolbarMain);

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

        // Нажатие на ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ViewingProtokolsList.this, ViewSilovoyTrans.class);
                SilovoyTrans silovoyTrans = silovoyTransList.get(position);
                int idOfSelectedItem = silovoyTrans.getId();
                i.putExtra(ConstantsMy.ID_KEY,idOfSelectedItem );
                startActivity(i);
                finish();
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
            String object = silovoyTransList.get(i).getObject();
            String work = silovoyTransList.get(i).getWork();
            String date = silovoyTransList.get(i).getDate();
            ClassForViewingListProtocols classForViewingListProtocols = new ClassForViewingListProtocols(work,object,date);
            arrayList.add(i,classForViewingListProtocols);
        }

        //  Проход по списку freeFormList, создание объекта ClassForViewingListProtocols с такими же полями и занесение его в список
        for (int i = 0; i< freeFormList.size(); i++){
            String object = freeFormList.get(i).getmObjectOrPodstancia();
            String work = freeFormList.get(i).getmWork();
            String date = freeFormList.get(i).getmDate();
            ClassForViewingListProtocols classForViewingListProtocols = new ClassForViewingListProtocols(work,object,date);
            arrayList.add(i,classForViewingListProtocols);
        }

        return arrayList;
    }


}