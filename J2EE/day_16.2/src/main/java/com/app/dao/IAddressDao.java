package com.app.dao;

import com.app.pojos.Address;

public interface IAddressDao {
//add a method to save address details , linked to a student
	String assignAddressDetails(int studentId,Address a);
}
