package com.test.testproject007.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.test.testproject007.R
import com.test.testproject007.data.Apartment
import com.test.testproject007.data.TestData
import com.test.testproject007.ui.theme.Dimens
import com.test.testproject007.ui.theme.Gray2
import com.test.testproject007.ui.theme.Yellow2

val BigApartmentImageHeight: Dp = 200.dp
val MapHeight: Dp = 200.dp
val DividedLineHeight: Dp = 2.dp
val MapZoom: Float = 15f

@Composable
fun ApartmentScreen(apartment: Apartment) {
    Column(modifier = Modifier
        .verticalScroll(ScrollState(ScrollStateInitial))
        .background(color = Gray2)) {
        Column(modifier = Modifier.background(Color.White)) {
            Image(
                painter = painterResource(id = apartment.imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(BigApartmentImageHeight)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
            Column(modifier = Modifier.padding(horizontal = Dimens.PaddingNormal)) {
                Text(text = stringResource(id = apartment.apartmentType.resId),
                    style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
                Text(text = "${apartment.cityName}, ${apartment.address}",
                    style = MaterialTheme.typography.subtitle1, color = Color.Gray)
                Spacer(modifier = Modifier.height(Dimens.PaddingLarge))
                Text(
                    text = stringResource(id = apartment.descriptionRes),
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(Dimens.PaddingLarge))
            }
            Text(
                text = stringResource(id = R.string.popular_apartment), style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .background(color = Yellow2)
                    .padding(Dimens.PaddingNormal)
            )
            Map(apartment.latitude, apartment.longitude)
        }
        Price(apartment.price)
        Spacer(modifier = Modifier.height(Dimens.PaddingLarge))
    }
}

@Composable
fun Price(price: Int) {
    Text(text = stringResource(id = R.string.price_by_day),
        style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(Dimens.PaddingNormal))

    Column(modifier = Modifier
        .background(color = Color.White)
        .padding(Dimens.PaddingNormal)) {
        Text(text = stringResource(id = R.string.price, price), style = MaterialTheme.typography.subtitle1)
        Text(
            text = stringResource(id = R.string.price_by_day_description_test),
            style = MaterialTheme.typography.subtitle1,
            color = Color.Gray
        )
        Spacer(
            modifier = Modifier
                .height(Dimens.PaddingSmall)
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .height(DividedLineHeight)
                .fillMaxWidth()
                .background(color = Gray2)
        )
        Spacer(
            modifier = Modifier
                .height(Dimens.PaddingSmall)
                .fillMaxWidth()
        )
        Text(text = stringResource(id = R.string.all_prices), style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun Map(latitude: Double, longitude: Double) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(latitude, longitude), MapZoom)
    }
    Column(modifier = Modifier
        .height(MapHeight)
        .fillMaxWidth()
        .padding(Dimens.PaddingNormal)) {
        GoogleMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApartmentScreen() {
    ApartmentScreen(TestData.apartment)
}