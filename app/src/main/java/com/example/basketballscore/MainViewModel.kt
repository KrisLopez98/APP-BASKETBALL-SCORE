package com.example.basketballscore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
// ESTA APLICANDO HERENCIA
// VIEW MODEL: SE ENCARGA DE LA LOGICA
class MainViewModel: ViewModel(){

    // PROPIEDADES
    private  val _localScore = MutableLiveData<Int>()

    val localScore: LiveData<Int>
    get() =_localScore

    private val _visitorScore = MutableLiveData<Int>()

    val visitorScore: LiveData<Int>
    get() = _visitorScore



    // CONSTRUCTOR: ESTE HACE USO DEL METODO QUE SE DECLARO COMO "resetScore" PARA QUE SE EJECUTE AL MISMO TIEMPO QUE LA VARIABLES
    init {
        resetScores()
    }

    // METODO: SU FUNCIÓN ES RESETEAR LOS MARCADORES Y QUE SU VALOR INICIE EN 0
    fun resetScores(){
        _localScore.value = 0
        _visitorScore.value = 0
        //cambio
    }

    // METODO: SU FUNCIÓN ES AUMENTAR PUNTOS YA SEA +1 O +2 AL MARCADOR LOCAL
    /**************** ADD POINTS *****************/
    //EL ACTIVITY SE VA ENCARGAR DE PINTAR LOS DATOS
    fun addPointsToLocal(points:Int){
        _localScore.value = _localScore.value?.plus(points)
    }

    // METODO: SU FUNCIÓN ES AUMENTAR PUNTOS YA SEA +1 O +2 AL MARCADOR DEL VISITANTE
    fun addPointsToVisitor(points: Int){
        _visitorScore.value = _visitorScore.value?.plus(points)
    }

    // METODO: SU FUNCIÓN ES RESTAR -1 PUNTO AL MARCADOR DEL EQUIPO LOCAL
    /**************** DECREASE POINTS *****************/
    fun decreasePointsToLocal(){
        var localScoreValue = _localScore.value!!
        if (localScoreValue > 0){
            localScoreValue--
            _localScore.value = localScoreValue
        }
    }

    //METODO: SU FUNCIÓN ES RESTAR -1 AL MARCADO DEL EQUIPO VISITANTE
    fun decreasePointsToVisitor(){
        var visitorScoreValue = _visitorScore.value!!
        if (visitorScoreValue > 0) {
            visitorScoreValue--
            _visitorScore.value = visitorScoreValue
        }
    }
}