package com.klevy.map

import com.klevy.map.dao.CountryRepository
import com.klevy.map.dataModels.Country
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class MyRunner(@Autowired private val countryRepository: CountryRepository): CommandLineRunner {
    private final val logger: Logger = LoggerFactory.getLogger(MyRunner::class.java)

    @Transactional
    override fun run(vararg args: String?) {
        logger.info("initializing countries")

        countryRepository.save(Country("US"))
        countryRepository.save(Country("Spain"))
        countryRepository.save(Country("Mexico"))
        countryRepository.save(Country("Canada", 1242343))

    }


}