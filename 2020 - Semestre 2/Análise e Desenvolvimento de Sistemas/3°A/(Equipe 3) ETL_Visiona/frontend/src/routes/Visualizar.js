import React, { Fragment, useEffect, useState } from "react";
import { MapContainer, GeoJSON, TileLayer } from "react-leaflet";
import "leaflet/dist/leaflet.css";
import L from 'leaflet';
import HeaderNoSearch from '../sections/HeaderNoSearch';
// import mapData from '../assets/geo.json';
import api from '../services/api';
import { LinearProgress } from '@material-ui/core';
import { withStyles } from '@material-ui/styles';


export default function Visualizar() {

    const [isLoading, setLoading] = useState(true);
    const [mapData, setMapData] = useState();
    const [centerJson, setCenterJson] = useState();
    const [zoomJson, setZoomJson] = useState();

    // const address = 'https://api.maptiler.com/maps/streets/{z}/{x}/{y}.png?key=vpKwi7e2rRjEWHBci22Y';
    // var address = 'https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png';
    // var address = 'https://server.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer/tile/{z}/{y}/{x}';
    // var address = 'https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}';
    var address = 'https://{s}.tile.thunderforest.com/landscape/{z}/{x}/{y}.png?apikey=a109b81a979b41be897167f29e7f357b'

    const user = localStorage.getItem('jumbo/user');
    const password = localStorage.getItem('jumbo/password');
    const host = localStorage.getItem('jumbo/host');
    const port = localStorage.getItem('jumbo/port');
    const database = localStorage.getItem('jumbo/database');
    const table = localStorage.getItem('jumbo/table');

    const dados = {
        user,
        password,
        host,
        port,
        database,
        table
    };

    useEffect(() => {
        api.post('/get_geojson', dados, {
            responseType: "blob"
        })
            .then(response => {
                const downloadUrl = window.URL.createObjectURL(new Blob([response.data]));
                fetch(downloadUrl)
                    .then(res => res.json()
                        .then((result) => {
                            setMapData(result);
                            const geojson = L.geoJSON(result);
                            setCenterJson(geojson.getBounds().getCenter());
                            setZoomJson(geojson.getBounds());
                            setLoading(false);

                        }))
            })
            ;
    }, []);


    const ColorLinearProgress = withStyles({
        colorPrimary: {
            backgroundColor: '#00FFE0',
        },
        barColorPrimary: {
            backgroundColor: '#373A52',
        },
    })(LinearProgress);

    if (isLoading) {
        return <div className="vis">
            <Fragment>
                <HeaderNoSearch />
            </Fragment>
            <div id="load">
                <div className="load-div" align="center">
                    <ColorLinearProgress />
                    <br></br>
                    Carregando...
                </div>
            </div>
        </div>;
    }

    const pointToLayer = (feature, latlng) => {
        return L.circleMarker(latlng, {
            color: 'rgb(51, 136, 255)',
            fillColor: '#"rgb(51, 136, 255)"',
            fillOpacity: .6,
            radius: 0.5
        })
    };

    return (
        <div className="vis">
            <Fragment>
                <HeaderNoSearch />
            </Fragment>
            <MapContainer
                style={{ height: "calc(100vh - 60px)" }} center={centerJson} bounds={zoomJson}>
                <TileLayer url={address} ></TileLayer>
                <GeoJSON
                    data={mapData.features}
                    pointToLayer={pointToLayer}
                />
            </MapContainer>
        </div>
    );
}
