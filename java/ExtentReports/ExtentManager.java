package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentManager {

    private static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;


    public synchronized static ExtentReports getReporter() {
        if (report == null) {
            String df = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/testReport"+df+".html");

            report= new ExtentReports();
            report.attachReporter(htmlReporter);
            htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setDocumentTitle("Extent Report Demo");
            htmlReporter.config().setReportName("Prueba Nombre Reporte");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        }
        return report;
    }



}
