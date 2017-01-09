package org.craftedsw.tripservicekata.trip;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;
public class TripServiceTest {
	
	private TripServiceMock tripService;
	private User friend;
	
	@Before
	public void setup(){
		tripService = new TripServiceMock();
		friend = new User();
	}
	
	@Test
	public void should_return_trips_for_valid_user(){
		assertThat(tripService.getTripsByUser(createUser()).size(), is(1));
	}

	private User createUser() {
		User user = new User();		
		user.addFriend(friend);
		user.addTrip( new Trip());
		return user;
	}
		
	private class TripServiceMock extends TripService{
		@Override
		protected List<Trip> findTripsByUser(User user) {
			return asList(new Trip());
		}
		
		@Override
		protected User getLoggedUser() {
			return friend;
		}
	}
	
}
