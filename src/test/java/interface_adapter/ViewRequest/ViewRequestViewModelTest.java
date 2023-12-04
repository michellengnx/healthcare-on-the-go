//package interface_adapter.ViewRequest;
//
//import interface_adapter.ViewRequest.ViewRequestState;
//import interface_adapter.ViewRequest.ViewRequestViewModel;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ViewRequestViewModelTest {
//
//    private ViewRequestViewModel viewModel;
//
//    @BeforeEach
//    public void setUp() {
//        viewModel = new ViewRequestViewModel();
//    }
//
//    @Test
//    public void testInitialState() {
//        // Ensure that the initial state is as expected
//        ViewRequestState initialState = viewModel.getViewRequestState();
//        assertNotNull(initialState);
//        // Add more assertions based on the expected initial state of your application
//    }
//
//    @Test
//    public void testSetState() {
//        // Test setting a new state and check if it triggers property change
//        ViewRequestState newState = new ViewRequestState();
////        newState.setUserName("michelle");
//        viewModel.setState(newState);
//
//        ViewRequestState updatedState = viewModel.getViewRequestState();
//        assertSame(newState, updatedState);
//
//        // Add more assertions based on the expected behavior
//    }
//
//    @Test
//    public void testPropertyChange() {
//        // Test if property change is triggered when the state is updated
//        MockPropertyChangeListener listener = new MockPropertyChangeListener();
//        viewModel.addPropertyChangeListener(listener);
//
//        ViewRequestState newState = new ViewRequestState();
//        newState.setUserName(/* set a username */);
//        viewModel.setState(newState);
//
//        assertTrue(listener.propertyChangeCalled);
//        // Add more assertions based on the expected behavior
//    }
//
//    // Define a mock property change listener for testing
//    private static class MockPropertyChangeListener implements PropertyChangeListener {
//        boolean propertyChangeCalled = false;
//
//        @Override
//        public void propertyChange(java.beans.PropertyChangeEvent evt) {
//            propertyChangeCalled = true;
//        }
//    }
//}
