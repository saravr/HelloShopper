package com.example.helloshopper.repository

import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: ProductService) {
    suspend fun getProducts() = productService.getProducts().products

    suspend fun getProduct(id: Int) = productService.getProduct(id)
}