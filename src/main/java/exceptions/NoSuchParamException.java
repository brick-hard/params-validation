package exceptions;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

/**
 * desc:
 *
 * @author ljf
 * date: 2021/7/26
 */
public class NoSuchParamException extends ValueException {

    public NoSuchParamException(String message) {
        super(message);
    }

    public NoSuchParamException(String message, String str) {
        super(message.replaceAll("%n", str));
    }

}
