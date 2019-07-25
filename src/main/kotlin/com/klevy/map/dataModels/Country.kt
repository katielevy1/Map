package com.klevy.map.dataModels

import javax.persistence.*

@Entity
data class Country(@Column(unique=true) val name: String, val population: Long = 0, val government: String = "",
                   val currency: String = "", val gdp: Long = 0, val other: String = "") {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Long = 0
}