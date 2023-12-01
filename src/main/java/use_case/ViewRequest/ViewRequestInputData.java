package use_case.ViewRequest;

public class ViewRequestInputData {
    public String getUserName() {
        return userName;
    }

    private String userName;
    public ViewRequestInputData(String userName){
        this.userName = userName;

    }
}
