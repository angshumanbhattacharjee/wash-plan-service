/**
 * 
 */
package com.wash.plan.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wash.plan.constants.IConstants;
import com.wash.plan.model.WashPlanModel;
import com.wash.plan.model.WashPlanModelCriteria;
import com.wash.plan.repository.WashPlanRepository;
import com.wash.plan.service.WashPlanService;
import com.wash.plan.utility.CommonUtility;

/**
 * @author ANGSHUMAN
 *
 */
@Service
public class WashPlanServiceImpl implements WashPlanService {

	@Autowired
	private WashPlanRepository repository;

	@Override
	public WashPlanModel createWashPlan(WashPlanModel model) throws Exception {
		
		try {
			model = repository.save(prepareObject(model));
		} catch (Exception e) {
			throw e;
		}
		return model;
	}

	private WashPlanModel prepareObject(WashPlanModel model) throws Exception{
		if(!StringUtils.isEmpty(model.getWashPlanId())) {
			model.setPlanUpdatedDate(CommonUtility.getCurrentDateInString());
		}
		else {
			model.setPlanCreatedDate(CommonUtility.getCurrentDateInString());
			model.setWashPlanStatus(2);
		}
		return model;
	}

	@Override
	public List<WashPlanModel> WashPlansPlansByCriteria(WashPlanModelCriteria criteria) throws Exception {
		List<WashPlanModel> list = null;
		try {
			list = repository.findbyCriteria(criteria);
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public String deleteWashPlan(WashPlanModelCriteria criteria) throws Exception {
		Optional<WashPlanModel> response = null;
		try {
			response = repository.findById(criteria.getWashPlanId());
			if(response.isPresent() && response.get().getWashPlanStatus().equals(2)) {
				response.get().setPlanUpdatedDate(CommonUtility.getCurrentDateInString());
				response.get().setWashPlanStatus(1);
				repository.save(response.get());
				return IConstants.SUCCESS_RESPONSE;
			}
			else if(response.isPresent() && response.get().getWashPlanStatus().equals(1)) {
				return IConstants.FAILURE_RESPONSE;
			}
			else {
				return IConstants.ERROR_RESPONSE;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}
