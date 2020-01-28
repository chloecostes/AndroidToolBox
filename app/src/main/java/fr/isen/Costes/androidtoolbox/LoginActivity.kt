package fr.isen.Costes.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.carrier.CarrierIdentifier
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val goodIdentifier = "admin"
    val goodPassword = "123"

    var userPref: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userPref = getSharedPreferences(Constants.UserPreferencesName, Context.MODE_PRIVATE)
        checkPreferences()
        validateButton.setOnClickListener {
            doLogin()
        }
    }
    fun doLogin() {
        if (canLog(userName.text.toString(), passwordEditText.text.toString())){
            val intent = Intent(this, HomeActivity::class.java)
            saveUser(userName.text.toString(), passwordEditText.text.toString())
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    fun canLog(identifier: String, password: String) :  Boolean  {
        return identifier == goodIdentifier && password == goodPassword
    }

    fun saveUser(identifier: String, password: String) {
        val editor = userPref?.edit()
        editor?.putString(Constants.kIdentifier, identifier)
        editor?.putString(Constants.kPassword, password)
        editor?.commit()
    }
    fun checkPreferences() {
        val identifier = userPref?.getString(Constants.kIdentifier, null)?:""
        val password = userPref?.getString(Constants.kPassword, null)?:""
        userName.setText(identifier)
        passwordEditText.setText(password)
        doLogin()
    }
}
