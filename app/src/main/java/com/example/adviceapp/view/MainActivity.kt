package com.example.adviceapp.view

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adviceapp.databinding.ActivityMainBinding
import com.example.adviceapp.model.Advice
import com.example.adviceapp.presenter.AdvicePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding
    private lateinit var fab : FloatingActionButton
    private lateinit var presenter: AdvicePresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var contentMain: LinearLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = AdvicePresenter(this)
        progressBar = binding.progressBar
        contentMain = binding.contentMain

        recyclerView = binding.rvMain
        adapter = MainAdapter(this, mutableListOf(), presenter)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        fab = binding.fab
        fab.setOnClickListener {
            presenter.findRandom()
        }
    }

    fun showProgress() {
        if (recyclerView.visibility == View.VISIBLE){
            recyclerView.visibility = View.GONE
        }
        contentMain.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    fun showAdvice(advice: Advice) {
        adapter.addTolist(advice)
    }

    fun hideProgress() {
        if(progressBar.visibility != View.GONE){
            progressBar.visibility = View.GONE
        }
        when {
            adapter.itemCount != 0 -> {
                recyclerView.visibility = View.VISIBLE
            }
            adapter.itemCount == 0 -> {
                recyclerView.visibility = View.GONE
                contentMain.visibility = View.VISIBLE
            }
        }
    }

    fun showFailure(msg : String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}