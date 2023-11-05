package com.example.helloshopper.data.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val brand: String? = null,
    val category: String? = null,
    val discountPercentage: Double? = null,
    val images: List<String>? = null,
    val rating: Double? = null,
    val stock: Int? = null,
    val thumbnail: String? = null
)