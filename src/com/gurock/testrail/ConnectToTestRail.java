package com.gurock.testrail;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestResult;

import admin.sothelabs.testUtils.TestData;

public class ConnectToTestRail {

	public APIClient client;
	public Long runID;
	public int caseID;

	public void closeRun(APIClient client, Long runID) throws MalformedURLException, IOException, APIException {
		Map<String, Serializable> data_close = new HashMap<String, Serializable>();
		data_close.put("suite_id", TestData.SUITE_ID);
		client.sendPost("close_run/" + runID, data_close);
		System.out.println("Successfully closed the Test Run : " + runID);
	}

	public void addNewRun(APIClient client) throws MalformedURLException, IOException, APIException {
		Map<String, Serializable> data_add = new HashMap<String, Serializable>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		data_add.put("suite_id", TestData.SUITE_ID);
		data_add.put("name", "This is a new test automation run - " + sdf.format(timestamp));
		ArrayList<String> list = new ArrayList<String>();
		list.add("1751");
		list.add("1754");
		list.add("1752");
		list.add("1753");
		list.add("1755");
		list.add("1756");
		list.add("1758");
		list.add("1759");
		list.add("1760");
		list.add("1761");
		list.add("1762");
		data_add.put("case_ids", list);
		JSONObject k = (JSONObject) client.sendPost("add_run/" + TestData.PROJECT_ID, data_add);
		System.out.println("New Run created as : " + k.get("id"));
	}

	public int getCaseID(Method m) {
		if (m.getName() == "createNewObject") {
			caseID = 1751;
		} else if (m.getName() == "editObject") {
			caseID = 1754;
		} else if (m.getName() == "createNewConsignment") {
			caseID = 1752;
		} else if (m.getName() == "editConsignment") {
			caseID = 1753;
		} else if (m.getName() == "addObjectsToConsignment") {
			caseID = 1755;
		} else if (m.getName() == "removeObjectsFromConsignment") {
			caseID = 1756;
		} else if (m.getName() == "createAuction") {
			caseID = 1758;
		} else if (m.getName() == "editAuction") {
			caseID = 1759;
		} else if (m.getName() == "publishAuction") {
			caseID = 1762;
		} else if (m.getName() == "addAndRemoveLots") {
			caseID = 1760;
		} else {
			caseID = 1761;
		}
		return caseID;
	}

	public Long getRunID(APIClient client) throws MalformedURLException, IOException, APIException {
		// Map<String, Integer> data = new HashMap<String, Integer>();
		JSONArray j = (JSONArray) client.sendGet("get_runs/" + TestData.PROJECT_ID);
		JSONObject new_run_id = (JSONObject) j.get(0);
		runID = (Long) new_run_id.get("id");
		// System.out.println(runID);
		return runID;
	}

	public static APIClient myClient() {
		APIClient client;
		client = new APIClient(TestData.TESTRAIL_URL);
		client.setUser(TestData.TESTRAIL_USERNAME);
		client.setPassword(TestData.TESTRAIL_PASSWORD);
		return client;
	}

	public static void sendResultsToTestrail(APIClient client, ITestResult result, Long runID, int caseID)
			throws MalformedURLException, IOException, APIException {
		Map<String, Integer> data = new HashMap<String, Integer>();
		int Status = new Integer(result.getStatus());
		/*
		 * System.out.println("Status is :" + Status); System.out.println(
		 * "Case ID is...... : " + caseID); System.out.println(
		 * "Run ID is...... : " + runID); int Status=new Integer(result);
		 */
		if (Status == 2) {
			Status = Status + 3;
		}
		/*
		 * System.out.println("Parameters: "+result.getParameters());
		 * System.out.println("method name: " +
		 * result.getMethod().getMethodName() + " status: " + Status);
		 */
		data.put("status_id", Status);
		// data.put(comment, "Updated the status successfully");
		// System.out.println(data);
		client.sendPost("add_result_for_case/" + runID + "/" + caseID, data);
		// System.out.println(client.sendGet("get_Case/"+caseID));
		System.out.println("Successfully Updated the status in Testrail for " + result.getMethod().getMethodName()
				+ " to " + Status);
	}
}
