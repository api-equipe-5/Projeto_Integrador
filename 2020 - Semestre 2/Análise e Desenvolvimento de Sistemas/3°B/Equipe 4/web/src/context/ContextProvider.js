import React, { useState } from 'react';
import AppContext from '.';
const ContextProvider = ({ children }) => {
  const [shapeReturn, setShapeReturn] = useState([]);
  const context = {
    shapeReturn,
    setShapeReturn,
  };
  return (
    <AppContext.Provider value={ context }> 
      {children}
    </AppContext.Provider>
  );
}
export default ContextProvider;