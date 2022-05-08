package com.example.todo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tfc01.R
import com.example.tfc01.model.Tarefa

import com.example.todo.ui.list.Todo


class MainActivity : AppCompatActivity() {
    private lateinit var adaptar: Todo
    private lateinit var text_task: TextView
    private lateinit var Urgent: SwitchCompat
    private lateinit var tarefas: ArrayList<Tarefa>
    private lateinit var resicler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.Urgent=findViewById(R.id.switch1)
        this.text_task=findViewById(R.id.texto_tarefa)
        this.resicler=findViewById(R.id.recicle)
        this.tarefas= ArrayList()
        this.adaptar = Todo(this.tarefas)
        this.resicler.layoutManager = LinearLayoutManager(this)
        this.resicler.adapter = this.adaptar
    }

    fun Add(V: View)
    {
        val texto:String= this.text_task.text.toString()
        if (Urgent.isChecked)
        {
            if(texto.isNotEmpty())
            {
                val tarefa = Tarefa(texto, false,true)
                this.adaptar.addTask(tarefa)
                this.text_task.setText("")
            }
        }else{
            if(texto.isNotEmpty())
            {
                val tarefa = Tarefa(texto,false,false)
                this.adaptar.addTask(tarefa)
                this.text_task.setText("")
            }
        }
    }

}