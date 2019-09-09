package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;


public class ConsumingJsonDateFromURLAndStoringinDB {

	private static final String NULL = null;

	public static void POSTRequest()
			throws IOException, ClassNotFoundException, SQLException, JSONException, ParseException {
		/*
		 * final String POST_PARAMS = "{\n" + "\"q\"= 3\r\n" + "\n}";
		 * System.out.println(POST_PARAMS);
		 */

		URL obj = new URL("https://iwfm-etl.azurewebsites.net/report/WMA/PPMCSubStatus/Test?q=3 ");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		String name = "ppmcsubstatus";
		String password = "P@Qy4S3xCZR5X*k6";

		String authString = name + ":" + password;
		// System.out.println("auth string: " + authString);
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		// System.out.println("Base64 encoded auth string: " + authStringEnc);
		postConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
		postConnection.setRequestProperty("Content-Type", "application/json");

		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		// os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		int responseCode = postConnection.getResponseCode();
		// System.out.println("POST Response Code : " + responseCode);
		// System.out.println("POST Response Message : " +
		// postConnection.getResponseMessage());
		// System.out.println(HttpURLConnection.HTTP_OK);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			System.out.println();
			in.close();
			// print result
			// System.out.println(response.toString());

			JSONObject myresponse = new JSONObject(response.toString());
			
		
			// System.out.println(myresponse);

			JSONArray fields = myresponse.getJSONArray("Fields");

			Object id = fields.get(0);
			// System.out.println(id);

			Object status = fields.get(1);
			// System.out.println(status);

			Object position = fields.get(2);
			// System.out.println(position);

			Object modified = fields.get(3);
			// System.out.println(modified);
			
			/*
			 * ObjectMapper mapper = new ObjectMapper(); mapper.
			 */

			JSONArray values = myresponse.getJSONArray("Values");
			

			// System.out.println(values);

			// int jsonLenght = values.length();

			Fields field = new Fields();

		//	for (int i = 0; i < values.length(); i++) {
			JSONArray value0 = values.getJSONArray(0);
			
			Object object = value0.get(2);
			
			if (object == null || object == JSONObject.NULL) {
				object = null;
			
			System.out.println("Object  :  "+object);
			
			 
			
			// ------
			

			field.setID(value0.get(0));
			field.setStatus(value0.get(1));
			field.setPosition(value0.get(2));
			field.setModified(value0.get(3));

			System.out.println(field.getID());
			System.out.println(field.getStatus());
			System.out.println(field.getPosition());
			System.out.println(field.getModified());

			// System.out.println("Values in " + i + " Array : " + value0);
			/*
			 * System.out.println("Id : " + value0.get(0)); System.out.println("Status : " +
			 * value0.get(1)); System.out.println("Position : " + value0.get(2));
			 * System.out.println("Modified : " + value0.get(3));
			 */

			System.out.println("JDBC....");

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kamesh", "root", "root");
			String query = " insert into WMAPAPI (ID, Status, Position, Modified)" + " values (?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setLong(1, field.getID());
			preparedStmt.setString(2, field.getStatus());
			preparedStmt.setInt(3, field.getPosition());
			preparedStmt.setString(4, field.getModified());

			preparedStmt.execute();

			System.out.println("STORED....");

		//	 }

		} 
			else {
			System.out.println("POST NOT WORKED");
		}
		}
	}

	private static void If(boolean equals) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, SQLException, JSONException, ParseException {
		ConsumingJsonDateFromURLAndStoringinDB.POSTRequest();
	}

}
