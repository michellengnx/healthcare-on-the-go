package interface_adapter;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class ViewModelTest {

    // A concrete implementation of the abstract ViewModel for testing
    private static class TestViewModel extends ViewModel {
        public TestViewModel(String viewName) {
            super(viewName);
        }

        @Override
        public void firePropertyChanged() {
            // Implementation not needed for this test
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
            // Implementation not needed for this test
        }
    }

    @Test
    void getViewName() {
        // Arrange
        String expectedViewName = "TestView";
        TestViewModel testViewModel = new TestViewModel(expectedViewName);

        // Act
        String actualViewName = testViewModel.getViewName();

        // Assert
        assertEquals(expectedViewName, actualViewName);
    }


    // Additional tests for the abstract methods can be added as needed.
}
