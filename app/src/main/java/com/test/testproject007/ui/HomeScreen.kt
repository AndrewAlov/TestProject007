package com.test.testproject007.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.test.testproject007.R
import com.test.testproject007.data.Apartment
import com.test.testproject007.data.City
import com.test.testproject007.data.TestData
import com.test.testproject007.ui.theme.Black2
import com.test.testproject007.ui.theme.Dimens
import com.test.testproject007.ui.theme.TestProject007Theme

val LogoImageHeight: Dp = 80.dp
val ApartmentImageWidth: Dp = 160.dp
val ApartmentImageHeight: Dp = 120.dp
val CityImageWidth: Dp = 160.dp
val CityImageHeight: Dp = 120.dp
val ScrollStateInitial: Int = 0
val SubtitleMaxLines: Int = 1

@Composable
fun HomeScreen(lastApartments: ArrayList<Apartment>, cities: ArrayList<City>, onApartmentClick: () -> Unit = {}) {
    Column(modifier = Modifier.verticalScroll(ScrollState(ScrollStateInitial))) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Black2)
        ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(LogoImageHeight)
                        .padding(Dimens.PaddingNormal)
                )
            Row(verticalAlignment = CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.PaddingNormal)
                .background(color = Color.White, shape = RoundedCornerShape(Dimens.RoundingSmall))) {
                    Text(text = stringResource(id = R.string.search_title),
                        style = MaterialTheme.typography.h6,color = Color.Gray,
                        modifier = Modifier.padding(vertical = Dimens.PaddingMediumSmall, horizontal = Dimens.PaddingNormal))
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(painter = painterResource(id = android.R.drawable.ic_menu_search), contentDescription = null,
                        modifier = Modifier.padding(horizontal = Dimens.PaddingMediumSmall))
            }
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
        }
        Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
        LastApartments(lastApartments, onApartmentClick)
        Spacer(modifier = Modifier.height(Dimens.PaddingLarge))
        Cashback()
        Spacer(modifier = Modifier.height(Dimens.PaddingLarge))
        Cities(cities)
        Spacer(modifier = Modifier.height(Dimens.PaddingLarge))
        Reviews()
    }
}

@Composable
fun Cashback() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.PaddingNormal)
            .background(color = Black2, shape = RoundedCornerShape(Dimens.RoundingNormal))
    ) {
        Column(modifier = Modifier.padding(Dimens.PaddingNormal)) {
            Text(
                text = stringResource(id = R.string.cashback_title),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
            Text(
                text = stringResource(id = R.string.cashback_subtitle),
                style = MaterialTheme.typography.subtitle1,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
            Text(
                text = stringResource(id = R.string.cashback_description),
                style = MaterialTheme.typography.subtitle1,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun Cities(cities: ArrayList<City>) {
    Row {
        Spacer(modifier = Modifier.width(Dimens.PaddingNormal))
        Column {
            Text(text = stringResource(id = R.string.popular_destinations),
                style = MaterialTheme.typography.h6,fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
            Text(text = stringResource(id = R.string.frequently_selected),
                style = MaterialTheme.typography.subtitle1, color = Color.Gray, maxLines = SubtitleMaxLines)
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
            LazyRow {
                items(cities.size) {
                    City(cities[it])
                    Spacer(modifier = Modifier.width(Dimens.PaddingNormal))
                }
            }
        }
    }
}

@Composable
fun City(city: City) {
    Column {
        Image(
            painter = painterResource(id = city.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(CityImageWidth)
                .height(CityImageHeight)
                .clip(RoundedCornerShape(Dimens.RoundingNormal))
        )
        Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
        Text(text = city.name, style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
        Text(text = pluralStringResource(id = R.plurals.variants, count = city.count, city.count),
            style = MaterialTheme.typography.subtitle1, color = Color.Gray)
    }
}

@Composable
fun Reviews() {
    Row {
        Spacer(modifier = Modifier.width(Dimens.PaddingNormal))
        Column {
            Text(text = stringResource(id = R.string.last_reviews),
                style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
        }
    }
}

@Composable
fun LastApartments(apartments: ArrayList<Apartment>, onApartmentClick: () -> Unit) {
    Row {
        Spacer(modifier = Modifier.width(Dimens.PaddingNormal))
        Column {
            Text(text = stringResource(id = R.string.you_watched),
                style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
            LazyRow {
                items(apartments.size) {
                    LastApartment(apartment = apartments[it], onApartmentClick = onApartmentClick)
                    Spacer(modifier = Modifier.width(Dimens.PaddingNormal))
                }
            }
        }
    }
}

@Composable
fun LastApartment(apartment: Apartment, onApartmentClick: () -> Unit) {
    Column(modifier = Modifier.clickable(onClick = onApartmentClick)) {
        Image(
            painter = painterResource(id = apartment.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(ApartmentImageWidth)
                .height(ApartmentImageHeight)
                .clip(RoundedCornerShape(Dimens.RoundingNormal))
        )
        Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
        Text(text = apartment.address, style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
        Text(text = apartment.cityName, style = MaterialTheme.typography.subtitle1, color = Color.Gray)
        Text(text = stringResource(id = apartment.apartmentType.resId),
            style = MaterialTheme.typography.subtitle1, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TestProject007Theme {
        HomeScreen(TestData.lastApartments, TestData.cities)
    }
}