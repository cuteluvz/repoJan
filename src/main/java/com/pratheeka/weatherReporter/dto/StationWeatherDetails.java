package com.pratheeka.weatherReporter.dto;

import java.util.Date;

import org.springframework.util.StringUtils;

public class StationWeatherDetails 
{
	private String stationName;
	private String province;
	private Date reportDate;
	private String meanTemp;
	private String highestMonthlyTemp;
	private String lowestMonthlyTemp;
	
	public StationWeatherDetails(String stationName, String province, Date reportDate, String meanTemp,
			String highestMonthlyTemp, String lowestMonthlyTemp) 
	{
		super();
		this.stationName = stationName;
		this.province = province;
		this.reportDate = reportDate;
		this.meanTemp = StringUtils.isEmpty(meanTemp) ? "Unavailable" : meanTemp;
		this.highestMonthlyTemp = StringUtils.isEmpty(highestMonthlyTemp) ? "Unavailable" : meanTemp;
		this.lowestMonthlyTemp = StringUtils.isEmpty(lowestMonthlyTemp) ? "Unavailable" : meanTemp;
	}
	
	
	public String getStationName() 
	{
		return stationName;
	}

	public String getProvince() 
	{
		return province;
	}

	public Date getReportDate() 
	{
		return reportDate;
	}

	public String getMeanTemp() 
	{
		return meanTemp;
	}

	public String getHighestMonthlyTemp() 
	{
		return highestMonthlyTemp;
	}

	public String getLowestMonthlyTemp() 
	{
		return lowestMonthlyTemp;
	}

	@Override
	public String toString() 
	{
		return "StationWeatherDetails [stationName=" + stationName + ", province=" + province + ", reportDate="
				+ reportDate + ", meanTemp=" + meanTemp + ", highestMonthlyTemp=" + highestMonthlyTemp
				+ ", lowestMonthlyTemp=" + lowestMonthlyTemp + "]";
	}
}
