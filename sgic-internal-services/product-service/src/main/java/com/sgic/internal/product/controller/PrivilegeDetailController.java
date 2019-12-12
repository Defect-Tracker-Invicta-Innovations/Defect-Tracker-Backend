//package com.sgic.internal.product.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgic.internal.product.controller.dto.PrivilegeDetailDto;
//import com.sgic.internal.product.controller.dto.mapper.PrivilegeDetailMapper;
//import com.sgic.internal.product.entities.PrivilegeDetail;
//
//@CrossOrigin(origins = "*",allowedHeaders = "*")
//@RestController
//public class PrivilegeDetailController {
//
//
//	@Autowired
//	private PrivilegeDetailMapper privilegeDetailMapper;
//
//	// Get All PrivilegeDetail
//	@GetMapping("/PrivilegeDetails")
//	public List<PrivilegeDetailDto> getAllPrivilegeDetail() {
//		return privilegeDetailMapper.getAllPrivilageDetail();
//	}
//
//	 //Get PrivilegeDetail By Id
//	@GetMapping("/PrivilegeDetail/{id}")
//	public PrivilegeDetailDto getPrivilegeDetailById(@PathVariable(name = "id") Long id) {
//		return privilegeDetailMapper.getPrivilegeDetailById(id);
//	}
//	
//
//	// Save All PrivilegeDetail
//	@PostMapping("/PrivilegeDetail")
//	public PrivilegeDetail savePrivilegeDetail(@RequestBody PrivilegeDetailDto privilegeDetailDto) {
//		return privilegeDetailMapper.savePrivilegeDetail(privilegeDetailDto);
//	}
//
//	// Update PrivilegeDetail
//	@PutMapping("/PrivilegeDetail/{id}")
//	public ResponseEntity<String> updatePrivilegeDetail(@RequestBody PrivilegeDetailDto privilegeDetailDto) {
//		try {
//			if (privilegeDetailMapper.UpdatePrivilegeDetail(privilegeDetailDto)!= null) {
//				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
//			}
//			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
//		} catch (Exception ex) {
//			
//		}
//
//		return null;
//	}
//	 //Delete PrivilegeDetail
//	@DeleteMapping("/PrivilegeDetail/{id}")
//	public ResponseEntity<String> deletePrivilege(@PathVariable(name = "id") Long id) {
//		System.out.print(id);
//		if (privilegeDetailMapper.getPrivilegeDetailById(id)!= null) {
//			if (privilegeDetailMapper.deletePrivilegeDetailById(id) == null) {
//				return new ResponseEntity<>("Privilege Detail Sucessfully deleted", HttpStatus.OK);
//			}
//		} else {
//			return new ResponseEntity<>("PrivilegeDetail Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
//	}
//
//}
