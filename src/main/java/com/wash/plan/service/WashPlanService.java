/**
 * 
 */
package com.wash.plan.service;

import java.util.List;

import com.wash.plan.model.WashPlanModel;
import com.wash.plan.model.WashPlanModelCriteria;

/**
 * @author ANGSHUMAN
 *
 */
public interface WashPlanService {

	public WashPlanModel createWashPlan(WashPlanModel model) throws Exception;

	public List<WashPlanModel> WashPlansPlansByCriteria(WashPlanModelCriteria criteria) throws Exception;

	public String deleteWashPlan(WashPlanModelCriteria criteria) throws Exception;

}
