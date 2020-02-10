package fr.isen.Costes.androidtoolbox
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.Costes.androidtoolbox.Models.RandomUserResult
import fr.isen.Costes.androidtoolbox.Models.UserModel
import kotlinx.android.synthetic.main.activity_web_service.*

class WebserviceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)
        getUsers()
    }

    fun getUsers() {

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://randomuser.me/api/?results=20"



        // Request a string response from the provided URL.
        val stringReq =
            StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->

                val gson = Gson()
                val result = gson.fromJson(response, RandomUserResult::class.java)
                var personList = ArrayList<UserModel>()

                result.results?.let {
                    it.forEach{
                        var person = UserModel()
                        person.gender = it.gender
                        person.fName = it.name?.first
                        person.lName = it.name?.last
                        person.picture= it.picture
                        person.email= it.email
                        person.location = it.location
                        personList.add(person)


                    }
                }
                userRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                userRecyclerView.adapter = UsersAdapter(personList)

            },
                Response.ErrorListener {
                    Log.d("volley", it.toString())
                })

        queue.add(stringReq)
    }



}