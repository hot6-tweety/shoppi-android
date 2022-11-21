package com.shoppi.app

import android.content.Context
import android.util.Log

class AssetLoader(private val context: Context) {

    fun getJsonString(fileName: String): String? {
        // runCatching 성공, 실패 case 로 나뉘어지는 경우 사용
        return kotlin.runCatching {
            loadAsset(fileName)
        }.getOrNull()
    }

    private fun loadAsset(fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            // inputStream 에 데이터가 있는지 확인하는 메소드
            val size = inputStream.available()
            // inputStream 데이터들은 ByteArray 타입
            val bytes = ByteArray(size)
            // 데이터 읽기
            inputStream.read(bytes)
            // String 타입으로 변환
            String(bytes)
        }
    }
}