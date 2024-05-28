package com.example.lab_8

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerViewVert.layoutManager = LinearLayoutManager(this)
        val languages = listOf(
            Pair("C++", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/ISO_C%2B%2B_Logo.svg/640px-ISO_C%2B%2B_Logo.svg.png"),
            Pair("C#", "https://armedsoft.com/sites/default/files/csharp_logo.png"),
            Pair("Java", "https://upload.wikimedia.org/wikipedia/uk/thumb/2/2e/Java_Logo.svg/800px-Java_Logo.svg.png"),
            Pair("Kotlin", "https://developer.okta.com/assets-jekyll/blog/tutorial-kotlin-beginners-guide/kotlin-logo-social-21c8518b19eb96d96f35e0057bb92b7e1281a24820e0fa09e39c42f184bd7faa.png"),
            Pair("JavaScript", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Unofficial_JavaScript_logo_2.svg/1200px-Unofficial_JavaScript_logo_2.svg.png"),
            Pair("TypeScript", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Typescript_logo_2020.svg/1200px-Typescript_logo_2020.svg.png"),
        )

        val adapter = LanguageAdapter(languages){ position: Int ->
            val intent = Intent(this, LanguageDetailsActivity::class.java)
            intent.putExtra("languageName", languages[position].first)
            startActivity(intent)
        }

        binding.recyclerViewVert.adapter = adapter
        binding.recyclerViewHor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val languagesNames = listOf(
            "C++",
            "C#",
            "Java",
            "Kotlin",
            "JavaScript",
            "TypeScript",
        )
        val adapterSecond = HorizontalViewAdapter(languagesNames)
        binding.recyclerViewHor.adapter = adapterSecond
    }
}