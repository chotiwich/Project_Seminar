package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Activity;
import net.javaguides.springboot.repository.ActivityRepository;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ActivityController {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	// get all activity
	@GetMapping("/activities")
	public List<Activity> getAllActivities(){
		return activityRepository.findAll();
	}
	
	// create activity rest api
	@PostMapping("/activities")
	public Activity createActivity(@RequestBody Activity activity) {
		return activityRepository.save(activity);
	}
	
	// get activity by id rest api
	@GetMapping("/activities/{id}")
	public ResponseEntity<Activity> getActivityById(@PathVariable long id) {
		Activity activity = activityRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Activity not exist with id :" +id));
		return ResponseEntity.ok(activity);
	}
	
	// update activity rest api
	@PutMapping("/activities/{id}")
	public ResponseEntity<Activity> updateActivity(@PathVariable Long id,@RequestBody Activity activityDetails){
		Activity activity = activityRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Activity not exist with id :" +id));
		activity.setActivity_name(activityDetails.getActivityName());
		activity.setActivity_Detail(activityDetails.getActivityDetail());
		activity.setActivityDate(activityDetails.getActivityDate());
		activity.setActivityLocation(activityDetails.getActivityLocation());
		activity.setActivityUrl(activityDetails.getActivityUrl());
		Activity updatedActivity = activityRepository.save(activity);
		return ResponseEntity.ok(updatedActivity);
	}
	
	// delete activity rest api
	@DeleteMapping("/activities/{id}")
	public ResponseEntity <Map<String,Boolean>> deleteActivity(@PathVariable Long id) {
		Activity activity = activityRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Activity not exist with id :" +id));
		activityRepository.delete(activity);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
