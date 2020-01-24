package com.pratheeka.weatherReporter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pratheeka.weatherReporter.dto.StationWeatherDetails;
import com.pratheeka.weatherReporter.utils.WeatherReportCSVParser;

@Service
public class WeatherReporterService 
{
	
	public Map<String, StationWeatherDetails> getWeatherReport()
	{
		final List<StationWeatherDetails> details = WeatherReportCSVParser.getAllStationsWeatherDetails();
		final Map<String, StationWeatherDetails> weatherReport = new HashMap<String, StationWeatherDetails>();
		for(StationWeatherDetails detail: details)
		{
			weatherReport.put(detail.getStationName(), detail);
		}
		return weatherReport;
	}
}
