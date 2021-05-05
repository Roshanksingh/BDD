package com.urbanFindr.commons.configuration.sections;

import com.urbanFindr.commons.configuration.enums.BrowserType;
import com.urbanFindr.commons.configuration.enums.OperatingSystem;

public class DriverDetails {
    public static boolean isHeadless;
    public static boolean shouldHighlightElement;
    public static String highlightColor;
    public static BrowserType browserType;
    public static OperatingSystem os;
    public static boolean isIncognito;
    public static boolean verbose;
}
