package api.utilities;
import java.io.File;                                                     
import java.io.IOException;                                              
import java.text.SimpleDateFormat;                                       
import java.util.Date;                                                   
                                                                         
import org.testng.ITestContext;
import org.testng.ITestListener;
//import org.testng.ITestListener;
import org.testng.ITestResult;                                           
//import org.testng.TestListenerAdapter;                                   
                                                                         
import com.aventstack.extentreports.ExtentReports;                       
import com.aventstack.extentreports.ExtentTest;                          
import com.aventstack.extentreports.Status;                              
import com.aventstack.extentreports.markuputils.ExtentColor;             
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;         
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;        
                                                                         
public class ExtentReportManager implements ITestListener {
  public ExtentSparkReporter sparkReporter;                                                                                                                      
  	public ExtentReports extent;                                                                                                                                
  	public ExtentTest test;                                                                                                                                   
  	                                                                                                                                                            
  		                                                                                                                                                           
  	public void onStart(ITestContext testContext)                                                                                                               
  	{                                                                                                                                                           
  		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp                                                             
  		String repName="Test-Report-"+timeStamp+".html";                                                                                                           
  		                                                                                                                                                           
  		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report                              
  		                                                                         
  		                                                                                                                                                           
  		sparkReporter.config().setDocumentTitle("PetRestAssuredProject"); // Tile of report    
  		sparkReporter.config().setReportName("pet store users API"); // name of the report     
  		                                                                                       
  		sparkReporter.config().setTheme(Theme.DARK);                                           
  		
  		extent=new ExtentReports();                                                                                                                                
  		 extent.attachReporter();                                                                                                                                                         extent.attachReporter(sparkReporter);                                                                                                                       
  		extent.setSystemInfo("Host name","localhost");                                                                                                             
  		extent.setSystemInfo("Application","pet store users api"); 
  		 extent.setSystemInfo("Operating System",System.getProperty("os.name")); 
  		 extent.setSystemInfo("User Name",System.getProperty("user.name"));  
  		extent.setSystemInfo("Environemnt","QA");                                                                                                                  
  		extent.setSystemInfo("user","pavan");                                                                                                                      
  		                                                                                                                                                           
 }                                                                                                                                                           
  	                                                                                                                                                            
  	public void onTestSuccess(ITestResult result)                                                                                                                   
  	{                                                                                                                                                           
  		test=extent.createTest(result.getName()); // create new entry in th report                                                                                   
  		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
  	     test.createNode(result.getName());                          
  	     test.assignCategory(result.getMethod().getGroups());        
  	     test.log(Status.PASS, "Test Failed");                       
  	     //test.log(Status.PASS, result.getThrowable().getMessage());
  	                                                                 
  	
}                                                                                                                                                           
  	                                                                                                                                                            
  	public void onTestFailure(ITestResult result)                                                                                                                   
  	{                                                                                                                                                           
  		test=extent.createTest(result.getName()); // create new entry in th report                                                                                   
  		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted  
  		test.createNode(result.getName());                                                                                                                                                           
  		test.assignCategory(result.getMethod().getGroups());
  		test.log(Status.FAIL, "Test Failed");
  		//test.log(Status.FAIL, result.getThrowable().getMessage());
  	}
  		
                                                                                                                                                            
  	                                                                                                                                                            
  	public void onTestSkipped(ITestResult result)                                                                                                                   
  	{                                                                                                                                                           
  		test=extent.createTest(result.getName()); // create new entry in th report                                                                                   
  		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));                                                                         
  	    test.createNode(result.getName());                          
  	    test.assignCategory(result.getMethod().getGroups());        
  	    test.log(Status.SKIP, "Test skipped");                       
  	    //test.log(Status.SKIP, result.getThrowable().getMessage());
  	                                                                
  	
  	
  	}                                                                                                                                                           
  	                                                                                                                                                            
  	public void onFinish(ITestContext testContext)                                                                                                              
  	{                                                                                                                                                           
  		extent.flush();                                                                                                                                            
  	}                                                                                                                                                           
  }                                                                                                                                                            