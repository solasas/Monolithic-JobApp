package com.sashank.jobapp1.review.impl;

import com.sashank.jobapp1.company.Company;
import com.sashank.jobapp1.review.Review;
import com.sashank.jobapp1.review.ReviewRepository;
import com.sashank.jobapp1.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl() {
    }

    @Override
    public void createReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public boolean updateReview(Review review, Long id) {
        Optional<Review> reviewOptional =reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            Review reviewToUpdate= reviewOptional.get();

            reviewToUpdate.setContent(reviewToUpdate.getContent());
            reviewToUpdate.setRating(reviewToUpdate.getRating());

            reviewRepository.save(reviewToUpdate);
            return true;

        }
        return false;
    }

    @Override
    public boolean deleteReview(Long id) {
        if(reviewRepository.existsById(id)){
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);

    }
}
