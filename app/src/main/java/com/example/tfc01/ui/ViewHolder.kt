package com.example.todo.ui.list

import android.view.View
import android.widget.CheckBox
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tfc01.R
import com.example.tfc01.model.Tarefa


class ViewHolder (
    itemView: View,
    private val adapter: Todo
):RecyclerView.ViewHolder(itemView) {
    private val Check: CheckBox
    private val Texto_Tarefa: TextView
    private val Urgente: FrameLayout
    private lateinit var currentTask: Tarefa
    init{
        this.Check=itemView.findViewById((R.id.checkBox))
        this.Texto_Tarefa=itemView.findViewById(R.id.texto_tarefa)
        this.Urgente = itemView.findViewById(R.id.cor)
        Check.setOnCheckedChangeListener{_, done ->  currentTask.feito = done
        }
    }
    fun bind(task: Tarefa){
        this.currentTask = task
        this.Texto_Tarefa.text = this.currentTask.texto
        this.Check.isChecked = this.currentTask.feito
        val color = if (this.currentTask.urgente){
            ContextCompat.getColor(itemView.context,R.color.red)
        }else{
            ContextCompat.getColor(itemView.context,R.color.green)
        }
        Urgente.background.setTint(color)
    }
}