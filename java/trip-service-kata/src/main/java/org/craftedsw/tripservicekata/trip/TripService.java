package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = getLoggedUser();
		if (loggedUser != null) {
			return getTrips(user, loggedUser);
		} else {
			throw new UserNotLoggedInException();
		}
	}

	private List<Trip> getTrips(User user, User loggedUser) {
		if (isFriend(user, loggedUser)) {
			return findTripsByUser(user);
		}
		return new ArrayList<Trip>();
	}

	private boolean isFriend(User user, User loggedUser) {
		for (User friend : user.getFriends()) {
			if (friend.equals(loggedUser)) {
				return true;
			}
		}
		return false;
	}

	protected List<Trip> findTripsByUser(User user) {
		return TripDAO.findTripsByUser(user);
	}

	protected User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}
	
}
