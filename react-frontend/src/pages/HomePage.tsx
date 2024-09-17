// src/pages/HomePage.tsx
import React from 'react';
import { Link } from 'react-router-dom';

const HomePage: React.FC = () => {
  return (
    <div className="min-h-screen bg-gray-100 flex flex-col justify-center items-center">
      <h1 className="text-4xl font-bold mb-4">Welcome to Red Panda Trading</h1>
      <p className="text-xl mb-8">Your intelligent trading companion</p>
      <div className="space-x-4">
        <Link to="/auth" className="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded">
          Sign Up
        </Link>
        <Link to="/auth" className="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded">
          Log In
        </Link>
      </div>
      <div className="mt-8">
        <h2 className="text-2xl font-semibold mb-2">About the Developer</h2>
        <p>Hi, I'm [Your Name]. I'm passionate about finance and technology.</p>
        <div className="mt-4 space-x-4">
          <a href="https://github.com/yourusername" target="_blank" rel="noopener noreferrer" className="text-blue-500 hover:text-blue-600">
            GitHub
          </a>
          <a href="https://linkedin.com/in/yourusername" target="_blank" rel="noopener noreferrer" className="text-blue-500 hover:text-blue-600">
            LinkedIn
          </a>
        </div>
      </div>
    </div>
  );
};

export default HomePage;