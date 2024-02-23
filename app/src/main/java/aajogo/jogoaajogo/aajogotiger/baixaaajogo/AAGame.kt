package aajogo.jogoaajogo.aajogotiger.baixaaajogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AAGame : AppCompatActivity() {
    private val words = listOf("apple", "banana", "cherry", "melon", "orange", "plum")
    private var randomWord = ""
    private val guessedLetters = mutableListOf<Char>()
    private var attempts = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aagame)
        val attemptsTextView = findViewById<TextView>(R.id.attemptsTextView)
        val wordTextView = findViewById<TextView>(R.id.wordTextView)
        val letterEditText = findViewById<EditText>(R.id.letterEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)

        randomWord = words.random()

        submitButton.setOnClickListener {
            val letter = letterEditText.text.toString().toLowerCase().firstOrNull()


            if (letter != null && letter.isLetter()) {
                if (!guessedLetters.contains(letter)) {
                    guessedLetters.add(letter)

                    val displayWord = randomWord.map { if (it in guessedLetters) it else '_' }.joinToString(" ")
                    wordTextView.text = "Word: $displayWord"

                    if (!randomWord.contains(letter)) {
                        attempts--
                        attemptsTextView.text = "Attempts: $attempts" // Обновляем текст счетчика
                    }


                    if (attempts == 0) {
                        endGame(false)
                    } else if (randomWord.all { it in guessedLetters }) {
                        endGame(true)
                    }
                }
            }
        }

    }

    private fun endGame(isWinner: Boolean) {
        val wordTextView = findViewById<TextView>(R.id.wordTextView)
        val submitButton = findViewById<Button>(R.id.submitButton)

        if (isWinner) {
            wordTextView.text = "Congratulations, you guessed the word: $randomWord"
        } else {
            wordTextView.text = "You lose. The word was: $randomWord"
        }

        submitButton.isEnabled = false
    }

}