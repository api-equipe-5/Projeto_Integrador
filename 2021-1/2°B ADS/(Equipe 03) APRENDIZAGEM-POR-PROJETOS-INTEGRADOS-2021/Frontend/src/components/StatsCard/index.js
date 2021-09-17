/* eslint-disable react/prop-types */
import React from 'react';
import {
  Card,
  CardContent,
  Grid,
  Typography
} from '@material-ui/core';

const StatsCard = ({ label, value }) => (
  <Card>
    <CardContent>
      <Grid container spacing={3} sx={{ alignItems: 'center', flexDirection: 'column' }}>
        <Grid item>
          <Typography color="textSecondary" gutterBottom variant="h1">{value}</Typography>
        </Grid>
        <Grid item>
          <Typography color="textSecondary" gutterBottom variant="h5">{label}</Typography>
        </Grid>
      </Grid>
    </CardContent>
  </Card>
);

export default StatsCard;
