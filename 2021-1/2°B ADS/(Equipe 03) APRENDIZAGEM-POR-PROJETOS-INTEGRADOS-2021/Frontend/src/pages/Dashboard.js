/* eslint-disable object-curly-newline */
import React, { useContext, useEffect, useState } from 'react';
import { Helmet } from 'react-helmet';
import { Box, Container, Grid, InputLabel } from '@material-ui/core';
import TaskList from 'src/components/dashboard//LatestOrders';
import Sales from 'src/components/dashboard//Sales';
import TrafficByDevice from 'src/components/dashboard//TrafficByDevice';
import StatsCard from 'src/components/StatsCard';
import './styles.css';
import { api } from 'src/services/api';
import AuthContext from 'src/contexts/auth';
import ProjectList from 'src/components/Projects/ProjectList';
import UsersList from 'src/components/Users/UsersList';
import sortWorkedHours from 'src/utils/sortWorkedHours';
import {
  sortWorkedHoursDecreasing,
  sortWorkedHoursIncreasing
} from 'src/utils/sortByHours';
import roles from 'src/constants/roles';
import statusList from 'src/constants/StatusList';
import { sortDown, sortUp } from 'src/utils/sortAlphabetically';

const Dashboard = () => {
  const [project, setProject] = useState(null);
  const [projects, setProjects] = useState([]);
  const [users, setUsers] = useState([]);
  const [projectId, setProjectId] = useState(null);
  const [percentageArray, setPercentageArray] = useState([]);
  const [hoursSortType, setHoursSortType] = useState();
  const [alphaSortType, setAlphaSortType] = useState();

  const { token, user } = useContext(AuthContext);

  useEffect(() => {
    const getProjects = async () => {
      const response = await api.get('/project/hours', {
        headers: {
          Authorization: `Bearer ${token}`
        }
      });

      const projectArray = response.data;

      const sortedProjects = projectArray.sort(sortWorkedHours);

      setProjects(sortedProjects);
    };

    getProjects();
  }, [token]);

  const getProject = async (id) => {
    const response = await api.get('/listar', {
      headers: {
        Authorization: `Bearer ${token}`,
        projectId: id
      }
    });
    setProjectId(id);
    setProject(response.data);
  };

  const sortByHoursDecreasing = () => {
    const tasksArray = project.tasks.tasks;

    let sortedTasks;
    if (hoursSortType === 'Increasing') {
      sortedTasks = tasksArray.sort(sortWorkedHoursDecreasing);
      setHoursSortType('Decreasing');
    } else {
      sortedTasks = tasksArray.sort(sortWorkedHoursIncreasing);
      setHoursSortType('Increasing');
    }

    const data = {
      stats: project.stats,
      tasks: {
        project: project.tasks.project,
        tasks: sortedTasks
      }
    };

    setProject(data);
  };

  const sortByAlphabetically = () => {
    const tasksArray = project.tasks.tasks;
    let sortedTasks;

    if (alphaSortType === 'Increasing') {
      sortedTasks = tasksArray.sort(sortUp);
      setAlphaSortType('Decreasing');
    } else {
      sortedTasks = tasksArray.sort(sortDown);
      setAlphaSortType('Increasing');
    }

    const data = {
      stats: project.stats,
      tasks: {
        project: project.tasks.project,
        tasks: sortedTasks
      }
    };

    setProject(data);
  };

  useEffect(() => {
    const getUsers = async () => {
      const response = await api.get('/users/hours', {
        headers: {
          Authorization: `Bearer ${token}`
        }
      });

      const usersArray = response.data;

      const sortedUsers = usersArray.sort(sortWorkedHours);

      setUsers(sortedUsers);
    };
    getUsers();
  }, [token]);

  const getByColab = async (id) => {
    const response = await api.get('/listar', {
      headers: {
        Authorization: `Bearer ${token}`,
        projectId,
        colab_id: id
      }
    });

    setProject(response.data);
  };

  useEffect(() => {
    const convertToPercentage = () => {
      const statsToArray = Object.entries(project.stats);
      const total = statsToArray.reduce((acc, obj) => acc + obj[1], 0);

      let statsArray = [];

      statusList.forEach((element) => {
        statsToArray.forEach((object) => {
          if (element === object[0]) {
            const calc = Math.round((object[1] / total) * 100);

            const statsPercentage = {
              stat: element,
              percentage: calc
            };

            statsArray = [...statsArray, statsPercentage];
          }
        });
      });

      setPercentageArray(statsArray);
    };

    if (project) convertToPercentage();
  }, [project]);

  return (
    <>
      <Helmet>
        <title>DashW</title>
      </Helmet>
      <Box
        sx={{
          backgroundColor: 'background.default',
          minHeight: '100%',
          py: 3
        }}
      >
        <Container maxWidth={false}>
          <Box sx={{ marginTop: 0, marginBottom: 2 }}>
            <InputLabel id="label" className="select-input-dash">
              Selecione o projeto:
              {project ? ` ${project.tasks.project}` : null}
            </InputLabel>
            {user.id_role === roles.ID_GESTOR ? (
              <Grid item lg={12} md={12} xl={12} xs={12}>
                <ProjectList projects={projects} chooseProject={getProject} />
              </Grid>
            ) : (
              <Grid container spacing={3}>
                <Grid item lg={8} md={8} xl={8} xs={8}>
                  <ProjectList projects={projects} chooseProject={getProject} />
                </Grid>
                <Grid item lg={4} md={4} xl={4} xs={4}>
                  <UsersList users={users} chooseColab={getByColab} />
                </Grid>
              </Grid>
            )}
          </Box>
          {!project ? null : (
            <Grid container spacing={3}>
              <Grid item lg={2} sm={6} xl={3} xs={12}>
                <StatsCard
                  label="IN_PROGESS"
                  value={project.stats.IN_PROGRESS}
                />
              </Grid>
              <Grid item lg={2} sm={6} xl={3} xs={12}>
                <StatsCard
                  label="QA_TESTING"
                  value={project.stats.QA_TESTING}
                />
              </Grid>
              <Grid item lg={2} sm={6} xl={3} xs={12}>
                <StatsCard
                  label="QA_DEPLOYING"
                  value={project.stats.QA_DEPLOYING}
                />
              </Grid>
              <Grid item lg={2} sm={6} xl={3} xs={12}>
                <StatsCard
                  label="RELEASE_TO_PROD"
                  value={project.stats.RELEASE_TO_PROD}
                />
              </Grid>
              <Grid item lg={2} sm={6} xl={3} xs={12}>
                <StatsCard label="FOR_TEST" value={project.stats.FOR_TEST} />
              </Grid>
              <Grid item lg={2} sm={6} xl={3} xs={12}>
                <StatsCard
                  label="PROD_DEPLOYING"
                  value={project.stats.PROD_DEPLOYING}
                />
              </Grid>
              <Grid item lg={8} md={12} xl={9} xs={12}>
                <Sales stats={project.stats} />
              </Grid>
              <Grid item lg={4} md={6} xl={3} xs={12}>
                {percentageArray.length > 0 ? (
                  <TrafficByDevice
                    status={percentageArray}
                    sx={{ height: '100%' }}
                  />
                ) : null}
              </Grid>
              {project ? (
                <Grid item lg={12} md={12} xl={9} xs={12}>
                  <TaskList
                    sortDescription={sortByAlphabetically}
                    project={project}
                    sort={sortByHoursDecreasing}
                  />
                </Grid>
              ) : null}
            </Grid>
          )}
        </Container>
      </Box>
    </>
  );
};

export default Dashboard;
