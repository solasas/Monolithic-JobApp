package com.sashank.jobapp1.review;

import com.sashank.jobapp1.review.impl.ReviewServiceImpl;
import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewServiceImpl reviewService;

    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping()
    public ResponseEntity<String> createReview(Review review){
        reviewService.createReview(review);
        return new ResponseEntity<>("Review Added Sucessfully", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(Long id){
        Review review=reviewService.getReviewById(id);
        if(review!=null){
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review review){
        reviewService.updateReview(review,id);
        return new ResponseEntity<>("Review Updated Sucessfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id){
        boolean isDeleted= reviewService.deleteReview(id);
        if(isDeleted){
            return new ResponseEntity<>("Review Deleted Sucessfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);
        }
    }
}
