package com.example.protokols;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.protokols.data_base_package.SilovoyTransformator.SilovoyTrans;

import java.util.ArrayList;
// В одну из таблиц базы данных сохраняются объекты класса SilovoyTrans "Измерение силового трансформатора" .
// В классе ViewingProtokolsList создается список из этих объектов и передается в адаптер через конструктор.

public class AdapterForList extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<ClassForViewingListProtocols> classForViewingListProtocolsArrayList;

    // Конструктор

    // Метод : возвращает размер списка silovoyTransArrayList

    // Метод : возвращает объект из списка silovoyTransArrayList по заданной позиции

    // Метод : возвращает позицию по заданной позиции (не понимаю)

    // Метод : устанавливает текст в шаблонные элементы ListView с помощью getter-ов из объекта silovoyTrans

    // Метод : из списка silovoyTransArrayList по позиции из объекта класса Object делает объект класса SilovoyTrans


    // Конструктор
    AdapterForList(Context context, ArrayList<ClassForViewingListProtocols> classForViewingListProtocolsArrayList){
        this.context = context;
        this.classForViewingListProtocolsArrayList = classForViewingListProtocolsArrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    // Метод : возвращает размер списка silovoyTransArrayList
    @Override
    public int getCount() {
        return classForViewingListProtocolsArrayList.size();
    }

    // Метод : возвращает объект из списка silovoyTransArrayList по заданной позиции
    @Override
    public Object getItem(int position) {
        return classForViewingListProtocolsArrayList.get(position);
    }

    // Метод : возвращает позицию по заданной позиции (не понимаю)
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Метод : устанавливает текст в шаблонные элементы ListView с помощью getter-ов из объекта silovoyTrans
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_for_list_view, parent, false);
        }
        ClassForViewingListProtocols classForViewingListProtocolsArrayList = getclassForViewingListProtocolsArrayList(position);
        // ((TextView) view.findViewById(R.id.tvItem1)).setText(Integer.toString(silovoyTrans.getPasportType()));
        ((TextView) view.findViewById(R.id.tvItem1)).setText(classForViewingListProtocolsArrayList.getWork().replace("\n", " "));
        ((TextView) view.findViewById(R.id.tvItem2)).setText(classForViewingListProtocolsArrayList.getObject());
        ((TextView) view.findViewById(R.id.tvItem3)).setText(classForViewingListProtocolsArrayList.getDate());
        switch (classForViewingListProtocolsArrayList.getWork().toString()){
            case "Неустановленная форма" :
                ((ImageView) view.findViewById(R.id.imgIcon)).setImageResource(R.drawable.ic_free_form);
                break;
            case "Испытание силового трансформатора" :
                ((ImageView) view.findViewById(R.id.imgIcon)).setImageResource(R.drawable.ic_transformer);
                break;
        }
        return view;
    }

    // Метод : из списка silovoyTransArrayList по позиции из объекта класса Object делает объект класса SilovoyTrans
    private ClassForViewingListProtocols getclassForViewingListProtocolsArrayList(int position) {
        return   (ClassForViewingListProtocols) getItem(position);
    }


}