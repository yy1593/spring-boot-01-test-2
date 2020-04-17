package com.gyhl.test.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yang
 * @since 2020-03-13
 */
/* @Data */
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;
	
	private Integer sexId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSexId() {
		return sexId;
	}

	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}
	
	

}
