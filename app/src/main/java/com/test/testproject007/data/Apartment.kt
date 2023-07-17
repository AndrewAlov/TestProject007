package com.test.testproject007.data

data class Apartment(
    val imageRes: Int,
    val cityName: String,
    val address: String,
    val apartmentType: ApartmentType,
    val price: Int = 0,
    val descriptionRes: Int = -1,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)
