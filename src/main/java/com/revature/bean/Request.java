package com.revature.bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Request {
	
	private int rembId;
	private float amount;
	private Timestamp timeSubmitted;
	private Timestamp timeResolved;
	private String description;
	private  String receipt;
	private int authorNumber;
	private int resolveNumber;
	private int statusId;
	private int typeId;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(int rembId, float amount, Timestamp timeSubmitted, Timestamp timeResolved, String description,
			String receipt, int authorNumber, int resolveNumber, int statusId, int typeId) {
		super();
		this.rembId = rembId;
		this.amount = amount;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.description = description;
		this.receipt = receipt;
		this.authorNumber = authorNumber;
		this.resolveNumber = resolveNumber;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	/**
	 * @return the rembId
	 */
	public int getRembId() {
		return rembId;
	}

	/**
	 * @param rembId the rembId to set
	 */
	public void setRembId(int rembId) {
		this.rembId = rembId;
	}

	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/**
	 * @return the timeSubmitted
	 */
	public Timestamp getTimeSubmitted() {
		return timeSubmitted;
	}

	/**
	 * @param timeSubmitted the timeSubmitted to set
	 */
	public void setTimeSubmitted(Timestamp timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}

	/**
	 * @return the timeResolved
	 */
	public Timestamp getTimeResolved() {
		return timeResolved;
	}

	/**
	 * @param timeResolved the timeResolved to set
	 */
	public void setTimeResolved(Timestamp timeResolved) {
		this.timeResolved = timeResolved;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the receipt
	 */
	public String getReceipt() {
		return receipt;
	}

	/**
	 * @param receipt the receipt to set
	 */
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	/**
	 * @return the authorNumber
	 */
	public int getAuthorNumber() {
		return authorNumber;
	}

	/**
	 * @param authorNumber the authorNumber to set
	 */
	public void setAuthorNumber(int authorNumber) {
		this.authorNumber = authorNumber;
	}

	/**
	 * @return the resolveNumber
	 */
	public int getResolveNumber() {
		return resolveNumber;
	}

	/**
	 * @param resolveNumber the resolveNumber to set
	 */
	public void setResolveNumber(int resolveNumber) {
		this.resolveNumber = resolveNumber;
	}

	/**
	 * @return the statusId
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Request [rembId=" + rembId + ", amount=" + amount + ", timeSubmitted=" + timeSubmitted
				+ ", timeResolved=" + timeResolved + ", description=" + description + ", receipt=" + receipt
				+ ", authorNumber=" + authorNumber + ", resolveNumber=" + resolveNumber + ", statusId=" + statusId
				+ ", typeId=" + typeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + authorNumber;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + rembId;
		result = prime * result + resolveNumber;
		result = prime * result + statusId;
		result = prime * result + ((timeResolved == null) ? 0 : timeResolved.hashCode());
		result = prime * result + ((timeSubmitted == null) ? 0 : timeSubmitted.hashCode());
		result = prime * result + typeId;
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
		Request other = (Request) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (authorNumber != other.authorNumber)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (rembId != other.rembId)
			return false;
		if (resolveNumber != other.resolveNumber)
			return false;
		if (statusId != other.statusId)
			return false;
		if (timeResolved == null) {
			if (other.timeResolved != null)
				return false;
		} else if (!timeResolved.equals(other.timeResolved))
			return false;
		if (timeSubmitted == null) {
			if (other.timeSubmitted != null)
				return false;
		} else if (!timeSubmitted.equals(other.timeSubmitted))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	

	
	

}
