package com.crs.lt.dao;

import java.util.UUID;

import com.crs.lt.beans.Payment;

public interface PaymentDao {

	void save(Payment payment);

	Payment getPaymentByUserId(UUID userId);
}
