package com.hien.mywaterok.worker

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.hien.mywaterok.MainActivity


class WaterReminderWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        val plantName = inputData.getString(NAME_KEY) ?: return Result.failure()

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(applicationContext, MainActivity.CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_popup_reminder) // Bạn có thể đổi icon tùy ý
            .setContentTitle("Water me!")
            .setContentText("It's time to water your $plantName.")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        // Sử dụng ID ngẫu nhiên hoặc hashcode để hiển thị nhiều thông báo cùng lúc
        notificationManager.notify(plantName.hashCode(), notification)
        return Result.success()
    }
    companion object {
        const val NAME_KEY = "PLANT_NAME"
    }
}