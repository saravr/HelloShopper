package com.example.helloshopper

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloshopper.data.model.Product
import com.example.helloshopper.viewmodel.ProductViewModel

@Composable
fun ProductListScreen
            (productViewModel: ProductViewModel) {
    val context = LocalContext.current

    val products by productViewModel.products.collectAsState(listOf())

    LaunchedEffect(Unit) {
        productViewModel.getProducts()
    }

    ShowProducts(products = products) {
        Toast.makeText(context, "Clicked product id $it", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun ShowProducts(products: List<Product>, clickHandler: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(products) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable(onClick = {
                        clickHandler(it.id)
                    }),
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        it.title,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                    Text(it.description, style = MaterialTheme.typography.bodyMedium)
                }
            }
            Divider()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowProductsPreview() {
    val products = List(10) {
        Product(
            id = it,
            title = "Product #$it",
            brand = "Brand #$it",
            description = "Description #$it",
            price = it * 10
        )
    }
    ShowProducts(products = products) {}
}