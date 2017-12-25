package com.miw.persistence;


public interface PersistenceFactory {
	public BookDataService getBookDataService();

	public IvaDataService getIvaDataService();
}
