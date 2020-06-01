package com.wash.plan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wash.plan.model.WashPlanModel;

@Repository
public interface WashPlanRepository extends MongoRepository<WashPlanModel, String>, WashPlanCriteriaRepository {

}
