package com.example.mapboxsample.data.repository

import android.content.Context
import com.example.mapboxsample.domain.model.SampleInfo
import com.example.mapboxsample.domain.repository.LocalDateRepository
import com.example.mapboxsample.presentation.MainActivity.Companion.TAG
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferenceImpl @Inject constructor(
    @ApplicationContext context: Context
) : LocalDateRepository {
    companion object {
        val SP_SAMPLE = "SP_SAMPLE"
    }
    private val mSharedPreference = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    private val mMoshi = Moshi.Builder().build()

    override var sampleInfo: SampleInfo? = null
        get() {
            val adapter = mMoshi.adapter(SampleInfo::class.java)
            val json = mSharedPreference.getString(SP_SAMPLE, null)
            return if (json != null) {
                adapter.fromJson(json)
            } else {
                null
            }
        }
        set(value) {
            val adapter = mMoshi.adapter(SampleInfo::class.java)
            val decodeJson = adapter.toJson(value)
            mSharedPreference.edit().putString(SP_SAMPLE, decodeJson).apply()
            field = value
        }

}