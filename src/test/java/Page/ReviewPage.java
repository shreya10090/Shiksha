package Page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage {
	WebDriver driver;
	@FindBy(xpath = "//a[text()=\"Login\"]")
	WebElement login;
	@FindBy(xpath = "//input[@placeholder=\"Email address\"]")
	WebElement email;
	@FindBy(xpath = "//input[@class=\"input password\"]")
	WebElement password;
	@FindBy(xpath = "//button[text()=\"Login\"]")
	WebElement submit;
	@FindBy(xpath = "//a[contains(@lang,'en')]")
	WebElement elementToHover;
	@FindBy(xpath = "//a[@el='MBA' and @ea='Top Ranked Colleges' and @relative='true' and contains(@href, '/mba/ranking/top-private-mba-colleges-in-india/125')]")
	WebElement topColleges;
	@FindBy(xpath = "//a[@ title=\"XLRI Xavier School of Management\"]")
	WebElement xavier;
	@FindBy(xpath = "//a[@title=\"XLRI Jamshedpur Reviews\"]")
	WebElement review;
	@FindBy(xpath = "//span[@class=\"minimize-me\"]")
	WebElement cross;
	@FindBy(xpath = "//a[@ea=\"Review\"]")
	WebElement writeReview;
	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement Email;
	@FindBy(xpath = "//input[@name=\"firstname\"]")
	WebElement FullName;
	@FindBy(xpath = "//input[@name=\"mobile\"]")
	WebElement Mobile;
	@FindBy(xpath = "//select[@name=\"gender\"]")
	WebElement selectGender;
	@FindBy(xpath = "//select[@name=\"yearOfGraduation\"]")
	WebElement selectYear;
	@FindBy(xpath = "//input[@placeholder=\"Select Your College\"]")
	WebElement CollegeName;
	@FindBy(xpath = "//li[contains(text(), 'XLRI Jamshedpur: Fees, Courses, Admission 2024, Placements, Ranking')]")
	WebElement CollegeNameF;
	@FindBy(xpath = "//select[@name=\"location\"]")
	WebElement selectLocation;
	@FindBy(xpath = "//div[@class=\"selectInput courseDrpdwn css-b62m3t-container\"]")
	WebElement selectCourse;
	@FindBy(id = "react-select-2-placeholder")
	WebElement courseName;
	@FindBy(id = "nxtBtn")
	WebElement Next1;
	@FindBy(xpath = "(//i[text()=\"5\"])[1]")
	WebElement ratePlacement;
	@FindBy(xpath="(//textarea[@class=\"inputTextarea\"])[1]")
	WebElement reviewPlacement;
	@FindBy(xpath = "(//i[text()=\"5\"])[2]")
	WebElement rateInfra;
	@FindBy(xpath="(//textarea[@class=\"inputTextarea\"])[2]")
	WebElement reviewInfra;
	@FindBy(xpath = "(//i[text()=\"5\"])[3]")
	WebElement rateFac;
	@FindBy(xpath="(//textarea[@class=\"inputTextarea\"])[3]")
	WebElement reviewFac;
	@FindBy(xpath="(//i[text()=\"5\"])[4]")
	WebElement valueForMoney;
	@FindBy(xpath="(//i[text()=\"5\"])[5]")
	WebElement campusLife;
	@FindBy(xpath="//input[@placeholder=\"e.g. 1500000\"]")
	WebElement cost1;
	@FindBy(xpath="//label [@for=\"rcmndedYes\"]")
	WebElement recommend;
	@FindBy(xpath="(//textarea[@class=\"inputTextarea\"])[5]")
	WebElement title1;
	@FindBy(xpath="//input[@class=\"button button--orange\"]")
	WebElement Next2;
	@FindBy(xpath="//input[@name=\"socialProfileURL\"]")
	WebElement linkedIN;
	@FindBy(xpath="//input[@class=\"button button--orange\"]")
	WebElement Next3;
	@FindBy(xpath="/html/body/div[3]/main/div/div/div[3]/div/div[1]/ul/li[1]/ul/li[1]/div/label")
	WebElement noLang;
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement submitButton;
	//@FindBy(xpath="(//div[@class=\"feedBackWidget\"]/div[@class=\"feedbackQuestionBox\"]/div)[2]/div[@class=\"ansBox\"]/span[2]")
	@FindBy(xpath="//span[@class=\"whiteCrcl like iflxBox\"]")
	WebElement like;
	@FindBy(xpath="//textarea[@placeholder=\"Write anything else you’d want us to know\"]")
	WebElement feedback;
	@FindBy(xpath="//button[@class=\"fdbkSendBtn\"]")
	WebElement sendFeedback;
	
	@FindBy(xpath="//h2[@class=\"heading\"]")
	WebElement submitted;

	String email1 = "sda4dt8ey7y@gmail.com";
	String name1 = "shreya";
	String num1 = "8939999849";
	String clg1 = "XLRI Jamshedpur";
	String review1 = " Outstanding placement opportunities! The college provides excellent career guidance and connects students with top-tier companies.The college provides excellent career guidance and connects students with top-tier companies. A springboard for success!";
	String review2 = "The college boasts impressive infrastructure with modern facilities. From state-of-the-art classrooms to well-equipped labs and recreational spaces, From state-of-the-art classrooms to well-equipped labs and recreational spaces, it offers a conducive environment for learning and growth.";
	String review3 = " The faculty at this college are highly knowledgeable and dedicated. They go above and beyond to ensure students grasp concepts thoroughly.. They go above and beyond to ensure students grasp concepts thoroughly. Their expertise and support foster an enriching learning experience.";
	String money ="150000";
	String title = "Exemplary Faculty: Nurturing Excellence ";
	String linkedIn = "https://www.linkedin.com/?trk=guest_homepage-basic_nav-header-logo";
	
	

	public void ExplicitWait(WebElement webElement,int time){

			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

				wait.until(ExpectedConditions.elementToBeClickable(webElement));

		 }
	

	public ReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// login method in background
	public void background() throws InterruptedException, AWTException {
		ExplicitWait(login,3);
		login.click();
		Thread.sleep(2000);
		email.sendKeys("shreya.soni1009@gmail.com");
		Robot robot = new Robot();
		int xCoordinate = 500;
		int yCoordinate = 500;
		robot.mouseMove(xCoordinate, yCoordinate);
		Thread.sleep(2000);
		password.sendKeys("abc123");
		Thread.sleep(1000);
		submit.click();
		Thread.sleep(1000);

	}

	// when user selects top MBA colleges option
	public void topCollege() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(1000);
		topColleges.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", xavier);
		Thread.sleep(2000);
		xavier.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", review);
		Thread.sleep(2000);
		review.click();
	}

	// When user clicks on write a review option
	public void writeReviewOption() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(1000);

		js.executeScript("arguments[0].scrollIntoView(true);", writeReview);
		Thread.sleep(2000);

		writeReview.click();
	}

	// When user enters email , name and contact number
	public void form1(String EmailID, String Name, String mobile) throws InterruptedException, AWTException {
		Thread.sleep(2000);
		String mainWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(mainWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", Email);
		Thread.sleep(1000);
		Email.sendKeys(EmailID);
		FullName.sendKeys(Name);
		Mobile.sendKeys(mobile);
	}

	// When user selects gender, year, courses and Location
	
	public void form2(String college) throws InterruptedException, AWTException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", selectGender);

		Select select = new Select(selectGender);
		select.selectByValue("female");

		Select selectyear = new Select(selectYear);
		selectyear.selectByValue("2023");

		CollegeName.sendKeys(college);
		Thread.sleep(1000);
		CollegeNameF.click();

		Thread.sleep(1000);

		Select selectlocation = new Select(selectLocation);
		selectlocation.selectByValue("89818");

		selectCourse.click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

//When User click on next button , then scenario 1 is passed..
	public void next1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Next1);
		Next1.click();
	}

