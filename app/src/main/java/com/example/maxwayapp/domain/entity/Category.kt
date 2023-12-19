package com.example.maxwayapp.domain.entity

data class Category(
    val active: Boolean,
    val child_categories: Any,
    val description: Description,
    val id: String,
    val image: String,
    val order_no: String,
    val parent_id: String,
    val products: List<ProductX>,
    val slug: String,
    val title: TitleX
)