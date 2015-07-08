package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the TEWTTERRRR database table.
 * 
 */
@Entity
@Table(name="Tewtterrrr", schema="TESTUSER")
@NamedQuery(name="Tewtterrrr.findAll", query="SELECT T FROM Tewtterrrr T")
public class Tewtterrrr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private Timestamp mdate;

	@Column(name="\"MESSAGE\"")
	private String message;

	private String name;

	public Tewtterrrr() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getMdate() {
		return this.mdate;
	}

	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}