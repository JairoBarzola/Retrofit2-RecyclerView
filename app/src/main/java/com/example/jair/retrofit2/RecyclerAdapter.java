package com.example.jair.retrofit2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian on 22/03/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public Context context;
   // static   int lastPosition=-1;
    public List<Usuario> usuarioList = new ArrayList<>();

    public  RecyclerAdapter(Context context,List<Usuario> usuarioList){
        this.usuarioList= usuarioList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(usuarioList.get(position).getNombre());
        holder.apellido.setText(usuarioList.get(position).getApellido());
        holder.edad.setText(String.valueOf(usuarioList.get(position).getEdad()));
        Picasso.with(context).load(usuarioList.get(position).getCarrera()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView apellido;
        TextView edad;
        //TextView carrera;
        ImageView imageView;

        public ViewHolder(View itemView) {

            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            apellido= (TextView) itemView.findViewById(R.id.apellido);
            edad = (TextView) itemView.findViewById(R.id.edad);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

}