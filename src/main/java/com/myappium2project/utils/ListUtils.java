package com.myappium2project.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Utility class for safely adding unique values extracted from {@link WebElement} objects to existing lists.
 * <p>
 * These methods prevent duplicate entries when building test data collections from UI elements.
 */
public final class ListUtils {

    private ListUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Adds unique text values from a list of {@link WebElement} instances to a target {@code List<String>}.
     *
     * @param targetList  the list to add new unique items to
     * @param webElements the source elements whose text values are evaluated
     */
    public static void addUniqueItemsToStringList(List<String> targetList, List<WebElement> webElements) {
        for (WebElement item : webElements) {
            String elementAttributeText = item.getText();
            if (!targetList.contains(elementAttributeText)) {
                targetList.add(elementAttributeText);
            }
        }
    }

    /**
     * Parses and adds unique float values from a list of {@link WebElement} instances to a target {@code List<Float>}.
     * <p>
     * Assumes each element's text starts with a currency or symbol character (e.g., "$123.45"),
     * and skips the first character before parsing.
     *
     * @param targetList  the list to add new unique float values to
     * @param webElements the source elements whose text values are parsed into floats
     */
    public static void addUniqueItemsToFloatList(List<Float> targetList, List<WebElement> webElements) {
        for (WebElement item : webElements) {
            float elementAttributeTextAsFloat = Float.parseFloat(item.getText().substring(1));
            if (!targetList.contains(elementAttributeTextAsFloat)) {
                targetList.add(elementAttributeTextAsFloat);
            }
        }
    }
}