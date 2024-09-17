// src/pages/HistoryPage.tsx
import React, { useEffect, useState } from 'react';
import { fetchTradeHistory } from '../services/api';

interface Trade {
  id: string;
  symbol: string;
  type: 'buy' | 'sell';
  quantity: number;
  price: number;
  date: string;
}

const HistoryPage: React.FC = () => {
  const [tradeHistory, setTradeHistory] = useState<Trade[]>([]);
  const [sortField, setSortField] = useState<keyof Trade>('date');
  const [sortDirection, setSortDirection] = useState<'asc' | 'desc'>('desc');

  useEffect(() => {
    const loadTradeHistory = async () => {
      try {
        const history = await fetchTradeHistory();
        setTradeHistory(history);
      } catch (error) {
        console.error('Error loading trade history:', error);
      }
    };

    loadTradeHistory();
  }, []);

  const sortedHistory = [...tradeHistory].sort((a, b) => {
    if (a[sortField] < b[sortField]) return sortDirection === 'asc' ? -1 : 1;
    if (a[sortField] > b[sortField]) return sortDirection === 'asc' ? 1 : -1;
    return 0;
  });

  const handleSort = (field: keyof Trade) => {
    if (field === sortField) {
      setSortDirection(sortDirection === 'asc' ? 'desc' : 'asc');
    } else {
      setSortField(field);
      setSortDirection('asc');
    }
  };

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Trade History</h1>
      <div className="bg-white p-6 rounded-lg shadow overflow-x-auto">
        <table className="w-full">
          <thead>
            <tr>
              <th onClick={() => handleSort('date')} className="cursor-pointer p-2 text-left">Date</th>
              <th onClick={() => handleSort('symbol')} className="cursor-pointer p-2 text-left">Symbol</th>
              <th onClick={() => handleSort('type')} className="cursor-pointer p-2 text-left">Type</th>
              <th onClick={() => handleSort('quantity')} className="cursor-pointer p-2 text-left">Quantity</th>
              <th onClick={() => handleSort('price')} className="cursor-pointer p-2 text-left">Price</th>
            </tr>
          </thead>
          <tbody>
            {sortedHistory.map((trade) => (
              <tr key={trade.id} className="border-b">
                <td className="p-2">{new Date(trade.date).toLocaleDateString()}</td>
                <td className="p-2">{trade.symbol}</td>
                <td className={`p-2 ${trade.type === 'buy' ? 'text-green-500' : 'text-red-500'}`}>
                  {trade.type.toUpperCase()}
                </td>
                <td className="p-2">{trade.quantity}</td>
                <td className="p-2">${trade.price.toFixed(2)}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default HistoryPage;