// src/pages/SearchPage.tsx
import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const SearchPage: React.FC = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [searchResults, setSearchResults] = useState<any[]>([]);

  const handleSearch = async (e: React.FormEvent) => {
    e.preventDefault();
    // Implement stock search functionality
    // Update searchResults state with the results
  };

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Search Stocks</h1>
      <form onSubmit={handleSearch} className="mb-6">
        <input
          type="text"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          placeholder="Search for stocks..."
          className="p-2 border rounded w-full md:w-1/2"
        />
        <button type="submit" className="mt-2 bg-blue-500 text-white p-2 rounded hover:bg-blue-600">Search</button>
      </form>
      <div>
        {searchResults.map((stock) => (
          <Link key={stock.symbol} to={`/stock/${stock.symbol}`} className="block p-4 mb-2 bg-white rounded shadow hover:shadow-md">
            <h2 className="text-xl font-semibold">{stock.name} ({stock.symbol})</h2>
            <p>Price: ${stock.price}</p>
          </Link>
        ))}
      </div>
    </div>
  );
};

export default SearchPage;