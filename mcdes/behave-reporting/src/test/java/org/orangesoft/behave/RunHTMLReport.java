package org.orangesoft.behave;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RunHTMLReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File reportOutputDirectory = new File("Path of Html report which needs to be generated");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("path of created json file(Json Report)");

		String jenkinsBasePath = "";
		String buildNumber = "1";
		String projectName = "behave";
		boolean skippedFails = true;
		boolean pendingFails = false;
		boolean undefinedFails = true;
		boolean missingFails = true;
		boolean runWithJenkins = false;
		boolean parallelTesting = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optionally only if you need
		configuration.setStatusFlags(skippedFails, pendingFails, undefinedFails, missingFails);
		configuration.setParallelTesting(parallelTesting);
		configuration.setJenkinsBasePath(jenkinsBasePath);
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	}

}
