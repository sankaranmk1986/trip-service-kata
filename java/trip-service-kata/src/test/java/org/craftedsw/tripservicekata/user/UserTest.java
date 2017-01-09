package org.craftedsw.tripservicekata.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.Test;

public class UserTest {
	
	@Test
	public void should_return_1_trip_if_1_trip_added(){
		User user = new User();
		user.addTrip(new Trip());
		assertThat(user.trips().size(), is(1));		
	}
	
	@Test
	public void should_return_1_friend_if_1_friend_added(){
		User user = new User();
		user.addFriend(new User());
		assertThat(user.getFriends().size(), is(1));		
	}
}
