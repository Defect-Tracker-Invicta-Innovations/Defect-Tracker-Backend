package com.sgic.internal.defecttracker.defectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.internal.defecttracker.defectservice.entities.HRPrivilege;
import com.sgic.internal.defecttracker.defectservice.services.HRPrivilegeService;


@RestController
@CrossOrigin
public class HRPrivilegeController {
	
	@Autowired
	private HRPrivilegeService hrPrivilegeService; 
	
	@PostMapping("/saveHRPrivilege")
	public HRPrivilege savePMPrivilege(@RequestBody HRPrivilege hrPrivilege) {
		return hrPrivilegeService.createHRPrivilege(hrPrivilege);	
	}
	
	@GetMapping("/getAlHRPrivilegeInfo")
	public List<HRPrivilege> getAllPMPrivilegeInfo(){
		return hrPrivilegeService.getallHRPrivilege();
	}
	
	@GetMapping("/getHRPrivilegeName/{privilegeName}")
	public ResponseEntity<HRPrivilege> getPMPrivilegeByPrivilegeName(@PathVariable(name = "privilegeName") String privilegeName) {
		try {
			
			return new ResponseEntity<>(hrPrivilegeService.getByPrivilegeName(privilegeName), HttpStatus.OK);
		} catch (Exception ex) {
			
		}
		return null;
	}
	
	@PutMapping("updateHRPrivilege/{id}") 
	public ResponseEntity<String> updatePMPrivilege( @RequestBody HRPrivilege hrPrivilege ,@PathVariable (name = "id") Long id) {
		try {
			if (hrPrivilegeService.updateHRPrivilege(hrPrivilege, id)!= null) {
				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
			}
			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
		} catch (Exception ex) {
			
		}

		return null;
	}
	
	@DeleteMapping("/deleteHRPrivilege/{id}") 
	public ResponseEntity<String> deleteHRPrivilegeByid(@PathVariable("id") Long id) {
		try {
			hrPrivilegeService.deleteHRPrivilege(id);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
		}
		return null;
	}

}
