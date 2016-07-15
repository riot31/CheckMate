package com.springapp.mvc.service.util;

import com.springapp.mvc.service.enums.Notations;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by o.lutsevich on 24.1.16.
 */
public class MessageUtils {
    private static final String DEFAULT_RESOURCE_BUNDLE = "i18n/messages";
    private static final String UNRESOLVED_MESSAGE_FORMAT = "???%s???";
    private static final String FORMAT_MESSAGE_STROKE = " походил с %s на %s";
    private static final Integer COUNT_COORDINATE = 2;
    private static final String REGEX_MESSAGE_STROKE = " ";


    public static String getMessage(String key, Object[] params, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }

        ResourceBundle bundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_BUNDLE, locale, new EncodingResourceBundleControl("UTF-8"));
        String text;

        try {
            text = bundle.getString(key);
            if (params != null) {
                text = new MessageFormat(text, locale).format(params, new StringBuffer(), null).toString();
            }

        } catch (MissingResourceException e) {
            text = String.format(UNRESOLVED_MESSAGE_FORMAT, key);
        }
        return text;
    }

    public static String getMessage(String key) {
        return getMessage(key, null, null);
    }

    public static String castToStroke(String message) {
        String[] tempList = message.split(REGEX_MESSAGE_STROKE);
        if (tempList.length == COUNT_COORDINATE) {
            String result = FORMAT_MESSAGE_STROKE;
            return String.format(result, Notations.positionOf(tempList[0]).name(), Notations.positionOf(tempList[1]).name());
        }
        return UNRESOLVED_MESSAGE_FORMAT;
    }
}

