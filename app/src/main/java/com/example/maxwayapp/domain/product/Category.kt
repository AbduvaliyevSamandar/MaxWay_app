package com.example.maxwayapp.domain.product

data class Category(
    val active: Boolean,
    val child_categories: Any,
    val description: DescriptionXX,
    val id: String,
    val image: String,
    val order_no: String,
    val parent_id: String,
    val products: Any,
    val slug: String,
    val title: TitleXX
)