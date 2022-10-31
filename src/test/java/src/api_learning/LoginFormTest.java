package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

public class LoginFormTest {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try{
            // Navigate to Login Form
            MobileElement navLoginBtnElem = (MobileElement) appiumDriver.findElements(MobileBy.AccessibilityId("Login"));
            navLoginBtnElem.click();

            // Find Login Form elements
            MobileElement emailInputElem = (MobileElement) appiumDriver.findElements(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordInputElem = (MobileElement) appiumDriver.findElements(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtnElem = (MobileElement) appiumDriver.findElements(MobileBy.AccessibilityId("button-LOGIN"));

            // Interact with Login Form | Fill username and password
            emailInputElem.sendKeys("teo@sth.com");
            passwordInputElem.sendKeys("12345678");
            loginBtnElem.click();

            // Verification | Login Dialog
            WebDriverWait wait = new WebDriverWait(appiumDriver,10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));

            MobileElement loginDialogTittleElem = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println("Dialog Tittle:" + loginDialogTittleElem.getText());

            // Print the dialog content

            // Debug purpose ONLY
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }

        appiumDriver.quit();

    }
}
