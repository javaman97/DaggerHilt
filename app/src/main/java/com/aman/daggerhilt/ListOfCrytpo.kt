package com.aman.daggerhilt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.util.DebugLogger
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ListOfCrytpo(innerPadding: PaddingValues, cryptoList: List<CryptoCurrency>?) {
    LazyColumn(contentPadding = innerPadding) {
        items(cryptoList ?: emptyList()) { crypto ->
            EachCrypto(crypto)
        }
    }
}


@Composable
fun EachCrypto(crypto: CryptoCurrency) {
    Row(modifier = Modifier
        .background(Color.Gray)
        .fillMaxWidth()
        .padding(5.dp)) {

        val imageLoader = ImageLoader.Builder(LocalContext.current)
            .logger(DebugLogger())  // Log network request details for debugging
            .build()

        AsyncImage(
            model = crypto.image,
            contentDescription = crypto.name,
            imageLoader = imageLoader,
            modifier = Modifier.padding(8.dp),
            placeholder = painterResource(id = R.drawable.placeholder_loading),
            error = painterResource(id = R.drawable.crypto_error)
        )

        Text(text = crypto.name, fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Preview
@Composable
fun PreviewEachCrypto() {
    EachCrypto(CryptoCurrency(
        image = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/BTC_Logo.svg/1200px-BTC_Logo.svg.png",
        name = "BitCoin"
    ))
}
