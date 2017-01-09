package org.craftedsw.tripservicekata.trip;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;
public class TripServiceTest {
	
	private TripService tripService;
	
	@Before
	public void setup(){
		tripService = new TripService();
	}
	
	@Test
	public void should_return_trips_for_valid_user(){
		assertThat(tripService.getTripsByUser(createUser()).size(), is(1));
	}

	private User createUser() {
		User user = new User();
		User friend = new User();
		user.addFriend(friend);
		user.addTrip( new Trip());
		return user;
	}
	
}
