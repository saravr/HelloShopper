package com.example.helloshopper.repository

import com.example.helloshopper.data.model.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: ProductService
) {
    suspend fun getProducts(): List<Product> {
        return productService.getProducts().products
    }

    suspend fun getProduct(id: Int): Product {
        return productService.getProduct(id)
    }
}