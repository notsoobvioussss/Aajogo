package aajogo.jogoaajogo.aajogotiger.baixaaajogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CountryActivity : AppCompatActivity() {
    private val countries = listOf(
        Country("Canada", "This country is known for its vast landscapes and maple syrup."),
        Country("France", "This country is famous for its cuisine, including croissants and escargot."),
        Country("Japan", "This country is known for its sushi and cherry blossoms."),
        Country("Australia", "This country is home to kangaroos and the Sydney Opera House."),
        Country("Italy", "This country is famous for its pasta, pizza, and art."),
        Country("Brazil", "This country is known for its Carnival and Amazon Rainforest."),
        Country("Russia", "This country is the largest in the world and is known for its matryoshka dolls."),
        Country("Egypt", "This country is home to the pyramids and the Nile River."),
        Country("India", "This country is known for its diverse culture and spicy cuisine."),
        Country("South Africa", "This country is known for its wildlife and Table Mountain.")
    )
    private lateinit var currentCountry: Country
    private var attempts = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
        val answerEditText = findViewById<EditText>(R.id.answerEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val attemptsTextView = findViewById<TextView>(R.id.attemptsTextView)

        currentCountry = countries.random()
        descriptionTextView.text = currentCountry.description
        attemptsTextView.text = "Attempts left: $attempts"

        submitButton.setOnClickListener {
            val userAnswer = answerEditText.text.toString()
            if (userAnswer.equals(currentCountry.name, ignoreCase = true)) {
                descriptionTextView.text = "Congratulations! You guessed the country."
                answerEditText.isEnabled = false
                submitButton.isEnabled = false
            } else {
                attempts--
                if (attempts > 0) {
                    descriptionTextView.text = "Incorrect. You have $attempts attempts left."
                    attemptsTextView.text = "Attempts left: $attempts"
                } else {
                    descriptionTextView.text = "Game over. The correct answer was ${currentCountry.name}."
                    answerEditText.isEnabled = false
                    submitButton.isEnabled = false
                }
            }
        }
    }
}
