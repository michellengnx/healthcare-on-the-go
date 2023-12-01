package view;

import data_access.FileRequestDataAccessObject;
import interface_adapter.ViewRequest.RequestController;
import interface_adapter.ViewRequest.ViewRequestViewModel;
import use_case.ViewRequest.ViewRequestUseCase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ViewRequestsView extends JFrame implements ActionListener {
    private final String viewName = "Request History";
    private final ViewRequestViewModel viewRequestViewModel;
    private final RequestController requestController;

    private JButton homeButton;
    private JTable table;
    private JScrollPane scrollPane;

    private JPanel buttonPanel;
    public ViewRequestsView(ViewRequestViewModel viewRequestViewModel, RequestController requestController){
        this.requestController = requestController;
        this.viewRequestViewModel = viewRequestViewModel;
        this.setLayout(new BorderLayout());

        this.buttonPanel = new JPanel();
        this.homeButton = new JButton("home");
        this.homeButton.addActionListener(this);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(homeButton);






        JLabel title = new JLabel("Request History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<String> userName = viewRequestViewModel.getUserName();
        ArrayList<String> doctorNames = viewRequestViewModel.getDoctorNames();
        ArrayList<String> creationTime = viewRequestViewModel.getDoctorNames();
        ArrayList<String> services = viewRequestViewModel.getServices();
        ArrayList<String> destinations = viewRequestViewModel.getDestinations();
        ArrayList<Integer> urgencies = viewRequestViewModel.getUrgencys();
        ArrayList<Float> etas = viewRequestViewModel.getEtas();
        ArrayList<Float> distances = viewRequestViewModel.getDistances();
        ArrayList<Boolean> completed = viewRequestViewModel.getCompleted();

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
        ViewRequestViewModel viewModel = new ViewRequestViewModel(data);
        ViewRequestUseCase viewRequestUseCase = new ViewRequestUseCase(fileRequestDataAccessObject);
        RequestController viewRequestController = new RequestController(viewRequestUseCase);

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
