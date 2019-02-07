package br.com.tpa.soc_teste.ws;

import javax.xml.ws.Endpoint;

public class ExameServerPublisher {
	
	public static void main(String[] args) {
		
		String URL = "http://localhost:8081/br.com.tpa.soc_teste.ws";
		Endpoint.publish(URL, new ExameServerImpl());
	}

}
