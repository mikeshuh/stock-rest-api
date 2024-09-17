// src/pages/WatchlistPage.tsx
import React, { useEffect } from 'react';
import { Link } from 'react-router-dom';
import { useAppContext } from '../contexts/AppContext';
import { fetchWatchlist } from '../services/api';

const WatchlistPage: React.FC = () => {
  const { state, dispatch } = useAppContext();

  useEffect(() => {
    const loadWatchlist = async () => {
      try {
        const watchlist = await fetchWatchlist();
        dispatch({ type: 'SET_WATCHLIST', payload: watchlist });
      } catch (error) {
        console.error('Error loading watchlist:', error);
      }
    };

    loadWatchlist();
  }, [dispatch]);

  const removeFromWatchlist = async (symbol: string) => {
    // Implement remove from watchlist functionality
    // Update the watchlist in the state after removal
  };

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Your Watchlist</h1>
      <div className="bg-white p-6 rounded-lg shadow">
        {state.watchlist.map((stock) => (
          <div key={stock.symbol} className="flex justify-between items-center p-4 mb-2 border-b hover:bg-gray-100">
            <Link to={`/stock/${stock.symbol}`} className="flex-grow">
              <h2 className="text-xl font-semibold">{stock.name} ({stock.symbol})</h2>
              <p className="text-gray-600">Price: ${stock.price}</p>
            </Link>
            <div>
              <span className={`font-bold ${stock.change >= 0 ? 'text-green-500' : 'text-red-500'}`}>
                {stock.change >= 0 ? '+' : ''}{stock.change.toFixed(2)}%
              </span>
              <button
                onClick={() => removeFromWatchlist(stock.symbol)}
                className="ml-4 bg-red-500 text-white p-2 rounded hover:bg-red-600"
              >
                Remove
              </button>
            </div>
          </div>
        ))}
        {state.watchlist.length === 0 && (
          <p className="text-gray-500">Your watchlist is empty. Add stocks from the search page.</p>
        )}
      </div>
    </div>
  );
};

export default WatchlistPage;