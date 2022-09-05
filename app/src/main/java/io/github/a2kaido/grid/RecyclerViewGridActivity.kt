package io.github.a2kaido.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import io.github.a2kaido.grid.databinding.ActivityRecyclerViewGridBinding

class RecyclerViewGridActivity : ComponentActivity() {

    private lateinit var binding: ActivityRecyclerViewGridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewGridBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        view.adapter = RecyclerViewItemAdapter(
            buildList {
                for (i in 0..999) {
                    add("Item: $i")
                }
            }
        )
    }
}