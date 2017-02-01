package com.storageservice.person.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.jws.WebService;
import org.json.JSONObject;
import com.storageservice.person.model.Person;


//Service Implementation

@WebService(endpointInterface = "com.storageservice.person.ws.LocalApiPersonModel", serviceName = "storageServicePerson")
public class LocalApiPersonImpl implements LocalApiPersonModel {
	static String localurl = "https://localdbservice.herokuapp.com/localdbservice";


	@Override 
	public Person getPersonInformation(long id) {
		String url = localurl + "/person/" + id;
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			int responseCode = con.getResponseCode();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			Person p = new Person();
			System.out.println(response.toString());
			JSONObject jobj = new JSONObject(response.toString());

			p.setLastname(jobj.getString("lastname"));
			p.setfirstname(jobj.getString("firstname"));
			p.setBirthdate(jobj.getString("birthdate"));
			p.setGenre(jobj.getString("genre"));
			p.setEmail(jobj.getString("email"));
			p.setLevel(jobj.getJSONObject("level").getString("name"));
			p.setNTotalGoal((jobj.getInt("ntotalGoal")));
			p.setNGoalAchieved(jobj.getInt("ngoalAchieved"));
			p.setDescription(jobj.getJSONObject("level").getString("description"));
			p.setLifeStyle(jobj.getJSONObject("lifeStyle").getString("style"));
p.setIdPerson(jobj.getInt("idPerson"));
p.setIdLevel(jobj.getInt("idLevel"));
p.setIdLifeStyle(jobj.getInt("idLifeStyle"));
p.setPassword(jobj.getString("password"));


			return p;
		} catch (Exception e) {

			System.out.println("error in getting person data on local db " + e);

			return null;
		}

	}

	@Override
	public int registration(Person p) {
		try {
			String url = localurl + "/person";

			URL obj = new URL(url);
			HttpURLConnection con;

			con = (HttpURLConnection) obj.openConnection();

			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			// request body

			String str ="{\"lastname\":\""+p.getLastname()+"\",\"firstname\":\""+p.getfirstname()+"\",\"birthdate\":\""+p.getBirthdate()+"\","
					+ "\"email\":\""+p.getEmail()+"\",\"genre\":\""+p.getGenre()+"\",\"password\":\""+p.getPassword()+"\",\"idLifeStyle\":"+p.getIdLifeStyle()+","
							+ "\"idLevel\":1}";
							

			byte[] outputInBytes = str.getBytes("UTF-8");
			OutputStream os = con.getOutputStream();
			os.write(outputInBytes);
			os.close();

			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject jobj = new JSONObject(response.toString());
			int idregistered = jobj.getInt("idPerson");
			return idregistered;

		} catch (Exception e) {
			System.out.println("error during post registration call " + e);
			return 0;

		}

	}

	@Override
	public Person login(String email,String psw) {
		String url = localurl + "/login?email="+email+"&psw="+psw ;
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			int responseCode = con.getResponseCode();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			Person p = new Person();
			System.out.println(response.toString());
			JSONObject jobj = new JSONObject(response.toString());
			p.setIdPerson(jobj.getInt("idPerson"));
			p.setBirthdate(jobj.getString("birthdate"));
			p.setfirstname(jobj.getString("firstname"));
			p.setLastname(jobj.getString("lastname"));
			p.setEmail(jobj.getString("email"));
			p.setGenre(jobj.getString("genre"));
			//p.setHeight(jobj.getDouble("height"));
			//p.setWeight(jobj.getDouble("weight"));
			return p;
		}catch(Exception e){
			return null;
		}
		
	}

	public int updatePerson(Person p){
		try{
		URL obj = new URL(localurl + "/person/"+p.getIdPerson());
		HttpURLConnection con;

		con = (HttpURLConnection) obj.openConnection();

		con.setDoOutput(true);
		con.setRequestMethod("PUT");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Content-Type", "application/json");
		// request body

		String str ="{\"lastname\":\""+p.getLastname()+"\",\"firstname\":\""+p.getfirstname()+"\",\"birthdate\":\""+p.getBirthdate()+"\","
				+ "\"email\":\""+p.getEmail()+"\",\"genre\":\""+p.getGenre()+"\",\"password\":\""+p.getPassword()+"\",\"idLifeStyle\":"+p.getIdLifeStyle()+","
						+ "\"idLevel\":"+p.getIdLevel()+",\"ntotalGoal\":"+p.getNTotalGoal()+",\"ngoalAchieved\":"+p.getNGoalAchieved()+"}";
		
		byte[] outputInBytes = str.getBytes("UTF-8");
		OutputStream os = con.getOutputStream();
		os.write(outputInBytes);
		os.close();

		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JSONObject jobj = new JSONObject(response.toString());
		int idPerson= jobj.getInt("idPerson");
System.out.println("blalalalalallalallalalalalal "+idPerson);
		return idPerson;

	} catch (Exception e) {
		System.out.println("error during post registration call " + e);
		return 0;

	}
	
		
		
	}
	

		
	}

