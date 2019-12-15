package com.sgic.internal.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.common.api.enums.RestApiResponseStatus;
import com.eureka.common.api.response.BasicResponse;
import com.eureka.common.dto.mapper.Mapper;
import com.sgic.internal.product.controller.dto.CompanyDto;
import com.sgic.internal.product.entities.Company;
import com.sgic.internal.product.services.CompanyService;
import com.sgic.internal.product.util.AppConstants;
import com.sgic.internal.product.util.ErrorCodes;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	Mapper mapper;
	
	@Autowired
	ErrorCodes errorCodes;

	
	// Save Company
	@PostMapping(AppConstants.COMPANY_URL)
	public ResponseEntity<Object> saveCompany(@RequestBody CompanyDto companyDto) {
		if (companyService.isCompanyAlreadyExist(companyDto.getCompanyName())) {
			return new ResponseEntity<>(
					new BasicResponse<>(RestApiResponseStatus.VALIDATION_FAILURE,AppConstants.SERVICE_NAME ,"Company Already exist!!!"),HttpStatus.BAD_REQUEST);
		}
		Company company = mapper.map(companyDto, Company.class);
		companyService.saveCompany(company);
		return new ResponseEntity<>(new BasicResponse<>(RestApiResponseStatus.CREATED,AppConstants.SERVICE_NAME, "Company Successfully Created!!!" ),HttpStatus.OK);
	}

	// Get All Company
	@GetMapping(AppConstants.COMPANIES_URL)
	public ResponseEntity<List<CompanyDto>> getAllCompany() {
		List<Company> companies = companyService.getAllCompany();
		return new ResponseEntity<>(mapper.map(companies, CompanyDto.class),HttpStatus.OK);
	}

	 //Get Company By Id
	@GetMapping(AppConstants.COMPANY_BY_ID_URL)
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable (AppConstants.COMPANY_PATH_VARIABLE) Long id) {
		Company company = companyService.getCompanyById(id);
		return new ResponseEntity<>(mapper.map(company, CompanyDto.class),HttpStatus.OK);
	}
		

	// Update Company
	@PutMapping(AppConstants.COMPANY_BY_ID_URL)
	public ResponseEntity<Object> updateCompany(@RequestBody CompanyDto companyDto) {
		Company company = mapper.map(companyDto, Company.class);
		if(companyService.saveCompany(company) != null){
		return new ResponseEntity<>(
		new BasicResponse<>(RestApiResponseStatus.OK, AppConstants.SERVICE_NAME, "Update Successfully!!!"), HttpStatus.OK);
		}
		return new ResponseEntity<>("Failed To Update", HttpStatus.OK);
	}

//	// Delete Company
//	@DeleteMapping(AppConstants.COMPANY_BY_ID_URL)
//	public ResponseEntity<String> deleteCompany(@PathVariable(name = "companyId") Long companyId) {
//		if (companyMapper.getCompanyById(companyId) != null) {
//			if (companyMapper.deleteCompanyById(companyId) == null) {
//				logger.info("Company Controller -> Company Deleted Successful");
//				return new ResponseEntity<>("Company Sucessfully deleted", HttpStatus.OK);
//			}
//		} else {
//			logger.info("Company Controller -> Company Id Not Found");
//			return new ResponseEntity<>("Company Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
//		}
//		logger.info("Company Controller -> Company Deleted Failed!!!");
//		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
//	}
//
}
