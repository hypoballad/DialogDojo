package com.hypoballad.dialogdojo.data.local

import com.google.gson.annotations.SerializedName

data class Practice(
    @SerializedName("r_id")

    val id: Int,
    @SerializedName("r_title")
    val title: String,
    @SerializedName("r_date")
    val date: String,
    @SerializedName("r_time")
    val time: String,
    @SerializedName("r_dialogs")
    val dialogs: MutableList<Dialog>,
    val isFavorite: Boolean)

data class Dialog(
    @SerializedName("r_d_id")
    val id: Int,
    @SerializedName("r_d_title")
    val title: String,
    @SerializedName("r_d_content")
    val content: String)

// get dialog list from dummy data
val dummyDialogs = listOf(
    Dialog(1, "Dialog 1", "Excuse me, can we see the menu please?"),
    Dialog(2, "Dialog 2", "Of course, here you are."),
    Dialog(3, "Dialog 3", "Thank you. What do you recommend?"),
    Dialog(4, "Dialog 4", "Our chef's special is the grilled salmon. It's delicious."),
    Dialog(5, "Dialog 5", "Sounds good. I'll have that, please."),
    Dialog(6, "Dialog 6", "Excellent choice. And for your friend?"),
    Dialog(7, "Dialog 7", "She'll have the spaghetti carbonara."),
    Dialog(8, "Dialog 8", "Very good. And can I get you anything to drink?"),
    Dialog(9, "Dialog 9", "Just water for now, please."),
)

val dummyPractices = listOf(
    Practice(
        1,
        "Practice 1",
        "2021-01-01",
        "12:00",
        mutableListOf(
            Dialog(1, "Dialog 1", "Content 1")),
        isFavorite = true),
    Practice(
        2,
        "Practice 2",
        "2021-01-02",
        "13:00",
        mutableListOf(
            Dialog(2, "Dialog 2", "Content 2")),
        isFavorite = false),
    Practice(
        3,
        "Practice 3",
        "2021-01-03",
        "14:00",
        mutableListOf(
            Dialog(3, "Dialog 3", "Content 3")),
        isFavorite = true),
    Practice(
        4,
        "Practice 4",
        "2021-01-04",
        "15:00",
        mutableListOf(
            Dialog(4, "Dialog 4", "Content 4")),
        isFavorite = false),
    Practice(
        5,
        "Practice 5",
        "2021-01-05",
        "16:00",
        mutableListOf(
            Dialog(5, "Dialog 5", "Content 5")),
        isFavorite = true),
    Practice(
        6,
        "Practice 6",
        "2021-01-06",
        "17:00",
        mutableListOf(
            Dialog(6, "Dialog 6", "Content 6")),
        isFavorite = false),
    Practice(
        7,
        "Practice 7",
        "2021-01-07",
        "18:00",
        mutableListOf(
            Dialog(7, "Dialog 7", "Content 7")),
        isFavorite = true),
    Practice(
        8,
        "Practice 8",
        "2021-01-08",
        "19:00",
        mutableListOf(
            Dialog(8, "Dialog 8", "Content 8")),
        isFavorite = false),
    Practice(
        9,
        "Practice 9",
        "2021-01-09",
        "20:00",
        mutableListOf(
            Dialog(9, "Dialog 9", "Content 9")),
        isFavorite = true),
    Practice(
        10,
        "Practice 10",
        "2021-01-10",
        "21:00",
        mutableListOf(
            Dialog(10, "Dialog 10", "Content 10")),
        isFavorite = false),
    Practice(
        11,
        "Practice 11",
        "2021-01-11",
        "22:00",
        mutableListOf(
            Dialog(11, "Dialog 11", "Content 11")),
        isFavorite = true),
    Practice(
        12,
        "Practice 12",
        "2021-01-12",
        "23:00",
        mutableListOf(
            Dialog(12, "Dialog 12", "Content 12")),
        isFavorite = false),
    Practice(
        13,
        "Practice 13",
        "2021-01-13",
        "00:00",
        mutableListOf(
            Dialog(13, "Dialog 13", "Content 13")),
        isFavorite = true),
    Practice(
        14,
        "Practice 14",
        "2021-01-14",
        "01:00",
        mutableListOf(
            Dialog(14, "Dialog 14", "Content 14")),
        isFavorite = false),
    Practice(
        15,
        "Practice 15",
        "2021-01-15",
        "02:00",
        mutableListOf(
            Dialog(15, "Dialog 15", "Content 15")),
        isFavorite = true))
