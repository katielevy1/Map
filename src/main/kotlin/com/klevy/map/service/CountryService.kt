package com.klevy.map.service

import com.klevy.map.dao.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryService(@Autowired val countryRepository: CountryRepository) {
    fun findAll() = countryRepository.findAll().toList()
    fun count() = countryRepository.count()
}