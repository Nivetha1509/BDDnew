package urbanladder.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentmanager {
	private static ExtentReports report;
	public static ExtentReports generateReport()  {
		ExtentReports report = new ExtentReports();	
		try {
			ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter(".\\report\\extenthtmlreport.html");
			report.attachReporter(htmlReporter);
			return report;}
			catch(Exception c) {
				System.out.println("Extent Report could not be created");
				return report;
			}	
	}	
	public static ExtentReports getInstance() {
		if(report==null)
		{
			generateReport();
		}
		return report;
	}
}
