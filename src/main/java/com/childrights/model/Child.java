package com.childrights.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Child {
	@Id
	@GeneratedValue
	@NotNull
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	@NotNull
	private String gender;
	@NotNull
	private String age;
	@NotNull
	private String address;
}
