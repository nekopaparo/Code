(function () {
    const upperLimit = [10, 10, 10, 10, 10];
    const lowerLimit = [6, 6, 6, 6, 6];
    const lastElectricity = [11, 16, 7, 3, 14];
    const Electricity = [5, 10, 11, 8, 7];
    
    const ctx = document.getElementById('myChart_bar').getContext('2d');
    const data = {
        labels: [
          '廚房',
          '客廳',
          '臥室',
          '廁所',
          '淋浴間'
        ],
        datasets: [
        // data1
        {
            type: 'line',
            label: '警戒值',
            data: upperLimit,
            backgroundColor: 'red',
            borderColor: 'red',
            radius: false
        },
        // data2
        {
            type: 'line',
            label: '警戒值',
            data: lowerLimit,
            backgroundColor: 'green',
            borderColor: 'green',
            radius: false
        },
        // data3
        {
          label: '昨日用電量',
          data: lastElectricity,
          backgroundColor: 'rgb(201, 203, 207)',
        },
        // data4
        {
            label: '今日用電量',
            data: Electricity
        }]
      };
    var myBarChart = new Chart(ctx, {
        type: 'bar',
        data: data,
        options: {
            responsive: true,
            plugins: {
                //legend: false,
                legend: {
                    position: 'top', // top | bottom | left | right
                },
                title: {
                    display: true,
                    text: '用電量統計',
                },
                subtitle: {
                    display: true,
                    text: '家裡',
                    color: 'blue',
                    font: {
                        size: 12,
                        family: 'tahoma',
                        weight: 'normal',
                        style: 'italic'
                    }
                }
            },
            elements: {
                bar: {
                  backgroundColor: colorize(true),
                  //borderColor: colorize(true),
                  borderWidth: 2
                }
            }
        }
    });
    // https://www.chartjs.org/docs/latest/samples/scriptable/bar.html
    function colorize() {
        return (ctx) => {
            const v = ctx.parsed.y;
            return v < lowerLimit[ctx.index] ? '0358B6'
                : v <= upperLimit[ctx.index] ? '#44DE28'
                : '#D60000';
        };
    }
}(this));