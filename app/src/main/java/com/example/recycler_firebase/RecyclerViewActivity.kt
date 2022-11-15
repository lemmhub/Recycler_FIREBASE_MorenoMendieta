package com.example.recycler_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class RecyclerViewActivity : AppCompatActivity() {


    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<Horarios>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        userRecyclerView = findViewById(R.id.usuarios_lista)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<Horarios>()
        getHorarios()

    }

    private fun getHorarios() {
        dbref=FirebaseDatabase.getInstance().getReference("Usuarios")
        dbref.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                println(snapshot)
                println("PRueba de datos")
                if(snapshot.exists()){
                    for (userSnapshot in snapshot.children){
                        val horario = userSnapshot.getValue(Horarios::class.java)
                        userArrayList.add(horario!!) //no es nulo

                    }
                    userRecyclerView.adapter = Adaptador(userArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        } )

    }


}
