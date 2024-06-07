package com.ppooii.trabajot1.APIs.GoogleMaps;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppooii.trabajot1.Component.ScheduledTasks;

public class Geocoder {
	private static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	private static final String GEOCODING_RESOURCE ="https://maps.googleapis.com/maps/api/place/findplacefromtext/json?fields=all&inputtype=textquery&key=";
	
	private static final String API_KEY ="APY_KEY";
	
	public Geocoder() {
		
	}
	
	public String GeocodeSync (String query) throws IOException, InterruptedException{
		HttpClient httpclient = HttpClient.newHttpClient();
		
		String encodedQuery = URLEncoder.encode(query, "UTF-8");
		String requestUri = GEOCODING_RESOURCE+API_KEY+"&input="+encodedQuery;
		
		HttpRequest geocodingRequest = HttpRequest.newBuilder().GET().uri(URI.create(requestUri))
				.timeout(Duration.ofMillis(2000)).build();
		
		HttpResponse geocodingResponse = httpclient.send(geocodingRequest,
				HttpResponse.BodyHandlers.ofString());
		
		return (String) geocodingResponse.body();
		
	}
	
	public String getLatLng (String query) throws IOException, InterruptedException{
		ObjectMapper mapper = new ObjectMapper();
		
		String response = this.GeocodeSync(query);
		
		JsonNode responsejsonNode = mapper.readTree(response);
		logger.info("REpuesta de data de google api");
		logger.info(responsejsonNode.asText());
		JsonNode items = responsejsonNode.get("candidates");
		
		String latitud  = items.get(0).get("geometry").get("location").get("lat").asText();
		String longitud = items.get(0).get("geometry").get("location").get("lng").asText();
		
		return latitud + ","+longitud;
		
	}
	
}
