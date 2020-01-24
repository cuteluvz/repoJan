package com.pratheeka.weatherReporter.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pratheeka.weatherReporter.dto.StationWeatherDetails;
import com.pratheeka.weatherReporter.utils.WeatherReportCSVParser;

@Service
public class WeatherReporterService 
{
	
	public Map<String, StationWeatherDetails> getWeatherReport()
	{
		final List<StationWeatherDetails> details = WeatherReportCSVParser.getAllStationsWeatherDetails();
		
		final Map<String, StationWeatherDetails> weatherReport = details.stream().collect(
	                Collectors.toMap(StationWeatherDetails::getStationName, d->d));

		return weatherReport;
	}
}
