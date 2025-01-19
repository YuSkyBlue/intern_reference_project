package com.example.intern_reference_project

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SampleSttActivityViewModel @Inject constructor(

) : ViewModel() {
    private val _speechText = MutableLiveData<String>()
    val speechText: LiveData<String> get() = _speechText

    fun getRecordPermissionGranted(): Boolean {
        var status = false
//        when (val response = getRecordPermissionUseCase.getRecordPermission()) {
//            is Response.Success -> status = response.value.granted
//            is Response.Error -> Log.e(TAG, "Error:{${response.reason}")
//        }
        return status
    }

    fun createSpeechListener() {
        viewModelScope.launch {
//            createSpeechListenerUseCase.createSpeechListener().collect() { event ->
//                when (event) {
//                    is SpeechToTextEvent.ReadyToSpeech -> {
//                        Log.i(TAG, "ReadyToSpeech")
//                    }
//
//                    is SpeechToTextEvent.BeginingOfSpeech -> {
//                        Log.i(TAG, "BeginingOfSpeech")
//                    }
//
//                    is SpeechToTextEvent.EndOfSpeech -> {
//                        Log.i(TAG, "EndOfSpeech")
//                    }
//
//                    is SpeechToTextEvent.SpeechResult -> {
//                        Log.i(TAG, "Text : ${event.text}")
//                        _speechText.value = event.text
//                    }
//                }
//            }
        }
    }

    fun startSpeechListener() {
        viewModelScope.launch {
//            when (val response = startListenerUseCase.startSpeechListener()) {
//                is Response.Success -> Log.e(TAG, "Success")
//                is Response.Error -> Log.e(TAG, "Error:{${response.reason}")
//            }
        }
    }

    fun stopSpeechListener() {
        TODO("Not yet implemented")
    }

    companion object {
        const val TAG = "SampleSttActivityViewModel"
    }
}