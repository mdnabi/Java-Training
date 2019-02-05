package com.lti.training.dao;

import java.util.List;

import com.lti.training.main.CarPart;

public interface CarPartsDao {
	
	public void addNewPart(CarPart carPart);
	public List<CarPart> getAvailableParts();
	
}
