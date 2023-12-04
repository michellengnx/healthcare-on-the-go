package interface_adapter.SignUp;

public class SignUpState {
    private String error = null;

    public SignUpState() {

    }

    public SignUpState(SignUpState copy) {
        this.error = copy.error;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getCreateRequestError() {
        return this.error;
    }
}