//*************************************************************************************************************************//

//when user rates and reviews placement
	public void placementReview(String review) throws InterruptedException, AWTException {
		topCollege();
		writeReviewOption();
		form1(email1, name1, num1);
		form2(clg1);
		next1();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(1000);

		js.executeScript("arguments[0].scrollIntoView(true);", ratePlacement);
		Thread.sleep(2000);

		ratePlacement.click();
		Thread.sleep(2000);

		reviewPlacement.sendKeys(review);
		Thread.sleep(2000);


	}

	public void infrastructureReview(String review2) {
		rateInfra.click();

		reviewInfra.sendKeys(review2);
		
	}

	public void facultyReview(String review2) {
		rateFac.click();
		reviewFac.sendKeys(review2);
	}

	

	public void ratingForValue(String cost) {
		valueForMoney.click();
		campusLife.click();
		cost1.sendKeys(cost);
		
	}
	
	public void titles(String title) {
		title1.sendKeys(title);
	}

	public void recommend() {
		recommend.click();
		
	}

	public void next2() {
	Next2.click();		
	}

//******************************************************************************************************************************
	//All the previous steps
		public void prevForm() throws InterruptedException, AWTException {
			placementReview(review1);
			infrastructureReview(review2);
			facultyReview(review3);
			ratingForValue(money);
			titles(title);
			recommend();
			next2();
		}

		public void clickLinkedIn(String profileLink) throws InterruptedException {
			Thread.sleep(2000);
			linkedIN.sendKeys(profileLink);
			Thread.sleep(2000);
		}

		public void next3() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", Next3);
			Next3.click();			
		}
//*********************************************************************************************************************************
		//All the previous steps
				public void prevForm2() throws InterruptedException, AWTException {
					prevForm();
					clickLinkedIn(linkedIn);
					next3();				
				}
				public void nolanguage() throws InterruptedException {
					Thread.sleep(1000);
					noLang.click();	
					Thread.sleep(1000);
				}

				public void submit() {
					submitButton.click();
					
				}

//**********************************************************************************************************************************
				

				public void feedback(String feedbck) throws InterruptedException {
					Actions actions = new Actions(driver);
					actions.moveToElement(elementToHover).perform();
					JavascriptExecutor js = (JavascriptExecutor) driver;

			        js.executeScript("window.scrollBy(0, 1090)");


//			     actions.moveToElement(like).perform();
//			     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//			     wait.until(ExpectedConditions.elementToBeClickable(like)).click();
			     Thread.sleep(1000);

			     
					js.executeScript("arguments[0].click();", like);

			     Thread.sleep(2000);

			     // Send feedback
			     feedback.sendKeys(feedbck);
					Thread.sleep(2000);
					sendFeedback.click();
					
					
				}
							
				
				
}
