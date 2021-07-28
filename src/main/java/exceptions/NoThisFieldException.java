package exceptions;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * desc:
 *
 * @author ljf
 * date: 2021/7/26
 */
public class NoThisFieldException extends ValueException {
    public NoThisFieldException(String message) {
        super(message);
    }

    public NoThisFieldException(String message, String str) {
        super(message.replaceAll("%n", str));
    }
}
