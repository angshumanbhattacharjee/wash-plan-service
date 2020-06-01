/**
 * 
 */
package com.wash.plan.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@Document(collection = "wash-plans")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@ToString
public class WashPlanModel implements Serializable{

	/**
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
