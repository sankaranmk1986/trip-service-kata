package org.craftedsw.tripservicekata.trip;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
public class TripServiceTest {
	
	private TripServiceMock tripService;
	private User friend;
	
	@Mock
	private TripDAO tripDAO;
	
	@Before
	public void setup(){
		tripService = new TripServiceMock(tripDAO);
		friend = new User();
	}
	
	@Test
	public void should_return_trips_for_valid_user(){
		assertThat(tripService.getTripsByUser(createUser()).size(), is(1));
	}
	
	@Test(expected=UserNotLoggedInException.class)
	public void should_throw_exception_for_not_logged_user(){
		TripServiceNotLoggedIn tripServiceNotLoggedIn = new TripServiceNotLoggedIn(tripDAO);
		tripServiceNotLoggedIn.getTripsByUser(createUser());
	}

	private User createUser() {
		User user = new User();		
		user.addFriend(friend);
		user.addTrip( new Trip());
		return user;
	}
		
	private class TripServiceMock extends TripService{
		public TripServiceMock(TripDAO tripDAO) {
			super(tripDAO);
		}

		@Override
		protected List<Trip> findTripsByUser(User user) {
			return asList(new Trip());
		}
		
		@Override
		protected User getLoggedUser() {
			return friend;
		}
	}
	
	private class TripServiceNotLoggedIn extends TripService{
				
		public TripServiceNotLoggedIn(TripDAO tripDAO) {
			super(tripDAO);
		}

		@Override
		protected User getLoggedUser() {
			return null;
		}
	}
	
}
