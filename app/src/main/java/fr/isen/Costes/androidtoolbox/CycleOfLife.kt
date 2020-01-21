package fr.isen.Costes.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class CycleOfLife : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle_of_life)
    }

    override fun onPause() {
        super.onPause()
        Log.d("message", "Tache de fond")

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"cycle destroy",Toast.LENGTH_LONG).show()
         Log.d("message","ok")
    }
}
