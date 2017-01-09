package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.junit.Test;

public class UserSessionTest {
	
	@Test(expected=CollaboratorCallException.class)
	public void should_throw_exception_if_getLoggedUser_call(){
		UserSession.getInstance().getLoggedUser();
	}

}
