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

        countryRepository.save(Country("United States", 331883986, "Democracy", "$$", 20544000000))
        countryRepository.save(Country("Spain", 49331076))
        countryRepository.save(Country("Mexico", 135295893))
        countryRepository.save(Country("Canada", 35151728))

    }


}