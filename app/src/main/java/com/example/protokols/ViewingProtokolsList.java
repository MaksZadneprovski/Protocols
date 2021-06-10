package com.example.protokols;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.example.protokols.data_base_package.AppDelegateBd;
import com.example.protokols.data_base_package.FreeForm.FreeForm;
import com.example.protokols.data_base_package.FreeForm.FreeFormDao;
import com.example.protokols.data_base_package.FreeForm.MainFreeForm;
import com.example.protokols.data_base_package.SilovoyTransformator.MainSilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;
import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTransDao;
import com.example.protokols.data_base_package.SilovoyTransformator.ViewSilovoyTrans;
import com.example.protokols.utils.ConstantsMy;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewingProtokolsList extends AppCompatActivity {
    private ListView lv;
    private List<SilovoyTrans> silovoyTransList;
    private List <FreeForm> freeFormList;
    private FloatingActionButton fabAdd;
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
        fabAdd = findViewById(R.id.fabViewingProtocols);

        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(3).setEnabled(false);
        bottomNavigationView.getMenu().getItem(3).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(4).setEnabled(false);
        bottomNavigationView.getMenu().getItem(4).setIcon(R.drawable.dot_white);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.bottomNavIc1){
                    Intent i = new Intent( ViewingProtokolsList.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else  if (item.getItemId() == R.id.bottomNavIc2){

                }
                return true;
            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(ViewingProtokolsList.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menuAddSilovoyTrans:
                                Intent i = new Intent(ViewingProtokolsList.this, MainSilovoyTrans.class);
                                startActivity(i);
                                break;
                            case R.id.menuAddFreeform:
                                Intent b = new Intent(ViewingProtokolsList.this, MainFreeForm.class);
                                startActivity(b);
                                break;

                        }
                        return true;
                    }
                });
                popupMenu.show();
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
                // Диалог
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewingProtokolsList.this);
                builder.setTitle("Удаление");
                builder.setMessage("Вы действительно хотите удалить элемент из списка?");
                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ClassForViewingListProtocols classForViewingListProtocols = getArrayList(silovoyTransList, freeFormList).get(position);
                        String work =classForViewingListProtocols.getWork();
                        if (work.equals("Испытание\nсилового\nтрансформатора")){
                            // Удаляем объект из БД
                            silovoyTransDao.deleteSilovoyTrans(silovoyTransList.get(classForViewingListProtocols.getId()));
                        }

                        // Заново берем данные из БД
                        silovoyTransList =silovoyTransDao.getAll();
                        freeFormList = freeFormDao.getAll();
                        // Обновляем адаптер
                        AdapterForList adapter = new AdapterForList(ViewingProtokolsList.this, getArrayList(silovoyTransList, freeFormList));
                        lv.setAdapter(adapter);
                    }
                });
                builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });
    }

    // Метод : Создает ArrayList из приходящих в параметры List-ов
    private ArrayList<ClassForViewingListProtocols> getArrayList(List<SilovoyTrans> silovoyTransList, List <FreeForm> freeFormList ) {

        ArrayList<ClassForViewingListProtocols> arrayList = new ArrayList<ClassForViewingListProtocols>();

        //  Проход по списку silovoyTransList, создание объекта ClassForViewingListProtocols с такими же полями и занесение его в список
        for (int i = 0; i< silovoyTransList.size(); i++){
            int id = silovoyTransList.get(i).getId();
            int idForDB = silovoyTransList.get(i).getIdForDB();
            String object = silovoyTransList.get(i).getmObjectOrPodstancia();
            String work = silovoyTransList.get(i).getmWork();
            String date = silovoyTransList.get(i).getmDate();
            ClassForViewingListProtocols classForViewingListProtocols = new ClassForViewingListProtocols(id,idForDB,work,object,date);
            arrayList.add(i,classForViewingListProtocols);
        }

        //  Проход по списку freeFormList, создание объекта ClassForViewingListProtocols с такими же полями и занесение его в список
        for (int i = 0; i< freeFormList.size(); i++){
            int id = freeFormList.get(i).getId();
            int idForDB = freeFormList.get(i).getIdForDB();
            String object = freeFormList.get(i).getmObjectOrPodstancia();
            String work = freeFormList.get(i).getmWork();
            String date = freeFormList.get(i).getmDate();
            ClassForViewingListProtocols classForViewingListProtocols = new ClassForViewingListProtocols(id, idForDB, work,object,date);
            arrayList.add(i,classForViewingListProtocols);
        }
        // Сортировка по единому ID
        Collections.sort(arrayList, new Comparator<ClassForViewingListProtocols>() {
            @Override
            public int compare(ClassForViewingListProtocols o1, ClassForViewingListProtocols o2) {
                if (o1.getIdForBD()<o2.getIdForBD()) return 1;
                else if (o1.getIdForBD()>o2.getIdForBD()) return -1;
                else return 0;
            }
        });

        return arrayList;
    }


}