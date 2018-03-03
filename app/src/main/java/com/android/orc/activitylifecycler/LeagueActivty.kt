package com.android.orc.activitylifecycler

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.orc.activitylifecycler.util.EXTRA_LEAGUE
import com.android.orc.activitylifecycler.util.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*
import model.Player

class LeagueActivty : AppCompatActivity(), View.OnClickListener {


    val TAG = "LifeCycler"
    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        Log.d(TAG, "${javaClass.simpleName} OnCreate")

        initInstance()
    }


    override fun onStart() {
        Log.d(TAG, "${javaClass.simpleName} OnStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "${javaClass.simpleName} OnResume")
        super.onResume()
    }

    override fun onRestart() {
        Log.d(TAG, "${javaClass.simpleName} OnRestart")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(TAG, "${javaClass.simpleName} OnPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "${javaClass.simpleName} OnStop")
        super.onStop()
    }


    private fun initInstance() {
        btnMensLeague.setOnClickListener(this)
        btnWomensLeague.setOnClickListener(this)
        btnCoLeague.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == btnMensLeague) {
            btnWomensLeague.isChecked = false
            btnCoLeague.isChecked = false
            player.league = "Mens"

        } else if (v == btnWomensLeague) {
            btnMensLeague.isChecked = false
            btnCoLeague.isChecked = false
            player.league = "Womens"

        } else if (v == btnCoLeague) {
            btnMensLeague.isChecked = false
            btnWomensLeague.isChecked = false
            player.league = "Co-ed"
        }
    }


    fun leagueOnClick(view: View) {

        if (player.league == null) {
            Toast.makeText(this, "Please select League", Toast.LENGTH_SHORT).show()
        } else {
            val SkillActivity = Intent(this, SkillActivity::class.java)
            SkillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(SkillActivity)
        }
    }
}
