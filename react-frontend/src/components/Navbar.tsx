// src/components/Navbar.tsx
import React from 'react';
import { Link } from 'react-router-dom';
import { useAppContext } from '../contexts/AppContext';

const Navbar: React.FC = () => {
  const { state, dispatch } = useAppContext();

  const handleLogout = () => {
    dispatch({ type: 'SET_USER', payload: null });
    localStorage.removeItem('token');
  };

  return (
    <nav className="bg-white shadow-lg">
      <div className="max-w-7xl mx-auto px-4">
        <div className="flex justify-between h-16">
          <div className="flex">
            <Link to="/dashboard" className="flex-shrink-0 flex items-center">
              Red Panda Trading
            </Link>
          </div>
          <div className="flex items-center">
            <Link to="/search" className="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900">Search</Link>
            <Link to="/portfolio" className="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900">Portfolio</Link>
            <Link to="/watchlist" className="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900">Watchlist</Link>
            <button onClick={handleLogout} className="ml-4 px-3 py-2 rounded-md text-sm font-medium text-white bg-red-500 hover:bg-red-600">Logout</button>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;