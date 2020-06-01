/**
 * 
 */
package com.wash.plan.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;

import com.wash.plan.constants.IConstants;
import com.wash.plan.model.WashPlanModel;
import com.wash.plan.model.WashPlanModelCriteria;
import com.wash.plan.repository.WashPlanCriteriaRepository;

/**
 * @author ANGSHUMAN
 *
 */
public class WashPlanRepositoryImpl implements WashPlanCriteriaRepository{
	
	@Autowired
	private MongoTemplate repository;

	@Override
	public List<WashPlanModel> findbyCriteria(WashPlanModelCriteria criteria) throws Exception {
		List<WashPlanModel> list = null;
		try {
			list = repository.find(getWhereClause(criteria), WashPlanModel.class);
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	private Query getWhereClause(WashPlanModelCriteria criteria) {
		Query whereClause = new Query();
		
		if(!StringUtils.isEmpty(criteria.getAddOns())) {
			whereClause.addCriteria(Criteria.where(IConstants.ADD_ONS).is(criteria.getAddOns()));
		}
		if(!StringUtils.isEmpty(criteria.getPlanCreatedDate())) {
			whereClause.addCriteria(Criteria.where(IConstants.PLAN_CREATED_DATE).is(criteria.getPlanCreatedDate()));
		}
		if(!StringUtils.isEmpty(criteria.getPlanUpdatedDate())) {
			whereClause.addCriteria(Criteria.where(IConstants.PLAN_UPDATED_DATE).is(criteria.getPlanUpdatedDate()));
		}
		if(!StringUtils.isEmpty(criteria.getPromocode())) {
			whereClause.addCriteria(Criteria.where(IConstants.PROMOCODE).is(criteria.getPromocode()));
		}
		if(!StringUtils.isEmpty(criteria.getWashPlan())) {
			whereClause.addCriteria(Criteria.where(IConstants.WASH_PLAN).is(criteria.getWashPlan()));
		}
		if(!StringUtils.isEmpty(criteria.getWashPlanId())) {
			whereClause.addCriteria(Criteria.where(IConstants.WASH_PLAN_ID).is(criteria.getWashPlanId()));
		}
		if(!StringUtils.isEmpty(criteria.getWashPlanStatus())) {
			whereClause.addCriteria(Criteria.where(IConstants.WASH_PLAN_STATUS).is(criteria.getWashPlanStatus()));
		}
		return whereClause;
	}

}
