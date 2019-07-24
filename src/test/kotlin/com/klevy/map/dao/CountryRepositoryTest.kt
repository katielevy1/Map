package com.klevy.map.dao

import org.assertj.core.api.Assertions.assertThat

import com.klevy.map.dataModels.Country
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class CustomerRepositoryTests {
    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Autowired
    private val countries: CountryRepository? = null

    @Test
    fun testFindByLastName() {
        val country = Country("first", 100000)
        entityManager.persist<Any>(country)

        val findByName = countries?.findByName(country.name)
        assertThat(findByName?.size).isEqualTo(1)
        assertThat(findByName?.get(0)?.name).isEqualTo(country.name)
    }
}