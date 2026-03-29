package com.hien.mywaterok.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.hien.mywaterok.model.Plant
import com.hien.mywaterok.worker.WaterReminderWorker
import java.util.concurrent.TimeUnit

class WaterViewModel(application: Application) : AndroidViewModel(application) {

    private val workManager = WorkManager.getInstance(application)

    // Dữ liệu giả lập theo hình ảnh thiết kế
    val plants = listOf(
        Plant("Lithop", "Succulent", "Stone mimicking succulent", "Water monthly"),
        Plant("Carrot", "Root", "Hardy root vegetable", "Water daily"),
        Plant("Peony", "Flower", "Spring blooming flower", "Water weekly"),
        Plant("Pothos", "Houseplant", "Indoor vine", "Water weekly"),
        Plant("Fiddle Leaf Fig", "Broadleaf evergreen", "Ornamental fig", "Water weekly"),
        Plant("Strawberry", "Fruit", "Delicious red fruit", "Water daily")
    )

    fun scheduleReminder(plant: Plant, duration: Long, unit: TimeUnit) {
        // Đưa tên cây vào inputData để Worker có thể đọc được
        val data = Data.Builder()
            .putString(WaterReminderWorker.NAME_KEY, plant.name)
            .build()

        // Tạo request chạy 1 lần với thời gian delay tương ứng
        val workRequest = OneTimeWorkRequestBuilder<WaterReminderWorker>()
            .setInitialDelay(duration, unit)
            .setInputData(data)
            .build()

        // Đảm bảo mỗi cây chỉ có 1 lịch nhắc nhở duy nhất đang chờ
        workManager.enqueueUniqueWork(
            plant.name,
            ExistingWorkPolicy.REPLACE,
            workRequest
        )
    }
}