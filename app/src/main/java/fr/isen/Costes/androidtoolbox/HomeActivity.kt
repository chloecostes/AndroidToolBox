package fr.isen.Costes.androidtoolbox


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        cycleButton.setOnClickListener {
            val intent = Intent(this, CycleOfLife::class.java)
            startActivity(intent)
        }

        SaveButton.setOnClickListener {
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }

        PermissionButton.setOnClickListener {
            val intent = Intent(this, PermissionActivity::class.java)
            startActivity(intent)
        }

        WebServicesButton.setOnClickListener {
            val intent = Intent(this, WebserviceActivity::class.java)
            startActivity(intent)
        }


        logoutButton.setOnClickListener {
            val userPref = getSharedPreferences(Constants.UserPreferencesName, Context.MODE_PRIVATE)
            val editor = userPref.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }


}




