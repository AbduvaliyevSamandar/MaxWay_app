package com.example.maxwayapp.domain.product

data class Brand(
    val description: DescriptionXX,
    val id: String,
    val image: String,
    val is_active: Boolean,
    val order_no: String,
    val parent_id: String,
    val slug: String,
    val title: TitleXX
)