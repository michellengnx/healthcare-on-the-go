
package use_case.LockScreen;

import org.junit.jupiter.api.Test;
import use_case.LockView.LockInputBoundary;
import use_case.LockView.LockInteractor;
import use_case.LockView.LockOutputBoundary;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LockScreenInteractorTest {

    /**
     * Test the LockScreenInteractor executes successfully.
     */
    @Test
    void successTest() {
        // Mock the presenter
        LockOutputBoundary lockScreenPresenter = mock(LockOutputBoundary.class);

        // Create the interactor
        LockInputBoundary interactor = new LockInteractor(lockScreenPresenter);

        // Execute the use case with a view name
        interactor.execute("SampleView");

        // Verify that the presenter's prepareSuccessView method was called with the correct view name
        verify(lockScreenPresenter).prepareSuccessView("SampleView");
    }
}
