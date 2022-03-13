package com.example.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.basketballscore.databinding.ActivityScore2Binding
// ESTA APLICANDO HERENCIA
class ScoreActivity : AppCompatActivity() {


    //SE CREAN CONSTANTES
    companion object{
        //SE CREO LLAVES PARA POSTERIORMENTE CONSTRUIR LOS INTENT Y RELACIONAR EL MAIN ACTIVITY CON EL SCORE ACTIVITY
        const val LOCAL_SCORE_KEY = "local_score"
        const val VISITOR_SCORE_KEY = "visitor_score"
    }

    // METODO
    override fun onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)
        val binding = ActivityScore2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // CON ESTAS VAL ESTA TRAYENDO LOS DATOS DEL MAIN ACTIVITY AL SCORE ACTIVITY
        val localScore = intent.extras!!.getInt(LOCAL_SCORE_KEY)
        val visitorScore = intent.extras!!.getInt(VISITOR_SCORE_KEY)

        //CREACIÓN DE LOGCAT
        Log.d("localScore", "value $localScore")
        Log.d("visitorScore", "value $visitorScore")

        //ESTA HACIENDO REFERENCIA DEL MARCADOR FINAL Y CON EL ESTA TRAYENDO LA INFORMACION DEL
        //PUNTAJE Y LA INFORMACIÓN DE LA VARIABLES QUE SE DECLARARON CON ANTERIORIDAD LAS CUALES SON
        //GUARDADAS EN EL FINAL SCORE
        binding.finalScore.text = getString(R.string.local_visitor_score_format, localScore, visitorScore)

        //AQUÍ SE REALIZA LA PARTE DEL MENSAJE FINAL QUE ACOMPAÑA AL MARCADO FINAL. EN EL DICE QUE SI:
        // LA PUNTUACIÓN DEL LOCAL ES MAYOR AL DEL VISITANTE ENVÍE UN MENSAJE: "LOCAL WON"
        // SÍ LA PUNTUACION DEL VISITANTE ES MAYOR AL DEL LOCAL ENVÍE UN MENSAJE: "VISITANT WON"
        // PERO QUE SI AMBOS TIENEN EL MISMO NUMERO DE PUNTOS ENVÍE: "ES UN EMPATE"
        when{
            localScore > visitorScore -> binding.messageFinalGame.text = getString(R.string.local_won)
            visitorScore > localScore -> binding.messageFinalGame.text = getString(R.string.visitor_won)
            else -> binding.messageFinalGame.text = getString(R.string.it_was_a_tie)
        }
    }
}