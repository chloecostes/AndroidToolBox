package fr.isen.Costes.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        cycleButton.setOnClickListener {
            doClick()
        }
    }

        fun doClick() {
            val intent = Intent(this, CycleOfLife::class.java)
            startActivity(intent)
        }


}