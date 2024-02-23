package aajogo.jogoaajogo.aajogotiger.baixaaajogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class AANumber : AppCompatActivity() {
    private val minNumber = 1
    private val maxNumber = 100
    private var secretNumber = 0
    private var attempts = 6
    private val maxAttempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aanumber)

        val instructionsTextView = findViewById<TextView>(R.id.instructionsTextView)
        val guessEditText = findViewById<EditText>(R.id.guessEditText)
        val guessButton = findViewById<Button>(R.id.guessButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val attemptsTextView = findViewById<TextView>(R.id.attemptsTextView)

        secretNumber = Random.nextInt(minNumber, maxNumber + 1)

        guessButton.setOnClickListener {
            if (attempts > maxAttempts) {
                val guess = guessEditText.text.toString().toIntOrNull()

                if (guess != null) {
                    attempts--
                    attemptsTextView.text = "Attempts: $attempts"

                    if (guess == secretNumber) {
                        resultTextView.text = "Congratulations! You guessed the number in $attempts attempts."
                        guessButton.isEnabled = false
                    } else if (guess < secretNumber) {
                        resultTextView.text = "Try a higher number."
                    } else {
                        resultTextView.text = "Try a lower number."
                    }

                    if (attempts == maxAttempts) {
                        resultTextView.text = "Out of attempts! The secret number was $secretNumber. You lose."
                        guessButton.isEnabled = false
                    }
                } else {
                    resultTextView.text = "Please enter a valid number."
                }
            }
        }
    }
}