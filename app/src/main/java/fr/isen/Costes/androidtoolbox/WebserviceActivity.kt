package fr.isen.Costes.androidtoolbox
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.Costes.androidtoolbox.Models.RandomUserResult

class WebserviceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)

        val userApiUrl = "https://randomuser.me/api/?results=20"
        val queue = Volley.newRequestQueue(this)

        val req = StringRequest(Request.Method.GET, userApiUrl, Response.Listener {

            val gson = Gson()
            val result = gson.fromJson(it, RandomUserResult::class.java)

            result.results?.let {
                Log.d("volley", it[0].gender)

            }

        }, Response.ErrorListener {
            Log.d("volley", it.toString())
        })

        queue.add(req)
    }


}