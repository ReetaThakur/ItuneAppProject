package com.reeta.ituneappproject.view

import com.reeta.ituneappproject.response.ResponseDTO

sealed class MainUiModel {
    data class onSuccess(val responseDTO: ResponseDTO):MainUiModel()
    data class onFailure(val error:String):MainUiModel()
}