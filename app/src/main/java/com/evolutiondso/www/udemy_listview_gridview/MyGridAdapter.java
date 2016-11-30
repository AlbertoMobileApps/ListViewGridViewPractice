package com.evolutiondso.www.udemy_listview_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Albrtx on 29/11/2016.
 */

public class MyGridAdapter extends BaseAdapter{

        //le pasamos el contexto porque aqui es donde lo vamos a mostrar
        private Context context;
        private int layout;
        private List<String> names;

        //Click isquierdo y generate constructor (como en una clase java necesita constructor de que se va a pasar)
        public MyGridAdapter(Context context, int layout, List<String> names) {
            this.context = context;
            this.layout = layout;
            this.names = names;
        }




        //Cuantas veces vamos a dibujar el list item, no sabemos pero le decimos que del tamaño de la lista
        @Override
        public int getCount() {
            return this.names.size();
        }

        //No se usa tanto pero se le pasa un una posicion de item de la coleccion
        @Override
        public Object getItem(int position) {
            return this.names.get(position);
        }

        @Override
        public long getItemId(int id) {
            return id;
        }


        //Este es importante! normalmente se pasa position, converview (asi se llama)
        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolderGrid holder;

            if (convertView == null){
                //Inflamos la vista que nos ha llegado con nustro layout personalizado
                LayoutInflater layoutInflater = LayoutInflater.from(this.context);
                convertView = layoutInflater.inflate(this.layout,null);

                //Instanciamos el viewHolder
                holder = new ViewHolderGrid();
                //Referenciamos el elemento a modificar y lo rellenamos
                holder.nametextViews =(TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(holder);

            }else{
                holder = (ViewHolderGrid) convertView.getTag();
            }

            //mandamos traer el valor actual dependiente de la posicion.
            String currenName = names.get(position);
            holder.nametextViews.setText(currenName);

            //devolvemos la vista inflada
            return convertView;

        }

        static class ViewHolderGrid{
            private TextView nametextViews;
        }

    }
