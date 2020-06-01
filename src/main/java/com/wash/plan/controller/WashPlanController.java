/**
 * 
 */
package com.wash.plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wash.plan.model.WashPlanModel;
import com.wash.plan.model.WashPlanModelCriteria;
import com.wash.plan.service.WashPlanService;

/**
 * @author ANGSHUMAN
 *
 */
@RestController
public class WashPlanController {

	@Autowired
	private WashPlanService service;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "wash-plan-service/createWashPlan", produces = "application/json")
	public ResponseEntity createWashPlan(@RequestBody(required = true) WashPlanModel model) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.createWashPlan(model), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response ;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "wash-plan-service/getWashPlansByCriteria", produces = "application/json")
	public ResponseEntity getWashPlansByCriteria(@RequestBody(required = true) WashPlanModelCriteria criteria) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.WashPlansPlansByCriteria(criteria), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response ;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "wash-plan-service/deleteWashPlan", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity deleteWashPlan(@RequestBody(required = true) WashPlanModelCriteria criteria) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.deleteWashPlan(criteria), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response ;
	}
	
}
