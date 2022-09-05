package io.github.a2kaido.grid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.a2kaido.grid.ui.theme.LazyVerticalGridSampleTheme

class ComposeGridActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalGridSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ItemList()
                }
            }
        }
    }
}

@Composable
fun ItemList(
    lazyGridState: LazyGridState = rememberLazyGridState()
) {
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        state = lazyGridState,
    ) {
        items(1000) { index ->
            Text(
                modifier = Modifier
                    .clickable {
                        context.startActivity(Intent(context, RecyclerViewGridActivity::class.java))
                    }
                    .fillMaxWidth()
                    .height(160.dp),
                text = "Item: $index",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyVerticalGridSampleTheme {
        ItemList()
    }
}