
package use_case.LockScreen;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LockScreenInteractorTest {

    /**
     * Test the LockScreenInteractor executes successfully.
     */
    @Test
    void successTest() {
        // Mock the presenter
        LockScreenOutputBoundary lockScreenPresenter = mock(LockScreenOutputBoundary.class);

        // Create the interactor
        LockScreenInputBoundary interactor = new LockScreenInteractor(lockScreenPresenter);

        // Execute the use case with a view name
        interactor.execute("SampleView");

        // Verify that the presenter's prepareSuccessView method was called with the correct view name
        verify(lockScreenPresenter).prepareSuccessView("SampleView");
    }
}
