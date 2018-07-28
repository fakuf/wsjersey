package com.ws.serviceimp;

import com.ws.iservice.IPersonaService;

public class FactoryService {
	
	public static IPersonaService getPersonaService() {
		return new PersonaServiceImp();
	}
}
