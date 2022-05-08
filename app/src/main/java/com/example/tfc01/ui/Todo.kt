package com.example.todo.ui.list

import  android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tfc01.R
import com.example.tfc01.model.Tarefa


class Todo (
    private val tarefas: ArrayList<Tarefa>
): RecyclerView.Adapter<ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(
            R.layout.item_view,
            parent,
            false
        )
        return ViewHolder(itemView, this)
    }

    fun addTask(todo: Tarefa)
    {
        tarefas.add(todo)
        notifyItemInserted(tarefas.size-1)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.tarefas[position])
    }
    override fun getItemCount(): Int {
        return this.tarefas.size
    }
}