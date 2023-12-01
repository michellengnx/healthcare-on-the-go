package view;

import data_access.FileRequestDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewRequest.ViewRequestController;
import interface_adapter.ViewRequest.ViewRequestPresenter;
import interface_adapter.ViewRequest.ViewRequestState;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.ViewRequest.ViewRequestInteractor;
import use_case.ViewRequest.ViewRequestOutputData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ViewRequestsView extends JFrame implements ActionListener {
    private final String viewName = "Request History";
    private final ViewRequestViewModel viewRequestViewModel;
    private final ViewRequestController requestController;

    private JButton homeButton;
    private JTable table;
    private JScrollPane scrollPane;


    private JPanel buttonPanel;
    public ViewRequestsView(ViewRequestViewModel viewRequestViewModel, ViewRequestController requestController){
        this.requestController = requestController;
        this.viewRequestViewModel = viewRequestViewModel;
        ViewRequestState state = viewRequestViewModel.getViewRequestState();
        this.setLayout(new BorderLayout());

        this.buttonPanel = new JPanel();
        this.homeButton = new JButton("home");
        this.homeButton.addActionListener(this);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(homeButton);






        JLabel title = new JLabel("Request History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<String> userName = state.getUserName();
        ArrayList<String> doctorNames = state.getDoctorNames();
        ArrayList<String> creationTime = state.getDoctorNames();
        ArrayList<String> services = state.getServices();
        ArrayList<String> destinations = state.getDestinations();
        ArrayList<Integer> urgencies = state.getUrgencies();
        ArrayList<Float> etas = state.getEtas();
        ArrayList<Float> distances = state.getDistances();
        ArrayList<Boolean> completed = state.getCompleted();

        // Create data for the table
        int size = userName.size();
        String[][] data = new String[size][9];

        for (int i = 0; i < size; i++) {
            data[i][0] = userName.get(i);
            data[i][1] = doctorNames.get(i);
            data[i][2] = creationTime.get(i);
            data[i][3] = String.valueOf(urgencies.get(i));
            data[i][4] = destinations.get(i);
            data[i][5] = services.get(i);
            data[i][6] = String.valueOf(etas.get(i));
            data[i][7] = String.valueOf(distances.get(i));
            data[i][8] = String.valueOf(completed.get(i));
        }

        // Column headers
        String[] headers = {"UserName", "DoctorNames", "CreationTime", "Urgency", "Destinations",
                "Services", "ETAs", "Distances", "Completed"};

        // Create a table model with the data and headers
        DefaultTableModel model = new DefaultTableModel(data, headers);

        // Create JTable with the model
        this.table = new JTable(model);

        this.setSize(800, 600);
        // Add table to a scroll pane
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        this.add(buttonPanel,BorderLayout.SOUTH);

        setVisible(true);


    }
    public static void main(String[] args) throws IOException {
        FileRequestDataAccessObject fileRequestDataAccessObject = new FileRequestDataAccessObject("/Users/ismaelchona/IdeaProject/csc207-project/src/main/java/data/requests.csv");


        ArrayList<ArrayList<String>> data = fileRequestDataAccessObject.getRequestUser("patient1");
        // Example instantiation of ViewRequestViewModel
        ViewRequestViewModel viewModel = new ViewRequestViewModel();
        viewModel.setViewRequestState(new ViewRequestState(data));
        ViewRequestPresenter viewRequestPresenter = new ViewRequestPresenter(new ViewManagerModel(),viewModel);


        ViewRequestOutputData viewRequestOutputData = new ViewRequestOutputData(data);
        ViewRequestInteractor viewRequestInteractor = new ViewRequestInteractor(fileRequestDataAccessObject,viewRequestPresenter);


        ViewRequestController viewRequestController = new ViewRequestController(viewRequestInteractor);

        SwingUtilities.invokeLater(() -> {
            ViewRequestsView view = new ViewRequestsView(viewModel, viewRequestController); // Assuming null for RequestController
           // Fetch and display the data
        });





    }


    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("nuts");

    }
}
