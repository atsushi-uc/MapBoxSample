package com.example.mapboxsample.domain.repository

import com.example.mapboxsample.domain.model.SampleInfo

interface LocalDateRepository {
    var sampleInfo: SampleInfo?
}