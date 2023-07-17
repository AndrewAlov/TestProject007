package com.test.testproject007.data

import com.test.testproject007.R

object TestData {
    val cities = arrayListOf(
        City("Ульяновск", R.drawable.city_ulyan,50100),
        City("Санкт-Петербург", R.drawable.city_spb,25363),
        City("Москва", R.drawable.city_msk,15961),
        City("Ульяновск", R.drawable.city_ulyan,50100),
        City("Санкт-Петербург", R.drawable.city_spb,25363),
        City("Москва", R.drawable.city_msk,15961)
    )
    val lastApartments = arrayListOf(
        Apartment(R.drawable.last_apartment_1, "Сочи", "Приморская улица, 19", ApartmentType.BEDROOM_1),
        Apartment(R.drawable.last_apartment_2, "Сочи", "Приморская улица, 29", ApartmentType.STUDIO)
    )
    val apartment = Apartment(
        R.drawable.last_apartment_1,
        "Сочи",
        "Приморская улица, 19",
        ApartmentType.BEDROOM_1,
        1700,
        R.string.test_apartment_description,
        43.60296,
        39.73432
    )
}