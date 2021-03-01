package br.com.gama.contacorrente.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintUtil {

	public static void toJson(Object obj) {
		
		var mapper = new ObjectMapper();
		
		try {
			
			var json = mapper.writeValueAsString(obj);
			
			System.out.print(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
