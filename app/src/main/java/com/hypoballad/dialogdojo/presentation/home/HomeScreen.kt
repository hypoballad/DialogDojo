package com.hypoballad.dialogdojo.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Column {
        // 一番上の段に広告を表示
        AdBanner()

        Row(verticalAlignment = Alignment.CenterVertically) {
            // メニューボタンを表示
            MenuButton()

            // 練習履歴検索ボックスを表示
            SearchBox()
        }

        // 練習履歴リストを表示
        PracticeHistoryList()

        // 画面右下に練習を追加するボタンを表示
        AddPracticeButton()
    }
}

@Composable
fun AdBanner() {
    // TODO: 広告の表示
}

@Composable
fun MenuButton() {
    // TODO: メニューボタンの表示
}

@Composable
fun SearchBox() {
    // TODO: 練習履歴検索ボックスの表示
}

@Composable
fun PracticeHistoryList() {
    // TODO: 練習履歴リストの表示
}

@Composable
fun AddPracticeButton() {
    // TODO: 練習を追加するボタンの表示
}

