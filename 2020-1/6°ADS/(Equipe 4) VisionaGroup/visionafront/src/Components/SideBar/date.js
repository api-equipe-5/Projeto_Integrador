import React from 'react';
import moment from 'moment';
import { DateRangePicker } from 'rsuite';

import 'rsuite/dist/styles/rsuite-default.css';
import './style.scss';

// function to get range date
const Date = (props) => {
  const { RangeDate = () => {} } = props;

  function getDate(e) {
    const startDate = moment(e[0]).format('YYYY-MM-DD');
    const endDate = moment(e[1]).format('YYYY-MM-DD');
    const date = {
      startDate,
      endDate,
    };
    RangeDate(date);
  }

  return (
    <div className="date">
      <span className="title">Selecione o espaço de tempo:</span>
      <div className="date-container">
        <DateRangePicker
          format="DD MMM YYYY"
          locale={{
            sunday: 'Dom',
            monday: 'Seg',
            tuesday: 'Ter',
            wednesday: 'Qua',
            thursday: 'Qui',
            friday: 'Sex',
            saturday: 'Sab',
            ok: 'OK',
            today: 'Hoje',
            yesterday: 'Ontem',
            last7Days: 'Ultimos 7 dias',
          }}
          showOneCalendar
          onChange={getDate}
        />
      </div>
      <div className="border" />
    </div>
  );
};

export default Date;
