package com.lti.training.dao;

import java.sql.SQLException;
import java.util.List;

import com.lti.training.exception.DataAccessException;
import com.lti.training.main.CarPart;

public interface CarPartsDao {
	
	public void addNewPart(CarPart carPart) throws DataAccessException;
	public List<CarPart> getAvailableParts();
	
}
