package com.klevy.map.controller

import com.klevy.map.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class MapController(@Autowired val countryService: CountryService) {
    @GetMapping
    fun greeting(@RequestParam(name="name", required = false, defaultValue = "World") name: String, model: Model): String {
        model.addAttribute("name", name)
        model.addAttribute("countries", countryService.findAll())
        return "map"
    }
}