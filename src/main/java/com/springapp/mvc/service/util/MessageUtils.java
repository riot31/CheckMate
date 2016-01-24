package com.springapp.mvc.service.util;

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


}

