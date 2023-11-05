package com.example.helloshopper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloshopper.data.model.Product
import com.example.helloshopper.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository): ViewModel() {
    private var _products = MutableSharedFlow<List<Product>>()
    val products = _products.asSharedFlow()

    suspend fun getProducts() {
        viewModelScope.launch {
            val products = productRepository.getProducts()
            _products.emit(products)
        }
    }

    suspend fun getProduct(id: Int) = productRepository.getProduct(id)
}