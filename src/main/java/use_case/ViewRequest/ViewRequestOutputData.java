package use_case.ViewRequest;

import java.util.ArrayList;

public class ViewRequestOutputData {
    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    private final ArrayList<ArrayList<String>> data;

    public ViewRequestOutputData(ArrayList<ArrayList<String>> data){
        this.data = data;
    }
}
