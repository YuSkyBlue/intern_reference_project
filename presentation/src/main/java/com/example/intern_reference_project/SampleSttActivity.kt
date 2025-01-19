package com.example.intern_reference_project

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.intern_reference_project.databinding.ActivitySamplesttBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class SampleSttActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySamplesttBinding
    private val sampleSttActivityViewModel: SampleSttActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySamplesttBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

//        checkPermission()
//        createSpeechListener()
//        setOnClickListener()
//        observeSpeechText()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

//    private fun setOnClickListener() {
//        binding.button.setOnTouchListener { view, motionEvent ->
//            when (motionEvent.actionMasked) {
//                MotionEvent.ACTION_DOWN -> {
//                    startSpeechListener()
//                }
//            }
//            false
//        }
//    }

    private val speechRecognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
    }
//    private fun createSpeechListener() {
//        sampleSttActivityViewModel.createSpeechListener()
//    }
//
//    private fun startSpeechListener() {
//
////        speechRecognizer?.startListening(speechRecognizerIntent)
//        sampleSttActivityViewModel.startSpeechListener()
//    }
//
//    private fun stopSpeechListener() {
//        sampleSttActivityViewModel.stopSpeechListener()
//    }
//
//    private fun observeSpeechText() {
//        sampleSttActivityViewModel.speechText.observe(this) {
//            binding.text.setText(it)
//        }
//    }
//
//    private fun checkPermission() {
//        val granted = sampleSttActivityViewModel.getRecordPermissionGranted()
//        if (granted == false) {
//            requestPermission()
//        } else {
//            Log.i(TAG, "permission Already Granted")
//        }
//    }

    private fun requestPermission() {
        requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { permission ->
        when(permission) {
            true -> {
                Toast.makeText(this,"Permission Granted", Toast.LENGTH_SHORT).show()
            }
            false -> {
                Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "SampleSttActivity"
        const val RecordAudioRequestCode = 1
    }
}
