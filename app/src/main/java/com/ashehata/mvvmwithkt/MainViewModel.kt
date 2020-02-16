package com.ashehata.mvvmwithkt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _isFormValid = MutableLiveData<Boolean>()

    val isValid: LiveData<Boolean>
        get() = _isFormValid

    var username = ""

    var userPassword = ""
        set(value) {
            field = value
            validateForm()
        }

    private fun validateForm() {
        if (username.length > 8 && userPassword.length > 8) {
            _isFormValid.postValue(true)
        } else {
            _isFormValid.postValue(false)
        }
    }

}