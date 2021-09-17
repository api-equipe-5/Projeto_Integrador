/* eslint-disable prefer-const */
/* eslint-disable no-underscore-dangle */
import React, { useRef, useEffect } from 'react';
import { Map, TileLayer, FeatureGroup, GeoJSON } from 'react-leaflet';
import { EditControl } from 'react-leaflet-draw';

import 'leaflet-draw/dist/leaflet.draw.css';
import 'leaflet/dist/leaflet.css';
import './style.scss';

const BASELAYER =
  'https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}';

const STATE_LAYER =
  'https://stamen-tiles-{s}.a.ssl.fastly.net/toner-hybrid/{z}/{x}/{y}{r}.png';

const normalizeBbox = (bbox) => {
  const {
    _northEast: { lat: latNE, lng: lngNE },
    _southWest: { lat: latSW, lng: lngSW },
  } = bbox;
  return {
    latNE,
    lngNE,
    latSW,
    lngSW,
  };
};

const Mapa = (props) => {
  const map = useRef(null);
  const geoJSONRef = useRef();
  const { GetBBox = () => {}, geoJSON, onChangeGeoJSON = () => {} } = props;

  const latLngToGeoJSON = (coords) => {
    return {
      type: 'Polygon',
      coordinates: [coords.map((coord) => [coord.lng, coord.lat])],
    };
  };

  const getLatlon = ({ latlng, bbox }) => {
    const [coords] = latlng;
    coords.push(coords[0]);
    onChangeGeoJSON(latLngToGeoJSON(coords));
    const coordsWKT = coords
      .map((val) => `${val.lat.toFixed(6)} ${val.lng.toFixed(6)}`)
      .join(',');

    const data = {
      bbox: normalizeBbox(bbox),
      coordsWKT,
    };

    GetBBox(data);
  };

  useEffect(() => {
    if (!map.current || !geoJSON || !geoJSONRef.current) return;
    const mapLeaflet = map.current.leafletElement;
    const gJSON = geoJSONRef.current.leafletElement;

    gJSON.addData(geoJSON);
    mapLeaflet.fitBounds(gJSON.getBounds());
    GetBBox({
      bbox: normalizeBbox(gJSON.getBounds()),
      coordsWKT: geoJSON.features[0].geometry.coordinates[0]
        .map((coord) => `${coord[0].toFixed(6)} ${coord[1].toFixed(6)}`)
        .join(', '),
    });
    onChangeGeoJSON(geoJSON.features[0].geometry);
  }, [geoJSON]);

  return (
    <Map
      style={{ height: '100%', width: '100%' }}
      zoom={11}
      center={[-23.607392, -46.560112]}
      maxZoom={17}
      minZoom={5}
      ref={map}
    >
      <TileLayer url={BASELAYER} />
      <TileLayer url={STATE_LAYER} />

      <FeatureGroup>
        <EditControl
          position="bottomright"
          onCreated={(e) => {
            // // eslint-disable-next-line no-underscore-dangle
            getLatlon({ latlng: e.layer._latlngs, bbox: e.layer._bounds });
          }}
          draw={{
            marker: false,
            circle: false,
            rectangle: false,
            polygon: true,
            polyline: false,
            circlemarker: false,
          }}
        />
        <GeoJSON ref={geoJSONRef} />
      </FeatureGroup>
    </Map>
  );
};

export default Mapa;
