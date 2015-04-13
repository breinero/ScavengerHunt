package com.mongodb.tour.circuitbreaker;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class ConcurrentRequests implements Threshold {

	private final Integer max;
	
	public ConcurrentRequests( Integer max ) {
		this.max = max;
	}
	
	@Override
	public boolean isExceeded(DescriptiveStatistics stats) {
		return ( (stats.getN() * stats.getMean()) >= max );
	}

}