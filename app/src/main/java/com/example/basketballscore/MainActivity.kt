package com.example.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basketballscore.databinding.ActivityMainBinding

//ESTA APLICANDO HERENCIA
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //UN VIEWMODEL SE CREA DE LA SIGUIENTE MANERA
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.localScore.observe(this, Observer {
            binding.localScoreText.text = it.toString()
        })

        //MIENTRAS QUE EL VIEW MODEL DE ACTUALIZAR LOS SCORES
        viewModel.visitorScore.observe(this, Observer {
            binding.visitorScoreText.text = it.toString()
        })

        // HACE REFERENCIA DEL BOTON EN DONDE SE PUEDE CONTINUAR CON CON LA SIGUIENTE PANTALLA
        binding.continueActivity.setOnClickListener {
            startScoreActivity()
        }
    }

    //REALIZA LA ACCIÓN DE CREAR UN CANAL DE COMUNICACIÓN ENTRE EL MAIN ACTIVITY Y EL SCORE ACTIVITY
    //HACIENDO USO DE LAS LLAVES QUE SE CREARON EN EL SCORE ACTIVITY
    private fun startScoreActivity(){
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY, viewModel.localScore.value)
        intent.putExtra(ScoreActivity.VISITOR_SCORE_KEY, viewModel.visitorScore.value)
        startActivity(intent)
    }
}