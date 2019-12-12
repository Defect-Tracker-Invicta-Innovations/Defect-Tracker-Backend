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

import com.sgic.internal.defecttracker.defectservice.entities.ProjectPrivilege;
import com.sgic.internal.defecttracker.defectservice.services.ProjectPrivilegeService;

@RestController
@CrossOrigin
public class ProjectPrivilegeController {

	@Autowired
	private ProjectPrivilegeService projectPrivilegeService;
	
	@PostMapping("/saveProjectPrivilege")
	public ProjectPrivilege saveProjectPrivilege(@RequestBody ProjectPrivilege projectPrivilege) {
		return projectPrivilegeService.createProjectPrivilege(projectPrivilege);	
	}
	
	@GetMapping("/getAllProjectPrivilegeInfo")
	public List<ProjectPrivilege> getAllProjectPrivilegeInfo(){
		return projectPrivilegeService.getallProjectPrivilege();
	}
	
	@GetMapping("/getprojectprivilegeName/{privilegeName}")
	public ResponseEntity<ProjectPrivilege> getQAPrivilegeByPrivilegeName(@PathVariable(name = "privilegeName") String privilegeName) {
		try {
			
			return new ResponseEntity<>(projectPrivilegeService.getByPrivilegeName(privilegeName), HttpStatus.OK);
		} catch (Exception ex) {
			
		}
		return null;
	}
	
	@PutMapping("updateprojectprivilege/{id}") 
	public ResponseEntity<String> updateProjectPrivilege( @RequestBody ProjectPrivilege projectPrivilege ,@PathVariable (name = "id") Long id) {
		try {
			if (projectPrivilegeService.updateProjectPrivilege(projectPrivilege, id)!= null) {
				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
			}
			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
		} catch (Exception ex) {
			
		}

		return null;
	}
	
	@DeleteMapping("/deleteprojectprivilege/{id}") 
	public ResponseEntity<String> deleteProjectPrivilegeByid(@PathVariable("id") Long id) {
		try {
			projectPrivilegeService.deleteProjectPrivilege(id);;
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
		}
		return null;
	}
}
