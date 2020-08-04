package com.globallogic.ejercicio.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "phones")
public class PhoneEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8740067259692687799L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "pho_id", columnDefinition = "VARCHAR(255)")
	private UUID id;
	@Column(name = "pho_number")
	private String number;
	@Column(name = "pho_citycode")
	private String cityCode;
	@Column(name = "pho_countrycode")
	private String countryCode;
	@ManyToOne
	@JoinColumn(name="pho_usr_uuid")
	private UserEntity usr;

}
