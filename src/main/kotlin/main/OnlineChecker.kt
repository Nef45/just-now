package main

const val SECONDS_IN_MINUTE = 60
const val SECONDS_IN_HOUR = 3600
const val SECONDS_IN_DAY = 86400

fun main() {
    val secondsAgo1 = 50
    val secondsAgo2 = 21 * SECONDS_IN_MINUTE
    val secondsAgo3 = 18 * SECONDS_IN_HOUR
    val secondsAgo4 = 2 * SECONDS_IN_DAY
    val secondsAgo5 = 3 * SECONDS_IN_DAY
    val secondsAgo6 = 3 * SECONDS_IN_DAY + 600

    val messageText1 = agoToText(secondsAgo1)
    val messageText2 = agoToText(secondsAgo2)
    val messageText3 = agoToText(secondsAgo3)
    val messageText4 = agoToText(secondsAgo4)
    val messageText5 = agoToText(secondsAgo5)
    val messageText6 = agoToText(secondsAgo6)

    println(messageText1)
    println(messageText2)
    println(messageText3)
    println(messageText4)
    println(messageText5)
    println(messageText6)
}

fun agoToText(seconds: Int): String {
    val minutes = seconds / SECONDS_IN_MINUTE
    val hours = seconds / SECONDS_IN_HOUR
    val ending = when (seconds) {
        in 0..SECONDS_IN_MINUTE -> "только что"
        in (SECONDS_IN_MINUTE + 1).. SECONDS_IN_HOUR -> "$minutes ${defineMinutesEnding(seconds)} назад"
        in (SECONDS_IN_HOUR + 1) .. SECONDS_IN_DAY -> "$hours ${defineHoursEnding(seconds)} назад"
        in (SECONDS_IN_DAY + 1) .. (SECONDS_IN_DAY * 2) -> "сегодня"
        in (SECONDS_IN_DAY * 2 + 1) .. (SECONDS_IN_DAY * 3) -> "вчера"
        else -> "давно"
    }
    return "был(а) в сети $ending"
}

fun defineMinutesEnding(seconds: Int = 0): String {
    val minutes = seconds / SECONDS_IN_MINUTE
    return when (seconds) {
        in SECONDS_IN_MINUTE .. SECONDS_IN_HOUR -> {
            when {
                minutes in 11..20 -> "минут"
                minutes == 1 || minutes % 10 == 1 -> "минуту"
                minutes == 2 || minutes % 10 == 2 ||
                        minutes == 3 || minutes % 10 == 3 ||
                        minutes == 4 || minutes % 10 == 4 -> "минуты"
                else -> "минут"
            }
        }
        else -> "Time format error"
    }
}

fun defineHoursEnding(seconds: Int = 0): String {
    val hours = seconds / SECONDS_IN_HOUR
    return when (seconds) {
        in SECONDS_IN_HOUR..SECONDS_IN_DAY -> {
            when {
                hours == 1 || hours % 20 == 1 -> "час"
                hours == 2 || hours % 20 == 2 ||
                        hours == 3 || hours % 20 == 3 ||
                        hours == 4 || hours % 20 == 4 -> "часа"
                else -> "часов"
            }
        }
        else -> "Time format error"
    }
}