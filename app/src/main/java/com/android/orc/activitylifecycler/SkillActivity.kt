package com.android.orc.activitylifecycler

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.orc.activitylifecycler.util.EXTRA_LEAGUE
import com.android.orc.activitylifecycler.util.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity(), View.OnClickListener {


    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        Toast.makeText(this, "$league", Toast.LENGTH_SHORT).show()

        initInstance()
    }

    private fun initInstance() {
        btnBeginner.setOnClickListener(this)
        btnBaller.setOnClickListener(this)
    }

    fun onClickFinish(view: View) {
        if (skill == null) {
            Toast.makeText(this, "select skill", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, SearchActivity::class.java)
            intent.putExtra(EXTRA_LEAGUE, league)
            intent.putExtra(EXTRA_SKILL, skill)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        if (v == btnBeginner) {
            btnBaller.isChecked = false
            skill = "beginner"

        } else if (v == btnBaller) {
            btnBeginner.isChecked = false
            skill = "baller"
        }
    }
}
