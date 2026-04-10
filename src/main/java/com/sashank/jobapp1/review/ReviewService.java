package com.sashank.jobapp1.review;

public interface ReviewService {
    void createReview(Review review);
    boolean updateReview(Review review,Long id);
    boolean deleteReview(Long id);
    Review getReviewById(Long id);
}
