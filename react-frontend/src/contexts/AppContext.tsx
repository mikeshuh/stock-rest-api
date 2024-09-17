// src/contexts/AppContext.tsx
import React, { createContext, useContext, useReducer, ReactNode } from 'react';

type User = {
  id: string;
  username: string;
  email: string;
};

type Stock = {
  symbol: string;
  name: string;
  price: number;
  change: number;
};

type State = {
  user: User | null;
  stocks: Stock[];
  watchlist: Stock[];
  portfolio: any[]; // Define a more specific type based on your needs
};

type Action = 
  | { type: 'SET_USER'; payload: User | null }
  | { type: 'SET_STOCKS'; payload: Stock[] }
  | { type: 'SET_WATCHLIST'; payload: Stock[] }
  | { type: 'SET_PORTFOLIO'; payload: any[] };

const initialState: State = {
  user: null,
  stocks: [],
  watchlist: [],
  portfolio: [],
};

const AppContext = createContext<{
  state: State;
  dispatch: React.Dispatch<Action>;
}>({
  state: initialState,
  dispatch: () => null,
});

const reducer = (state: State, action: Action): State => {
  switch (action.type) {
    case 'SET_USER':
      return { ...state, user: action.payload };
    case 'SET_STOCKS':
      return { ...state, stocks: action.payload };
    case 'SET_WATCHLIST':
      return { ...state, watchlist: action.payload };
    case 'SET_PORTFOLIO':
      return { ...state, portfolio: action.payload };
    default:
      return state;
  }
};

export const AppProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <AppContext.Provider value={{ state, dispatch }}>
      {children}
    </AppContext.Provider>
  );
};

export const useAppContext = () => useContext(AppContext);