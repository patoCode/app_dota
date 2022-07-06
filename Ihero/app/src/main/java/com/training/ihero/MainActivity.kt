package com.training.ihero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.ihero.databinding.ActivityMainBinding
import com.training.ihero.network.ApiObject
import com.training.ihero.response.HeroListElement
import com.training.ihero.response.ListHeroResponse
import com.training.ihero.ui.Adapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: Adapter
    private val list = mutableListOf<HeroListElement>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        binding.btnList.setOnClickListener {
            list()
        }
        //list()
    }

    private fun initRecycler(){
        adapter = Adapter(list)
        binding.rvMain.layoutManager = LinearLayoutManager(this)
        binding.rvMain.adapter = adapter
    }

    private fun list(){
        CoroutineScope(Dispatchers.IO).launch {
            val can: Response<ListHeroResponse> = ApiObject.ApiAdapter().listHero()
            val _data = can.body()!!
            runOnUiThread {
                if (can.isSuccessful) {
                    list.clear()
                    list.addAll(_data.list)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }


}