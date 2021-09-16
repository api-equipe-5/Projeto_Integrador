/* eslint-disable react/jsx-one-expression-per-line */
/* eslint-disable react/prop-types */
import { Doughnut } from 'react-chartjs-2';
import {
  Box,
  Card,
  CardContent,
  CardHeader,
  Divider,
  Typography,
  colors,
  useTheme
} from '@material-ui/core';
import { useEffect, useState } from 'react';

const TrafficByDevice = ({ props, status }) => {
  console.log(status[0].percentage);
  const theme = useTheme();

  const [data, setData] = useState();

  useEffect(() => {
    const defineData = () => {
      const dataObject = {
        datasets: [
          {
            data: [
              status[0].percentage,
              status[1].percentage,
              status[2].percentage,
              status[3].percentage,
              status[4].percentage,
              status[5].percentage,
              status[6].percentage
            ],
            backgroundColor: [
              colors.indigo[500],
              colors.red[600],
              colors.purple[600],
              colors.cyan[600],
              colors.amber[600],
              colors.lightGreen[600],
              colors.green[600]
            ],
            borderWidth: 8,
            borderColor: colors.common.white,
            hoverBorderColor: colors.common.white
          }
        ],
        labels: [
          'IN_PROGRESS',
          'QA_TESTING',
          'QA_DEPLOYING',
          'RELEASE_TO_PROD',
          'FOR_TEST',
          'PROD_DEPLOYING',
          'DONE'
        ]
      };

      setData(dataObject);
    };

    if (status.length > 0) defineData();
  }, [status]);

  const options = {
    animation: false,
    cutoutPercentage: 80,
    layout: { padding: 0 },
    legend: {
      display: false
    },
    maintainAspectRatio: false,
    responsive: true,
    tooltips: {
      backgroundColor: theme.palette.background.paper,
      bodyFontColor: theme.palette.text.secondary,
      borderColor: theme.palette.divider,
      borderWidth: 1,
      enabled: true,
      footerFontColor: theme.palette.text.secondary,
      intersect: false,
      mode: 'index',
      titleFontColor: theme.palette.text.primary
    }
  };
  return (
    <Card {...props}>
      <CardHeader title="Porcentagem Geral" />
      <Divider />
      <CardContent>
        <Box
          sx={{
            height: 300,
            position: 'relative'
          }}
        >
          <Doughnut data={data} options={options} />
        </Box>
        <Box
          sx={{
            display: 'flex',
            justifyContent: 'center',
            pt: 2
          }}
        >
          {status.slice(0, 3).map(({ stat, percentage }) => (
            <Box
              key={stat}
              sx={{
                p: 1,
                textAlign: 'center'
              }}
            >
              <Typography
                color="textPrimary"
                variant="body1"
                style={{ fontSize: 12 }}
              >
                {stat}
              </Typography>
              <Typography style={{ fontSize: 20 }} variant="h2">
                {percentage}%
              </Typography>
            </Box>
          ))}
        </Box>
        <Box
          sx={{
            display: 'flex',
            justifyContent: 'center',
            pt: 2
          }}
        >
          {status.slice(3, 7).map(({ stat, percentage }) => (
            <Box
              key={stat}
              sx={{
                p: 1,
                textAlign: 'center'
              }}
            >
              <Typography
                color="textPrimary"
                variant="body1"
                style={{ fontSize: 12 }}
              >
                {stat}
              </Typography>
              <Typography style={{ fontSize: 20 }} variant="h2">
                {percentage}%
              </Typography>
            </Box>
          ))}
        </Box>
      </CardContent>
    </Card>
  );
};

export default TrafficByDevice;
