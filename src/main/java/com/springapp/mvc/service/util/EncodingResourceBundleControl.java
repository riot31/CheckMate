package com.springapp.mvc.service.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by o.lutsevich on 24.1.16.
 */
public class EncodingResourceBundleControl extends ResourceBundle.Control {
    private final String encoding;

    private final static Logger log = Logger.getLogger(EncodingResourceBundleControl.class.getName());

    public EncodingResourceBundleControl(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
        String bundleName = toBundleName(baseName, locale);
        String resourceName = toResourceName(bundleName, "properties");
        URL resourceURL = loader.getResource(resourceName);
        if (resourceURL != null) {
            try {
                return new PropertyResourceBundle(new InputStreamReader(resourceURL.openStream(), encoding));
            } catch (Exception z) {
                log.log(Level.FINE, "exception thrown during bundle init", z);
            }
        }

        return super.newBundle(baseName, locale, format, loader, reload);
    }
}