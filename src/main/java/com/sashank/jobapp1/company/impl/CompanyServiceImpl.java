package com.sashank.jobapp1.company.impl;

import com.sashank.jobapp1.company.Company;
import com.sashank.jobapp1.company.CompanyRepository;
import com.sashank.jobapp1.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    private  CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
