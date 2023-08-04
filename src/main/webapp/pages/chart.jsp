<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Application Line Chart</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

    <h1>Student Application Line Chart</h1>
    <canvas id="lineChart" width="800" height="400"></canvas>
    <script>
    var years = [];
    var counts = [];
    
    <%
    List<Map<String, Object>> applicationCounts = (List<Map<String, Object>>) request.getAttribute("applicationCounts");
    for (Map<String, Object> row : applicationCounts) {
        String applicationDate = row.get("applicationDate").toString();
        int count = ((Number) row.get("count")).intValue();
    %>
        years.push(<%= applicationDate.substring(0, 4) %>);
        counts.push(<%= count %>);
    <%
    }
    %>

        var ctx = document.getElementById('lineChart').getContext('2d');
        var myLineChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: years,
                datasets: [{
                    label: 'Number of Students Applied',
                    data: counts,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderWidth: 1
                }]
            },
            options: {
                responsive: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>
</body>
</html>
