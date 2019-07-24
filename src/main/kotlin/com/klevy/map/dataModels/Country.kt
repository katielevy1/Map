package com.klevy.map.dataModels

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Country(val name: String, val population: Long = 0) {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Long = 0
}