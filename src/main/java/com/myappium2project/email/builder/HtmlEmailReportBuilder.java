package com.myappium2project.email.builder;

import com.myappium2project.email.models.TestResult;

import java.util.List;

/**
 * Utility class for generating a simple HTML-formatted automated test report
 * intended for email delivery (e.g. via SendGrid).
 * <p>
 * The report includes suite summary statistics and a styled table of individual test results.
 */
public class HtmlEmailReportBuilder {

    private HtmlEmailReportBuilder() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Builds an HTML-formatted test report summarizing the results of a test suite.
     *
     * @param startTime the formatted start time of the test run
     * @param endTime   the formatted end time of the test run
     * @param suiteName the name of the test suite being reported
     * @param results   a list of individual {@link TestResult} objects
     * @return an HTML string representing the complete email report body
     */
    public static String buildReport(String startTime, String endTime, String suiteName, List<TestResult> results) {
        int total = results.size();
        long passed = results.stream().filter(r -> r.getStatus().equalsIgnoreCase("PASS")).count();
        long failed = results.stream().filter(r -> r.getStatus().equalsIgnoreCase("FAIL")).count();
        long skipped = results.stream().filter(r -> r.getStatus().equalsIgnoreCase("SKIP")).count();

        double totalDurationInSeconds = results.stream()
                .mapToDouble(TestResult::getDurationSeconds)
                .sum();

        double averageDuration = results.isEmpty() ? 0.0 : totalDurationInSeconds / results.size();

        String totalFormatted = String.format("%.2f s", totalDurationInSeconds);
        String averageFormatted = String.format("%.2f s", averageDuration);

        StringBuilder html = new StringBuilder();

        html.append("<html><head><style>")
                .append("body { font-family: Arial, sans-serif; }")
                .append("table { border-collapse: collapse; width: 100%; margin-top: 20px; }")
                .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                .append("th { background-color: #E8EDDE; color: #333; }")

                .append(".stats-table { width: 40%; margin-top: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-collapse: collapse; }")
                .append(".stats-table th, .stats-table td { border: 1px solid #ccc; padding: 8px; text-align: center; }")
                .append(".stats-table th { width: 25%; }")
                .append(".pass { color: green; }")
                .append(".fail { color: red; }")
                .append(".skip { color: orange; }")

                .append(".result-table th { background-color: #4CAF50; color: white; }")
                .append("th.suite-header { background-color: #E7F5E5 !important; color: #222; font-weight: bold; text-align: center; padding: 8px; font-size: 1.1em; }") // Suite fejléc tulajdonságai
                .append(".result-table th.class-column { width: 35%; }")
                .append(".result-table th.test-column { width: 35%; }")
                .append(".result-table th.status-column, .result-table td.status-column { width: 15%; }")
                .append(".result-table th.duration-column, .result-table td.duration-column { width: 15%; }")

                .append("</style></head><body>");

        html.append("<h2>Automated Test Report</h2>");

        html.append("<p><strong>Start:</strong>&nbsp;").append(startTime)
                .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Total duration:</strong> ").append(totalFormatted)
                .append("<br>&nbsp;<strong>End:</strong>&nbsp;").append(endTime)
                .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Average per test:</strong> ").append(averageFormatted).append("</p>");

        html.append("<table class='stats-table'>")
                .append("<tr>")
                .append("<th>Total</th><th>Passed</th><th>Failed</th><th>Skipped</th>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>").append(total).append("</td>")
                .append("<td class='pass'>").append(passed).append("</td>")
                .append("<td class='fail'>").append(failed).append("</td>")
                .append("<td class='skip'>").append(skipped).append("</td>")
                .append("</tr>")
                .append("</table>");

        html.append("<table class='result-table'>")
                .append("<tr><th colspan='4' class='suite-header'>").append(suiteName).append("</th></tr>") // suite név teljes szélességben
                .append("<tr>")
                .append("<th class='class-column'>Class</th>")
                .append("<th class='test-column'>Test Name</th>")
                .append("<th class='status-column'>Status</th>")
                .append("<th class='duration-column'>Duration</th>")
                .append("</tr>");

        for (TestResult result : results) {
            String statusClass = switch (result.getStatus().toUpperCase()) {
                case "PASS" -> "pass";
                case "FAIL" -> "fail";
                case "SKIP" -> "skip";
                default -> "";
            };

            html.append("<tr>")
                    .append("<td class='class-column'>").append(result.getClassName()).append("</td>")
                    .append("<td class='test-column'>").append(result.getName()).append("</td>")
                    .append("<td class='status-column ").append(statusClass).append("'>").append(result.getStatus()).append("</td>")
                    .append("<td class='duration-column'>").append(result.getDurationFormatted()).append("</td>")
                    .append("</tr>");
        }

        html.append("</table></body></html>");

        return html.toString();
    }
}