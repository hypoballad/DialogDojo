package com.hypoballad.dialogdojo.presentation.practice.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.SettingsVoice
import androidx.compose.material.icons.outlined.Cyclone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hypoballad.dialogdojo.data.local.Dialog
import com.hypoballad.dialogdojo.data.local.dummyDialogs
import com.hypoballad.dialogdojo.ui.theme.DialogDojoTheme

@Composable
fun PracticeDetailScreen() {
    Column (modifier = Modifier.fillMaxSize())  {
        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            // add text field

            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 8.dp,
                    horizontal = 8.dp)
            ) {
                itemsIndexed(dummyDialogs) { index, dialog ->
                    DialogCard(item = dialog, isEvenRow = index % 2 == 0)
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var textFieldValue = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = textFieldValue.value,
                onValueChange = {textFieldValue.value = it },
                // label = { Text("Label") },
                modifier = Modifier.weight(1f)
            )

            IconButton(
                onClick = { /* TODO */ },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(Icons.Default.Send, contentDescription = "Send")
            }
        }


        // add mic button bottom center of the screen
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.SettingsVoice, contentDescription = "Call")
            }
        }
    }
}

@Composable
fun DialogCard(item: Dialog, isEvenRow: Boolean = false) {
    // Add padding around our card
    Row(modifier = Modifier.padding(8.dp)
        .fillMaxWidth()
        .wrapContentWidth(if (isEvenRow) Alignment.End else Alignment.Start),
        horizontalArrangement = if (isEvenRow) Arrangement.End else Arrangement.Start
    ) {
        // Add an icon to the card use
        if (isEvenRow) {
            DialogIcon(icon = Icons.Filled.Person)
        } else {
            DialogIcon(icon = Icons.Outlined.Cyclone)
        }

        // Add some space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        // Add a column with the name and description
        DialogColumn(item = item, isEvenRow = isEvenRow)

    }
}

@Composable
private fun DialogIcon(icon: ImageVector) {
    Icon(
        imageVector = icon,
        contentDescription = "Practice Person Icon",
        modifier = Modifier
            .size(20.dp)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
    )
}

@Composable
private fun DialogColumn(item: Dialog, isEvenRow: Boolean) {
    Column {
        Surface(shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
            color = if (isEvenRow) Color(0xFFBBDEFB) else Color.LightGray
        ) {
            Text(
                text = item.content,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

// preview of PracticeDetailScreen
@Preview
@Composable
fun DefaultPreview() {
    DialogDojoTheme {
        Surface {
            PracticeDetailScreen()
        }
    }
}