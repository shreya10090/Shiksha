package StepDefinition;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DriverSetup.SetupDriver;
import Page.ReviewPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;


public class WriteReview {
	static WebDriver driver;
	ReviewPage rp;
	
	@Given("user is logged in on Shiksha application")
	public void user_is_logged_in_on_shiksha_application() throws InterruptedException, AWTException {
		driver = SetupDriver.chromedriver();
		   rp = new ReviewPage(driver);
		   rp.background();
	}
	@When("user selects top mba colleges")
	public void user_selects_top_mba_colleges() throws InterruptedException {
	  rp.topCollege();
	}
	@When("click on write a review option")
	public void click_on_write_a_review_option() throws InterruptedException {
	   rp.writeReviewOption();
	}
	@When("^user enters (.*), (.*) and (.*)")
	public void user_enters_and(String EmailID, String Name, String mobile) throws InterruptedException, AWTException {
	   rp.form1(EmailID,Name,mobile);
	}

	@When("^selects (.*)")
	public void selects(String college) throws InterruptedException, AWTException {
	   rp.form2(college);
	}

	@Then("Click on next button")
	public void click_on_next_button() {
	    rp.next1();
	    Assert.assertEquals("https://www.shiksha.com/college-review-rating-form", driver.getCurrentUrl());
	}
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) {
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}
//	
//	****************************************************************************************************************************
	
	@When("user sends rating, enters reviews for Placements")
    public void user_sends_rating_enters_reviews_for_Placements(DataTable datatable) throws InterruptedException, AWTException {
        List<String> placementReviews = datatable.asList(String.class);     
        for (String review : placementReviews) {
       rp.placementReview(review);
        }
    }

    @When("user sends rating, enters reviews for Infrastructure")
    public void user_sends_rating_enters_reviews_for_Infrastructure(DataTable dataTable) {
        List<String> infrastructureReviews = dataTable.asList(String.class);     
        for (String review : infrastructureReviews) {
        	 rp.infrastructureReview(review);
        }
    }

    @When("user sends rating, enters reviews for Faculty")
    public void user_sends_rating_enters_reviews_for_Faculty(DataTable dataTable) {
        List<String> facultyReviews = dataTable.asList(String.class);    
        for (String review : facultyReviews) {
        	 rp.facultyReview(review);
        }
    }

    @When("user enters Title of Review")
    public void user_enters_Title_of_Review(DataTable dataTable) {
        List<String> titles = dataTable.asList(String.class);        
        for (String title : titles) {
        	 rp.titles(title);
        }
    }

    @When("user sends rating for value for money and campus")
    public void user_sends_rating_for_value_for_money_and_campus(DataTable dataTable) {    
    	List<String> costs = dataTable.asList(String.class);        
        for (String cost : costs) {
        	 rp.ratingForValue(cost);
        }
    }

    @When("user selects recommendation")
    public void user_selects_recommendation() {
     rp.recommend();
    }

    @Then("Click on second next button")
    public void click_on_second_next_button() {
     rp.next2();
    }
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) {
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}
	

//*************************************************************************************
    @When("^user enters (.*) Profile")
    public void user_enters_linkedin_profile(String profileLink) throws InterruptedException, AWTException {
    	rp.prevForm();
    	rp.clickLinkedIn(profileLink);
    }

    @When("click on third next option")
    public void click_on_third_next_option() {
       rp.next3();
    }
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) {
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}
//    
//*************************************************************************************************************************
    @When("user gives college feedback")
    public void user_gives_college_feedback() throws InterruptedException, AWTException {
       rp.prevForm2();
       
    }

    @Then("form is submitted")
    public void form_is_submitted() throws InterruptedException {
    	rp.nolanguage();
    	rp.submit();
    	Thread.sleep(1000);
		WebElement e1 = driver.findElement(By.xpath("//h2[@class=\"heading\"]"));
		String res = e1.getText();
		Assert.assertEquals("Thank You shreya. We have received your college review.",res);
    }
//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) {
//		   TakesScreenshot ts= (TakesScreenshot) driver;
//		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		   scenerio.attach(src, "image/png",scenerio.getName());
//	}
    
 //**************************************************************************************************************************
    @When("^user gives null feedback (.*)")
    public void user_gives_null_feedback(String feedbck) throws InterruptedException {
        rp.feedback(feedbck);
    }

    @Then("form should not be submitted")
    public void form_should_not_be_submitted() {
    	WebElement e1 = driver.findElement(By.xpath("//strong[@class=\"feedbackHeading\"]"));
		String res = e1.getText();
		Assert.assertEquals("Feedback contains no characters",res);
    }
	@AfterStep
	public static void takeScreendown(Scenario scenerio) {
		   TakesScreenshot ts= (TakesScreenshot) driver;
		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		   scenerio.attach(src, "image/png",scenerio.getName());
	}

}
