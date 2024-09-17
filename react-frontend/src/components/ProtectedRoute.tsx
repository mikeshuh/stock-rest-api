// // src/components/ProtectedRoute.tsx
// import React from 'react';
// import { Navigate, Outlet, useLocation } from 'react-router-dom';
// import { useAppContext } from '../contexts/AppContext';

// const ProtectedRoute: React.FC = () => {
//   const { state } = useAppContext();
//   const location = useLocation();

//   if (!state.user) {
//     return <Navigate to="/auth" state={{ from: location }} replace />;
//   }

//   return <Outlet />;
// };

// export default ProtectedRoute;

// TEMP DISABLED

import React from 'react';
import { Outlet } from 'react-router-dom';

const ProtectedRoute: React.FC = () => {
  // Temporarily bypass the authentication check
  return <Outlet />;
};

export default ProtectedRoute;