package com.shenby.grfa1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shenby.grfa1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val customApi: ICustomApi = CustomApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.apply {
            textView.apply {
                setText(R.string.current_package)
                setOnClickListener {
                    Toast.makeText(this@MainActivity, customApi.text, Toast.LENGTH_SHORT).show()
                }
            }
            textViewP1.text = "P1=${BuildConfig.PARAM_P1}"
            textViewP2.text = "P2=${BuildConfig.PARAM_P2}"
        }

    }


}