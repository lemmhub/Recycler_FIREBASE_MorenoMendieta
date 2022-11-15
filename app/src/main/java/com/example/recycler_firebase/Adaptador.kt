package com.example.recycler_firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.Hold

class Adaptador(private val userilst : ArrayList<Usuarios>) : RecyclerView.Adapter<Adaptador.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.usuarios_item,parent,false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val objetoActual = userilst[position]
        holder.nombre.text=objetoActual.nombre
        holder.apellidos.text=objetoActual.apellidos
        holder.edad.text=objetoActual.edad
    }

    override fun getItemCount(): Int {
        return userilst.size
    }


    class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nombre : TextView = itemView.findViewById(R.id.tv_nombre)
        val apellidos: TextView = itemView.findViewById(R.id.tv_apellidos)
        val edad : TextView = itemView.findViewById(R.id.tv_edad)
    }


}