package psl.np.common.error;

public class NpServiceCallException extends NpException {

    private static final long serialVersionUID = 1L;

    public NpServiceCallException() {
        this(5020, "Service call failed");
    }

    public NpServiceCallException(int code) {
        this(code, "Service call failed");
    }

    public NpServiceCallException(String message) {
        this(5020, message);
    }

    public NpServiceCallException(int code, String message) {
        super(502, code, message);
    }
}
