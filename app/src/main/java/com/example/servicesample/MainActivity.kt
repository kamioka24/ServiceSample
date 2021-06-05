package com.example.servicesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 再生ボタンタップ時の処理
    fun onPlayButtonClick(view: View) {
        // インテントオブジェクトを生成
        val intent = Intent(this, SoundManageService::class.java)
        // サービスを始動
        startService(intent)

        // 再生ボタンをアップ不可に、停止ボタンをタップ可に
        val btPlay = findViewById<Button>(R.id.btPlay)
        val btStop = findViewById<Button>(R.id.btStop)

        btPlay.isEnabled = false
        btStop.isEnabled = true
    }

    // 停止ボタンタップ時の処理
    fun onStopButtonClick(view: View) {
        // インテントオブジェクトを生成
        val intent = Intent(this, SoundManageService::class.java)
        // サービスを停止
        stopService(intent)

        // 再生ボタンをタップ可に、停止ボタンをタップ不可に
        val btPlay = findViewById<Button>(R.id.btPlay)
        val btStop = findViewById<Button>(R.id.btStop)
        btPlay.isEnabled = true
        btStop.isEnabled = false
    }
}