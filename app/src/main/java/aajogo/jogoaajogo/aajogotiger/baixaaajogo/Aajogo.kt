package aajogo.jogoaajogo.aajogotiger.baixaaajogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class Aajogo : AppCompatActivity() {
    private val crystals = arrayOf(R.drawable.crystal1, R.drawable.crystal2, R.drawable.crystal3)
    private val values = arrayOf(1, 2, 3)
    private var score = 0
    private var movesLeft = 10
    private var isGameOver = false
    private lateinit var crystal1: ImageView
    private lateinit var crystal2: ImageView
    private lateinit var crystal3: ImageView
    private lateinit var scoreView: TextView
    private lateinit var movesView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aajogo2)

        crystal1 = findViewById(R.id.crystal_1)
        crystal2 = findViewById(R.id.crystal_2)
        crystal3 = findViewById(R.id.crystal_3)
        scoreView = findViewById(R.id.score)
        movesView = findViewById(R.id.moves)

        crystal1.setOnClickListener { collectCrystal(0) }
        crystal2.setOnClickListener { collectCrystal(1) }
        crystal3.setOnClickListener { collectCrystal(2) }

        Handler().postDelayed(object : Runnable {
            override fun run() {
                if (!isGameOver) {
                    updateCrystalValues()
                    Handler().postDelayed(this, 100)
                }
            }
        }, 500)
        Handler(Looper.getMainLooper()).post(object : Runnable {
            override fun run() {
                moveCrystals()
                Handler(Looper.getMainLooper()).postDelayed(this, 500)
            }
        })
    }

    private fun updateCrystalValues() {
        for (i in crystals.indices) {
            val randomValue = Random.nextInt(1, 4)
            values[i] = randomValue
            val crystal = getCrystal(i)
            crystal.setImageResource(crystals[i])
            crystal.tag = randomValue
        }
    }

    private fun collectCrystal(index: Int) {
        if (!isGameOver) {
            val value = values[index]
            score += value
            scoreView.text = "Score: $score"
            movesLeft--
            movesView.text = "Moves left: $movesLeft"
            if (movesLeft == 0) {
                gameOver()
            }
        }
    }

    private fun moveCrystals() {
        crystal1.x = Random.nextInt(800).toFloat()
        crystal1.y = Random.nextInt(700,1500).toFloat()
        crystal2.x = Random.nextInt(800).toFloat()
        crystal2.y = Random.nextInt(700,1500).toFloat()
        crystal3.x = Random.nextInt(800).toFloat()
        crystal3.y = Random.nextInt(700,1500).toFloat()
    }

    private fun getCrystal(index: Int): ImageView {
        return when (index) {
            0 -> crystal1
            1 -> crystal2
            else -> crystal3
        }
    }

    private fun gameOver() {
        isGameOver = true
        crystal1.isEnabled = false
        crystal2.isEnabled = false
        crystal3.isEnabled = false
        scoreView.text = "Game over! Score: $score"
        movesView.text = ""
    }
}