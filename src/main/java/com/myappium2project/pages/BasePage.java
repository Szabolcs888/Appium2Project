package com.myappium2project.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    protected final Logger LOG;

    public BasePage() {
        LOG = LogManager.getLogger(this.getClass());
    }
}