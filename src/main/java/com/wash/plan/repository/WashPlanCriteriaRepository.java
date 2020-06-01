package com.wash.plan.repository;

import java.util.List;

import com.wash.plan.model.WashPlanModel;
import com.wash.plan.model.WashPlanModelCriteria;

@FunctionalInterface
public interface WashPlanCriteriaRepository {
	
	public List<WashPlanModel> findbyCriteria(WashPlanModelCriteria criteria) throws Exception;
}
