package exceptions;

/**
 * Description:
 * Created by lvhw on 2016/8/12 22:33.
 */
public class BiArgException extends Exception {

    public BiArgException() {
    }

    public BiArgException(String message) {
        super(message);
    }

    public BiArgException(String message, Throwable cause) {
        super(message, cause);
    }

    public BiArgException(Throwable cause) {
        super(cause);
    }

}
