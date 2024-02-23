package aajogo.jogoaajogo.aajogotiger.baixaaajogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.cbrt

class AACalc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aacalc)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        calculateButton.setOnClickListener {
            val input = inputEditText.text.toString().toDoubleOrNull()
            if (input != null) {
                val cubicRoot = calculateCubicRoot(input)
                resultTextView.text = "Cubic root: $cubicRoot"
            } else {
                resultTextView.text = "Incorrect format"
            }
        }
    }

    private fun calculateCubicRoot(number: Double): Double {
        return cbrt(number)
    }

}