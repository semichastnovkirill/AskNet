package org.communis.asknet.exceptions.error;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeConstants {

    public static final Map<ErrorCodeIdentifier, String> messages = new HashMap<>();

    public static final ErrorCodeIdentifier CONFIGURE = new ErrorCodeIdentifier("10");
    public static final ErrorCodeIdentifier CONFIGURE_LIST_ERROR = CONFIGURE.branch("1");
    public static final ErrorCodeIdentifier CONFIGURE_INFO_ERROR = CONFIGURE.branch("2");
    public static final ErrorCodeIdentifier CONFIGURE_ADD_ERROR = CONFIGURE.branch("3");
    public static final ErrorCodeIdentifier CONFIGURE_UPDATE_ERROR = CONFIGURE.branch("4");
    public static final ErrorCodeIdentifier CONFIGURE_PARSE_ERROR = CONFIGURE.branch("5");
    public static final ErrorCodeIdentifier VIEW = new ErrorCodeIdentifier("11");
    public static final ErrorCodeIdentifier VIEW_BUILD_ERROR = VIEW.branch("1");

    static {
        messages.put(CONFIGURE_LIST_ERROR, "Ошибка при получении реестра конифгураций");
        messages.put(CONFIGURE_INFO_ERROR, "Ошибка при получении конфигурации");
        messages.put(CONFIGURE_ADD_ERROR, "Ошибка при добавлении конфигурации");
        messages.put(CONFIGURE_UPDATE_ERROR, "Ошибка при изменении конфигурации");
        messages.put(CONFIGURE_PARSE_ERROR, "Ошибка парсинга конфигурации");

        messages.put(VIEW_BUILD_ERROR, "Ошибка построения представления");
    }
}
