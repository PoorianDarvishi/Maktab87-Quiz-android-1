package com.example.resultactcal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    val title = MutableLiveData("")
    val date = MutableLiveData("")
    val info = MutableLiveData("")
    var status: Status? = null
    fun setStatusToDo(){
        status = Status.TODO
    }
    fun setStatusDoing(){
        status = Status.DOING
    }
    fun setStatusDone(){
        status = Status.DONE
    }



    private val listToDo = mutableListOf<Task>()
    private val listDoing = mutableListOf<Task>()
    private val listDone = mutableListOf<Task>()

    fun getListToDo(): MutableList<Task> {
        return listToDo
    }

    fun getListDoing(): MutableList<Task> {
        return listDoing
    }

    fun getListDone(): MutableList<Task> {
        return listDone
    }

    fun createTask(): String {
        return if (status != null && title.value != "" && date.value != "" && info.value != "") {
            when (status) {
                Status.TODO -> listToDo.add(Task(title.value!!, date.value!!, info.value!!))
                Status.DOING -> listDoing.add(Task(title.value!!, date.value!!, info.value!!))
                Status.DONE -> listDone.add(Task(title.value!!, date.value!!, info.value!!))
                else -> {}
            }
            clearTask()
            "Task Create"
        } else {
            "Please complete the task information!!"
        }
    }


    private fun clearTask() {
        title.value = ""
        date.value = ""
        info.value = ""
    }
}