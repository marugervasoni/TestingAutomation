package Reportes;

import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("Selenium Version", "5.0.9");
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Navegador", "Chrome");
        extent.setSystemInfo("Ambiente", "QA");
        return extent;
    }
}
