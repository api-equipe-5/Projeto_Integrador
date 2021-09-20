import React from 'react';
import { Route as RouteRRD } from 'react-router-dom';

import { getToken } from '../../../services/auth';

import OnlyAuthenticated from '../OnlyAuthenticated';

const Route = ({privateRoute, ...props}) => {
  const isUserConnected = getToken();
  
  return (
    <>
      {privateRoute ? isUserConnected ? (
        <RouteRRD {...props}/>
      ): (
        <OnlyAuthenticated/>
      ): (
        <RouteRRD {...props}/>
      )}
    </>
  )
}

export default Route;