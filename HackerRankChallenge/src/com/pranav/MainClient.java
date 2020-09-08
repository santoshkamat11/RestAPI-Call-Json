package com.pranav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainClient {

	public static void main(String[] args) throws IOException {
		
		String httpsURL = "https://jsonmock.hackerrank.com/api/article_users?page=1";
		
		URL myUrl = new URL(httpsURL);
        HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        String response;
        response = in.readLine();
        
        JSONObject jObject  = new JSONObject(response); // json
        JSONArray array = jObject.getJSONArray("data");
        
        for(int i = 0 ; i < array.length() ; i++) {
        	JSONObject obj  = array.getJSONObject(i);
        	int submission = obj.getInt("submission_count");
        	
        	if(submission > 10) {
        		System.out.println("Author with more than 10 submissions is "+obj.getString("username"));
        	}
        }

	}

}
