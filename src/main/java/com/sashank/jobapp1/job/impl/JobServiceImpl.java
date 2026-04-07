package com.sashank.jobapp1.job.impl;

import com.sashank.jobapp1.job.Job;
import com.sashank.jobapp1.job.JobRepository;
import com.sashank.jobapp1.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs=new ArrayList<>();
    JobRepository jobrepository;
//    private Long nextId=1L;

    public JobServiceImpl(JobRepository jobrepository) {
        this.jobrepository = jobrepository;
    }

    @Override
    public List<Job> findAll() {

        return jobrepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //giving the control to set id only to company
//        job.setId(nextId++);
//        jobs.add(job);
         jobrepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for(Job job: jobs){
//            if(job.getId().equals(id)){
//                return  job;
//            }
//        }
//        return null;

        return jobrepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        Iterator<Job> iterator=jobs.iterator();
//        while(iterator.hasNext()){
//            Job job=iterator.next();
//            if(job.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
        try{
        jobrepository.deleteById(id);
        return true;}
        catch (Exception e){
            return false;

        }


    }

    @Override
    public boolean updateJob(Long id,Job updatedJob) {
//        for(Job job: jobs){
//            if(job.getId().equals(id)){
//                job.setTitle(updatedJob.getTitle());
//                job.setDescription(updatedJob.getDescription());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//                return true;
//            }
//        }
        Optional<Job> joboptional=jobrepository.findById(id);
        if(joboptional.isPresent()){
            Job job=joboptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobrepository.save(job);
            return true;

        }

        return false;
    }

}
