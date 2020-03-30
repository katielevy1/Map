package com.klevy.map

import com.klevy.map.dao.CountryRepository
import com.klevy.map.dataModels.Country
import com.klevy.map.dataModels.FreedomStatus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.io.File
import java.io.FileReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.core.io.ClassPathResource

@Component
class MyRunner(@Autowired private val countryRepository: CountryRepository): CommandLineRunner {
    private final val logger: Logger = LoggerFactory.getLogger(MyRunner::class.java)

    @Transactional
    override fun run(vararg args: String?) {
        logger.info("initializing countries")

//        countryRepository.save(Country("United States", 331883986, "Democracy", "$$", 20544000000))
//        countryRepository.save(Country("Spain", 49331076))
//        countryRepository.save(Country("Mexico", 135295893))
//        countryRepository.save(Country("Canada", 35151728))

        val gson = Gson()
        val resource: File = ClassPathResource("data/countryIndices.json").file
        val fileReader = FileReader(resource).readText()

        val listCountryType = object : TypeToken<List<CountryIndices>>() {}.type
        val countries: List<CountryIndices> = gson.fromJson(fileReader, listCountryType)

        countries.map {
            val freedomStatus = if(it.freedomStatus == "-") FreedomStatus.UNKNOWN else FreedomStatus.valueOf(it.freedomStatus)
            Country(name = it.country, politicalRights = it.politicalRights, civilLiberties = it.civilLiberties,
                    freedomStatus = freedomStatus)
        }.map {
            countryRepository.save(it)
        }
    }


}

data class CountryIndices(val country: String, val politicalRights: String, val civilLiberties: String, val freedomStatus: String)
