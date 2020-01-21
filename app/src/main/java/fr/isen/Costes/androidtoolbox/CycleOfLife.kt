package fr.isen.Costes.androidtoolbox

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class CycleOfLife : AppCompatActivity(), CycleOfLifeFragment.OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle_of_life)
    }

    override fun onPause() {
        super.onPause()
        Log.d("message", "Tache de fond")

    }

    override fun onDestroy() {
        Toast.makeText(this,"cycle destroyed",Toast.LENGTH_LONG).show()
        super.onDestroy()
   }


    override fun onFragmentInteraction() {
        Toast.makeText(this,"fragment destroyed",Toast.LENGTH_LONG).show()
    }



}
