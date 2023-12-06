package use_case.Lock;

/**
 * Defines the output boundary contract for the locking operation.
 * Implementations handle the preparation of a successful view after a locking operation.
 */

public interface LockOutputBoundary {
    public void prepareSuccessView(String viewName);
}
