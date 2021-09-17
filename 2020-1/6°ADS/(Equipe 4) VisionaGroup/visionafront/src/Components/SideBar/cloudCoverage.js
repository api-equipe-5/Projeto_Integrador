import React, { useState } from 'react';
import { Grid, Row, Col, Slider } from 'rsuite';
import { BsFillCloudFill } from 'react-icons/bs';

import 'rsuite/dist/styles/rsuite-default.css';
import './style.scss';

const CloudCoverage = (props) => {
  const [value, setValue] = useState(50);
  const { CloudChange = () => {} } = props;

  return (
    <Grid fluid className="coverage-container">
      <div className="title-container">
        <span className="title">Cobertura de nuvem</span>
      </div>
      <Row>
        <Col>
          <Slider
            progress
            defaultValue={50}
            color="blue"
            step
            onChange={(e) => {
              setValue(e);
              CloudChange(e);
            }}
          />
        </Col>
      </Row>
      <Row>
        <Col className="col">
          <BsFillCloudFill size={30} />
          <span className="cloudValue">{value}%</span>
        </Col>
      </Row>
      <div className="border" />
    </Grid>
  );
};

export default CloudCoverage;
