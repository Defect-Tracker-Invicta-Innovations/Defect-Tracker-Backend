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
import com.sgic.internal.defecttracker.defectservice.entities.QAPrivilege;
import com.sgic.internal.defecttracker.defectservice.services.QAPrivilegeService;


@RestController
@CrossOrigin
public class QAPrivilegeController {

	@Autowired
	private QAPrivilegeService qaPrivilegeService;
	
	@PostMapping("/saveQAPrivilege")
	public QAPrivilege saveQAPrivilege(@RequestBody QAPrivilege qaPrivilege) {
		return qaPrivilegeService.createQAPrivilege(qaPrivilege);	
	}
	
	@GetMapping("/getAllQAPrivilegeInfo")
	public List<QAPrivilege> getAllQAPrivilegeInfo(){
		return qaPrivilegeService.getallQAPrivilege();
	}
	
	@GetMapping("/getprivilegeName/{privilegeName}")
	public ResponseEntity<QAPrivilege> getQAPrivilegeByPrivilegeName(@PathVariable(name = "privilegeName") String privilegeName) {
		try {
			
			return new ResponseEntity<>(qaPrivilegeService.getByPrivilegeName(privilegeName), HttpStatus.OK);
		} catch (Exception ex) {
			
		}
		return null;
	}
	
	@PutMapping("updateprivilege/{id}") 
	public ResponseEntity<String> updateQAPrivilege( @RequestBody QAPrivilege qaPrivilege ,@PathVariable (name = "id") Long id) {
		try {
			if (qaPrivilegeService.updateQAPrivilege(qaPrivilege,id)!= null) {
				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
			}
			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
		} catch (Exception ex) {
			
		}

		return null;
	}
	
	@DeleteMapping("/deleteqaprivilege/{id}") 
	public ResponseEntity<String> deleteQAPrivilegeByid(@PathVariable("id") Long id) {
		try {
			qaPrivilegeService.deleteQAprivilege(id);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception ex) {
		}
		return null;
	}
}
