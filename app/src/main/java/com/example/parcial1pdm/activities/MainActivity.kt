package com.example.parcial1pdm.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.parcial1pdm.Fragments.MatchList
import com.example.parcial1pdm.Fragments.MatchResults
import com.example.parcial1pdm.R
import com.example.parcial1pdm.database.entities.Match
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var match: Match
    private lateinit var matchList: MatchList
    private lateinit var matchResult: MatchResults


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        match = Match("","",0,0,"","","")
        initFragment(match)

        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, NewMatchActivity::class.java)
            startActivity(intent)
        }
    }

    fun initFragment(match: Match){
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            if(match.winner == ""){
                Title.text = "Matches Played"
                matchList = MatchList.newInstance()
                changefragment(R.id.List, matchList)
            }
            else{
                Title.text = "Match Results"
                matchResult = com.example.parcial1pdm.Fragments.MatchResults.newInstance(match)
                changefragment(R.id.List, matchResult)
            }
        }
        if(resources.configuration.orientation === Configuration.ORIENTATION_LANDSCAPE){
            matchList = MatchList.newInstance()
            matchResult = MatchResults.newInstance(match)
            changefragment(R.id.LandList, matchList)
            changefragment(R.id.LandShow, matchResult)
        }
    }

    fun changefragment(id: Int, frag: Fragment){
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }

    override fun onClickListElement(match: Match) {
        Toast.makeText(this, match.date, Toast.LENGTH_SHORT).show()
        initFragment(match)
    }

    override fun onClickListElementLand(match: Match) {
        matchResult = MatchResult.newInstance(match)
        changefragment(R.id.LandShow, matchResult)
    }

    override fun onClickScores(match: Match) {
        initFragment(match)
    }

}
