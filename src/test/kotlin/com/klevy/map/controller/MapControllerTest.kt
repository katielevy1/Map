package com.klevy.map.controller

import com.klevy.map.service.CountryService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class MapControllerTest {

    @Autowired lateinit var countryService: CountryService

    @Test
    fun parseCountryNames() {
        val parseCountryNamesJson = countryService.parseCountryNamesJson()
        Assert.assertEquals(null, parseCountryNamesJson)
    }
}