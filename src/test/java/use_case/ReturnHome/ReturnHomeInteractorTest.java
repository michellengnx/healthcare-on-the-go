package use_case.ReturnHome;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ReturnHomeInteractorTest {

    /**
     * Test the ReturnHomeInteractor executes successfully.
     */
    @Test
    void successTest() {
        // Mock the presenter
        ReturnHomeOutputBoundary returnHomePresenter = mock(ReturnHomeOutputBoundary.class);

        // Create the interactor
        ReturnHomeInputBoundary interactor = new ReturnHomeInteractor(returnHomePresenter);

        // Execute the use case
        interactor.execute();

        // Verify that the presenter's prepareSuccessView method was called
        verify(returnHomePresenter).prepareSuccessView();
    }
}
