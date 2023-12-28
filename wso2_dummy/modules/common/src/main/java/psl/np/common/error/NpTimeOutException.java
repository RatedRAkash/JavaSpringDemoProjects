package psl.np.common.error;

public class NpTimeOutException extends NpException {

    private static final long serialVersionUID = 1L;

    public NpTimeOutException() {
        this(5040, "Service call timeout");
    }

    public NpTimeOutException(int code) {
        this(code, "Service call timeout");
    }

    public NpTimeOutException(String message) {
        this(5040, message);
    }

    public NpTimeOutException(int code, String message) {
        super(504, code, message);
    }
}
