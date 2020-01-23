package com.klevy.map.service

import com.klevy.map.dao.CountryRepository
import com.klevy.map.dataModels.Country
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.GsonJsonParser
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import java.io.FileReader

@Service
class CountryService(@Autowired val countryRepository: CountryRepository) {
    fun findAll() = countryRepository.findAll().toList()
    fun count() = countryRepository.count()
    fun update(country: Country) = countryRepository.save(country)

    fun parseCountryNamesJson(): List<Any> {
        val file = ResourceUtils.getFile("classpath:/static/country.json")
        val countryNamesJson = FileReader(file).toString()
        val countryNamesList = GsonJsonParser().parseMap(countryNamesJson).values
        return  countryNamesList.toList()
    }
}