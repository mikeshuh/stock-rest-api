// src/pages/PortfolioPage.tsx
import React, { useEffect } from 'react';
import { useAppContext } from '../contexts/AppContext';
import { fetchPortfolio } from '../services/api';

const PortfolioPage: React.FC = () => {
  const { state, dispatch } = useAppContext();

  useEffect(() => {
    const loadPortfolio = async () => {
      try {
        const portfolio = await fetchPortfolio();
        dispatch({ type: 'SET_PORTFOLIO', payload: portfolio });
      } catch (error) {
        console.error('Error loading portfolio:', error);
      }
    };

    loadPortfolio();
  }, [dispatch]);

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Your Portfolio</h1>
      <div className="bg-white p-6 rounded-lg shadow mb-6">
        <h2 className="text-xl font-semibold mb-4">Holdings</h2>
        {/* Add portfolio holdings table here */}
      </div>
      <div className="bg-white p-6 rounded-lg shadow mb-6">
        <h2 className="text-xl font-semibold mb-4">Performance Chart</h2>
        {/* Add performance chart component here */}
      </div>
      <div className="bg-white p-6 rounded-lg shadow">
        <h2 className="text-xl font-semibold mb-4">Asset Allocation</h2>
        {/* Add asset allocation chart here */}
      </div>
    </div>
  );
};

export default PortfolioPage;