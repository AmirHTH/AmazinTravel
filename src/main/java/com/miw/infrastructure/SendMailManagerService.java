package com.miw.infrastructure;

import com.miw.model.Billete;

public interface SendMailManagerService {
	public boolean sendMail(String to, Billete billete);
}
