// src/components/Sidebar.tsx
import React from 'react';
import { Link } from 'react-router-dom';

const Sidebar: React.FC = () => {
  return (
    <div className="bg-gray-800 text-white w-64 space-y-6 py-7 px-2 absolute inset-y-0 left-0 transform -translate-x-full md:relative md:translate-x-0 transition duration-200 ease-in-out">
      <nav>
        <Link to="/dashboard" className="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700">Dashboard</Link>
        <Link to="/portfolio" className="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700">Portfolio</Link>
        <Link to="/watchlist" className="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700">Watchlist</Link>
        <Link to="/history" className="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700">Trade History</Link>
        <Link to="/settings" className="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700">Settings</Link>
        <Link to="/help" className="block py-2.5 px-4 rounded transition duration-200 hover:bg-gray-700">Help</Link>
      </nav>
    </div>
  );
};

export default Sidebar;