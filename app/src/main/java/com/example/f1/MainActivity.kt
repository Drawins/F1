package com.example.f1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RaceAdapter()
        recyclerView.adapter = adapter

        fetchData()
    }

    private fun fetchData() {
        val service = F1RetrofitClient.getService()
        val call = service.getRaces()
        call.enqueue(object : Callback<RaceTable> {
            override fun onResponse(call: Call<RaceTable>, response: Response<RaceTable>) {
                if (response.isSuccessful) {
                    response.body()?.RaceTable?.Rounds?.let {
                        adapter.setData(it)
                    }
                }
            }
            override fun onFailure(call: Call<RaceTable>, t: Throwable) {
                println("no data")
            }
        })
    }
}
