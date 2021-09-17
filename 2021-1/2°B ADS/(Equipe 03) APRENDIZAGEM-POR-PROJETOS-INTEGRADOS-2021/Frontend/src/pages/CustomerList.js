import React, { useEffect, useState, useContext } from 'react';
import { Helmet } from 'react-helmet';
import { Box, Container } from '@material-ui/core';
import ColabsList from 'src/components/Colabs/ColabsList';
import CustomerListToolbar from 'src/components/customer/CustomerListToolbar';
import { api } from 'src/services/api';
import AuthContext from 'src/contexts/auth';
import sortWorkedHours from 'src/utils/sortWorkedHours';

const CustomerList = () => {
  const [users, setUsers] = useState([]);
  const [filteredUsersArray, setFilteredUsersArray] = useState([]);
  const { token } = useContext(AuthContext);

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

  const searchUser = (value) => {
    let filterUsers = [];
    users.forEach((user) => {
      if (user.user.nome.includes(value)) {
        filterUsers = [...filterUsers, user];
      }
    });

    setFilteredUsersArray(filterUsers);
  };

  return (
    <>
      {users.length > 0 ? (
        <>
          <Helmet>
            <title>Colaboradores | DashW</title>
          </Helmet>
          <Box
            sx={{
              backgroundColor: 'background.default',
              minHeight: '100%',
              py: 3
            }}
          >
            <Container maxWidth={false}>
              <CustomerListToolbar search={searchUser} />
              <Box sx={{ pt: 3 }}>
                {filteredUsersArray.length > 0 ? (
                  <ColabsList customers={filteredUsersArray} />
                ) : (
                  <ColabsList customers={users} />
                )}
              </Box>
            </Container>
          </Box>
        </>
      ) : null}
    </>
  );
};

export default CustomerList;
