package view;

import entities.Service;
import interface_adapter.CreateRequest.CreateRequestController;
import interface_adapter.CreateRequest.CreateRequestState;
import interface_adapter.CreateRequest.CreateRequestViewModel;
import interface_adapter.LeaveReview.LeaveReviewController;
import interface_adapter.LeaveReview.LeaveReviewViewModel;
import interface_adapter.ReturnHome.ReturnHomeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

/**
 * View that displays the necessary interface for a patient create a new request, and a way to return to the home
 * screen.
 */
public class LeaveReviewView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "leave review";

    private final Integer[] stars = {1, 2, 3, 4, 5};

    public LeaveReviewView(LeaveReviewController leaveReviewController,
                           LeaveReviewViewModel leaveReviewViewModel) {
        leaveReviewViewModel.addPropertyChangeListener(this);

        // screen title
        JLabel title = new JLabel(leaveReviewViewModel.RATE_ORDER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
