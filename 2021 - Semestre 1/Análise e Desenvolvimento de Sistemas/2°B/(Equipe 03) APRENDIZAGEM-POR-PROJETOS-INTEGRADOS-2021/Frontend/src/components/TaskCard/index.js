/* eslint-disable object-curly-newline */
/* eslint-disable react/prop-types */
import React from 'react';
import { Card, CardContent, Grid, Typography } from '@material-ui/core';

const TaskCard = ({ description, workedHours }) => (
  <Card style={{ marginBottom: 10 }}>
    <CardContent>
      <Grid
        container
        spacing={3}
        sx={{ alignItems: 'flex-start', flexDirection: 'column' }}
      >
        <Grid item>
          <Typography color="textSecondary" gutterBottom variant="h5">
            {description}
          </Typography>
        </Grid>
        <Grid
          container
          sx={{
            justifyContent: 'space-between',
            flexDirection: 'row',
            padding: 2.5
          }}
        >
          <Typography color="textSecondary" gutterBottom variant="h5">
            Tempo trabalhado
          </Typography>
          <Typography color="textSecondary" gutterBottom variant="h5">
            {workedHours}
          </Typography>
        </Grid>
      </Grid>
    </CardContent>
  </Card>
);

export default TaskCard;
