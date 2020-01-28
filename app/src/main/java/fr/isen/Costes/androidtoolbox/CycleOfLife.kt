package fr.isen.Costes.androidtoolbox

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class CycleOfLife : AppCompatActivity(), OnFragmentListenerInteraction {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle_of_life)

        val firstFragment = CycleOfLifeFragment()
    //    supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, firstFragment).commit()
    }

    override fun onPause() {
        super.onPause()
        Log.d("message", "Tache de fond")

    }

    override fun onDestroy() {
        Toast.makeText(this,"cycle destroyed",Toast.LENGTH_LONG).show()
        super.onDestroy()
   }

    override fun swipeFragment() {
        val secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, secondFragment).commit()
    }


}
