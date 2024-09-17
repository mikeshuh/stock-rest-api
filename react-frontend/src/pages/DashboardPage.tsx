// src/pages/DashboardPage.tsx
import React, { useEffect } from 'react';
import { useAppContext } from '../contexts/AppContext';
import { fetchPortfolio, fetchWatchlist } from '../services/api';

const DashboardPage: React.FC = () => {
  const { state, dispatch } = useAppContext();

  useEffect(() => {
    const loadDashboardData = async () => {
      try {
        const [portfolio, watchlist] = await Promise.all([
          fetchPortfolio(),
          fetchWatchlist()
        ]);
        dispatch({ type: 'SET_PORTFOLIO', payload: portfolio });
        dispatch({ type: 'SET_WATCHLIST', payload: watchlist });
      } catch (error) {
        console.error('Error loading dashboard data:', error);
      }
    };

    loadDashboardData();
  }, [dispatch]);

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Dashboard</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div className="bg-white p-6 rounded-lg shadow">
          <h2 className="text-xl font-semibold mb-4">Portfolio Overview</h2>
          {/* Add portfolio summary here */}
        </div>
        <div className="bg-white p-6 rounded-lg shadow">
          <h2 className="text-xl font-semibold mb-4">Watchlist</h2>
          {/* Add watchlist summary here */}
        </div>
      </div>
    </div>
  );
};

export default DashboardPage;