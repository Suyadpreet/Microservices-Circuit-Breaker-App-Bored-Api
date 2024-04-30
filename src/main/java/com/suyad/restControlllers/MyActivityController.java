package com.suyad.restControlllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.suyad.activities.Activity;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class MyActivityController 
{
	private final String BORED_API = "https://www.boredapi.com/api/activity";

	@GetMapping("/")
	@CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
	public String getRandomActivity() 
	{
		System.out.println("Main method logic has been executed........");
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Activity> responseEntity = rt.getForEntity(BORED_API, Activity.class);
		Activity activity = responseEntity.getBody();
		//System.out.println("Activity Recieved::" + activity.getActivity());
		
		int i = 10/0;
		
		return activity.getActivity();
	}
	public String fallbackRandomActivity(Throwable throwable) 
	{
		System.out.println("Fall back method logic has been executed......");
		return "Watch a video from Ashok IT...!!";
	}
}
