import React, { useEffect, useState } from 'react';
import { atas } from '../../services/crudata';
import Navbar from '../../components/Navbar/navbar';
import rotarelatorio from '../../components/Navbar/rotarelatorio.json';
import { Bar } from 'react-chartjs-2';


function Relatorios() {
    const [chartData, setChartData] = useState({})

    const chart = () => {
        setChartData({
            labels: ['Novas', 'Revisadas', 'Assinadas', 'Enviadas'],
            datasets: [{
                label: 'ATAs por Status',
                backgroundColor: '#6e72bb',
                borderWidth: 4,
                data: [novas.length, revisadas.length, assinadas.length, enviadas.length]
            }]
        })
    }

 

    const [mes, setMes] = useState('');
    const [novas, setNovas] = useState([]);
    const [revisadas, setRevisadas] = useState([]);
    const [assinadas, setAssinadas] = useState([]);
    const [enviadas, setEnviadas] = useState([]);

    async function buscaAtas() {
        setNovas([]);
        setRevisadas([]);
        setAssinadas([]);
        setEnviadas([]);
        const response = await atas();
        console.log(response.data[2].datacriacao[4])
        for (var i = 0; i < response.data.length; i++) {
            if (mes != '') {
                if (response.data[i].datacriacao[3] + response.data[i].datacriacao[4] == mes) {
                    switch (response.data[i].status) {
                        case 'Nova':
                            novas.push(response.data[i]);
                            break;
                        case 'Revisada':
                            revisadas.push(response.data[i]);
                            break;
                        case 'Assinada':
                            assinadas.push(response.data[i]);
                            break;
                        case 'Enviada':
                            enviadas.push(response.data[i]);
                            break;
                    }
                }
            }
            else {
                switch (response.data[i].status) {
                    case 'Nova':
                        novas.push(response.data[i]);
                        break;
                    case 'Revisada':
                        revisadas.push(response.data[i]);
                        break;
                    case 'Assinada':
                        assinadas.push(response.data[i]);
                        break;
                    case 'Enviada':
                        enviadas.push(response.data[i]);
                        break;
                }
            }

        }
        console.log(novas);
        console.log(revisadas);
        console.log(assinadas);
        console.log(enviadas);
        chart();
    }

    useEffect(() => {
        buscaAtas();

    }, [mes])

    return (
        <>
            <Navbar routes={rotarelatorio} />
            <h2>Relatórios</h2>
            <h4>Escolha um mês:</h4>
            <select name="mes" onChange={(e) => setMes(e.target.value)}  >
                <option name="mes" value="">Todos</option>
                <option name="mes" value="01">Janeiro</option>
                <option name="mes" value="02">Fevereiro</option>
                <option name="mes" value="03">Março</option>
                <option name="mes" value="04">Abril</option>
                <option name="mes" value="05">Maio</option>
                <option name="mes" value="06">Junho</option>
                <option name="mes" value="07">Julho</option>
                <option name="mes" value="08">Agosto</option>
                <option name="mes" value="09">Setembro</option>
                <option name="mes" value="10">Outubro</option>
                <option name="mes" value="11">Novembro</option>
                <option name="mes" value="12">Dezembro</option>
            </select>
            <Bar style={{ maxWidth: '600px', maxHeight: '400px', marginBottom: '4%', marginTop: '4%' }} data={chartData} options={{
              
                title: { text: 'ATAS por Status' }
            }}
             />
        </>
    );
}
export default Relatorios;