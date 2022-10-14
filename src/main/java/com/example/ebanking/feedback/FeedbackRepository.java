package com.example.ebanking.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Modifying
    @Query(value = "DELETE FROM feedback WHERE f_id=?1", nativeQuery = true)
    Feedback dltFeedback(long fId);

}
