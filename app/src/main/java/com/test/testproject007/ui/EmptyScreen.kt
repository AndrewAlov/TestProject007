package com.test.testproject007.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.test.testproject007.R
import com.test.testproject007.ui.theme.Dimens

@Composable
fun EmptyScreen() {
    Box (modifier = Modifier.fillMaxSize().padding(Dimens.PaddingLarge), contentAlignment = Alignment.Center) {
        Text(text = stringResource(id = R.string.empty_screen_description),
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewEmptyScreen() {
    PreviewEmptyScreen()
}