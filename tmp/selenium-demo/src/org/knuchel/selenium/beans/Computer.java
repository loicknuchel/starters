package org.knuchel.selenium.beans;

public class Computer {
	public static final String NAME = "name";
	public static final String INTRODUCED = "introduced";
	public static final String DISCONTINUED = "discontinued";
	public static final String COMPANY = "company";
	private String name;
	private String introduced;
	private String discontinued;
	private String company;

	public Computer() {

	}

	public Computer(String name, String introduced, String discontinued, String company) {
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = company;
	}

	public String getField(String field) {
		if (NAME.equals(field)) {
			return getName();
		} else if (INTRODUCED.equals(field)) {
			return getIntroduced();
		} else if (DISCONTINUED.equals(field)) {
			return getDiscontinued();
		} else if (COMPANY.equals(field)) {
			return getCompany();
		}
		throw new IllegalStateException("Field " + field + " is unknown !");
	}

	public void setField(String field, String value) {
		if (NAME.equals(field)) {
			setName(value);
		} else if (INTRODUCED.equals(field)) {
			setIntroduced(value);
		} else if (DISCONTINUED.equals(field)) {
			setDiscontinued(value);
		} else if (COMPANY.equals(field)) {
			setCompany(value);
		}
		throw new IllegalStateException("Field " + field + " is unknown !");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduced() {
		return introduced;
	}

	public void setIntroduced(String introduced) {
		this.introduced = introduced;
	}

	public String getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(String discontinued) {
		this.discontinued = discontinued;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Computer [name=" + name + ", introduced=" + introduced + ", discontinued=" + discontinued + ", company=" + company + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
		result = prime * result + ((introduced == null) ? 0 : introduced.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (discontinued == null) {
			if (other.discontinued != null)
				return false;
		} else if (!discontinued.equals(other.discontinued))
			return false;
		if (introduced == null) {
			if (other.introduced != null)
				return false;
		} else if (!introduced.equals(other.introduced))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
