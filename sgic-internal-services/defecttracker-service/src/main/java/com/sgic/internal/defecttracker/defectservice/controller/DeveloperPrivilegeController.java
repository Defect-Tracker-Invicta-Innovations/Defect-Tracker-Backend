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
import com.sgic.internal.defecttracker.defectservice.entities.DeveloperPrivilege;
import com.sgic.internal.defecttracker.defectservice.services.DeveloperPrivilegeService;

@RestController
@CrossOrigin
public class DeveloperPrivilegeController {

	@Autowired
	private DeveloperPrivilegeService developerPrivilegeService;
	
	@PostMapping("/saveDeveloperPrivilege")
	public DeveloperPrivilege saveDeveloperPrivilege(@RequestBody DeveloperPrivilege developerPrivilege) {
		return developerPrivilegeService.createDeveloperPrivilege(developerPrivilege);	
	}
	
	@GetMapping("/getAllDeveloperPrivilegeInfo")
	public List<DeveloperPrivilege> getAllDeveloperPrivilegeInfo(){
		return developerPrivilegeService.getallDeveloperPrivilege();
	}
	
	@GetMapping("/getDeveloperPrivilegeName/{privilegeName}")
	public ResponseEntity<DeveloperPrivilege> getDeveloperPrivilegeByPrivilegeName(@PathVariable(name = "privilegeName") String privilegeName) {
		try {
			
			return new ResponseEntity<>(developerPrivilegeService.getByPrivilegeName(privilegeName), HttpStatus.OK);
		} catch (Exception ex) {
			
		}
		return null;
	}
	
	@PutMapping("updateDeveloperPrivilege/{id}") 
	public ResponseEntity<String> updateDeveloperPrivilege( @RequestBody DeveloperPrivilege developerPrivilege ,@PathVariable (name = "id") Long id) {
		try {
			if (developerPrivilegeService.updateDeveloperPrivilege(developerPrivilege, id)!= null) {
				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
			}
			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
		} catch (Exception ex) {
			
		}

		return null;
	}
	
	@DeleteMapping("/deleteDeveloperPrivilege/{id}") 
	public ResponseEntity<String> deleteDeveloperPrivilegeByid(@PathVariable("id") Long id) {
		try {
			developerPrivilegeService.deleteDeveloperPrivilege(id);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
		}
		return null;
	}
}
