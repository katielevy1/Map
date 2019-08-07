package com.klevy.map.component

import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource(value = ["classpath:static/country.json"])
class CountryList {

}
