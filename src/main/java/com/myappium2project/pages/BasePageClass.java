package com.myappium2project.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePageClass {
    protected final Logger LOG;

    public BasePageClass() {
        LOG = LogManager.getLogger(this.getClass());
    }
}