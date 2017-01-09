package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {
	
	private TripDAO tripDAO; 
	
	public TripService(TripDAO tripDAO){
		this.tripDAO = tripDAO;
	}

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		return getTrips(user);		
	}

	private List<Trip> getTrips(User user) {
		if (isFriend(user)) {
			return findTripsByUser(user);
		}
		return new ArrayList<Trip>();
	}

	private boolean isFriend(User user) {
		User loggedUser = getLoggedUser();
		for (User friend : user.getFriends()) {
			if (friend.equals(loggedUser)) {
				return true;
			}
		}
		return false;
	}

	protected List<Trip> findTripsByUser(User user) {
		return tripDAO.findTripsByUser(user);
	}

	protected User getLoggedUser() throws UserNotLoggedInException{
		return UserSession.getInstance().getLoggedUser();
	}
	
}
