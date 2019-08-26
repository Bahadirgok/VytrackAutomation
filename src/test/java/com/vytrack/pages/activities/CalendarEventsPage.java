package com.vytrack.pages.activities;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.VYTrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CalendarEventsPage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEventBtn;

    @FindBy(css = "[id^='oro_calendar_event_form_title']")
    public WebElement titleInputLocator;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDateLocator;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDateLocator;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTimeLocator;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTimeLocator;

    public CalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void setStartDate(String startDate){
//        String startDate = startDateLocator.getText();
//        String[] startDate2= startDate.split(" ");
//        String startDay = startDate2[1].substring(0,startDate2[1].length()-1);
//        int day = Integer.parseInt(startDay)+1;
//        String newStartDate = Integer.toString(day);
//        startDateLocator.sendKeys(newStartDate);
        startDateLocator.sendKeys(startDate);

    }

    public void setStartTime(String startTime){
        startTimeLocator.sendKeys(startTime);


    }


    public void checkTime(String a, String b ){
        String subA = a.substring(0,a.length()-6);
        int hour = Integer.parseInt(subA);

        String subB = b.substring(0,b.length()-6);
        int hourB = Integer.parseInt(subB);


        Assert.assertEquals(hourB,hour+1);

    }


    public void checkDate(String a, String b){
        String [] arr = a.split(" ");
        String [] arr2 = b.split(" ");

        String subA = arr[1].substring(0,arr[1].length()-1);
        String subB = arr2[1].substring(0,arr2[1].length()-1);

        int dateA = Integer.parseInt(subA);
        int dateB = Integer.parseInt(subB);

        Assert.assertEquals(dateB,dateA+1);
    }
}
