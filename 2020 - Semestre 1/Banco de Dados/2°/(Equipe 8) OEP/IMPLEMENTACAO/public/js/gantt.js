google.charts.load('current', {'packages':['gantt']});
google.charts.setOnLoadCallback(function () {
    drawChart1();
    drawChart2();
});


function drawChart1() {
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Task ID');
    data.addColumn('string', 'Task Name');
    data.addColumn('string', 'Resource');
    data.addColumn('date', 'Start Date');
    data.addColumn('date', 'End Date');
    data.addColumn('number', 'Duration');
    data.addColumn('number', 'Percent Complete');
    data.addColumn('string', 'Dependencies');

    data.addRows([
        ['Sprint', 'Sprint', null,
        new Date(2020, 6, 1), new Date(2020, 6, 12), null, 100, null],
        ['Plan', 'Planejamento', null,
        new Date(2020, 6, 1), new Date(2020, 6, 2), null, 100, null],
        ['Develop', 'Desenvolvimento do Código', null,
        new Date(2020, 6, 2), new Date(2020, 6, 10), null, 100, 'Plan'],
        ['Review', 'Revisão', null,
        new Date(2020, 6, 10), new Date(2020, 6, 11), null, 100, 'Develop'],
        ['Retro', 'Retrospectiva', null,
        new Date(2020, 6, 11), new Date(2020, 6, 12), null, 100, 'Review']
    ]);

    var options = {
        height: 400,
        gantt: {
        trackHeight: 30
        }
    };

    var chart = new google.visualization.Gantt(document.getElementById('chart_div'));

    chart.draw(data, options);
}

function drawChart2() {

    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Task ID');
    data.addColumn('string', 'Task Name');
    data.addColumn('string', 'Resource');
    data.addColumn('date', 'Start Date');
    data.addColumn('date', 'End Date');
    data.addColumn('number', 'Duration');
    data.addColumn('number', 'Percent Complete');
    data.addColumn('string', 'Dependencies');

    data.addRows([
        ['Vep', 'VEP', null,
        new Date(2020, 5, 4), new Date(2020, 7, 10), null, 100, null],
        ['Interface', 'Criação de interface da aplicação', null,
        new Date(2020, 5, 4), new Date(2020, 5, 15), null, 100, null],
        ['Priorities', 'Priorização de Requisitos', null,
        new Date(2020, 5, 4), new Date(2020, 5, 15), null, 100, null],
        ['Backlog', 'Backlog do Produto', null,
        new Date(2020, 5, 4), new Date(2020, 5, 15), null, 100, null],
        ['Formularios', 'Criar formulários de cadastro', null,
        new Date(2020, 5, 18), new Date(2020, 5, 29), null, 100, 'Interface'],
        ['Consulta', 'Criar telas de consulta', null,
        new Date(2020, 5, 18), new Date(2020, 5, 29), null, 100, 'Interface'],
        ['Gantt', 'Diagrama de Gantt', null,
        new Date(2020, 6, 1), new Date(2020, 6, 12), null, 100, 'Formularios'],
        ['Database', 'Armazenar informações em um banco de dados', null, new Date(2020, 6, 15), new Date(2020, 6, 26), null, 100, 'Gantt'],
        ['Authentication', 'Criar uma autenticação para o programa', null, new Date(2020, 6, 27), new Date(2020, 7, 10), null, 100, 'Database'],
    ]);

    var options = {
        height: 400,
        gantt: {
        trackHeight: 30
        }
    };

    var chart = new google.visualization.Gantt(document.getElementById('chart_div2'));

    chart.draw(data, options);
}

function mostra(id) {
    var elem = document.getElementById(id); 
    elem.style.display = (elem.style.display == 'block') ? 'none':'block';
}