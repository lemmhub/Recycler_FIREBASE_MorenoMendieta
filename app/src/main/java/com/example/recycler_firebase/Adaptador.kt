package com.example.recycler_firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador(private val userilst : ArrayList<Horarios>) : RecyclerView.Adapter<Adaptador.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView =  LayoutInflater.from(parent.context).inflate(R.layout.horarios_item,parent,false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val objetoActual = userilst[position]
        holder.profesor.text=objetoActual.profesor
        holder.Horario.text=objetoActual.Horario
        holder.Materia.text=objetoActual.Materia
    }

    override fun getItemCount(): Int {
        return userilst.size
    }


    class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        val profesor : TextView = itemView.findViewById(R.id.tv_profesor)
        val Materia: TextView = itemView.findViewById(R.id.tv_materia)
        val Horario : TextView = itemView.findViewById(R.id.tv_horarios)
    }


}