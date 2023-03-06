package com.hypoballad.dialogdojo.presentation.practice.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.hypoballad.dialogdojo.data.local.Practice
import com.hypoballad.dialogdojo.data.local.dummyPractices

@Composable
fun PracticeHistoryScreen() {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp)) {
        itemsIndexed(dummyPractices) { index, practice ->
            PracticeHistoryItem(practice, isEvenRow = index % 2 == 0)
        }
    }
}

@Composable
fun PracticeHistoryItem(item: Practice, isEvenRow: Boolean = false) {
    Card(elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
    ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)) {
                PracticeHistoryIcon(Icons.Filled.Edit,
                    Modifier.weight(0.15f))
                PracticeHistoryDetails(
                    item.title,
                    Modifier.weight(0.85f))
            }
    }
}

@Composable
private fun PracticeHistoryIcon(icon: ImageVector,  modifier: Modifier) {
    Icon(
        imageVector = icon,
        contentDescription = "Practice History Icon",
        modifier = modifier.padding(8.dp)
    )
}


@Composable
private fun PracticeHistoryDetails(title: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = title,
            style= MaterialTheme.typography.h6,
            maxLines = 1,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PracticeHistoryScreen()
}

