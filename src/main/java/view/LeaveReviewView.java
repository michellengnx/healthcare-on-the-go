package view;

import interface_adapter.LeaveReview.LeaveReviewController;
import interface_adapter.LeaveReview.LeaveReviewViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


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
