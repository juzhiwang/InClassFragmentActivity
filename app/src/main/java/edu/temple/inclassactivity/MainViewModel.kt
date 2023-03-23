package edu.temple.inclassactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val imageIDs = MutableLiveData<IntArray>()

    fun setImangeIDs (imageIDs : IntArray){

        this.imageIDs.value = imageIDs
    }

    fun getImageIDs ( )  : LiveData<IntArray>{

        return imageIDs


    }

}