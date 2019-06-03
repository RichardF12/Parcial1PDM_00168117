package com.example.parcial1pdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.parcial1pdm.R
import com.example.parcial1pdm.database.entities.Match
import com.example.parcial1pdm.models.MatchViewModel
import com.example.parcial1pdm.models.ScoreViewModel
import kotlinx.android.synthetic.main.activity_new_match.*

class NewMatchActivity : AppCompatActivity() {

    private lateinit var matchViewmodel: MatchViewModel
    private lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_match)
        matchViewmodel = ViewModelProviders.of(this).get(MatchViewModel::class.java)
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        Score_A.text = scoreViewModel.score_A.toString()
        Score_B.text = scoreViewModel.score_B.toString()
        this.apply {
            Score_add_1_A.setOnClickListener {
                scoreViewModel.score_A++
                Score_A.text = scoreViewModel.score_A.toString()
            }
            Score_add_2_A.setOnClickListener {
                scoreViewModel.score_A+=2
                Score_A.text = scoreViewModel.score_A.toString()
            }
            Score_add_3_A.setOnClickListener {
                scoreViewModel.score_A+=3
                Score_A.text = scoreViewModel.score_A.toString()
            }
            Score_add_1_B.setOnClickListener {
                scoreViewModel.score_B++
                Score_B.text = scoreViewModel.score_B.toString()
            }
            Score_add_2_B.setOnClickListener {
                scoreViewModel.score_B+=2
                Score_B.text = scoreViewModel.score_B.toString()
            }
            Score_add_3_B.setOnClickListener {
                scoreViewModel.score_B+=3
                Score_B.text = scoreViewModel.score_B.toString()
            }
            btn_send.setOnClickListener {

                val winner = if(scoreViewModel.score_A > scoreViewModel.score_B) {
                    Team_A.text.toString()
                }else if (scoreViewModel.score_A == scoreViewModel.score_B) {
                        "Draw"
                }else {
                    Team_B.text.toString()
                }

                var data = Match(Team_A.text.toString(), Team_B.text.toString(), scoreViewModel.score_A,
                    scoreViewModel.score_B, winner, Date.text.toString(), Time.text.toString())

                var flag = true

                if(TextUtils.isEmpty(Team_A.text) || TextUtils.isEmpty(Team_B.text) || TextUtils.isEmpty(Date.text) || TextUtils.isEmpty(Time.text)) {
                    flag = false
                }

                if(flag) {
                    matchViewmodel.insert(data)
                    finish()
                }else {
                    Toast.makeText(this, "Unable to Add New Match",
                            Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
