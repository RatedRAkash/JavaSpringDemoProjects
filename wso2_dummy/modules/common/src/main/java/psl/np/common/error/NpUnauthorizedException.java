package psl.np.common.error;

public class NpUnauthorizedException extends NpException {

    private static final long serialVersionUID = 1L;

    public NpUnauthorizedException(int code) {
        this(code, "Unauthorized");
    }

    public NpUnauthorizedException(String message) {
        this(4011, message);
    }

    public NpUnauthorizedException(int code, String message) {
        super(401, code, message);
    }
}
