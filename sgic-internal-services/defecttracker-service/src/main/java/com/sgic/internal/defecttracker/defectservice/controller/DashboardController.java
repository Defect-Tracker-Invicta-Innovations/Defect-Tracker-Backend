package com.sgic.internal.defecttracker.defectservice.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.internal.defecttracker.defectservice.repositories.DefectRepository;
import com.sgic.internal.defecttracker.defectservice.services.DashboardService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@SuppressWarnings("unused")
@RestController
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@Autowired
	private DefectRepository defectRepo;

	private static Logger logger = LogManager.getLogger(DashboardService.class);
	private long count;
	private int reject;
	private int low;
	private int High;
	private int rejectlow;
	private int rejectHigh;
	private int medium;
	private int rejectmedium;

	//get all defects on low count
	@GetMapping("/getlowcount")
	public ResponseEntity<Float> getTotalCount() {
		return new ResponseEntity<>(dashboardService.CalculateLow(count, reject, low, rejectlow), HttpStatus.OK);

	}

	//get all defects on high count
	@GetMapping("/gethightcount")
	public ResponseEntity<Float> getTotalCounthighseverity() {
		return new ResponseEntity<>(dashboardService.Calculatseverityhigh(count, reject, High, rejectHigh),
				HttpStatus.OK);

	}

	//get all defects on medium count
	@GetMapping("/getcountmedium")
	public ResponseEntity<Float> getTotalCountmedium() {
		return new ResponseEntity<>(dashboardService.CalculateMedium(count, rejectlow, medium, rejectmedium),
				HttpStatus.OK);

	}

	//get severity index for the defects
	@GetMapping("/getseverityindex")
	public ResponseEntity<Double> getSeverityIndex() {
		return new ResponseEntity<>(dashboardService.calculateSeverityIndex(), HttpStatus.OK);

	}

    //Total Severity Low Defect Count Controller
	@GetMapping("/getseveritylowcount")
	public ResponseEntity<Integer> countseveritytotalLow() {
		try {
			logger.info("Dashboard Controller--> successfully get Total Severity Low ");
			return new ResponseEntity<>(dashboardService.countseveritytotalLow(count, High), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Dashboard Controller--> Error" + e.getMessage());
		}
		return null;

	}

    //Total Severity Medium Defect Count Controller
	@GetMapping("/getseveritymediumcount")
	public ResponseEntity<Integer> countseveritytotalmedium() {
		try {
			logger.info("Dashboard Controller--> successfully get Total Severity Low ");
			return new ResponseEntity<>(dashboardService.countseveritytotalmedium(count, High), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Dashboard Controller--> Error" + e.getMessage());
		}
		return null;

	}

	// Total Severity High Defect Count Controller
	@GetMapping("/getseverityhigcount")
	public ResponseEntity<Integer> countseveritytotalhigh() {
		try {
			logger.info("Dashboard Controller--> successfull ");
			return new ResponseEntity<>(dashboardService.countseveritytotalhig(count, High), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Dashboard Controller--> Error" + e.getMessage());
		}
		return null;

	}
	
	@GetMapping("/getremarksratio")
	public ResponseEntity<Double> getRemarksRatio() {
		return new ResponseEntity<>(dashboardService.calculatedefectRemarksratio(count, reject), HttpStatus.OK);

	}
	
	@GetMapping("/getprioritymediumcount")
	public ResponseEntity<Integer> countprioritytotalmedium() {
		return new ResponseEntity<>(dashboardService.countprioritytotalmedium(count, High), HttpStatus.OK);
	}
	
	@GetMapping("/getpriorityhighcount")
	public ResponseEntity<Integer> countprioritytotalhigh() {
		return new ResponseEntity<>(dashboardService.countprioritytotalhigh(count, High), HttpStatus.OK);
	}
	
	@GetMapping("/getprioritylowcount")
	public ResponseEntity<Integer> countprioritytotallow() {
		return new ResponseEntity<>(dashboardService.countprioritytotallow(count, High), HttpStatus.OK);
	}
}
