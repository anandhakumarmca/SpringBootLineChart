<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Student Application Line Chart</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <h1>Student Application Line-Chart</h1>
    <canvas id="lineChart" width="800" height="400"></canvas>
    <script th:inline="javascript">
        var years = [2015,2016,2017,2018,2019,2020,2021,2022,2023];
        var counts = [2,4,5,3,2,1,3,2,1];

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
