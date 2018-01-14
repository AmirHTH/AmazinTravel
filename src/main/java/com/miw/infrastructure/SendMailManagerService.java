package com.miw.infrastructure;

import impl.miw.infrastructure.SendMailManager;

public interface SendMailManagerService {
	public boolean sendMail(String to);
}
