package com.top.webservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.find()
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerHeroes)
        val nom = findViewById<EditText>(R.id.editTextTextPersonName2)
        val buscar = findViewById<Button>(R.id.buttonBuscar)
        val afegir = findViewById<Button>(R.id.buttonAñadir)
        buscar.setOnClickListener {
            call.clone().enqueue(object : retrofit2.Callback<MutableList<Data>> {
                override fun onResponse(call: retrofit2.Call<MutableList<Data>>, response: Response<MutableList<Data>>){
                    if (response.isSuccessful){
                        recyclerview.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = Adapter(response.body()!!)
                            Toast.makeText(applicationContext,"GET correcte!",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                override fun onFailure(call: retrofit2.Call<MutableList<Data>>, t: Throwable){
                    t.printStackTrace()
                    Log.e("error", t.message.toString())
                }

            })
        }
        afegir.setOnClickListener {

                val apiService = RestApiService()
                val userInfo = Data(  id = null,
                    nombre = nom.text.toString(),
                     )

                apiService.addUser(userInfo) {
                    Toast.makeText(applicationContext,"POST correcte!",Toast.LENGTH_SHORT).show()

                }

        }

    }

}