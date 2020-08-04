package com.globallogic.ejercicio.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "usr")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2631762419800857236L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "usr_uuid", columnDefinition = "VARCHAR(255)")
	private UUID uuid;

	@Column(name = "usr_name")
	private String name;

	@Column(name = "usr_email")
	private String email;

	@Column(name = "usr_password")
	private String password;

	@OneToMany(mappedBy = "usr", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PhoneEntity> phones;

	@Column(name = "usr_created")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate created;

	@Column(name = "usr_modified")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate modified;

	@Column(name = "usr_lastlogin")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate lastLogin;

	@Column(name = "usr_isactive")
	private boolean isActive;

}
