package com.example.dicerolller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this,"Rolled Successfully!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val Dice = Dice(6)
        val diceRoll = Dice.roll()
        val diceImage:ImageView=findViewById(R.id.imageView)
        val result: TextView=findViewById(R.id.textView)
        result.text=diceRoll.toString()
        val Image=when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
       diceImage.setImageResource(Image)
      diceImage.contentDescription=diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}