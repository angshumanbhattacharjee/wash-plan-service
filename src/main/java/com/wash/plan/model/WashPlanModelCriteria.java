/**
 * 
 */
package com.wash.plan.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ANGSHUMAN
 *
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WashPlanModelCriteria implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	String washPlanId;
	
	@Getter
	@Setter
	String washPlan;
	
	@Getter
	@Setter
	List<String> addOns;
	
	@Getter
	@Setter
	String promocode;
	
	@Getter
	@Setter
	String planCreatedDate;
	
	@Getter
	@Setter
	String planUpdatedDate;
	
	@Getter
	@Setter
	Integer washPlanStatus;
}
