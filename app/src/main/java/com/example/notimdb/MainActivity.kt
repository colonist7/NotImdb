package com.example.notimdb

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notimdb.DetaildInfo.CastFragment
import android.content.Intent
import android.os.AsyncTask
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notimdb.Data.response.Cast
import com.example.notimdb.Data.response.Movies
import com.example.notimdb.DetaildInfo.MainRecyclerAdapter
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


class MainActivity : AppCompatActivity(), CastFragment.OnFragmentInteractionListener
{
    var json = Parent(mutableListOf<Movies>())
    var list = mutableListOf<Movies>()

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesRetreiverAsyncTask = MoviesRetreiverAsyncTask()
        moviesRetreiverAsyncTask.execute("https://my-json-server.typicode.com/nikoloz14/movies-db/db")
    }

    override fun onResume() {
        super.onResume()
    }

    fun test (json : Parent) {

        var recyclerView = findViewById(R.id.MovieList) as RecyclerView
        var j = 0
        for(i in json.movies) {
            println(i.toString())
            println("-----------------------------------------------------------------------------")
            val newView = ImageView(this)
                list.add(
                    Movies(
                        i.id,
                        i.title,
                        i.date,
                        i.language,
                        i.seasons,
                        i.imageUrl,
                        i.cast
                    ))
//            Glide.with(this)
//                .asBitmap()
//                .override(700, 500)
//                .load(i.imageUrl)
//                .into(newView)

//            val main = findViewById(R.id.container) as LinearLayout
//
//            newView.setOnClickListener {
//                val moviePager = Intent(this, MoviePager::class.java)
//                val data = i
//                moviePager.putExtra("obj", data)
//                this.startActivity(moviePager)
//            }

//            main.addView(newView)
        }


        val adapter = MainRecyclerAdapter(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    inner class MoviesRetreiverAsyncTask() : AsyncTask<String, Any, String>() {

        override fun doInBackground(vararg params: String?): String {
            Thread.sleep(3000L)
            val url = URL(params[0])
            val urlConnection = url.openConnection()

            val stream = BufferedInputStream(urlConnection.inputStream)
            val bufferedReader = BufferedReader(InputStreamReader(stream))
            val builder = StringBuilder()

            var chunk = bufferedReader.readLine()
            while (chunk != null) {
                builder.append(chunk)
                chunk = bufferedReader.readLine()
            }

            return builder.toString()
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            json = parseParent(JSONObject(result))
            println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
            print(json.toString())
            println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
            test(json)
        }
    }

    fun getMoviesFromJson(jsonObject: JSONObject): Movies {
        val id = jsonObject.getInt("id")
        val original_name = jsonObject.getString("title")
        val date = jsonObject.getString("date")
        val lang = jsonObject.getString("language")
        val seasons = jsonObject.getInt("seasons")
        val url = jsonObject.getString("imageUrl")
        val castList = parseCastList(jsonObject.getJSONArray("cast"))
        return Movies(id, original_name, date, lang, seasons, url, castList)
    }

    private fun parseWorkInfo(jsonObject: JSONObject): Cast {
        val id = jsonObject.getInt("id")
        val name = jsonObject.getString("fullName")
        val role = jsonObject.getString("role")
        val url = jsonObject.getString("imageUrl")
        return Cast(id,name,role,url)
    }

    private fun parseCastList(jsonArray: JSONArray): List<Cast> {
        val list = mutableListOf<Cast>()
        for (i in 0 until jsonArray.length()) {
            val obj = parseWorkInfo(jsonArray.getJSONObject(i))
            list.add(obj)
        }
        return list
    }

    private fun parseMovieList(jsonArray: JSONArray): List<Movies> {
        val list = mutableListOf<Movies>()
        for (i in 0 until jsonArray.length()) {
            val obj = getMoviesFromJson(jsonArray.getJSONObject(i))
            list.add(obj)
        }
        return list
    }

    private fun parseParent (jsonObject: JSONObject): Parent {
        val obj = parseMovieList(jsonObject.getJSONArray("movies"));
        return Parent(obj)
    }
}

data class Parent ( val movies: List<Movies>)
