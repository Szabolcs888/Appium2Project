package com.myappium2project.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Base class for all page objects in the framework.
 * <p>
 * Provides a pre-configured {@link Logger} instance for each concrete page class.
 */
public class BasePageClass {
    protected final Logger LOG;

    public BasePageClass() {
        LOG = LogManager.getLogger(this.getClass());
    }
}