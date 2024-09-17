// src/services/api.ts
const API_BASE_URL = 'http://your-api-url.com';

const handleResponse = async (response: Response) => {
  if (!response.ok) {
    const error = await response.json();
    throw new Error(error.message || 'An error occurred');
  }
  return response.json();
};

const getAuthHeaders = () => {
  const token = localStorage.getItem('token');
  return {
    'Content-Type': 'application/json',
    'Authorization': token ? `Bearer ${token}` : '',
  };
};

export const login = async (username: string, password: string) => {
  const response = await fetch(`${API_BASE_URL}/auth/login`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username, password }),
  });
  return handleResponse(response);
};

export const register = async (username: string, email: string, password: string) => {
  const response = await fetch(`${API_BASE_URL}/auth/register`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username, email, password }),
  });
  return handleResponse(response);
};

export const fetchStocks = async () => {
  const response = await fetch(`${API_BASE_URL}/stocks`, {
    headers: getAuthHeaders(),
  });
  return handleResponse(response);
};

export const fetchWatchlist = async () => {
  const response = await fetch(`${API_BASE_URL}/watchlist`, {
    headers: getAuthHeaders(),
  });
  return handleResponse(response);
};

export const fetchPortfolio = async () => {
  const response = await fetch(`${API_BASE_URL}/portfolio`, {
    headers: getAuthHeaders(),
  });
  return handleResponse(response);
};

// Add more API functions as needed
// src/services/api.ts

// Function to fetch all trade history
export const fetchTradeHistory = async (): Promise<any> => {
    try {
      const response = await fetch('/api/trades', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });
  
      // Check if the request was successful
      if (!response.ok) {
        throw new Error('Failed to fetch trade history');
      }
  
      // Parse and return the data
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error fetching trade history:', error);
      throw error;
    }
  };
  
  // You can also add another function to fetch trade history by userId if needed
  export const fetchTradeHistoryByUser = async (userId: number): Promise<any> => {
    try {
      const response = await fetch(`/api/trades/user/${userId}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });
  
      // Check if the request was successful
      if (!response.ok) {
        throw new Error(`Failed to fetch trade history for user ${userId}`);
      }
  
      // Parse and return the data
      const data = await response.json();
      return data;
    } catch (error) {
      console.error(`Error fetching trade history for user ${userId}:`, error);
      throw error;
    }
  };
  