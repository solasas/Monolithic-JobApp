package com.sashank.jobapp1.company.impl;

import com.sashank.jobapp1.company.Company;
import com.sashank.jobapp1.company.CompanyRepository;
import com.sashank.jobapp1.company.CompanyService;
import com.sashank.jobapp1.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean updateCompany(Company company,Long id) {
        Optional<Company> companyOptional =companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companyToUpdate= companyOptional.get();

            companyToUpdate.setDescription(companyToUpdate.getDescription());
            companyToUpdate.setName(companyToUpdate.getName());
            companyToUpdate.setJobs(companyToUpdate.getJobs());
            companyRepository.save(companyToUpdate);
            return true;

        }
        return false;
    }

}
