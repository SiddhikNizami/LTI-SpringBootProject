package com.crs.lt.daoimpl;

import java.util.UUID;

import com.crs.lt.beans.Payment;
import com.crs.lt.constants.DataCollections;
import com.crs.lt.dao.PaymentDao;

public class PaymentDaoImpl implements PaymentDao{

	@Override
	public void save(Payment payment) {
		DataCollections.payments.add(payment);
	}

	@Override
	public Payment getPaymentByUserId(UUID userId) {
		return DataCollections.payments.stream().filter(payment->payment.getStudentId().equals(userId)).findAny().orElse(null);
		
	}

}
