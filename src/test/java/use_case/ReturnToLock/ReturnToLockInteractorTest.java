package use_case.ReturnToLock;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ReturnToLockInteractorTest {

    /**
     * Test the ReturnToLockInteractor executes successfully.
     */
    @Test
    void successTest() {
        // Mock the presenter
        ReturnToLockOutputBoundary returnToLockPresenter = mock(ReturnToLockOutputBoundary.class);

        // Create the interactor
        ReturnToLockInputBoundary interactor = new ReturnToLockInteractor(returnToLockPresenter);

        // Execute the use case
        interactor.execute();

        // Verify that the presenter's prepareSuccessView method was called
        verify(returnToLockPresenter).prepareSuccessView();
    }
}
