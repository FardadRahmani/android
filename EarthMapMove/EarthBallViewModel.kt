package com.example.earthball

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class EarthBallViewModel : ViewModel() {

    private val _repository : EarthBallRepository = EarthBallRepository()
    private val _north = mutableStateOf(_repository.getEarthBall().north)
    private val _east = mutableStateOf(_repository.getEarthBall().east)
    private val _south = mutableStateOf(_repository.getEarthBall().south)
    private val _west = mutableStateOf(_repository.getEarthBall().west)

    //Expose variables as immutable state
    val north : MutableState<Int> = _north
    val east : MutableState<Int> = _east
    val south : MutableState<Int> = _south
    val west : MutableState<Int> = _west


    fun goNorth(){
        _repository.incrementNorth()
        _north.value = _repository.getEarthBall().north
        _south.value = _repository.getEarthBall().south
    }
    fun goEast(){
        _repository.incrementEast()
        _east.value = _repository.getEarthBall().east
        _west.value = _repository.getEarthBall().west
    }
    fun goSouth(){
        _repository.incrementSouth()
        _south.value = _repository.getEarthBall().south
        _north.value = _repository.getEarthBall().north
    }
    fun goWest(){
        _repository.incrementWest()
        _west.value = _repository.getEarthBall().west
        _east.value = _repository.getEarthBall().east
    }
}