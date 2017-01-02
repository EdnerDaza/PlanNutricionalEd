package com.ednerdaza.plannutricionaled.mvc.controllers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;

import com.ednerdaza.plannutricionaled.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ednerdaza on 2/01/17.
 */

public class ItemsAdapter extends ArrayAdapter {

    private Context context;
    //private ArrayList datos;
    private String[] datos;

    public ItemsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ItemsAdapter(Context context, String[] datos) {
        super(context, R.layout.listview_items, datos);
        // Guardamos los parámetros en variables de clase.
        this.context = context;
        this.datos = datos;
    }

    public ItemsAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    public ItemsAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
    }

    public ItemsAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public ItemsAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public ItemsAdapter(Context context, int resource, int textViewResourceId, Object[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // En primer lugar "inflamos" una nueva vista, que será la que se
        // mostrará en la celda del ListView. Para ello primero creamos el
        // inflater, y después inflamos la vista.
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.listview_items, null);

        Switch switchItem = (Switch) item.findViewById(R.id.switch_item_config);
        switchItem.setText("Edner");

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
    }


}
