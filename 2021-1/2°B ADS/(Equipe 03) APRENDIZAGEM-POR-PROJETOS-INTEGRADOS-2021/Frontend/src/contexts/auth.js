/* eslint-disable react/prop-types */
import React, { useState, createContext, useEffect } from 'react';

const AuthContext = createContext({ signed: true, user: {}, token: '' });

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(null);
  const [user, setUser] = useState({});

  useEffect(() => {
    const getStoragedData = () => {
      const storagedToken = localStorage.getItem('@dashw:token');
      const storagedUser = localStorage.getItem('@dashw:user');

      if (storagedToken && storagedUser) {
        setToken(storagedToken);
        setUser(storagedUser);
      }
    };
    getStoragedData();
  }, []);

  const signIn = (myToken, myUser) => {
    setToken(myToken);
    setUser(myUser);

    localStorage.setItem('@dashw:token', myToken);
    localStorage.setItem('@dashw:user', JSON.stringify(myUser));
  };

  const signOut = () => {
    setToken(null);
    setUser([]);

    localStorage.removeItem('@dashw:token');
    localStorage.removeItem('@dashw:user');
  };

  return (
    <AuthContext.Provider
      value={{
        signed: !!token,
        user,
        token,
        signIn,
        signOut
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};

export default AuthContext;
