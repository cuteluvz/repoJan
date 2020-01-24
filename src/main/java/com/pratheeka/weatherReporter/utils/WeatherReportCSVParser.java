package com.pratheeka.weatherReporter.utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pratheeka.weatherReporter.dto.StationWeatherDetails;

/**
 * Parser for the given weather report in .csv format
 * @author pratheeka.seethalam
 *
 */
public class WeatherReportCSVParser
{
	private static final Logger logger = LoggerFactory.getLogger(WeatherReportCSVParser.class);

	private static final String SAMPLE_CSV_FILE_PATH = "./dummy-climate-summary.csv";

	private static final List<StationWeatherDetails> allStationsWeatherDetails = new LinkedList<StationWeatherDetails>();

	/**
	 * Get the weather details of all stations.
	 * @return a list of {@link StationWeatherDetails}
	 */
	public static List<StationWeatherDetails> getAllStationsWeatherDetails() 
	{
		return (allStationsWeatherDetails.size() > 0) ? allStationsWeatherDetails : parseWeatherReport();
	}

	/**
	 * Creates a list of {@link StationWeatherDetails} by parsing the .csv file provided.
	 * @return a list of {@link StationWeatherDetails}
	 */
	private static List<StationWeatherDetails> parseWeatherReport() 
	{
		try 
		(
				Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT
								.withHeader("Station_Name", "Province", "Date", "Mean_Temp",
										"Highest_Monthly_Maxi_Temp", "Lowest_Monthly_Min_Temp")
								.withIgnoreHeaderCase()
								.withSkipHeaderRecord()
								.withTrim());
		) 
		{
			final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			for (CSVRecord csvRecord : csvParser) 
			{
				final String stationName = csvRecord.get("Station_Name");
				final String province = csvRecord.get("Province");
				final String date = csvRecord.get("Date");
				final Date reportDate = df.parse(date);
				final String meanTemp = csvRecord.get("Mean_Temp");
				final String highestMonthlyTemp = csvRecord.get("Highest_Monthly_Maxi_Temp");
				final String lowestMonthlyTemp = csvRecord.get("Lowest_Monthly_Min_Temp");

				allStationsWeatherDetails.add(new StationWeatherDetails(stationName, province, reportDate, meanTemp,
						highestMonthlyTemp, lowestMonthlyTemp));
			}
			csvParser.close();
		} 
		catch (IOException | ParseException e)
		{
			logger.error("An exception occurred while parsing the .csv file", e);
		}
		return allStationsWeatherDetails;
	}
}