package com.android.orc.activitylifecycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.orc.activitylifecycler.util.EXTRA_LEAGUE
import com.android.orc.activitylifecycler.util.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)



        initInstance()

    }

    private fun initInstance() {
        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)


        tvSearchLeague.text = "Looking for $league $skill league near you .... "
    }
}
