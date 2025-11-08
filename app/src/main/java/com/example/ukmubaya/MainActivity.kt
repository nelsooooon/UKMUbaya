package com.example.ukmubaya

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ukmubaya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var events: ArrayList<Event> = arrayListOf(
        Event(1, "ILPC", "Logic and programming competition", R.drawable.programming,
            "08/01/2021", 25, 10),
        Event(2, "MANIAC", "Multimedia competition", R.drawable.mm,
            "25/07/2021", 20, 10),
        Event(3, "ICF", "Informatics student exhibition", R.drawable.project,
            "25/07/2021", 50, 10)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fragmentList = EventFragmentList.newInstance(events)
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, fragmentList)
            //replace()
            //remove()
            commit()
        }
    }
}