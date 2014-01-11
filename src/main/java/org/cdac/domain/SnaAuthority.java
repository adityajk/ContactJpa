package org.cdac.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sna_authorities database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="SnaAuthority.getUserRole", query="Select sau from SnaAuthority sau where sau.authority = :userRole")
})
@Table(name="sna_authorities")
public class SnaAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String authority;

	//bi-directional many-to-one association to SnaAccount
	@OneToMany(mappedBy="snaAuthority")
	private List<SnaAccount> snaAccounts;

	public SnaAuthority() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public List<SnaAccount> getSnaAccounts() {
		return this.snaAccounts;
	}

	public void setSnaAccounts(List<SnaAccount> snaAccounts) {
		this.snaAccounts = snaAccounts;
	}

}