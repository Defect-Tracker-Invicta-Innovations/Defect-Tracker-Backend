//package com.sgic.internal.product.controller;
//
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
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
//import com.sgic.internal.product.controller.dto.PrivilegeDto;
//import com.sgic.internal.product.controller.dto.mapper.PrivilegeMapper;
//import com.sgic.internal.product.entities.Privilege;
//
//@CrossOrigin(origins = "*",allowedHeaders = "*")
//@RestController
//public class PrivilegeController {
//	
//	@Autowired
//	private PrivilegeMapper privilegeMapper;
//	
//	private static Logger logger = LogManager.getLogger(PrivilegeMapper.class);
//
//	// Get All Privilege
//	@GetMapping("/Privileges")
//	public List<PrivilegeDto> getAllPrivilege() {
//		logger.info("Controller -> Data Retrieved Successfull");
//		return privilegeMapper.getAllPrivilage();
//	}
//
//	 //Get Privilege By Id
//	@GetMapping("/Privilege/{privilageId}")
//	public PrivilegeDto getPrivilegeById(@PathVariable(name = "privilageId") String privilageId) {
//		logger.info("Controller -> Data Retrieved Successfull");
//		return privilegeMapper.getPrivilegeById(privilageId);
//	}
//	
//
//	// Save All Privilege
//	@PostMapping("/Privilege")
//	public Privilege savePrivilege(@RequestBody PrivilegeDto privilegeDTO) {
//		return privilegeMapper.savePrivilege(privilegeDTO);
//	}
//
//	// Update Privilege
//	@PutMapping("/Privilege/{privilageId}")
//	public ResponseEntity<String> updatePrivilege(@RequestBody PrivilegeDto privilegeDto) {
//		try {
//			logger.info("Privilege Controller :-> Update");
//			if (privilegeMapper.UpdatePrivilege(privilegeDto) != null) {
//				return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
//			}
//			return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
//		} catch (Exception ex) {
//			logger.error("Privilege Controller :-> Error" + ex.getMessage());
//		}
//
//		return null;
//	}
//	 //Delete Privilege
//	@DeleteMapping("/Privilege/{privilageId}")
//	public ResponseEntity<String> deletePrivilege(@PathVariable(name = "privilageId") String privilageId) {
//		System.out.print(privilageId);
//		if (privilegeMapper.getPrivilegeById(privilageId) != null) {
//			if (privilegeMapper.deletePrivilegeById(privilageId) == null) {
//				logger.info("Privilege Controller -> Privilege Deleted Successful");
//				return new ResponseEntity<>("Privilege Sucessfully deleted", HttpStatus.OK);
//			}
//		} else {
//			logger.info("Privilege Controller -> Privilege Id Not Found");
//			return new ResponseEntity<>("Privilege Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
//		}
//		logger.info("Privilege Controller -> Privilege Deleted Failed!!!");
//		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
//	}
//
//}
