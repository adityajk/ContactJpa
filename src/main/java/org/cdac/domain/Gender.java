package org.cdac.domain;

public enum Gender {

	MALE, FEMALE;
	
	public String toString() {
		switch(this) {
		case MALE: return "m";
	      case FEMALE: return "f";
	      default:       return "u";
		}
	}
}
