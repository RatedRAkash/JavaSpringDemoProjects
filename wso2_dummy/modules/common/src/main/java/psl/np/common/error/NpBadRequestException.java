package psl.np.common.error;

public class NpBadRequestException extends NpException {

    private static final long serialVersionUID = 1L;

    public NpBadRequestException(int code) {
        this(code, "Invalid request");
    }

    public NpBadRequestException(String message) {
        this(4000, message);
    }

    public NpBadRequestException(int code, String message) {
        super(400, code, message);
    }
}
