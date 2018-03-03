package com.android.orc.activitylifecycler

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.orc.activitylifecycler.util.EXTRA_LEAGUE
import com.android.orc.activitylifecycler.util.EXTRA_PLAYER
import com.android.orc.activitylifecycler.util.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*
import model.Player

class SkillActivity : AppCompatActivity(), View.OnClickListener {



    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)

        initInstance()
    }

    private fun initInstance() {
        btnBeginner.setOnClickListener(this)
        btnBaller.setOnClickListener(this)
    }

    fun onClickFinish(view: View) {
        if (player.skill == null) {
            Toast.makeText(this, "select skill", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, SearchActivity::class.java)
//            intent.putExtra(EXTRA_LEAGUE, league)
//            intent.putExtra(EXTRA_SKILL, skill)
            intent.putExtra(EXTRA_PLAYER, player)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        if (v == btnBeginner) {
            btnBaller.isChecked = false
            player.skill = "beginner"

        } else if (v == btnBaller) {
            btnBeginner.isChecked = false
            player.skill = "baller"
        }
    }
}
