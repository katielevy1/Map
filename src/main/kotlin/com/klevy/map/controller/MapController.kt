package com.klevy.map.controller

import com.klevy.map.dataModels.Country
import com.klevy.map.service.CountryService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.GsonJsonParser
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@Controller
class MapController(@Autowired val countryService: CountryService) {
    val logger = LoggerFactory.getLogger(MapController::class.java.name)

    @GetMapping
    fun greeting(@RequestParam(name="name", required = false, defaultValue = "Jason") name: String, model: Model): String {
        model.addAttribute("name", name)
        model.addAttribute("countries", countryService.findAll())
        model.addAttribute("countryNameList", countryService.countryDirectory)
        return "map"
    }

    @PostMapping("/update", consumes = ["application/x-www-form-urlencoded;charset=UTF-8"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCountry(@ModelAttribute @Valid country: Country) {
        logger.info("updating country $country")
        countryService.update(country)
    }
}