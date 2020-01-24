/**
 * 
 */
package com.pratheeka.weatherReporter.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pratheeka.weatherReporter.dto.StationWeatherDetails;
import com.pratheeka.weatherReporter.service.WeatherReporterService;

@Controller
public class WeatherReportController 
{
	private WeatherReporterService weatherReporterService;
	private Map<String, StationWeatherDetails> weatherReport = new HashMap<>();

    @Autowired
    public void setWeatherReporterService(WeatherReporterService weatherReporterservice, WeatherReporterService weatherReporterService) 
    {
        this.weatherReporterService = weatherReporterService;
    }
    
    @GetMapping("/")
    public String weatherReport(Model model) throws ParseException 
    {
    	weatherReport = (weatherReport.size() > 0) ? weatherReport :this.weatherReporterService.getWeatherReport();
        model.addAttribute("weatherReport", weatherReport);

        return "weatherReport";
    }
    
	@GetMapping("weatherReport/details")
	public String stationWeatherDetails(@RequestParam(required = false) String stationName, Model model) 
	{
		final StationWeatherDetails details = weatherReport.get(stationName);
		model.addAttribute("stationWeatherDetails", details);
		
		return "stationWeatherDetails";
	}
}