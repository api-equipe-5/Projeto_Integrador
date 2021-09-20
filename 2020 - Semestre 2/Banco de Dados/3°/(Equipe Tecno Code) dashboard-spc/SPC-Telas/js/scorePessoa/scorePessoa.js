$(function() {

  loadScore();
  
  function loadScore() {
    
    var endpoint = "http://localhost:9000/pagamentos/10076016675";

    $.getJSON(endpoint, function(data) {
        
    }).done(function(data) {
      window.feed = function(callback) {
        var tick = {};
        callback(JSON.stringify(data));
        };
    
        var myConfig = {
        type: "gauge",
        globals: {
          fontSize: 15
        },
        plotarea: {
          marginTop: 50
        },
        plot: {
          size: '100%',
          valueBox: {
            placement: 'center',
            text: '%v', //default
            fontSize: 15,
            rules: [{
                rule: '%v >= 718',
                text: '%v<br>Ótimo'
              },
              {
                rule: '%v < 718 && %v > 618',
                text: '%v<br>Bom'
              },
              {
                rule: '%v < 619 && %v > 525',
                text: '%v<br>Regular'
              },
              {
                rule: '%v < 526 && %v > 375',
                text: '%v<br>Ruim'
              },
              {
                rule: '%v <  375',
                text: '%v<br>Muito ruim'
              },
            ]
          }
        },
        tooltip: {
          borderRadius: 5
        },
        scaleR: {
          aperture: 180,
          minValue: 0,
          maxValue: 1000,
          center: {
            visible: false
          },
          tick: {
            visible: false
          },
          item: {
            offsetR: 0,
            rules: [{
              rule: '%i == 9',
              offsetX: 15
            }]
          },
          ring: {
            size: 50,
            rules: [{
                rule: '%v <= 375',
                backgroundColor: '#FF0000'
              },
              {
                rule: '%v > 375 && %v < 525',
                backgroundColor: '#FFA500'
              },
              {
                rule: '%v > 525 && %v < 618',
                backgroundColor: '#FFFF00'
              },
              {
                rule: '%v >= 618 && %v < 717',
                backgroundColor: '#00FF00'
              },
              {
                rule: '%v >= 717',
                backgroundColor: '#008000'
              }
            ]
          }
        },
        series: [{
          values: [data.score], // starting value
          backgroundColor: 'black',
          indicator: [4, 4, 10, 10, 0.5],
          animation: {
            effect: 2,
            method: 1,
            sequence: 4,
            speed: 900
          },
        }]
        };
    
        zingchart.render({
        id: 'myChart',
        data: myConfig,
        height: 198,
        width: 383
        });
      });
  

    
  }
 

});