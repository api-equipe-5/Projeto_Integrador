/* eslint-disable react/prop-types */
import { useState } from 'react';
import PropTypes from 'prop-types';
import PerfectScrollbar from 'react-perfect-scrollbar';
import {
  Box,
  Card,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TablePagination,
  TableRow,
  Typography
} from '@material-ui/core';
import extractHours from 'src/utils/extractHours';

const ProjectList = ({ projects, chooseProject, ...rest }) => {
  const [limit, setLimit] = useState(5);
  const [page, setPage] = useState(0);

  const handleLimitChange = (event) => {
    setLimit(event.target.value);
  };

  const handlePageChange = (event, newPage) => {
    setPage(newPage);
  };

  return (
    <Card {...rest}>
      <PerfectScrollbar>
        <Box sx={{ minWidth: 1050 }}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Nome do Projeto</TableCell>
                <TableCell>Horas trabalhadas</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {projects.slice(0, limit).map((project) => (
                <TableRow
                  hover
                  key={project.project.id}
                  onClick={() => chooseProject(project.project.id)}
                  style={{ cursor: 'pointer' }}
                >
                  <TableCell>
                    <Box
                      sx={{
                        alignItems: 'center',
                        display: 'flex'
                      }}
                    >
                      <Typography color="textPrimary" variant="body1">
                        {project.project.projetoNome}
                      </Typography>
                    </Box>
                  </TableCell>
                  <TableCell>{extractHours(project)}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </Box>
      </PerfectScrollbar>
      <TablePagination
        component="div"
        count={projects.length}
        onPageChange={handlePageChange}
        onRowsPerPageChange={handleLimitChange}
        page={page}
        rowsPerPage={limit}
        rowsPerPageOptions={[5, projects.length]}
      />
    </Card>
  );
};

ProjectList.propTypes = {
  projects: PropTypes.array.isRequired
};

export default ProjectList;
