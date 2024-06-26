package com.example.earthball

data class EarthBallModel (var north : Int,
    var east : Int,
    var south : Int,
    var west: Int)

class EarthBallRepository (){
    private var _ballModel : EarthBallModel = EarthBallModel(0, 0,0, 0)

    fun getEarthBall() = _ballModel
    fun incrementNorth (){
        _ballModel.north++
        _ballModel.south--
    }
    fun incrementEast (){
        _ballModel.east++
        _ballModel.west--
    }
    fun incrementSouth (){
        _ballModel.south++
        _ballModel.north--
    }
    fun incrementWest (){
        _ballModel.west++
        _ballModel.east--
    }


}
