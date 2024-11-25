package com.myappium2project.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ListUtils {

    public static void addUniqueItemsToStringList(List<String> targetList, List<WebElement> webElements) {
        for (WebElement item : webElements) {
            String elementAttributeText = item.getText();
            if (!targetList.contains(elementAttributeText)) {
                targetList.add(elementAttributeText);
            }
        }
    }

    public static void addUniqueItemsToFloatList(List<Float> targetList, List<WebElement> webElements) {
        for (WebElement item : webElements) {
            float elementAttributeTextAsFLoat = Float.parseFloat(item.getText().substring(1));
            if (!targetList.contains(elementAttributeTextAsFLoat)) {
                targetList.add(elementAttributeTextAsFLoat);
            }
        }
    }
}