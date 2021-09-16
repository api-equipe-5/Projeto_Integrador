/* eslint-disable no-param-reassign */
/* eslint-disable no-unused-expressions */
/* eslint-disable function-paren-newline */
/* eslint-disable implicit-arrow-linebreak */
/* eslint-disable no-confusing-arrow */
import React, { useEffect, useContext, useState } from 'react';
import { Helmet } from 'react-helmet';
import {
  Box,
  Container,
  Grid,
  Typography,
  InputLabel,
  Select,
  MenuItem
} from '@material-ui/core';
import { api } from 'src/services/api';
import AuthContext from 'src/contexts/auth';
import TaskCard from '../components/TaskCard';

const ProductList = () => {
  const { token } = useContext(AuthContext);
  const [projects, setProjects] = useState([]);
  const [project, setProject] = useState(null);

  useEffect(() => {
    const getProjects = async () => {
      const response = await api.get('/projects', {
        headers: {
          Authorization: `Bearer ${token}`
        }
      });

      setProjects(response.data);
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

    setProject(response.data);
  };

  return (
    <>
      <Helmet>
        <title>Kanbanboard | DashW </title>
      </Helmet>
      <div className="header-kanban">
        <InputLabel id="label" className="select-input-dash">
          Selecione o projeto:
        </InputLabel>
        <Select
          onChange={(value) => getProject(value.target.value)}
          id="select"
          value="null"
          className="select-dash select-style"
          variant="outlined"
        >
          <MenuItem value={null} disabled>
            {project ? project.tasks.project : 'Selecione um projeto'}
          </MenuItem>
          {projects.map((myProject) => (
            <MenuItem value={myProject.id}>{myProject.projetoNome}</MenuItem>
          ))}
        </Select>
      </div>

      <Box
        sx={{
          backgroundColor: '#000',
          py: 3,
          flexDirection: 'row',
          display: 'flex',
          width: 3000
        }}
      >
        {project ? (
          <>
            <Container style={{ maxWidth: '25%' }}>
              <Box sx={{ pt: 3 }}>
                <Grid
                  lg={12}
                  style={{
                    flexDirection: 'row',
                    marginLeft: 0,
                    backgroundColor: '#F5F8FA',
                    paddingTop: 15,
                    borderRadius: 3
                  }}
                >
                  <Typography
                    color="textSecondary"
                    style={{ textAlign: 'center' }}
                    gutterBottom
                    variant="h5"
                  >
                    IN_PROGRESS
                  </Typography>
                  <Grid
                    item
                    lg={12}
                    style={{
                      backgroundColor: '#F5F8FA',
                      padding: 15,
                      borderRadius: 3,
                      height: '65vh',
                      overflowY: 'scroll'
                    }}
                  >
                    {project.tasks.tasks.map((task) =>
                      task.status === 'IN_PROGRESS' ? (
                        <Grid
                          item
                          lg={12}
                          sm={6}
                          xl={3}
                          xs={12}
                          sx={{ margin: 1 }}
                        >
                          <TaskCard
                            description={task.descricao}
                            workedHours={task.horas}
                          />
                        </Grid>
                      ) : null
                    )}
                  </Grid>
                </Grid>
              </Box>
            </Container>
            <Container style={{ maxWidth: '30%' }}>
              <Box sx={{ pt: 3 }}>
                <Grid
                  lg={12}
                  style={{
                    flexDirection: 'row',
                    marginLeft: 0,
                    backgroundColor: '#F5F8FA',
                    paddingTop: 15,
                    borderRadius: 3
                  }}
                >
                  <Typography
                    color="textSecondary"
                    style={{ textAlign: 'center' }}
                    gutterBottom
                    variant="h5"
                  >
                    QA_TESTING
                  </Typography>
                  <Grid
                    item
                    lg={12}
                    style={{
                      backgroundColor: '#F5F8FA',
                      padding: 15,
                      borderRadius: 3,
                      height: '65vh',
                      overflowY: 'scroll'
                    }}
                  >
                    {project.tasks.tasks.map((task) =>
                      task.status === 'QA_TESTING' ? (
                        <Grid item lg={12} sm={6} xl={3} xs={12}>
                          <TaskCard
                            description={task.descricao}
                            workedHours={task.horas}
                          />
                        </Grid>
                      ) : null
                    )}
                  </Grid>
                </Grid>
              </Box>
            </Container>
            <Container style={{ maxWidth: '30%' }}>
              <Box sx={{ pt: 3 }}>
                <Grid
                  lg={12}
                  style={{
                    flexDirection: 'row',
                    marginLeft: 0,
                    backgroundColor: '#F5F8FA',
                    paddingTop: 15,
                    borderRadius: 3
                  }}
                >
                  <Typography
                    color="textSecondary"
                    style={{ textAlign: 'center' }}
                    gutterBottom
                    variant="h5"
                  >
                    QA_DEPLOYING
                  </Typography>
                  <Grid
                    item
                    lg={12}
                    style={{
                      backgroundColor: '#F5F8FA',
                      padding: 15,
                      borderRadius: 3,
                      height: '65vh',
                      overflowY: 'scroll'
                    }}
                  >
                    {project.tasks.tasks.map((task) =>
                      task.status === 'QA_DEPLOYING' ? (
                        <Grid item lg={12} sm={6} xl={3} xs={12}>
                          <TaskCard
                            description={task.descricao}
                            workedHours={task.horas}
                          />
                        </Grid>
                      ) : null
                    )}
                  </Grid>
                </Grid>
              </Box>
            </Container>
            <Container style={{ maxWidth: '30%' }}>
              <Box sx={{ pt: 3 }}>
                <Grid
                  lg={12}
                  style={{
                    flexDirection: 'row',
                    marginLeft: 0,
                    backgroundColor: '#F5F8FA',
                    paddingTop: 15,
                    borderRadius: 3
                  }}
                >
                  <Typography
                    color="textSecondary"
                    style={{ textAlign: 'center' }}
                    gutterBottom
                    variant="h5"
                  >
                    RELEASE_TO_PROD
                  </Typography>
                  <Grid
                    item
                    lg={12}
                    style={{
                      backgroundColor: '#F5F8FA',
                      padding: 15,
                      borderRadius: 3,
                      height: '65vh',
                      overflowY: 'scroll'
                    }}
                  >
                    {project.tasks.tasks.map((task) =>
                      task.status === 'RELEASE_TO_PROD' ? (
                        <Grid item lg={12} sm={6} xl={3} xs={12}>
                          <TaskCard
                            description={task.descricao}
                            workedHours={task.horas}
                          />
                        </Grid>
                      ) : null
                    )}
                  </Grid>
                </Grid>
              </Box>
            </Container>

            <Container style={{ maxWidth: '30%' }}>
              <Box sx={{ pt: 3 }}>
                <Grid
                  lg={12}
                  style={{
                    flexDirection: 'row',
                    marginLeft: 0,
                    backgroundColor: '#F5F8FA',
                    paddingTop: 15,
                    borderRadius: 3
                  }}
                >
                  <Typography
                    color="textSecondary"
                    style={{ textAlign: 'center' }}
                    gutterBottom
                    variant="h5"
                  >
                    FOR_TEST
                  </Typography>
                  <Grid
                    item
                    lg={12}
                    style={{
                      backgroundColor: '#F5F8FA',
                      padding: 15,
                      borderRadius: 3,
                      height: '65vh',
                      overflowY: 'scroll'
                    }}
                  >
                    {project.tasks.tasks.map((task) =>
                      task.status === 'FOR_TEST' ? (
                        <Grid item lg={12} sm={6} xl={3} xs={12}>
                          <TaskCard
                            description={task.descricao}
                            workedHours={task.horas}
                          />
                        </Grid>
                      ) : null
                    )}
                  </Grid>
                </Grid>
              </Box>
            </Container>

            <Container style={{ maxWidth: '30%' }}>
              <Box sx={{ pt: 3 }}>
                <Grid
                  lg={12}
                  style={{
                    flexDirection: 'row',
                    marginLeft: 0,
                    backgroundColor: '#F5F8FA',
                    paddingTop: 15,
                    borderRadius: 3
                  }}
                >
                  <Typography
                    color="textSecondary"
                    style={{ textAlign: 'center' }}
                    gutterBottom
                    variant="h5"
                  >
                    PROD_DEPLOYING
                  </Typography>
                  <Grid
                    item
                    lg={12}
                    style={{
                      backgroundColor: '#F5F8FA',
                      padding: 15,
                      borderRadius: 3,
                      height: '65vh',
                      overflowY: 'scroll'
                    }}
                  >
                    {project.tasks.tasks.map((task) =>
                      task.status === 'PROD_DEPLOYING' ? (
                        <Grid item lg={12} sm={6} xl={3} xs={12}>
                          <TaskCard
                            description={task.descricao}
                            workedHours={task.horas}
                          />
                        </Grid>
                      ) : null
                    )}
                  </Grid>
                </Grid>
              </Box>
            </Container>
            <Container style={{ maxWidth: '30%' }}>
              <Box sx={{ pt: 3 }}>
                <Grid
                  lg={12}
                  style={{
                    flexDirection: 'row',
                    marginLeft: 0,
                    backgroundColor: '#F5F8FA',
                    paddingTop: 15,
                    borderRadius: 3
                  }}
                >
                  <Typography
                    color="textSecondary"
                    style={{ textAlign: 'center' }}
                    gutterBottom
                    variant="h5"
                  >
                    DONE
                  </Typography>
                  <Grid
                    item
                    lg={12}
                    style={{
                      backgroundColor: '#F5F8FA',
                      padding: 15,
                      borderRadius: 3,
                      height: '65vh',
                      overflowY: 'scroll'
                    }}
                  >
                    {project.tasks.tasks.map((task) =>
                      task.status === 'DONE' ? (
                        <Grid item lg={12} sm={6} xl={3} xs={12}>
                          <TaskCard
                            description={task.descricao}
                            workedHours={task.horas}
                          />
                        </Grid>
                      ) : null
                    )}
                  </Grid>
                </Grid>
              </Box>
            </Container>
          </>
        ) : null}
      </Box>
    </>
  );
};

export default ProductList;
