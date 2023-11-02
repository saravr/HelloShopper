package com.example.helloshopper.repository

import com.example.helloshopper.data.model.Product
import com.example.helloshopper.data.model.ProductsResponse
import retrofit2.http.GET

interface ProductService {
    @GET("/products?limit=20")
    suspend fun getProducts(): ProductsResponse

    @GET("/product/{id}")
    suspend fun getProduct(id: Int): Product
}