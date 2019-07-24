package com.klevy.map.dao

import com.klevy.map.dataModels.Country
import org.springframework.data.repository.CrudRepository

interface CountryRepository : CrudRepository<Country, Long> {

    fun findByName(name: String): List<Country>
}