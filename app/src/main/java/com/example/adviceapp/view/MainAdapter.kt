package com.example.adviceapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.adviceapp.R
import com.example.adviceapp.model.Advice
import com.example.adviceapp.presenter.AdvicePresenter

class MainAdapter(
    private val context: Context,
    private val list: MutableList<Advice>,
    private val  presenter: AdvicePresenter
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){



   inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(advice: Advice){
            itemView.findViewById<TextView>(R.id.txt_advice).text = advice.advice
            itemView.findViewById<ImageView>(R.id.btn_delete).setOnClickListener {
                list.remove(advice)
                presenter.onCompleted()
                Toast.makeText(context,advice.advice + " Removido", Toast.LENGTH_SHORT).show()
                notifyDataSetChanged()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
       return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addTolist(advice: Advice) {
        list.add(advice)
        notifyDataSetChanged()
    }
}


