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
import com.sgic.internal.defecttracker.defectservice.entities.PMPrivilege;
import com.sgic.internal.defecttracker.defectservice.services.PMPrivilegeService;

@RestController
@CrossOrigin
public class PMPrivilegeController {

	@Autowired
	private PMPrivilegeService pmPrivilegeService;
	
	@PostMapping("/savePMPrivilege")
	public PMPrivilege savePMPrivilege(@RequestBody PMPrivilege pmPrivilege) {
		return pmPrivilegeService.createPMPrivilege(pmPrivilege);	
	}
	
	@GetMapping("/getAlPMPrivilegeInfo")
	public List<PMPrivilege> getAllPMPrivilegeInfo(){
		return pmPrivilegeService.getallPMPrivilege();
	}
	
	@GetMapping("/getpmPrivilegeName/{privilegeName}")
	public ResponseEntity<PMPrivilege> getPMPrivilegeByPrivilegeName(@PathVariable(name = "privilegeName") String privilegeName) {
		try {
			
			return new ResponseEntity<>(pmPrivilegeService.getByPrivilegeName(privilegeName), HttpStatus.OK);
		} catch (Exception ex) {
			
		}
		return null;
	}
	
	@PutMapping("updatePMPrivilege/{id}") 
	public ResponseEntity<String> updatePMPrivilege( @RequestBody PMPrivilege pmPrivilege ,@PathVariable (name = "id") Long id) {
		try {
			if (pmPrivilegeService.updatePMPrivilege(pmPrivilege, id)!= null) {
				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
			}
			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
		} catch (Exception ex) {
			
		}

		return null;
	}
	
	@DeleteMapping("/deletePMPrivilege/{id}") 
	public ResponseEntity<String> deletePMPrivilegeByid(@PathVariable("id") Long id) {
		try {
			pmPrivilegeService.deletePMPrivilege(id);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
		}
		return null;
	}
}
