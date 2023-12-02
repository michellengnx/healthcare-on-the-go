package interface_adapter.LeaveReview;

import entities.Patient;
import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class LeaveReviewViewModel extends ViewModel {
    public final String RATE_ORDER = "Rate Order";
    public final String DOCTOR_NAME = "Choose Doctor to Rate";
    public final String STARS = "Rate Service";
    public final String REVIEW_MESSAGE = "Leave a Review Message";
    public final String COMPLETE_BUTTON = "Submit";
    private LeaveReviewState state;

    public LeaveReviewViewModel() {
        super("Leave Review");
        this.state = new LeaveReviewState();
    }
    public void setState(LeaveReviewState state) {this.state = state;}

    public LeaveReviewState getState() {
        return state;
    }


    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}







