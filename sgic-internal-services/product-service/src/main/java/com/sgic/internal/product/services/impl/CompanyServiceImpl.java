package com.sgic.internal.product.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.entities.Company;
import com.sgic.internal.product.repositories.CompanyRepository;
import com.sgic.internal.product.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyRepository;

	private static Logger logger = LogManager.getLogger(CompanyRepository.class);

	@Override
	public Company getCompanyById(Long id) {
		try {
			logger.info("service started -> getCompanyById");
			return companyRepository.findCompanyById(id);
		}catch(Exception ex) {
			logger.error("Company Service Imp:--> Error" + ex.getMessage());	
		}
		return null;
		
	}

	@Override
	public Company saveCompany(Company company) {
		try {
			logger.info("service started -> SaveCompany");
			return companyRepository.save(company);
		}catch(Exception ex) {
			logger.error("Company Service Imp:--> Error" + ex.getMessage());	
		}
		return company;
		
	}

	@Override
	public List<Company> getAllCompany() {
		try {
			logger.info("service started -> GetAllCompany");
			return companyRepository.findAll();
		}catch(Exception ex) {
			logger.error("Company Service Imp:--> Error" + ex.getMessage());	
		}
		return null;
		
	}

	@Override
	public Company deleteCompanyById(Long id) {
		try {
			logger.info("service started -> deleteCompanyById");
			companyRepository.deleteById(id);
			return null;
		}catch(Exception ex) {
			logger.error("Company Service Imp:--> Error" + ex.getMessage());	
		}
		return null;
		
	}

	@Override
	public Company updateCompany(Company company) {
		try {
			logger.info("service started -> UpdateCompany");
			Long id = company.getId();
			logger.info("service started -> getCompanyId");
			boolean isExist = companyRepository.findCompanyById(id) != null;
			if (isExist) {
				logger.info("service started -> Updated By CompanyId");
				return companyRepository.save(company);
			} else {
				logger.info("service started -> companyId Not Found");
			}
		}catch(Exception ex) {
			logger.error("Company Service Imp:--> Error" + ex.getMessage());	
		}
		
		return null;
	}

	@Override
	public boolean isCompanyAlreadyExist(String companyName) {
		return companyRepository.existsByCompanyName(companyName);
	}

}
