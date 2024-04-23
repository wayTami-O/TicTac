package com.example.tic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.tic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var score: Int = 1
    private var x = intArrayOf()
    private var o = intArrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image1.setOnClickListener {
            pick(binding.image1 , 1)
        }


        binding.image2.setOnClickListener {
            pick(binding.image2 , 2)
        }

        binding.image3.setOnClickListener {
            pick(binding.image3 , 3)
        }

        binding.image4.setOnClickListener {
            pick(binding.image4 , 4)
        }

        binding.image5.setOnClickListener {
            pick(binding.image5 , 5)
        }

        binding.image6.setOnClickListener {
            pick(binding.image6 , 6)
        }

        binding.image7.setOnClickListener {
            pick(binding.image7 , 7)
        }

        binding.image8.setOnClickListener {
            pick(binding.image8 , 8)
        }

        binding.image9.setOnClickListener {
            pick(binding.image9 , 9)
        }

        binding.button.setOnClickListener {
            allClear()
        }
    }

    private fun pick(img: Any, index: Int) {
        if (score == 1 && index !in o && index !in x) {
            (img as ImageView).setImageResource(R.drawable.tic)
            x += index
            x.sort()
            score++
            if (x.size >= 3) {
                winner(true)
            }
            binding.over.text = "Сейчас ходит: 0"
        } else if (score == 2 && index !in x && index !in o) {
            (img as ImageView).setImageResource(R.drawable.round)
            o += index
            o.sort()
            score -= 1
            if (o.size >= 3) {
                winner(false)
            }
            binding.over.text = "Сейчас ходит: Х"
        } else {
            Toast.makeText(this, "Занято", Toast.LENGTH_SHORT).show()
        }
    }

    private fun winner(bool: Boolean) {
        when(bool) {
            true -> if ((1 in x && 2 in x && 3 in x) || (4 in x && 5 in x && 6 in x) || (7 in x && 8 in x && 9 in x) || (1 in x && 4 in x && 7 in x) || (2 in x && 5 in x && 8 in x) || (3 in x && 6 in x && 9 in x) || (7 in x && 5 in x && 3 in x) || (1 in x && 5 in x && 9 in x)) {
                allClear()
                Toast.makeText(this, "Победа стороны X", Toast.LENGTH_SHORT).show()
            }
            false -> if ((1 in o && 2 in o && 3 in o) || (4 in o && 5 in o && 6 in o) || (7 in o && 8 in o && 9 in o) || (1 in o && 4 in o && 7 in o) || (2 in o && 5 in o && 8 in o) || (3 in o && 6 in o && 9 in o) || (7 in o && 5 in o && 3 in o) || (1 in o && 5 in o && 9 in o)) {
                allClear()
                Toast.makeText(this, "Победа стороны 0", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun allClear() {
        binding.image1.setImageResource(R.drawable.white)
        binding.image2.setImageResource(R.drawable.white)
        binding.image3.setImageResource(R.drawable.white)
        binding.image4.setImageResource(R.drawable.white)
        binding.image5.setImageResource(R.drawable.white)
        binding.image6.setImageResource(R.drawable.white)
        binding.image7.setImageResource(R.drawable.white)
        binding.image8.setImageResource(R.drawable.white)
        binding.image9.setImageResource(R.drawable.white)
        x = intArrayOf()
        o = intArrayOf()
        score = 1
        binding.over.text = "Начните новую игру!"
    }
}