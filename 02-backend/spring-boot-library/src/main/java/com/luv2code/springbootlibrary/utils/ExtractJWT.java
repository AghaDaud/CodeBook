package com.luv2code.springbootlibrary.utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ExtractJWT {
//this static function can be used in multiple endpoints
	//extraction is going to be what we are passing in that we search for 
	//go to jwt.io on the right side you will se details
	public static String payloadJWTExtraction(String token,String extraction) {
		token.replace("Bearer", "");
		//string of arrays  calling the chunks and spliiting them into by period
		//when we split the first element is going to be the header 
		//second is going to be payload
		//the thrid is going to be signature
		String[] chunks = token.split("\\.");
		//its gonna decode just like JWT.io does
		Base64.Decoder decoder = Base64.getUrlDecoder();
		//only the payload is going to be decoded
		//it starts with 0 so 1 is going to be payload
		String payload = new String(decoder.decode(chunks[1]));
		String[] entries = payload.split(",");
		//we are creating map to get key value pair
		Map<String, String> map = new HashMap<String, String>();
		for (String entry : entries) {
			String[] keyValue = entry.split(":");
			// our sub , just like the sub in our signature tab in JWT.io is going to be in double qouation marks
			//looping through it to get the value sub which is goin to be sub which is email
			//we add that sub as key
			if (keyValue[0].equals(extraction)){
			int remove = 1;
			//removing extra with }
			if (keyValue[1].endsWith("}")) {
				remove = 2;
				
			}
			keyValue[1] = keyValue[1].substring(0,keyValue[1].length() - remove);
			keyValue[1] = keyValue[1].substring(1);
			map.put(keyValue[0], keyValue[1]);
 		}
	}
		if (map.containsKey(extraction)) {
			return map.get(extraction);
			
		}
		return null;
}
}