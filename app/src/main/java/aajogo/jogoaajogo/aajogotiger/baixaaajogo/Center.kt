package aajogo.jogoaajogo.aajogotiger.baixaaajogo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aajogo.jogoaajogo.aajogotiger.baixaaajogo.databinding.ActivityCenterBinding

class Center : AppCompatActivity() {
    lateinit var cnt_bind: ActivityCenterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        cnt_bind = ActivityCenterBinding.inflate(layoutInflater)
        setContentView(cnt_bind.root)

        cnt_bind.game1.setOnClickListener {
            st1()
        }
        cnt_bind.game2.setOnClickListener {
            st2()
        }
        cnt_bind.game2.setOnClickListener {
            st2()
        }
        cnt_bind.game3.setOnClickListener {
            st3()
        }
        cnt_bind.game4.setOnClickListener {
            st4()
        }
        cnt_bind.note.setOnClickListener {
            st5()
        }
        cnt_bind.plus.setOnClickListener {
            st6()
        }
        cnt_bind.exit.setOnClickListener {
            ext()
        }
    }



    private fun st1(){
        val st1 = Intent(this, Aajogo::class.java)
        startActivity(st1)
    }
    private fun st2(){
        val st2 = Intent(this, CountryActivity::class.java)
        startActivity(st2)
    }
    private fun st3(){
        val st3 = Intent(this, AAGame::class.java)
        startActivity(st3)
    }
    private fun st4(){
        val st4 = Intent(this, AANumber::class.java)
        startActivity(st4)
    }
    private fun st5(){
        val st5 = Intent(this, AADescript::class.java)
        startActivity(st5)
    }
    private fun st6(){
        val st6 = Intent(this, AACalc::class.java)
        startActivity(st6)
    }
    private fun ext(){
        finishAffinity()
    }
}